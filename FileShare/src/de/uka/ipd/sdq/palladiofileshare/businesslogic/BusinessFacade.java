package de.uka.ipd.sdq.palladiofileshare.businesslogic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;

public class BusinessFacade {
	
	private static Logger logger = Logger.getLogger("BusinessFacade");
	private CopyrightedMaterialDatabase copyDB;
	
	/**
	 * needs to terminate with a "/"
	 */
	private static final String fileStorageLocation = "uploadedFileStorage/";
	
	public BusinessFacade() {
		this.copyDB = new CopyrightedMaterialDatabase();
	}

	public void uploadFile(InputStream[] inputStream, FileType fileType) {
		byte[] fileHash;
		InputStream currentInputStream;
		
		for(int x = 0; x < inputStream.length; x++) {
			currentInputStream = inputStream[x];
			
			if(fileType != FileType.Archive)
			{
				compress(currentInputStream);
				fileHash = md5(currentInputStream);				
			} else {
				fileHash = md5(currentInputStream);
				compress(currentInputStream);
			}	
			
			if(isCopyrightedMaterial(fileHash)) {
				//reject file // do not store
			} else {
				storeFile(null, fileHash);
			}
		}
	}
	
	private void storeFile(byte[] stream, byte[] fileHash) {
		try {
			String hashString = createString(fileHash);
			FileOutputStream fileOutStream =
				new FileOutputStream(fileStorageLocation + hashString);
			
			try {
				fileOutStream.write(stream);
			} catch (IOException e) {
				e.printStackTrace();
				logger.error(e);	
			}			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			logger.error(e);			
		}		
	}

	private String createString(byte[] fileHash) {
		StringBuilder string = new StringBuilder("f");		
						
		for(int x = 0; x < fileHash.length; x++) {			
			string.append(fileHash[x]);
		}
		
		return string.toString();
	}

	private byte[] md5(InputStream inputStream) {		
		return null;
	}

	private void compress(InputStream inputStream) {
		
	}
	
	private boolean isCopyrightedMaterial(byte[] hash) {
		return this.copyDB.isCopyrightedMaterial(hash);		
	}
	

}
