package de.uka.ipd.sdq.palladiofileshare.algorithms.hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

	/** see Javadocs under docs/technotes/guides/security/StandardNames.html#MessageDigest 
	 * for details of algorithms; for message digest, the following are available
	 * MD5, MD5, SHA-1, SHA-256, SHA-384, SHA-512
	 */
	private static final String MESSAGE_DIGEST_TYPE = "SHA-512";

	public MessageDigest getMessageDigest(byte[] inputBytes) {		
		MessageDigest md;
		try {
			md = MessageDigest.getInstance(MESSAGE_DIGEST_TYPE);
			md.update(inputBytes);
			return md;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}
}
