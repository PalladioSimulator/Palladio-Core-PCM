package de.uka.ipd.sdq.palladiofileshare.businesslogic;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.palladiofileshare.businesslogic.util.Util;

/**
 * @author Klaus Krogmann
 *
 */
public class ExistingFilesDatabase {

	private static Set<Integer> fileHashes;
	private static Logger logger = Logger.getLogger(ExistingFilesDatabase.class);
	private static final int numberOfFilesInDB = 10*1000;
	private static ExistingFilesDatabase singleton;
	
	public static ExistingFilesDatabase getSingleton() {
		if(singleton == null) {
			singleton = new ExistingFilesDatabase();
		} 
		return singleton;		
	}
	
	private ExistingFilesDatabase() {	
		logger.debug("Init ExistingFilesDatabase start");
		fileHashes = new HashSet<Integer>();
		fileHashes = Util.initHashSetWithInteger(numberOfFilesInDB);
		logger.debug("Init ExistingFilesDatabase end");
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
