package de.uka.ipd.sdq.palladiofileshare.businesslogic.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.apache.log4j.Logger;

public class Util {

	private static Logger logger = Logger.getLogger(Util.class);
	private static int randomSeed = 1234;
		
	/**
	 * creates a string unique for file and thread
	 * @param fileHash
	 * @return
	 */
	public static Integer createIntegerHash(byte[] fileHash) {				
		Byte[] fileHash2 = new Byte[fileHash.length];
		
		for(int x = 0; x < fileHash.length; x++) {
			fileHash2[x] = new Byte(fileHash[x]);		
		}
		
		return Arrays.deepHashCode(fileHash2);
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
		
	/**
	 * creates a string unique for file and thread
	 * @param fileHash
	 * @return
	 */
	public static String createString_MK(byte[] fileHash) {		
		StringBuilder string = new StringBuilder("f_" + System.nanoTime()+".PFSfile");		
						
//		for(int x = 0; (x < fileHash.length && x < 40) ; x++) {			
//			string.append(fileHash[x]);
//		}
		
		return string.toString();
	}
		
	public static Set<Integer> initHashSetWithInteger(int amountOfData) {	
		Set<Integer> hashSet = new HashSet<Integer>();
		Random r = new Random(randomSeed);

		for(int x = 0; x < amountOfData; x++) {			
			//FIXME: adapt to size of used hash algorithm: 
			byte[] randomBytes = {0x0000,0x0000,0x0000,0x0000,0x0000,0x0000,0x0000,0x0000,0x0000,0x0000,0x0000,0x0000,0x0000,0x0000,0x0000,0x0000,0x0000,0x0000,0x0000,0x0000};
			MessageDigest md;
			
			try {
				md = MessageDigest.getInstance("SHA");

				r.nextBytes(randomBytes);
				md.update(randomBytes);
				hashSet.add(createIntegerHash(md.digest()));
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
				logger.error(e);
			}
		}
		return hashSet;
	}

	public static ArrayList<Byte[]> initialiseRandomByteArrays(
			int nrOfRandomDatasets, 
			boolean constantRandomDatasetSize,
			int initialRandomDatasetSize,
			int maximumRandomDatasetSizeIfVariableSize) {
		ArrayList<Byte[]> ret = new ArrayList<Byte[]>();
		int datasetSize = initialRandomDatasetSize;
		Random rd = new Random();
		for(int i=0; i<nrOfRandomDatasets; i++){
			if(!constantRandomDatasetSize){
				datasetSize = 
					initialRandomDatasetSize
						+rd.nextInt
						(
								maximumRandomDatasetSizeIfVariableSize
								  -initialRandomDatasetSize
						);
			}
			Byte[] nextEntry = new Byte[datasetSize];
			for(int j=0; j<nextEntry.length; j++){
				nextEntry[j] = new Integer(-128+rd.nextInt(256)).byteValue();
			}
			ret.add(nextEntry);
		}
		return ret;
	}
	
	public static ArrayList<byte[]> initialiseRandomPrimitiveByteArrays(
			int nrOfRandomDatasets, 
			boolean constantRandomDatasetSize,
			int initialRandomDatasetSize,
			int maximumRandomDatasetSizeIfVariableSize) {
		ArrayList<byte[]> ret = new ArrayList<byte[]>();
		int datasetSize = initialRandomDatasetSize;
		Random rd = new Random();
		for(int i=0; i<nrOfRandomDatasets; i++){
			if(!constantRandomDatasetSize){
				datasetSize = 
					initialRandomDatasetSize
						+rd.nextInt
						(
								maximumRandomDatasetSizeIfVariableSize
								  -initialRandomDatasetSize
						);
			}
			byte[] nextEntry = new byte[datasetSize];
			rd.nextBytes(nextEntry);
//			for(int j=0; j<nextEntry.length; j++){
//				nextEntry[j] = new Integer(-128+rd.nextInt(256)).byteValue();
//			}
			ret.add(nextEntry);
		}
		return ret;
	}
}
