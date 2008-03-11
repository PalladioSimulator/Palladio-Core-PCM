package de.uka.ipd.sdq.palladiofileshare.businesslogic;

import java.util.Set;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.palladiofileshare.businesslogic.util.Util;

public class ExistingFilesDatabase {
		

	private static Logger logger = Logger.getLogger("ExistingFilesDatabase");
	private static final int numberOfFilesInDB = 100000;
	private Set<byte[]> fileHashes;
	
	public ExistingFilesDatabase() {		
		fileHashes = Util.initHashSetWithHashs(numberOfFilesInDB);
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
