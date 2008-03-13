package de.uka.ipd.sdq.palladiofileshare.algorithms.hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Hash {

	/** see Javadocs under docs/technotes/guides/security/StandardNames.html#MessageDigest 
	 * for details of algorithms; for message digest, the following are available
	 * MD2, MD5, SHA-1, SHA-256, SHA-384, SHA-512
	 */
	private static final String MESSAGE_DIGEST_TYPE_MD2     = "MD2";
	private static final String MESSAGE_DIGEST_TYPE_MD5     = "MD5";
	private static final String MESSAGE_DIGEST_TYPE_SHA_1   = "SHA-1";
	private static final String MESSAGE_DIGEST_TYPE_SHA_256 = "SHA-256";
	private static final String MESSAGE_DIGEST_TYPE_SHA_384 = "SHA-384";
	private static final String MESSAGE_DIGEST_TYPE_SHA_512 = "SHA-512";
	private static final String DEFAULT_MESSAGE_DIGEST = MESSAGE_DIGEST_TYPE_SHA_512;
	
	private String messageDigestType;
	
	public Hash(){
		this.messageDigestType = MESSAGE_DIGEST_TYPE_SHA_512;
		PropertyConfigurator.configure("log4j.properties");
		log = Logger.getLogger(Hash.class);
	}
	private Logger log;
	
	public Hash(String messageDigestType){
		this();
		if(messageDigestType.equals(MESSAGE_DIGEST_TYPE_MD2)){
			this.messageDigestType = MESSAGE_DIGEST_TYPE_MD2;
		} else if(messageDigestType.equals(MESSAGE_DIGEST_TYPE_MD5)){
			this.messageDigestType = MESSAGE_DIGEST_TYPE_MD5;
		} else if(messageDigestType.equals(MESSAGE_DIGEST_TYPE_SHA_1)){
			this.messageDigestType = MESSAGE_DIGEST_TYPE_SHA_1;
		} else if(messageDigestType.equals(MESSAGE_DIGEST_TYPE_SHA_256)){
			this.messageDigestType = MESSAGE_DIGEST_TYPE_SHA_256;
		} else if(messageDigestType.equals(MESSAGE_DIGEST_TYPE_SHA_384)){
			this.messageDigestType = MESSAGE_DIGEST_TYPE_SHA_384;
		} else if(messageDigestType.equals(MESSAGE_DIGEST_TYPE_SHA_512)){
			this.messageDigestType = MESSAGE_DIGEST_TYPE_SHA_512;
		} else {
			log.error("No message digest algorithm called "+messageDigestType+";" +
					" taking "+DEFAULT_MESSAGE_DIGEST+" instead");
			this.messageDigestType = DEFAULT_MESSAGE_DIGEST;
		}
	}

	/**
	 * @param inputBytes
	 * @return
	 */
	public byte[] getMessageDigest(byte[] inputBytes) {		
		MessageDigest md;
		try {
			md = MessageDigest.getInstance(this.messageDigestType);
			md.update(inputBytes);
			return md.digest();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**TODO
	 * @return the (final static) message digest type represented by this object
	 */
	private String getMessageDigestType(){
		return this.messageDigestType;
	}
}
