package de.uka.ipd.sdq.palladiofileshare.businesslogic;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.apache.log4j.Logger;

public class CopyrightedMaterialDatabase {
	
	private static Logger logger = Logger.getLogger("CopyrightedMaterialDatabase");
	private static final int numberOfCopyrightedMaterials = 100000;
	private Set<byte[]> copyrightedHashs;
	
	public CopyrightedMaterialDatabase() {
		this.copyrightedHashs = new HashSet<byte[]>();
		copyrightedHashs = Util.initHashSetWithHashs(numberOfCopyrightedMaterials);
	}	

	public boolean isCopyrightedMaterial(byte[] hash) {	
		return this.copyrightedHashs.contains(hash);		
	}
}
