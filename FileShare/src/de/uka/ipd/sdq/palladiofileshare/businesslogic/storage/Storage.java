package de.uka.ipd.sdq.palladiofileshare.businesslogic.storage;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import de.uka.ipd.sdq.palladiofileshare.businesslogic.BusinessFacade;

public class Storage {	
	
	/**
	 * needs to terminate with a "/"
	 */
	private static final String fileStorageLocation = "uploadedFileStorage/";

	public void storeFile(StorageFile parameterObject) {
		try {
			String hashString = createString(parameterObject.getFileHash());
			FileOutputStream fileOutStream =
				new FileOutputStream(fileStorageLocation + hashString);
			
			try {
				fileOutStream.write(parameterObject.getStream());
			} catch (IOException e) {
				e.printStackTrace();
				BusinessFacade.logger.error(e);	
			}			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			BusinessFacade.logger.error(e);			
		}		
	}

	private String createString(byte[] fileHash) {
		StringBuilder string = new StringBuilder("f");		
						
		for(int x = 0; x < fileHash.length; x++) {			
			string.append(fileHash[x]);
		}
		
		return string.toString();
	}

}
