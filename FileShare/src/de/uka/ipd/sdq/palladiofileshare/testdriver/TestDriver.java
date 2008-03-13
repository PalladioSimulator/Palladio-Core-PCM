package de.uka.ipd.sdq.palladiofileshare.testdriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.logger.Log;
import de.uka.ipd.sdq.logger.LogFilter;
import de.uka.ipd.sdq.logger.LogPrinterFactory;
import de.uka.ipd.sdq.palladiofileshare.businesslogic.BusinessFacade;
import de.uka.ipd.sdq.palladiofileshare.businesslogic.FileType;

public class TestDriver {

	private static Logger logger = Logger.getLogger(TestDriver.class);
	private static Random random;

	private static final int randomSeed = 12345;
	private static final int numberParallelUsers = 5;
	private static final int userArrivalDelayMs = 1000;
	/**
	 * needs to terminate with a "/"
	 */
	private static final String uploadFilesLocation = "testFiles/";
	private static final String[] uploadFiles = {
			"tiny.txt",
		    "small.txt",
		    "medium.txt",
			"long.txt",
			"superlong.txt",
			"small.jpg",
			"medium.jpg",
			"large.jpg",
			"small.zip",
			"medium.zip",
			"large.zip"
		};
		
	public TestDriver() {	
		random = new Random(randomSeed);
	}
	
	public static void main(String args[]) {
		logger.info("Starting TestDriver");
		new TestDriver().start();		
		logger.info("Finished TestDriver");
	}
	
	public void start() {		
		for(int x = 0; x < numberParallelUsers; x++) {
			try {
				Thread.sleep(userArrivalDelayMs);
			} catch (InterruptedException e) {
				logger.error(e);
			}
			
			TestDataStruct testData = createTestDataStruct();
			BusinessFacade.uploadFiles(
				testData.getInputFiles(), testData.getInputFileTypes());			
		}
		
		//KK-Log:
		finishKKLogging();		
	}


	/**
	 * Creates a selection of n files from the list of files.
	 * Might contain duplicate files.
	 * @return
	 */
	private TestDataStruct createTestDataStruct() {		
		int numberOfAllFiles = uploadFiles.length;
		int numberOfFilesForUpload = random.nextInt(numberOfAllFiles);
		if(numberOfFilesForUpload == 0) {
			numberOfFilesForUpload = 1;
		}
	
		byte[][] inputFiles = new byte[numberOfFilesForUpload][];
		int[] inputFileTypes = new int[numberOfFilesForUpload];	
				
		for(int x = 0; x < numberOfFilesForUpload; x++) {
			//random pick from list of all files
			int selectedFile = random.nextInt(numberOfAllFiles);
			inputFiles[x] =
					fillBuffer(uploadFilesLocation + uploadFiles[selectedFile]);
			if(uploadFiles[selectedFile].endsWith(".txt")) {
				inputFileTypes[x] =
					FileType.TEXT;
			} else {
				inputFileTypes[x] =
					FileType.COMPRESSED;
			}
		}
		
		TestDataStruct testData = new TestDataStruct();
		testData.setInputFiles(inputFiles);
		testData.setInputFileTypes(inputFileTypes);		
		return testData;
	}
		
	/**
	 * from SPEC
	 * @param fileName
	 * @return
	 */
    private static byte[] fillBuffer(String fileName) {
        try {
            FileInputStream sif = new FileInputStream(fileName);
            int length = (int) new File(fileName).length();
            int counter = 0;
            
            // Only allocate size of input file rather than MAX - kmd
            // If compressed file is larger than input file this allocation
            // will fail and out of bound exception will occur
            // In real lie, compress will no do any compression as no
            // space is saved.-- kaivalya
            byte[] result = new byte[length];
            
            int bytes_read;
            while ((bytes_read = sif.read(result, counter,
                    (length - counter))) > 0) {
                counter += bytes_read;
            }
            
            sif.close(); // release resources
            
            if (counter != length) {
                logger.error(
                        "ERROR reading test input file");
            }
            return result;
        } catch (IOException e) {
        	logger.error(e);
        }
        
        return null;
    }    
    
    /**
     * KK: Parameter logging
     */
	private void finishKKLogging() {
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// KK-Log:
		// Specific Setup
		LogFilter logFilter = new LogFilter(true);		
		
		// Outputs
		//Log.WriteToConsole(LogPrinterFactory.getScreenOutput(), logFilter);
		//Log.WriteToFile(LogPrinterFactory.getScreenOutput(), logFilter, new File("out.csv"));
		Log.WriteToFile(LogPrinterFactory.getCSVOutput(), logFilter, new java.io.File("c:\\out.csv"));
		    		    	
		Log.invalidateCache();		
	}
}
