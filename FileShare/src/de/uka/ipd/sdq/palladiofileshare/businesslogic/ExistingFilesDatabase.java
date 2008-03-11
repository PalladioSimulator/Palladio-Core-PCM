package de.uka.ipd.sdq.palladiofileshare.businesslogic;

import java.util.Set;

import org.apache.log4j.Logger;

public class ExistingFilesDatabase {

	private static Logger logger = Logger.getLogger("ExistingFilesDatabase");	
	private Set<byte[]> fileHashes;
	
	public void addNewFileHash(byte[] fileHash) {
		if(!fileHashes.contains(fileHash)) {
			fileHashes.add(fileHash);
		}
	}

	public boolean existsInDatabase(byte[] fileHash) {
		return fileHashes.contains(fileHash);
	}
	
}
