package de.uka.ipd.sdq.palladiofileshare.testdriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
	
	public class InputFileStruct{
		public byte[] data;
		public String id;
		public int type;
		
		public InputFileStruct( 
				byte[] data,
				String id,
				int type){
			this.id = id;
			this.data = data;
			this.type = type;
		}
		
		public int compareTo(){//<InputFileStruct>
			return 0;
		}
		
		public void convertListToLists(
				List<InputFileStruct> input,
				byte[][] outputData,
				String[] outputId,
				int[] outputType
				){
			InputFileStruct currInputFileStruct;
			int i=0;
			for (Iterator<InputFileStruct> iterator = input.iterator(); 
				iterator.hasNext();) {
				currInputFileStruct = iterator.next();
				outputData[i] = currInputFileStruct.data;
				outputId[i] = currInputFileStruct.id;
				outputType[i] = currInputFileStruct.type;
				i++;
			}
		}
	}

	public class MeasurementResultByFileId{
		public long durationPartOne;
		public long durationPartTwo;
		public String fileId;
		public int fileIsCompressed;
		public long uploadId;
		
		public MeasurementResultByFileId(
				long uploadId,
				String fileId,
				int fileIsCompressed,
				long durationPartOne,
				long durationPartTwo){
			this.uploadId = uploadId;
			this.fileId = fileId;
			this.fileIsCompressed = fileIsCompressed;
			this.durationPartOne = durationPartOne;
			this.durationPartTwo = durationPartTwo;
		}
	}

	private static final int DEFAULT_NUMBER_OF_USERS = 1; //default: 30
	
	private static final int DEFAULT_PERMUTATION_REPEATABILITY_FACTOR = 4;
	
	private static final int DEFAULT_RANDOM_SEED = 12345; //default: 12345
	
	private static final String[] DEFAULT_UPLOADABLE_FILES = {
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
	private static final String DEFAULT_UPLOADABLE_FILES_DIRECTORY = "input/testFiles/";
	
	private static final int DEFAULT_UPLOADED_FILES_NR = 10*DEFAULT_UPLOADABLE_FILES.length;//numberOfAllFiles+random.nextInt(numberOfAllFiles);
	
	private static final int DEFAULT_USER_ARRIVAL_DELAY_MS = 5000;

	private static IBusinessFacade facade;

	private static Logger logger = Logger.getLogger(TestDriver.class);
		
	private static int numberOfOpenUploads = 0;
	
	private static int numberOfUsers = DEFAULT_NUMBER_OF_USERS;
	
	private static Random random;
	
	private static TestDriver singletonTestDriver;
	
	//List because each TestDataStruct contains several files
	private static Map<TestDataStruct, long[]> totalMeasurements;
	
	/**
	 * from SPEC
	 * @param fileName
	 * @return
	 */
    private static byte[] fillByteBufferFromFile(String fileName) {
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

	public static TestDriver getInstance() {
		if(singletonTestDriver==null){
			singletonTestDriver = new TestDriver();
		}
		return singletonTestDriver;
	}
	
	public static void main(String args[]) {
		
		boolean measure = true;
		if(args!=null && args.length>0){
			measure = true;
		}
		boolean monitor = false;
		logger.info("Starting TestDriver (measure: "+measure+", " +
				"monitor: "+monitor+")");
		TestDriver.getInstance().start(measure, monitor);		
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
    		TestDriver.getInstance().reportCompletedMeasurements(uploadId);
    	}
    }

	private boolean generatePermutationOfAllUploadableFiles = true;

	public TestDriver() {	
		random = new Random(DEFAULT_RANDOM_SEED);
		facade = new BusinessFacade();
		totalMeasurements = new HashMap<TestDataStruct, long[]>(numberOfUsers);
	}	
		
	//	/**
//	 * Creates a one file selection from the list of files.
//	 * @return
//	 */
//	@SuppressWarnings("unused")
//	private TestDataStruct createSingleFileTestDataStruct() {		
//		int numberOfAllFiles = DEFAULT_UPLOADABLE_FILES.length;
//		int numberOfFilesForUpload = 1;
//	
//		byte[][] inputFiles = new byte[numberOfFilesForUpload][];
//		int[] inputFileTypes = new int[numberOfFilesForUpload];	
//				
//		//random pick from list of all files
//		int selectedFile = random.nextInt(numberOfAllFiles);
//		inputFiles[0] =
//				fillBuffer(DEFAULT_UPLOADABLE_FILES_DIRECTORY + DEFAULT_UPLOADABLE_FILES[selectedFile]);
//		if(DEFAULT_UPLOADABLE_FILES[selectedFile].endsWith(".txt")) {
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
		int numberOfAllFiles = DEFAULT_UPLOADABLE_FILES.length;
		
		int numberOfFilesForUpload;
		if(generatePermutationOfAllUploadableFiles){
			numberOfFilesForUpload = numberOfAllFiles*DEFAULT_PERMUTATION_REPEATABILITY_FACTOR;
		}else{
			numberOfFilesForUpload = DEFAULT_UPLOADED_FILES_NR;
		}
		if(numberOfFilesForUpload == 0) {
			numberOfFilesForUpload = 1;//TODO document higher probability: important for PCM
		}
		
		TestDataStruct testData = generateRandomTestData(numberOfAllFiles,
				numberOfFilesForUpload);
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
		Log.WriteToFile(LogPrinterFactory.getCSVOutput(), logFilter, new java.io.File("c:\\out.csv"));
		    		    	
		Log.invalidateCache();		
	}    
    
	private TestDataStruct generateRandomTestData(
			int numberOfAllFiles,
			int numberOfFilesForUpload) {
		byte[][] inputFiles;
		int[] inputFileTypes;
		String[] inputFileIds;

		inputFiles= new byte[numberOfFilesForUpload][];
		inputFileTypes = new int[numberOfFilesForUpload];	
		inputFileIds = new String[numberOfFilesForUpload];	
		
		List<InputFileStruct> inputFileStructsList;
		inputFileStructsList= new ArrayList<InputFileStruct>();				
		int selectedFile = 0;
		for(int x = 0; x < numberOfFilesForUpload; x++) {
			//random pick from list of all files
			if(generatePermutationOfAllUploadableFiles){
				selectedFile = x%numberOfAllFiles;
			}else{
				selectedFile = random.nextInt(numberOfAllFiles)%numberOfAllFiles;
			}

			inputFileIds[x]  = DEFAULT_UPLOADABLE_FILES[selectedFile];
			inputFiles[x]    = fillByteBufferFromFile(DEFAULT_UPLOADABLE_FILES_DIRECTORY + inputFileIds[x]);
			if(inputFileIds[x].endsWith(".txt") || inputFileIds[x].endsWith(".pdf")) {
				inputFileTypes[x] = FileType.TEXT;
			} else {
				inputFileTypes[x] = FileType.COMPRESSED;
			}
			if(generatePermutationOfAllUploadableFiles){
				inputFileStructsList.add(new InputFileStruct(inputFiles[x], inputFileIds[x], inputFileTypes[x]));
			}
		}
		if(generatePermutationOfAllUploadableFiles){
			logger.debug("original ids:"+Arrays.toString(inputFileIds));
			logger.debug("original types:"+Arrays.toString(inputFileTypes));
			Collections.shuffle(inputFileStructsList);
			new InputFileStruct(null,"",1).convertListToLists(
					inputFileStructsList, 
					inputFiles, 
					inputFileIds, 
					inputFileTypes);
			logger.debug("permutatted ids:"+Arrays.toString(inputFileIds));
			logger.debug("permutatted types:"+Arrays.toString(inputFileTypes));
		}

		//uploadId generated by the constructor internally
		TestDataStruct testData = new TestDataStruct(
				inputFileIds,
				inputFiles,
				inputFileTypes);
		return testData;
	}

	private void printInputFileSizesToCSV(){
		File f;
		StringBuffer csvSB = new StringBuffer();
		for(int i=0; i<DEFAULT_UPLOADABLE_FILES.length; i++){
			f = new File(DEFAULT_UPLOADABLE_FILES_DIRECTORY+DEFAULT_UPLOADABLE_FILES[i]);
			csvSB.append(DEFAULT_UPLOADABLE_FILES[i]+";"+f.length()+";"+"\n");
		}
//		logger.debug(csvSB.toString());
		try {
			String fileSizesCSVPath = "results"+File.separator+"UploadFileSizes.csv";
			f = new File(fileSizesCSVPath);
			if(f.exists()) f.delete();
			f=null;
			FileOutputStream fw = new FileOutputStream(fileSizesCSVPath);
			fw.write(csvSB.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 
	
/**Format of the CSV file: 
	 * 		fileId, compressed, 
	 * 		min one, avg one , median one , max one, 
	 * 		min two, avg two , median two , max two, 
	 * 		then one-by-one: upload id, duration part one, duration part two 
	 * @param resultsByFileId
	 */
	private void printResultsByFileId(
			Map<String, List<MeasurementResultByFileId>> resultsByFileId,
			long fileNameRoot) {
		StringBuffer csvSB = new StringBuffer();
		String currKey;
		List<MeasurementResultByFileId> currValue;
		int currIsCompressed;
		Set<String> keySet = resultsByFileId.keySet();
		String[] keySetArray = keySet.toArray(new String[]{});
		Arrays.sort(keySetArray);

		int maxNrOfMeasurementsForAFile=0;
		int currSize;
		for (int u=0; u<keySetArray.length; u++) {
			currSize = resultsByFileId.get(keySetArray[u]).size();
			if(currSize>maxNrOfMeasurementsForAFile){
				maxNrOfMeasurementsForAFile = currSize;
			}
		}
		
//		csvSB.append(
//				"\"File ID\";"+
//				"\"Compressed\";"+
//				"\"Min of 1st measurement\";"+
//				"\"Avg of 1st measurement\";"+
//				"\"Med of 1st measurement\";"+
//				"\"Max of 1st measurement\";"+
//				"\"Min of 2nd measurement\";"+
//				"\"Avg of 2nd measurement\";"+
//				"\"Med of 2nd measurement\";"+
//				"\"Max of 2nd measurement\";");
		csvSB.append(
				"\"File ID\";"+
				"\"Compressed\";"+
				"\"part\";"+
				"\"Min of all measurements\";"+
				"\"Avg of all measurements\";"+
				"\"Med of all measurements\";"+
				"\"Max of all measurements\";");
		for(int i=0; i<maxNrOfMeasurementsForAFile; i++){
//			csvSB.append(
//					"\"Upload ID\";"+
//					"\"1st part\";"+
//					"\"2nd part\";");
			csvSB.append(
					"\"Upload ID\";"+
					"\"value\";");
		}
		csvSB.append("\n");

		for(int i=0; i<keySetArray.length; i++){
			currKey = keySetArray[i];//file name
			currValue = resultsByFileId.get(currKey);//List of MeasurementResultByFileId
			logger.debug(currValue.size()+" results for key "+currKey);
			if(currValue.size()==0){
				csvSB.append(
						"\""+currKey+"\";");
				csvSB.append("\n");
			}else{
				currIsCompressed = currValue.get(0).fileIsCompressed;
				
				List<Long> durationsOne = new ArrayList<Long>();
				List<Long> durationsTwo = new ArrayList<Long>();
				long sumDurationsOne = 0L;
				long sumDurationsTwo = 0L;
				for(MeasurementResultByFileId value : currValue){
					durationsOne.add(value.durationPartOne);
					sumDurationsOne += value.durationPartOne;
					durationsTwo.add(value.durationPartTwo);
					sumDurationsTwo += value.durationPartTwo;
				}
				Collections.sort(durationsOne);
				long minOne = durationsOne.get(0);
				long avgOne = sumDurationsOne/currValue.size();
				long medOne = durationsOne.get(durationsOne.size()/2);
				long maxOne = durationsOne.get(durationsOne.size()-1);
				
				Collections.sort(durationsTwo);
				long minTwo = durationsTwo.get(0);
				long avgTwo = sumDurationsTwo/currValue.size();
				long medTwo = durationsTwo.get(durationsTwo.size()/2);
				long maxTwo = durationsTwo.get(durationsTwo.size()-1);
//				csvSB.append(
//						"\""+currKey+"\";"+
//						currIsCompressed+";"+
//						minOne+";"+
//						avgOne+";"+
//						medOne+";"+
//						maxOne+";"+
//						minTwo+";"+
//						avgTwo+";"+
//						medTwo+";"+
//						maxTwo+";");
//				for(MeasurementResultByFileId value : currValue){
//					csvSB.append(
//							value.uploadId+";"+
//							value.durationPartOne+";"+
//							value.durationPartTwo+";");
//				}
				csvSB.append(
						"\""+currKey+"\";"+
						currIsCompressed+";"+
						"first"+";"+
						minOne+";"+
						avgOne+";"+
						medOne+";"+
						maxOne+";");
				for(MeasurementResultByFileId value : currValue){
					csvSB.append(
							value.uploadId+";"+
							value.durationPartOne+";");
				}
				csvSB.append("\n");
				
				csvSB.append(
						"\""+currKey+"\";"+
						currIsCompressed+";"+
						"second"+";"+
						minTwo+";"+
						avgTwo+";"+
						medTwo+";"+
						maxTwo+";");
				for(MeasurementResultByFileId value : currValue){
					csvSB.append(
							value.uploadId+";"+
							value.durationPartTwo+";");
				}
				csvSB.append("\n");
			}
		}
		
		System.out.println(csvSB.toString());
		
		try {
			FileOutputStream fos = new FileOutputStream("./results/"+
					"TotalMeasurements."+fileNameRoot+".byFile.csv");
			fos.write(csvSB.toString().getBytes());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * CSV-Schema: uploadId, fileId (oder "all"), isCompressed ("mixed" falls "all"), 
	 * first measurement, second measurement (falls nicht "all")
	 * @param uploadId
	 */
	private void reportCompletedMeasurements(long uploadId){
		FileOutputStream fos;
		Map<String , List<MeasurementResultByFileId>> resultsByFileId;
		resultsByFileId = new HashMap<String, List<MeasurementResultByFileId>>();
		for(int i=0; i<DEFAULT_UPLOADABLE_FILES.length; i++){
			resultsByFileId.put(DEFAULT_UPLOADABLE_FILES[i], new ArrayList<MeasurementResultByFileId>());
		}
		
		long fileNameRoot = System.currentTimeMillis();
		try {
			fos = new FileOutputStream("./results/"+
					"TotalMeasurements."+fileNameRoot+".csv");
			TestDataStruct currKey;
			Set<TestDataStruct> keySet;
			TestDataStruct[] keyArray;
			int i;
			logger.debug("Last upload finished, now reporting...");
			keySet = totalMeasurements.keySet();
			keyArray = keySet.toArray(new TestDataStruct[]{});
			Arrays.sort(keyArray);

			StringBuffer csvSB = new StringBuffer();
			csvSB.append(
					"\"Upload ID\";"+
					"\"File ID\";"+
					"\"is compressed\";"+
					"\"first meas.\";"+
					"\"second meas.\";\n");
			
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
						"all"+";"+
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
					resultsByFileId.get(currFileIds[j]).add(
							new MeasurementResultByFileId(
									currUploadId,
									currFileIds[j],
									isCompressedInt,
									currValues[2*j],
									currValues[2*j+1]
							)
						);
				}
			}
			System.out.println(csvSB.toString());
			this.printResultsByFileId(resultsByFileId, fileNameRoot);
			fos.write(csvSB.toString().getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
    /**
     * This seems to be sequential, but threads are spun off 
     * in the implementation of BusinessFacade
     */
    public void start(
    		boolean measure, 
    		boolean monitor) {		
		logger.debug("Measure: "+measure+", monitor: "+monitor);
		printInputFileSizesToCSV();
		
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
				Thread.sleep(DEFAULT_USER_ARRIVAL_DELAY_MS);
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
