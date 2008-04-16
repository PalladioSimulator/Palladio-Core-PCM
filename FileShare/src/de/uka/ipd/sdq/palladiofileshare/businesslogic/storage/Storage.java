package de.uka.ipd.sdq.palladiofileshare.businesslogic.storage;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.palladiofileshare.businesslogic.util.Util;

/**
 * @author Klaus Krogmann
 *
 */
public class Storage implements IStorage {	
	
	/**
	 * path needs to terminate with a "/"
	 */
	private static final String fileStorageLocation = "uploadedFileStorage/";
	
	private static Logger logger = Logger.getLogger(Storage.class);

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.palladiofileshare.businesslogic.storage.IStorage#storeFile(byte[], byte[])
	 */
	public long storeFile(
			byte[] stream, 
			byte[] fileHash, 
			boolean measure) {
		long start = 0L;
		long stop = 0L;
		if(measure) {
			start = System.nanoTime();
		}
		try {
//			String hashString = Util.createString(fileHash); //TODO check why an error occurs
			String hashString = Util.createString_MK(fileHash);
			FileOutputStream fileOutStream;
			fileOutStream = new FileOutputStream(fileStorageLocation + hashString);
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
		if(measure){
			stop = System.nanoTime();
			return (stop-start);
		} else {
			return -1;
		}
	}
}
