package de.uka.ipd.sdq.palladiofileshare.algorithms.compress_refactored;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class TestDriver {

	private static Logger l;
	
	//needs to terminate with a "/"
	private static final String uploadFilesLocation = "testFiles/";
	
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
		
	public TestDriver() {	
		PropertyConfigurator.configure("log4j.properties");
		l = Logger.getLogger(this.getClass().getCanonicalName());
		l.debug("Operation from "+(new File(".")).getAbsolutePath());
	}
	
	public static void main(String[] args) {
		//assumption: classes have already been instrumented...
		new TestDriver().start(args);		
	}
	
	public void start(String[] args) {
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
			this.runCompression(new Random().nextInt(uploadFiles.length));
		}
	}

	private void runCompression(Integer param) {
		FileInputStream sif = null;
		String fullFileName = uploadFilesLocation+uploadFiles[param];
		File inputFile = new File(fullFileName);
        int length = (int) inputFile.length();
		OutputBuffer ob = null;
		l.debug("Compressing for option "+param+", i.e. file "+
				inputFile.getAbsolutePath()+" (size "+length+")");
		try {
            sif = new FileInputStream(fullFileName);
            byte[] input = new byte[length];
            byte[] result = new byte[length];
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
            ob = Compress.performAction(input, length, Compress.COMPRESS, result);
            finish = System.nanoTime();
            l.debug((finish-start)+" ns to compress "+length+" bytes to "+
            		ob.getBuffer().length+" bytes (in fact, "+ob.getLength()+" bytes)");
            
            } catch (IOException e) {
        	l.error(e);
        }
		
	}
}
