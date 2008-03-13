package de.uka.ipd.sdq.palladiofileshare.businesslogic;

import java.security.MessageDigest;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.palladiofileshare.algorithms.compress.CompressionRunner;
import de.uka.ipd.sdq.palladiofileshare.algorithms.hash.Hash;
import de.uka.ipd.sdq.palladiofileshare.businesslogic.storage.IStorage;
import de.uka.ipd.sdq.palladiofileshare.businesslogic.storage.Storage;

public class BusinessCore {
	
	/**
	 * Size in bytes; if larger than this value, a different 
	 * storage system is used
	 */
	private static final int SIZE_OF_LARGE_FILES = 50000;
	private static Logger logger = Logger.getLogger(BusinessCore.class);
	
	// sub-components (internal)
	private CopyrightedMaterialDatabase copyDB;
	private ExistingFilesDatabase fileDB;
	private CompressionRunner compression;
	private Hash hash;
	
	// other components
	private IStorage storageSubSystemSmallFiles;
	private IStorage storageSubSystemLargeFiles;
		
	public BusinessCore() {
		this.copyDB = CopyrightedMaterialDatabase.getSingleton();
		this.fileDB = ExistingFilesDatabase.getSingleton();
		this.compression = new CompressionRunner();
		this.hash = new Hash();
		this.storageSubSystemLargeFiles = new Storage();
		this.storageSubSystemSmallFiles = new Storage();
	}

	/**
	 * 
	 * @param inputStream
	 * @param fileType FileType static ints
	 */
	public void uploadFiles(byte[][] inputFiles, int[] inputFileTypes) {
		
		byte[] fileHashAsBytes;		
		byte[] inputFile;
		byte[] compressedFile;
		
		for(int x = 0; x < inputFiles.length; x++) {			
			inputFile = inputFiles[x];
			
			if(inputFileTypes[x] == FileType.TEXT)
			{
				logger.debug("Non-Compressed file. Compressing.");
				compressedFile = this.compress(inputFile);
			} else {
				logger.debug("Compressed file. Doing nothing.");
				compressedFile = inputFile; //do nothing
			}
			
			MessageDigest fileHash;
			fileHash = this.getMessageDigest(compressedFile);
			fileHashAsBytes = fileHash.digest();
			
			if(isCopyrightedMaterial(fileHashAsBytes)) {
				logger.debug("Copyrighted file found. File not stored.");
				//reject file // do not store
			} else {
				if(isFileExistingInDB(fileHashAsBytes)) { 
					logger.debug("File already in DB.");
				} else {
					addFileToFileExistingDB(fileHashAsBytes);
					this.storeFileWithStrategy(compressedFile, fileHashAsBytes);					
				}
			}
		}
	}

	private MessageDigest getMessageDigest(byte[] inputBytes) {		
		return hash.getMessageDigest(inputBytes);
	}

	private byte[] compress(byte[] inputFile) {				
		return compression.compress(inputFile);
	}	
	
	private boolean isCopyrightedMaterial(byte[] hash) {
		return this.copyDB.isCopyrightedMaterial(hash);	
	}
	
	private boolean isFileExistingInDB(byte[] hash) {
		return this.fileDB.existsInDatabase(hash);				
	}
	
	private void addFileToFileExistingDB(byte[] hash) {
		this.fileDB.addNewFileHash(hash);				
	}
	
	private void storeFileWithStrategy(byte[] file, byte[] fileHash) {
		if(file.length > SIZE_OF_LARGE_FILES) {
			logger.debug("Writing large file to storage system.");
			this.storageSubSystemLargeFiles.storeFile(file, fileHash);
		} else {
			logger.debug("Writing small file to storage system.");
			this.storageSubSystemSmallFiles.storeFile(file, fileHash);
		}
	}
}
