package de.uka.ipd.sdq.palladiofileshare.businesslogic;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.apache.log4j.Logger;

public class Util {

	private static Logger logger = Logger.getLogger("Util");
	
	public static Set<byte[]> initHashSetWithHashs(int amountOfData) {	
		Set<byte[]> hashSet = new HashSet<byte[]>();
		Random r = new Random();

		for(int x = 0; x < amountOfData; x++) {			
			//FIXME: adapt to size of used hash algorithm: 
			byte[] randomBytes = {0x0000,0x0000,0x0000,0x0000,0x0000};
			MessageDigest md;
			
			try {
				md = MessageDigest.getInstance("SHA");

				r.nextBytes(randomBytes);
				md.update(randomBytes);
				hashSet.add(md.digest());
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
				logger.error(e);
			}
		}
		return hashSet;
	}
}
