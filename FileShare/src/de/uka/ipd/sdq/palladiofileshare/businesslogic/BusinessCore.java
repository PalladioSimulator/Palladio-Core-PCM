package de.uka.ipd.sdq.palladiofileshare.businesslogic;

import java.io.IOException;
import java.io.InputStream;

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
	public void uploadFiles(InputStream[] inputStream, int fileType) {
		byte[] fileHash;
		byte[] file;
		InputStream currentInputStream;
		
		for(int x = 0; x < inputStream.length; x++) {
			currentInputStream = inputStream[x];
			
			if(fileType == FileType.TEXT)
			{
				file = this.compress(currentInputStream);
				fileHash = this.md5(currentInputStream);				
			} else {
				fileHash = this.md5(currentInputStream);
				file = this.compress(currentInputStream);
			}	
			
			if(isCopyrightedMaterial(fileHash)) {
				logger.debug("Copyrighted file found. File not stored.");
				//reject file // do not store
			} else {
				if(isFileExistingInDB(fileHash)) {
					logger.debug("File already in DB.");
				} else {
					this.storeFileWithStrategy(file, fileHash);					
				}
			}
						
			try {
				currentInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
				logger.error(e);
			}
		}
	}
	
	private byte[] md5(InputStream inputStream) {		
		return null; //TODO: add implementation
	}

	private byte[] compress(InputStream inputStream) {				
		return compression.compress(inputStream);
	}	
	
	private boolean isCopyrightedMaterial(byte[] hash) {
		return this.copyDB.isCopyrightedMaterial(hash);	
	}
	
	private boolean isFileExistingInDB(byte[] hash) {
		return this.fileDB.existsInDatabase(hash);				
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
