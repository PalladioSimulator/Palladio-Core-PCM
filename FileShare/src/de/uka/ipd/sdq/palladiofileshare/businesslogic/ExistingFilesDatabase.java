package de.uka.ipd.sdq.palladiofileshare.businesslogic;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.palladiofileshare.businesslogic.util.Util;

public class ExistingFilesDatabase {

	private static ExistingFilesDatabase singleton;
	private static Logger logger = Logger.getLogger(ExistingFilesDatabase.class);
	private static final int numberOfFilesInDB = 100000;
	private Set<byte[]> fileHashes;
	
	private ExistingFilesDatabase() {	
		logger.debug("Init ExistingFilesDatabase start");
		fileHashes = new HashSet<byte[]>();
		fileHashes = Util.initHashSetWithHashs(numberOfFilesInDB);
		logger.debug("Init ExistingFilesDatabase end");
	}
	
	public static ExistingFilesDatabase getSingleton() {
		if(singleton == null) {
			singleton = new ExistingFilesDatabase();
		} 
		return singleton;		
	}
	
	public void addNewFileHash(byte[] fileHash) {
		if(!fileHashes.contains(fileHash)) {
			fileHashes.add(fileHash);
		}
	}

	public boolean existsInDatabase(byte[] fileHash) {
		return fileHashes.contains(fileHash);
	}
	
}
