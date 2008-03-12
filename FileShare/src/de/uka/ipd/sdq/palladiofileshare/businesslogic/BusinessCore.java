package de.uka.ipd.sdq.palladiofileshare.businesslogic;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.palladiofileshare.algorithms.compress.CompressionRunner;
import de.uka.ipd.sdq.palladiofileshare.businesslogic.storage.IStorage;
import de.uka.ipd.sdq.palladiofileshare.businesslogic.storage.Storage;

public class BusinessCore {
	
	/**
	 * Size in bytes; if larger than this value, a different 
	 * storage system is used
	 */
	private static final int SIZE_OF_LARGE_FILES = 50000;
	private static Logger logger = Logger.getLogger(BusinessCore.class);
	
	/** see Javadocs under docs/technotes/guides/security/StandardNames.html#MessageDigest 
	 * for details of algorithms; for message digest, the following are available
	 * MD5, MD5, SHA-1, SHA-256, SHA-384, SHA-512
	 */
	private static final String MESSAGE_DIGEST_TYPE = "SHA-512";
	
	// sub-components (internal)
	private CopyrightedMaterialDatabase copyDB;
	private ExistingFilesDatabase fileDB;
	private CompressionRunner compression;
	
	// other components
	private IStorage storageSubSystemSmallFiles;
	private IStorage storageSubSystemLargeFiles;
		
	public BusinessCore() {
		this.copyDB = CopyrightedMaterialDatabase.getSingleton();
		this.fileDB = ExistingFilesDatabase.getSingleton();
		this.compression = new CompressionRunner();
		this.storageSubSystemLargeFiles = new Storage();
		this.storageSubSystemSmallFiles = new Storage();
	}

	/**
	 * 
	 * @param inputStream
	 * @param fileType FileType static ints
	 */
	public void uploadFiles(byte[][] inputStreams, int fileType) {
		
		byte[] fileHashAsBytes;		
		byte[] inputFile;
		byte[] compressedFile;
		
		for(int x = 0; x < inputStreams.length; x++) {			
			inputFile = inputStreams[x];
			
			if(fileType == FileType.TEXT)
			{
				compressedFile = this.compress(inputFile);
			} else {
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
		MessageDigest md;
		try {
			md = MessageDigest.getInstance(MESSAGE_DIGEST_TYPE);
			md.update(inputBytes);
			return md;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
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
