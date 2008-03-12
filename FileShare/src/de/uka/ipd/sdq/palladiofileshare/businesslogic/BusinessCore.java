package de.uka.ipd.sdq.palladiofileshare.businesslogic;

import java.io.InputStream;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.palladiofileshare.algorithms.compress.Compress;
import de.uka.ipd.sdq.palladiofileshare.algorithms.compress.OutputBuffer;
import de.uka.ipd.sdq.palladiofileshare.algorithms.compress.Source;
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
	
	// other components
	private IStorage storageSubSystemSmallFiles;
	private IStorage storageSubSystemLargeFiles;
		
	public BusinessCore() {
		this.copyDB = CopyrightedMaterialDatabase.getSingleton();
		this.fileDB = ExistingFilesDatabase.getSingleton();
		this.storageSubSystemLargeFiles = new Storage();
		this.storageSubSystemSmallFiles = new Storage();
	}

	/**
	 * 
	 * @param inputStream
	 * @param fileType FileType static ints
	 */
	public void uploadFile(InputStream[] inputStream, int fileType) {
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
				file = fileHash = this.md5(currentInputStream);
				this.compress(currentInputStream);
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
		}
	}
	
	private byte[] md5(InputStream inputStream) {		
		return null;
	}

	private byte[] compress(InputStream inputStream) {		
		
		byte[][] COMPRESS_BUFFERS = null; //FIXME: see Harness.java: prepareBuffers
	    byte[][] DECOMPRESS_BUFFERS = null; //FIXME: see Harness.java: prepareBuffers
	    Compress CB = new Compress();
	    int btid = 0; //FIXME: see Harness.java
		
		Source source = null; //TODO: inputStream --> source
        OutputBuffer comprBuffer, decomprBufer;
        comprBuffer = CB.performAction(source.getBuffer(),
                source.getLength(),
                CB.COMPRESS,
                COMPRESS_BUFFERS[btid - 1]);
        decomprBufer = CB.performAction(COMPRESS_BUFFERS[btid - 1],
                comprBuffer.getLength(),
                CB.UNCOMPRESS,
                DECOMPRESS_BUFFERS[btid - 1]);
		
		
		return null;
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
