package de.uka.ipd.sdq.palladiofileshare.businesslogic.storage;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;

public class Storage implements IStorage {	
	
	private static Logger logger = Logger.getLogger(Storage.class);
	/**
	 * needs to terminate with a "/"
	 */
	private static final String fileStorageLocation = "uploadedFileStorage/";

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.palladiofileshare.businesslogic.storage.IStorage#storeFile(byte[], byte[])
	 */
	public void storeFile(byte[] stream, byte[] fileHash) {

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

	/**
	 * creates a string unique for file and thread
	 * @param fileHash
	 * @return
	 */
	private String createString(byte[] fileHash) {		
		StringBuilder string = new StringBuilder("f" + Thread.currentThread().getId());		
						
		for(int x = 0; (x < fileHash.length && x < 40) ; x++) {			
			string.append(fileHash[x]);
		}
		
		return string.toString();
	}

}
