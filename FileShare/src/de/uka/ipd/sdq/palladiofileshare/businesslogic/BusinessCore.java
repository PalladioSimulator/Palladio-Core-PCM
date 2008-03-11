package de.uka.ipd.sdq.palladiofileshare.businesslogic;

import java.io.InputStream;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.palladiofileshare.businesslogic.storage.Storage;

public class BusinessCore {
	
	private static Logger logger = Logger.getLogger("BusinessFacade");
	private CopyrightedMaterialDatabase copyDB;
	private ExistingFilesDatabase fileDB;
	private Storage storageSubSystem;
		
	public BusinessCore() {
		logger.debug("Init DBs start");
		this.copyDB = new CopyrightedMaterialDatabase();
		this.fileDB = new ExistingFilesDatabase();
		logger.debug("Init DBs end");
	}

	/**
	 * 
	 * @param inputStream
	 * @param fileType FileType static ints
	 */
	public void uploadFile(InputStream[] inputStream, int fileType) {
		byte[] fileHash;
		InputStream currentInputStream;
		
		for(int x = 0; x < inputStream.length; x++) {
			currentInputStream = inputStream[x];
			
			if(fileType == FileType.TEXT)
			{
				compress(currentInputStream);
				fileHash = md5(currentInputStream);				
			} else {
				fileHash = md5(currentInputStream);
				compress(currentInputStream);
			}	
			
			if(isCopyrightedMaterial(fileHash)) {
				logger.debug("Copyrighted file found.");
				//reject file // do not store
			} else {
				if(!isFileExistingInDB(fileHash)) {
					storageSubSystem.storeFile(null, fileHash);
				}
			}
		}
	}
	
	private byte[] md5(InputStream inputStream) {		
		return null;
	}

	private void compress(InputStream inputStream) {
		
	}
	
	private boolean isCopyrightedMaterial(byte[] hash) {
		return this.copyDB.isCopyrightedMaterial(hash);	
	}
	
	private boolean isFileExistingInDB(byte[] hash) {
		return this.fileDB.existsInDatabase(hash);				
	}

}
