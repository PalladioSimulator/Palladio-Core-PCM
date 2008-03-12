package de.uka.ipd.sdq.palladiofileshare.businesslogic;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
	public void uploadFiles(InputStream[] inputStream, int fileType) {
		MessageDigest fileHash;
		byte[] fileHashAsBytes;
		byte[] uncompressedFile;
		byte[] compressedFile;
		InputStream currentInputStream;
		
		for(int x = 0; x < inputStream.length; x++) {
			currentInputStream = inputStream[x];
			
			if(fileType == FileType.TEXT)
			{
				uncompressedFile = null; //TODO: generate from inputStream param
				compressedFile = this.compress(uncompressedFile); //TODO
			} else {
				compressedFile = null; //TODO: generate from inputStream param
				//makes no sense according to whiteboard... file = this.compress(currentInputStream);
			}	
			fileHash = this.getMessageDigest(compressedFile);
			fileHashAsBytes = fileHash.digest();
			
			if(isCopyrightedMaterial(fileHash)) { //TODO
				logger.debug("Copyrighted file found. File not stored.");
				//reject file // do not store
			} else {
				if(isFileExistingInDB(fileHash)) { //TODO
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
			} finally {
				//TODO
			}
		}
	}
	
	private MessageDigest getMessageHash(byte[] inputBytes) {		
		return this.getMessageDigest(inputBytes);
	}

	private byte[] getMessageHashAsByteArray(byte[] inputBytes) {		
		return this.getMessageDigestAsByteArray(inputBytes);
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

	private byte[] getMessageDigestAsByteArray(byte[] inputBytes) {		
		MessageDigest md;
		try {
			md = MessageDigest.getInstance(MESSAGE_DIGEST_TYPE);
			md.update(inputBytes);
			return md.digest();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
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
