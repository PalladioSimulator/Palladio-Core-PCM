package de.uka.ipd.sdq.ByCounter.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/** A special class to benchmark a few specific Java API methods.
 *  Does not belong semantically to ByCounter, but we need it for evaluation 
 *  on the basis of SPECjvm2008 benchmarks and for CBSE2008.
 * @author Michael Kuperberg
 * @since 0.3
 * @version 0.9
 */
public class MessageDigestBenchmarker {
//	public static final  int NUMBER_OF_BENCHMARKER_RUNS = 5000;
//	private static final int DEFAULT_NUMBER_OF_CHAININGS = 5;
//	private static final int DEFAULT_NUMBER_OF_METHOD_REPETITIONS = 40;
//	private static final int HASH_BYTELENGTH_SHA_512 = 512/8;
//	private static final int DEFAULT_BYTEARRAY_SIZE = 100*1000;
	
	/**
	 * The relative path to the "master CSV file, i.e. to the file which is 
	 * not overwritten, but rather extended by appending new results
	 */
	private static final String DEFAULT_MASTER_CSV_FILE = "Master.MessageDigestMeasurements.csv";
	
	/**
	 * This field maps the hash algorithm names (e.g. "SHA-512") to the 
	 * appropriate hash sizes in bytes (for SHA-512, it would be 512/8 = 64)  
	 */
	private static HashMap<String,Integer> hashSizes; 

	/**
	 * Help message that is printed if this class is run improperly
	 */
	private static final String helpMessage = 
		"This class requires exactly eight parameters " +
		"(please include all strings in double quotation marks, i.e. in \"\"):\n" +
		"1. parameter: platform description as string\n" +
		"2. parameter: jvm configuration as string, three values are allowed: \"-client\", \"-default\" and \"-server\"\n" +
		"3. parameter: JIT configuration as string, two values are allowed: \"-default\" and \"-Xint\" (interpretation-only mode without JIT, even on platforms where this option is named differently\n" +
		"4. parameter: digest algorithm as string (specify your own)\n" +
		"5. parameter: number of measurements as positive integer\n" +
		"6. parameter: whether to digest immediately (specifying input data as digest()'s parameter), or to perform update()s before calling parameterless digest()\n" +
		"7. parameter: input size as integer (i.e. length of -randomly generated- byte array which will be digested\n" +
		"8. parameter: number (as integer) of different randomly generated input byte arrays that form a pool from which parameters for digesting are quasi-randomly chosen.";
	
	/** Expects eight parameters, see helpMessage field or run the class 
	 * with the wrong number of parameters.
	 * @param args
	 */
	public static void main(String[] args){
		if(args == null || args.length!=8){
			System.out.println("Number of parameters is not eight, will exit\n");
			System.out.println(helpMessage);
			return;
		}
		String platDesc 				= args[0];
		String jvmConfDesc 				= args[1];
		String jitConfDesc 				= args[2];
		String digestAlgorithm 			= args[3];
		int nrOfMeasurements 			= new Integer(args[4]);
		boolean digestImmediately 		= new Boolean(args[5]);
		int inputSize 					= new Integer(args[6]);
		int nrOfDifferentRandomInputs 	= new Integer(args[7]);
		
		MessageDigestBenchmarker mdb 	= new MessageDigestBenchmarker();
		mdb.measureMessageDigesting(
				platDesc, 
				jvmConfDesc, 
				jitConfDesc, 
				digestAlgorithm, 
				nrOfMeasurements, 
				digestImmediately, 
				inputSize, 
				nrOfDifferentRandomInputs);
	}

	/**
	 * Logger instance (log4j)
	 */
	private Logger log;

	/**
	 * Random inputs for benchmarks
	 */
	byte[][] randomInputData;
	
	/**
	 * Random number generator
	 */
	Random rd; 
	
	/**
	 * Default constructor... relies on "log4j.properties" file to exist.
	 */
	public MessageDigestBenchmarker(){
		PropertyConfigurator.configure("log4j.properties");//TODO exception handling (also in other classes)
		log = Logger.getLogger(this.getClass().getCanonicalName());
		rd = new Random();
		hashSizes = new HashMap<String, Integer>();
		hashSizes.put("SHA-512", 512/8);
	}
	
	/** Fills this.randomInputData
	 * @param sizeOfRandomInputByteArray size of the byte arrays that will be created 
	 * @param numberOfRandomInputByteArray number of the byte arrays that will be created
	 */
	private void createRandomInputData(
			int sizeOfRandomInputByteArray,
			int numberOfRandomInputByteArray) {
		if(this.randomInputData==null
				|| randomInputData.length == 0
				|| this.randomInputData.length!=numberOfRandomInputByteArray 
				|| this.randomInputData[0].length != sizeOfRandomInputByteArray){
			this.randomInputData = new byte[numberOfRandomInputByteArray][sizeOfRandomInputByteArray];
		}
		log.debug("Starting creating random data");
		for(int i=0; i<this.randomInputData.length; i++){
			rd.nextBytes(this.randomInputData[i]);
			System.out.print(".");
		}
		System.out.println(":");
		log.debug("Finised creating random data");
	}
	
	/** TODO
	 * @param platfromDesc
	 * @param jvmConfDesc
	 * @param jitConfDesc
	 * @param digestAlgorithm
	 * @param nrOfMeasurements
	 * @param digestImmediately
	 * @param inputSize
	 * @param nrOfDifferentRandomInputs
	 * @return
	 */
	private Long[] measureMessageDigesting(
			String platfromDesc,
			String jvmConfDesc,
			String jitConfDesc,
			String digestAlgorithm,
			int nrOfMeasurements,
			boolean digestImmediately,
			int  inputSize,
			int  nrOfDifferentRandomInputs) {
		log.debug("Entering with platfromDesc = "+platfromDesc+", "+
				"jvmConfDesc = "+jvmConfDesc+", "+
				"jitConfDesc = "+jitConfDesc+", "+
				"digestAlgorithm = "+digestAlgorithm+", "+
				"nrOfMeasurements = "+nrOfMeasurements+", "+
				"digestImmediately = "+digestImmediately+", "+
				"inputSize = "+inputSize+", "+
				"nrOfDifferentRandomInputs = "+nrOfDifferentRandomInputs);
		MessageDigest md;
		long L1 = 0L;
		long L2 = 0L;
		long L3 = 0L;
		long L4 = 0L;
		long L5 = 0L;
		long L6 = 0L;
		List<Long> getInstanceMeasurements = new ArrayList<Long>();
		List<Long> updateTotalMeasurements = new ArrayList<Long>();
		List<Long> digestMeasurements = new ArrayList<Long>();
		
		int[] randomDataUnitsIndexes = new int[nrOfMeasurements/*nrOfChainings*/];
		byte[][] hashes = new byte[nrOfMeasurements][hashSizes.get(digestAlgorithm)];
		for(int j=0; j<randomDataUnitsIndexes.length; j++){
			randomDataUnitsIndexes[j] = rd.nextInt(nrOfDifferentRandomInputs);
		}
		this.createRandomInputData(inputSize,nrOfDifferentRandomInputs);

		for(int n = 0; n<nrOfMeasurements; n++){
			log.debug("Starting Measurement "+n);
			try {
				L1 = System.nanoTime();
				md = MessageDigest.getInstance(digestAlgorithm);
				L2 = System.nanoTime();
				getInstanceMeasurements.add(L2-L1);
			
				
				L3 = System.nanoTime();
//				for(int j=0; j<nrOfChainings; j++){
//					System.out.print(".");
					md.update(this.randomInputData[randomDataUnitsIndexes[n]]);
//				}
				L4 = System.nanoTime();
				updateTotalMeasurements.add(L4-L3);
//				System.out.println(":");
				
				L5 = System.nanoTime();
				hashes[n] = md.digest();
				L6 = System.nanoTime();
				digestMeasurements.add(L6-L5);
				
				//flip one byte in each data array :-)
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			for(int j=0; j<randomInputData.length; j++){
				randomInputData[j][rd.nextInt(randomInputData[0].length)] = (new Integer(rd.nextInt(256))).byteValue();
			}
//			hashesHashes[i] = md.digest(hashes[rd.nextInt(nrOfChainings)]);
			//TODO only the last measurement is logged...
//			log.debug((L2-L1)+" ns for MD creation (incl. nanoTime())");
//			log.debug((L4-L3)+" ns for "/*+nrOfChainings*/+" MD update(s) (incl. nanoTime())");
////			log.info((L4-L3)/*/nrOfChainings*/+" ns for MD update (incl. nanoTime() share)");
//			log.debug((L6-L5)+" ns for MD digest (incl. nanoTime())");
//			log.debug(hashes);
		}
		Collections.sort(getInstanceMeasurements);
		Collections.sort(updateTotalMeasurements);
		Collections.sort(digestMeasurements);
		log.info(getInstanceMeasurements.get(0)+" ns: min of getInstance(...)");
		log.info(updateTotalMeasurements.get(0)+" ns: min of update(...)");
		log.info(digestMeasurements.get(0)+" ns: min of digest()");
		log.info(getInstanceMeasurements.get(getInstanceMeasurements.size()-1)+" ns: max of getInstance(...)");
		log.info(updateTotalMeasurements.get(updateTotalMeasurements.size()-1)+" ns: max of update(...)");
		log.info(digestMeasurements.get(digestMeasurements.size()-1)+" ns: max of digest()");
		
		Long[] ret = new Long[3];
		ret[0] = getInstanceMeasurements.get(getInstanceMeasurements.size()/2);
		ret[1] = updateTotalMeasurements.get(updateTotalMeasurements.size()/2);
		ret[2] = digestMeasurements.get(digestMeasurements.size()/2);
		log.debug("======================================================");
		log.info(ret[0]+" ns: median of getInstance(...)");
		log.info(ret[1]+" ns: median of update(...)");
		log.info(ret[2]+" ns: median of digest()");
		this.writeToMasterAndPieceCSVFiles(
				platfromDesc, 
				jvmConfDesc, 
				jitConfDesc, 
				digestAlgorithm, 
				new Integer(nrOfMeasurements), 
				new Boolean(digestImmediately), 
				new Integer(inputSize), 
				new Integer(nrOfDifferentRandomInputs), 
				DEFAULT_MASTER_CSV_FILE, 
				ret);
//			StringBuffer sb = new StringBuffer();
//			for(int i=0; i<hashes.length; i++){
//				sb.append(hashes[i]+", ");
//			}
//			sb.append("\n");
//			log.debug(sb.toString());
		return ret;
	}
		
	/** TODO
	 * @param platfromDesc
	 * @param jvmConfDesc
	 * @param jitConfDesc
	 * @param digestAlgorithm
	 * @param nrOfMeasurements
	 * @param digestImmediately
	 * @param inputSize
	 * @param nrOfDifferentRandomInputs
	 * @param masterFilePath
	 * @param values
	 * @return
	 */
	public String writeToMasterAndPieceCSVFiles(
				List<String> platfromDesc,
				List<String> jvmConfDesc,
				List<String> jitConfDesc,
				List<String> digestAlgorithm,
				List<Integer> nrOfMeasurements,
				List<Boolean> digestImmediately,
				List<Integer> inputSize,
				List<Integer> nrOfDifferentRandomInputs,
				String masterFilePath,
				List<Long[]> values){
//		FileOutputStream fos = new FileOutputStream(masterFilePath);
		FileWriter fwMaster;
		FileWriter fwPiece;
		String retString = null;
		try {
			File masterFile = new File(masterFilePath);
			boolean masterFileExists = masterFile.exists();
			log.debug(masterFile.length());
			fwMaster = new FileWriter(masterFilePath, true);
			fwPiece = new FileWriter((System.currentTimeMillis()+".digestmeasurement.csv"), true);
			
			StringBuffer sb = new StringBuffer();
			sb.append("\"Platform description\"," +
					"\"JVM conf\"," +
					"\"JIT conf\"," +
					"\"digest algo\"," +
					"\"nr of measurements\"," +
					"\"immediate digesting?\"," +
					"\"input size\"," +
					"\"nr of diff. rd. inputs\"");
			for(int i=0; i<values.get(0).length; i++){
				sb.append(", \"value"+i+"\""); //TODO make column names parametrisable
			}
			sb.append("\n");
				
			if(!masterFileExists){
				log.debug("Master file does not exist");
				fwMaster.append(sb.toString());
			}else{
				log.debug("Master file already exists");
			}
			fwPiece.append(sb.toString());
			retString  = sb.toString();
			sb = new StringBuffer();
			for(int i=0; i<platfromDesc.size(); i++){
				sb.append(
						"\""+platfromDesc.get(i)+"\""+","+
						"\""+jvmConfDesc.get(i)+"\""+","+
						"\""+jitConfDesc.get(i)+"\""+","+
						"\""+digestAlgorithm.get(i)+"\""+","+
						nrOfMeasurements.get(i)+"\""+","+
						"\""+digestImmediately.get(i)+"\""+","+
						inputSize.get(i)+","+
						nrOfDifferentRandomInputs.get(i));
				Long[] valuesToWrite = values.get(i);
				for(int w = 0; w<valuesToWrite.length; w++){
					sb.append(","+valuesToWrite[w]);
				}
				sb.append("\n");
			}
			fwMaster.append(sb.toString());
			fwPiece.append(sb.toString());
			retString += sb.toString();
			fwMaster.close();
			fwPiece.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return retString;
	}
	
	/** Creates lists from single characteristics 
	 * and delegates writing List-taking counterpart
	 * @param platfromDesc
	 * @param jvmConfDesc
	 * @param jitConfDesc
	 * @param digestAlgorithm
	 * @param nrOfMeasurements
	 * @param digestImmediately
	 * @param inputSize
	 * @param nrOfDifferentRandomInputs
	 * @param masterFilePath
	 * @param values
	 * @return
	 */
	public String writeToMasterAndPieceCSVFiles(
			String platfromDesc,
			String jvmConfDesc,
			String jitConfDesc,
			String digestAlgorithm,
			Integer nrOfMeasurements,
			Boolean digestImmediately,
			Integer inputSize,
			Integer nrOfDifferentRandomInputs,
			String masterFilePath,
			Long[] values){
		
		ArrayList<String> a = new ArrayList<String>();
		a.add(platfromDesc);
		ArrayList<String> b = new ArrayList<String>();
		b.add(jvmConfDesc);
		ArrayList<String> c = new ArrayList<String>();
		c.add(jitConfDesc);
		ArrayList<String> d = new ArrayList<String>();
		d.add(digestAlgorithm);
		ArrayList<Integer> e = new ArrayList<Integer>();
		e.add(nrOfMeasurements);
		ArrayList<Boolean> f = new ArrayList<Boolean>();
		f.add(digestImmediately);
		ArrayList<Integer> g = new ArrayList<Integer>();
		g.add(inputSize);
		ArrayList<Integer> h = new ArrayList<Integer>();
		h.add(nrOfDifferentRandomInputs);
		ArrayList<Long[]> i = new ArrayList<Long[]>();
		i.add(values);
		return this.writeToMasterAndPieceCSVFiles(a,b,c,d,e,f,g,h,
				masterFilePath,i);
	}
	
//	private synchronized Map<String,Double> run(int times) throws InterruptedException {
//		Map<String,Double> res = new HashMap<String,Double>();
//		res.put("abs",this.benchmarkAbsDouble(times));
//		Thread.sleep(2000);
//		res.put("min",this.benchmarkMinInt(times));
//		Thread.sleep(2000);
//		res.put("loop_int",this.benchmarkForLoop_int(times));
//		Thread.sleep(2000);
//		res.put("loop_double",this.benchmarkForLoop_double(times));
//		Thread.sleep(2000);
//		StringBuffer sb = new StringBuffer();
//		sb.append(	"with times = "+times+": "+
//					"\n loop_int:         "+res.get("loop_int")+"" +
//					"\n loop_double:      "+res.get("loop_double")+"" +
//					"\n min with loop:    "+res.get("min")+"" +
//					"\n abs with loop:    "+res.get("abs")+"\n" +
//					"\n min without loop: "+(res.get("min")-res.get("loop_int"))+"" +
//					"\n abs without loop: "+(res.get("abs")-res.get("loop_double"))+"");
//		log.info(sb.toString());
//		return res;
//	}
//
//	private synchronized Double benchmarkForLoop_int(int times) throws InterruptedException {
//		Random rd = new Random();
//		int[] ziel = new int[times];
//		for(int i=0; i<times; i++){
//			ziel[i] = rd.nextInt(); 
//		}
//		Thread.sleep(500);
//		long start = 0L;
//		long stop = 0L;
//		start = System.nanoTime();
//		for(int i=0; i<times; i++){
//			ziel[i]++;
//		}
//		stop = System.nanoTime();
//		log.debug("Duration: "+(stop-start));
//		return ((double)(stop-start))/((double)(times));
//	}
//
//	private synchronized Double benchmarkMinInt(int times) throws InterruptedException {
//		Random rd = new Random();
//		int[] links = new int[times];
//		int[] rechts = new int[times];
//		int[] ziel = new int[times];
//		for(int i=0; i<times; i++){
//			links[i] = rd.nextInt(); 
//			rechts[i] = rd.nextInt(); 
//			ziel[i] = rd.nextInt(); 
//		}
//		Thread.sleep(500);
//		long start = 0L;
//		long stop = 0L;
//		start = System.nanoTime();
//		for(int i=0; i<times; i++){
//			ziel[i] = Math.min(links[i], rechts[i]);
//			ziel[i]++;
//		}
//		stop = System.nanoTime();
//		log.debug("Duration: "+(stop-start));
//		return ((double)(stop-start))/((double)(times));
//	}
//
//	private synchronized Double benchmarkAbsDouble(int times) throws InterruptedException {
//		Random rd = new Random();
//		double[] quelle = new double[times];
//		double[] ziel = new double[times];
//		for(int i=0; i<times; i++){
//			quelle[i] = rd.nextDouble(); 
//			ziel[i] = rd.nextDouble(); 
//		}
//		Thread.sleep(500);
//		long start = 0L;
//		long stop = 0L;
//		start = System.nanoTime();
//		for(int i=0; i<times; i++){
//			ziel[i] = Math.abs(quelle[i]);
//			ziel[i]++;
//		}
//		stop = System.nanoTime();
//		log.debug("Duration: "+(stop-start));
//		return ((double)(stop-start))/((double)(times));
//	}
//	
//	private synchronized Double benchmarkForLoop_double(int times) throws InterruptedException {
//		Random rd = new Random();
//		double[] ziel = new double[times];
//		for(int i=0; i<times; i++){
//			ziel[i] = rd.nextDouble(); 
//		}
//		Thread.sleep(500);
//		long start = 0L;
//		long stop = 0L;
//		start = System.nanoTime();
//		for(int i=0; i<times; i++){
//			ziel[i]++;
//		}
//		stop = System.nanoTime();
//		log.debug("Duration: "+(stop-start));
//		return ((double)(stop-start))/((double)(times));
//	}
}
