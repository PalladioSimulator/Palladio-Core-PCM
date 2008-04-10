package de.uka.ipd.sdq.palladiofileshare.businesslogic;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.palladiofileshare.businesslogic.util.Util;

public class ExistingFilesDatabase {

	private static ExistingFilesDatabase singleton;
	private static Logger logger = Logger.getLogger(ExistingFilesDatabase.class);
	private static final int numberOfFilesInDB = 100000;
	private static Set<Integer> fileHashes;
	
	private ExistingFilesDatabase() {	
		logger.debug("Init ExistingFilesDatabase start");
		fileHashes = new HashSet<Integer>();
		fileHashes = Util.initHashSetWithInteger(numberOfFilesInDB);
		logger.debug("Init ExistingFilesDatabase end");
	}
	
	public static ExistingFilesDatabase getSingleton() {
		if(singleton == null) {
			singleton = new ExistingFilesDatabase();
		} 
		return singleton;		
	}
	
	public boolean addNewFileHash(byte[] fileHash) {
		if(!fileHashes.contains(Util.createIntegerHash(fileHash))) {
			fileHashes.add(Util.createIntegerHash(fileHash));
			return true;
		}else{
			return false;
		}
	}

	public boolean existsInDatabase(byte[] fileHash) {
		return fileHashes.contains(Util.createIntegerHash(fileHash));
	}
}
