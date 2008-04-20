package de.uka.ipd.sdq.palladiofileshare.testdriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.logger.Log;
import de.uka.ipd.sdq.logger.LogFilter;
import de.uka.ipd.sdq.logger.LogPrinterFactory;
import de.uka.ipd.sdq.palladiofileshare.businesslogic.BusinessFacade;
import de.uka.ipd.sdq.palladiofileshare.businesslogic.CopyrightedMaterialDatabase;
import de.uka.ipd.sdq.palladiofileshare.businesslogic.ExistingFilesDatabase;
import de.uka.ipd.sdq.palladiofileshare.businesslogic.FileType;
import de.uka.ipd.sdq.palladiofileshare.businesslogic.IBusinessFacade;

public class TestDriver {

	private static IBusinessFacade facade;
	
	private static Logger logger = Logger.getLogger(TestDriver.class);
	
	private static int numberOfOpenUploads = 0;
	
	private static final int numberOfUsers = 1/*20*/; //default: 30 //TODO CAPS for CONSTANTS!
	
	private static Random random;
	
	private static final int randomSeed = 12345; //default: 12345

	//List because each TestDataStruct contains several files
	private static Map<TestDataStruct,long[]> totalMeasurements;

	private static final String[] uploadableFiles = {
			"j0.jpg",
			"j1.jpg",
			"j2.jpg",
			"j3.jpg",
			"j4.jpg",
			"j5.jpg",
			"j6.jpg",
			"j7.jpg",
			"j8.jpg",
			"j9.jpg",
			"p0.pdf",
			"p1.pdf",
			"p2.pdf",
			"p3.pdf",
			"p4.pdf",
			"p5.pdf",
			"p6.pdf",
			"p7.pdf",
			"p8.pdf",
			"p9.pdf",
//			"tiny.txt",
//		    "small.txt",
//		    "medium.txt",
//			"long.txt",
//			"superlong.txt",
//			"small.jpg",
//			"medium.jpg",
//			"large.jpg",
//			"small.zip",
//			"medium.zip",
//			"large.zip"
		};
		
	/**
	 * needs to terminate with a "/"
	 */
	private static final String uploadableFilesDirectory = "input/testFiles/";
	
	private static final int userArrivalDelayMs = 5000;
	
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

	public static void main(String args[]) {
		
		boolean measure = true;
		if(args!=null && args.length>0){
			measure = true;
		}
		boolean monitor = false;
		logger.info("Starting TestDriver (measure: "+measure+", " +
				"monitor: "+monitor+")");
		new TestDriver().start(measure, monitor);		
		logger.info("Finished TestDriver");
	}

	public synchronized static void recordPerformance(
			long uploadId, 
			String[] fileIds,
			long[] measurements){
		logger.debug("called by uploader with id "+uploadId);
		numberOfOpenUploads--;
		TestDataStruct currKey;
		long currUploadId;
		long[] currValue;
		Set<TestDataStruct> keySet = totalMeasurements.keySet();
		TestDataStruct[] keyArray = keySet.toArray(new TestDataStruct[]{});
		int i=0;
    	for(; i<keyArray.length; i++){
    		currKey = keyArray[i];
    		currUploadId = currKey.getUploadId();
    		if(currUploadId==uploadId){
    			currValue = totalMeasurements.get(currKey);
    			if(currValue!=null){
    				System.out.println("ERROR: re-recording performance " +
    						"for uploadId "+uploadId+"; RETURNING PREMATURELY");
    				return;
    			}else{
    				//fileID <--> measurement mapping implicitly given because
    				//in one upload, the files are processed sequentially
    				totalMeasurements.put(currKey, measurements);
    			}
    			i=keyArray.length; //premature loop exit
    		}
    	}
    	if(numberOfOpenUploads==0){ //write CSV file here
    		reportCompletedMeasurements(uploadId);
    	}
    }	
		
	/**
	 * CSV-Schema: uploadId, fileId (oder "all"), isCompressed ("mixed" falls "all"), first measurement, second measurement (falls nicht "all")
	 * @param uploadId
	 */
	private static void reportCompletedMeasurements(long uploadId){
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(
					"TotalMeasurements."+System.currentTimeMillis()+".csv");
			TestDataStruct currKey;
			Set<TestDataStruct> keySet;
			TestDataStruct[] keyArray;
			int i;
			logger.debug("Last upload finished, now reporting...");
			keySet = totalMeasurements.keySet();
			keyArray = keySet.toArray(new TestDataStruct[]{});
			
			StringBuffer csvSB = new StringBuffer();
			
			long currUploadId;
			long[] currValues;
			byte[][] currFiles;
			String[] currFileIds;
			int[] currFileTypes;
	
			for(i=0; i<keyArray.length; i++){
				currKey = keyArray[i];
				currValues = totalMeasurements.get(currKey);
				
				currUploadId = currKey.getUploadId();
				currFiles = currKey.getInputFiles();
				currFileIds = currKey.getInputFileIds();
				currFileTypes = currKey.getInputFileTypes();
				
				csvSB.append(
						currUploadId+";"+
						-1+";"+
						-1+";"+
						currValues[currValues.length-1]+";"+
						-1+";"+
						"\n");
				
				int isCompressedInt;
				for(int j=0; j<currFiles.length; j++){
					if(currFileTypes[j]==FileType.COMPRESSED){
						isCompressedInt = 1;
					}else{
						isCompressedInt = 0;
					}
					csvSB.append(
							currUploadId+";"+
							currFileIds[j]+";"+
							isCompressedInt+";"+
							currValues[2*j]+";"+
							currValues[2*j+1]+";"+
							"\n");
				}
			}
			System.out.println(csvSB.toString());
			fos.write(csvSB.toString().getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}    
    
	public TestDriver() {	
		random = new Random(randomSeed);
		facade = new BusinessFacade();
		totalMeasurements = new HashMap<TestDataStruct, long[]>(numberOfUsers);
	} 
	
	//	/**
//	 * Creates a one file selection from the list of files.
//	 * @return
//	 */
//	@SuppressWarnings("unused")
//	private TestDataStruct createSingleFileTestDataStruct() {		
//		int numberOfAllFiles = uploadableFiles.length;
//		int numberOfFilesForUpload = 1;
//	
//		byte[][] inputFiles = new byte[numberOfFilesForUpload][];
//		int[] inputFileTypes = new int[numberOfFilesForUpload];	
//				
//		//random pick from list of all files
//		int selectedFile = random.nextInt(numberOfAllFiles);
//		inputFiles[0] =
//				fillBuffer(uploadableFilesDirectory + uploadableFiles[selectedFile]);
//		if(uploadableFiles[selectedFile].endsWith(".txt")) {
//			inputFileTypes[0] =
//				FileType.TEXT;
//		} else {
//			inputFileTypes[0] =
//				FileType.COMPRESSED;
//		}
//		
//		TestDataStruct testData = new TestDataStruct();
//		testData.setInputFiles(inputFiles);
//		testData.setInputFileTypes(inputFileTypes);		
//		return testData;
//	}
//	
	/**
	 * Creates a selection of n files from the list of files.
	 * Might contain duplicate files.
	 * @return
	 */
	private TestDataStruct createTestDataStruct() {		
		int numberOfAllFiles = uploadableFiles.length;
		int numberOfFilesForUpload = random.nextInt(numberOfAllFiles);
		if(numberOfFilesForUpload == 0) {
			numberOfFilesForUpload = 1;//TODO document higher probability: important for PCM
		}
	
		byte[][] inputFiles = new byte[numberOfFilesForUpload][];
		int[] inputFileTypes = new int[numberOfFilesForUpload];	
		String[] inputFileIds = new String[numberOfFilesForUpload];	
				
		for(int x = 0; x < numberOfFilesForUpload; x++) {
			//random pick from list of all files
			int selectedFile = random.nextInt(numberOfAllFiles);
			inputFiles[x] =
					fillBuffer(uploadableFilesDirectory + uploadableFiles[selectedFile]);
			inputFileIds[x] = uploadableFiles[selectedFile];
			if(uploadableFiles[selectedFile].endsWith(".txt")
					|| uploadableFiles[selectedFile].endsWith(".pdf")) {
				inputFileTypes[x] =
					FileType.TEXT;
			} else {
				inputFileTypes[x] =
					FileType.COMPRESSED;
			}
		}

		//uploadId generated by the constructor internally
		TestDataStruct testData = new TestDataStruct(
				inputFileIds,
				inputFiles,
				inputFileTypes);
		return testData;//TODO log this instance!
	}
	
	/**
     * KK: Parameter logging
     */
	private void finishKKLogging() {
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			logger.error(e);
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
    
    /**
     * This seems to be sequential, but threads are spun off 
     * in the implementation of BusinessFacade
     */
    public void start(
    		boolean measure, 
    		boolean monitor) {		
		logger.debug("Measure: "+measure+", monitor: "+monitor);
    	
		//getting singleton to prevent the costs during "real" measurements
		CopyrightedMaterialDatabase cmd = CopyrightedMaterialDatabase.getSingleton();
		logger.debug("CopyrightedMaterialDatabase test: "+cmd.isCopyrightedMaterial(new byte[]{1}));

		//getting singleton to prevent the costs during "real" measurements
		ExistingFilesDatabase efd = ExistingFilesDatabase.getSingleton();
		logger.debug("ExistingFilesDatabase test: "+efd.existsInDatabase(new byte[]{1}));
		
    	if(numberOfOpenUploads>0){
			logger.error("CANNOT START NEW LOAD WHILE EXECUTING THE PREVIOUS ONE");
			return;
		}
		long start = 0;
		long stop = 0;
		System.out.println("===============================================\n");
		logger.debug("Users: "+numberOfUsers+", measure: "+measure+", monitor: "+monitor);

    	for(int x = 0; x < numberOfUsers; x++) {
			try {
				Thread.sleep(userArrivalDelayMs);
			} catch (InterruptedException e) {
				logger.error(e);
			}
			
			TestDataStruct testData = this.createTestDataStruct(); //default
			TestDriver.totalMeasurements.put(testData,null);
			//TestDataStruct testData = createSingleFileTestDataStruct();
			numberOfOpenUploads++;
			logger.info("Starting upload with id "+testData.getUploadId()+"" +
					"("+testData.getInputFiles().length+" files)");
			start = System.nanoTime();
			//TODO subsequent call should go over the interface!!!
			facade.uploadFiles(
					testData.getUploadId(), //user-specific, one-per-upload
					testData.getInputFiles(), 
					testData.getInputFileIds(),
					testData.getInputFileTypes(),
					measure,
					monitor);
			stop = System.nanoTime();
			System.out.println("Starting upload took " +
					(stop-start)+" ns (upload id: "+testData.getUploadId()+")");
//			currMeasurements.add(stop-start);
//			totalMeasurements.put(testData, currMeasurements);
			//TODO analyse these results
		}
		logger.debug(numberOfOpenUploads+" open uploads");
    	if(monitor) {
    		//KK-Log:
    		finishKKLogging();		
    	}
	}
}
