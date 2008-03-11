package de.uka.ipd.sdq.palladiofileshare.businesslogic;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class CopyrightedMaterialDatabase {
	
	private static final int numberOfCopyrightedMaterials = 10000;
	private Set<byte[]> copyrightedHashs;
	
	public CopyrightedMaterialDatabase() {
		this.copyrightedHashs = new HashSet<byte[]>();
		initCopyrightedHashs();
	}
	
	private void initCopyrightedHashs() {		
		Random r = new Random();

		for(int x = 0; x < numberOfCopyrightedMaterials; x++) {			
			byte[] randomBytes = null;
			MessageDigest md;
			
			try {
				md = MessageDigest.getInstance("SHA");

				r.nextBytes(randomBytes);
				md.update(randomBytes);
				this.copyrightedHashs.add(md.digest());
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean isCopyrightedMaterial(byte[] hash) {	
		return this.copyrightedHashs.contains(hash);		
	}
}
