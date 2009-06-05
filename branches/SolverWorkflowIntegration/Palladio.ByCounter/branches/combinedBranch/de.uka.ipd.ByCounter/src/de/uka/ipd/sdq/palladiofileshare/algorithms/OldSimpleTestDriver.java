package de.uka.ipd.sdq.palladiofileshare.algorithms;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class OldSimpleTestDriver {

	private static Logger l;
	
	//needs to terminate with a "/"
	private static final String uploadFilesLocation = "input/testFiles/";
	
	private static final String[] uploadFiles = {
			"lesstiny.txt", // index 0 //TODO document change w.r.t. PalladioFileShare
		    "small.txt", 	// index 1
		    "medium.txt", 	// index 2
			"long.txt", 	// index 3
			"superlong.txt",// index 4
			"small.jpg", 	// index 5
			"medium.jpg", 	// index 6
			"large.jpg", 	// index 7
			"small.zip", 	// index 8
			"medium.zip", 	// index 9
			"large.zip" 	// index 10
		};
		
	public OldSimpleTestDriver() {	
		PropertyConfigurator.configure("log4j.properties");
		l = Logger.getLogger(this.getClass().getCanonicalName());
		l.debug("Operation from "+(new File(".")).getAbsolutePath());
	}
	
	/**TODO perform warmup: 16000x with small byte arrays and monitor JIT compilation
	 * TODO use MessageDigest(<cheapesttype>) in a ByteArrayHashMap
	 * TODO profile existing application w.r.t. indexOf for middle-sized problems (100KB)
	 * TODO learn on existing small inputs, then generate even more middle-sized inputs
	 * TODO compare with the performance of existing 7ZIP java implementation
	 * @param args
	 */
	public static void main(String[] args) {
		//assumption: classes have already been instrumented...
		new OldSimpleTestDriver().start(args);		
	}
	
	public final void start(String[] args) {
		if(args!=null && args.length==1){
			Integer param = new Integer(args[0]);
			if(param>=0 && param<11){
				this.runCompression(param);
			}else{
				l.error("Parameter out of range: "+param+" (should be between 0 and 10)");
			}
		}else{
			l.error("Requires exactly one parameter to describe the input data, " +
					"choosing parameter randomly");
			@SuppressWarnings("unused")
			Random rd = new Random();
			this.runCompression(4); //rd.nextInt(uploadFiles.length));
		}
	}

	private final void runCompression(Integer param) {
		FileInputStream sif = null;
		String fullFileName = uploadFilesLocation+uploadFiles[param];
		File inputFile = new File(fullFileName);
        int length = (int) inputFile.length();
//		OutputBuffer ob = null;
		l.debug("Compressing for option "+param+", i.e. file "+
				inputFile.getAbsolutePath()+" (size "+length+")");
		try {
            sif = new FileInputStream(fullFileName);
            byte[] input = new byte[length];
//            byte[] result = new byte[length];
            int readLast = 0;
            int readTotally = 0;
            do{
            	readLast = sif.read(input, readTotally,(length - readTotally));
            	readTotally +=readLast;
            } while (readLast > 0);

            long start = System.nanoTime();
            int[] byteStatistics = new int[256];
            Arrays.fill(byteStatistics, 0);
            for(int i=0; i<input.length; i++){
            	byteStatistics[input[i]+128]++;
            }
            int total = 0;
            for(int i=0; i<byteStatistics.length; i++){
            	System.out.print(byteStatistics[i]+"+");
            	total += byteStatistics[i];
            }
            System.out.println("="+total);
            long finish = System.nanoTime();
            l.debug((finish-start)+" ns to compute statistics");
            
            sif.close(); // release resources
            start = System.nanoTime();
            //TODO can be null if early exit... -> take int case!
            byte[] compressed = OldSimpleLZW.lzwcompress(input, 256*256, false); 
//            ob = Compress.performAction(input, length, Compress.COMPRESS, result);
            finish = System.nanoTime();
            long nsDuration = finish-start;
            long usDuration = nsDuration/1000;
            long msDuration = usDuration/1000;
            
            l.debug(nsDuration+" ns="+usDuration+" us="+msDuration+" ms to compress "+length+" bytes to "+
            		compressed.length+" bytes (i.e., "+compressed.length/2+" chars)");
            
            } catch (IOException e) {
        	l.error(e);
        }
		
	}
}
