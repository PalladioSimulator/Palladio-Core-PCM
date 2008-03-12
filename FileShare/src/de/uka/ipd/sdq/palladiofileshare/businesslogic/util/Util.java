package de.uka.ipd.sdq.palladiofileshare.businesslogic.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.apache.log4j.Logger;

public class Util {

	private static Logger logger = Logger.getLogger(Util.class);
	
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
	
	/**
	 * creates a string unique for file and thread
	 * @param fileHash
	 * @return
	 */
	public static String createString(byte[] fileHash) {		
		StringBuilder string = new StringBuilder("f" + Thread.currentThread().getId());		
						
		for(int x = 0; (x < fileHash.length && x < 40) ; x++) {			
			string.append(fileHash[x]);
		}
		
		return string.toString();
	}
}
