package de.uka.ipd.sdq.palladiofileshare.businesslogic;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.logger.Log;
import de.uka.ipd.sdq.logger.enums.LogDataType;
import de.uka.ipd.sdq.logger.enums.LogType;
import de.uka.ipd.sdq.palladiofileshare.algorithms.Hash;
import de.uka.ipd.sdq.palladiofileshare.algorithms.SimpleLZW;
import de.uka.ipd.sdq.palladiofileshare.businesslogic.storage.IStorage;
import de.uka.ipd.sdq.palladiofileshare.businesslogic.storage.Storage;
import de.uka.ipd.sdq.palladiofileshare.testdriver.TestDriver;

/**
 * The class that actually contains the application logic.
 * @author Klaus Krogmann
 * @author Michael Kuperberg
 */
public class BusinessCore {
	
	/**
	 * log4j logger
	 */
	private Logger logger;
	
	/**
	 * Size in bytes; if larger than this value, a different 
	 * storage system is used
	 */
	private static final int SIZE_OF_LARGE_FILES = 50000; //TODO test	
	
//	private CompressionRunner compression;
	
	// sub-components (internal)
	private CopyrightedMaterialDatabase copyDB;
	private ExistingFilesDatabase fileDB;
	private Hash hash;
	
	// KK-Log:
	private de.uka.ipd.sdq.logger.Logger kkLogger;
	
	private IStorage storageSubSystemLargeFiles;
	
	private IStorage storageSubSystemSmallFiles;

	@SuppressWarnings("unused")
	private long uploadId;
		
	public BusinessCore(long uploadId) {		
		this.copyDB = CopyrightedMaterialDatabase.getSingleton();
		this.fileDB = ExistingFilesDatabase.getSingleton();
		this.hash = new Hash();
		this.kkLogger = Log.getLogger("BusinessCore", this.getClass().getName());
		this.logger = Logger.getLogger(BusinessCore.class);
		this.storageSubSystemLargeFiles = new Storage();
		this.storageSubSystemSmallFiles = new Storage();
		this.uploadId = uploadId;
		
		// KK-Log:
		kkLogger.setAutomaticLogLineAndMethodMode(true);    	
	}

	private void addFileToFileExistingDB(byte[] hash) {
		this.fileDB.addNewFileHash(hash);				
	}

	private byte[] compress(byte[] inputFile) {				
//		byte[] compressedFile = compression.compress(inputFile);	
		byte[] compressedFile = SimpleLZW.lzwcompress_inlined(inputFile, 512);	
		return compressedFile;
	}

	private byte[] getMessageDigest(byte[] inputBytes) {
		return hash.getMessageDigest(inputBytes);		
	}	
	
	private boolean isCopyrightedMaterial(byte[] hash) {
		boolean isCopyrighted = this.copyDB.isCopyrightedMaterial(hash);				
		return isCopyrighted;
	}
	
	private boolean isFileExistingInDB(byte[] hash) {		
		boolean isFileInDB = this.fileDB.existsInDatabase(hash);
		return isFileInDB;
	}
	
	private void storeLargeFile(byte[] file, byte[] fileHash) {
		this.storageSubSystemLargeFiles.storeFile(file, fileHash, true);
	}
	
	private void storeSmallFile(byte[] file, byte[] fileHash) {
		this.storageSubSystemSmallFiles.storeFile(file, fileHash, true);
	}
	
	/**
	 * Should measure total, as well as per-file durations
	 * @param uploadId
	 * @param uploadFiles
	 * @param uploadFileIds
	 * @param uploadFileTypes
	 * @param measure
	 * @param monitor
	 * @return 2*|inputFiles|+1 values: "before saving" and "saving" durations
	 * for each "inner" file, as well as "total duration" for the entire upload.
	 * If no saving will take place, the "saving" duration is -1 
	 * and "before saving" includes all other operations. 
	 */
	public long[] uploadFiles(
			long uploadId, //now unneeded...
			byte[][] uploadFiles, 
			String[] uploadFileIds, 
			int[] uploadFileTypes, 
			boolean measure,
			boolean monitor
			) {	
		long[] measurements = new long[2*uploadFiles.length+1];
		if(monitor) {
			kkLogger.newMethodInvocation();
			kkLogger.addLogEntryData(LogType.MethodCall,
					LogDataType.ParameterValue, "inputFiles.length",
					uploadFiles.length);
			
			for(int x = 0; x < uploadFiles.length; x++) {
				kkLogger.addLogEntryData(LogType.MethodCall,
					LogDataType.ParameterValue, "file-length " + x,
					uploadFiles[x].length);
			}		
			kkLogger.addLogEntryData(LogType.MethodCall,
				LogDataType.ParameterValue, "inputFileTypes.length",
				uploadFiles.length);
			for(int x = 0; x < uploadFileTypes.length; x++) {
				kkLogger.addLogEntryData(LogType.MethodCall,
					LogDataType.ParameterValue, "file-type " + x,
					uploadFileTypes[x]);
			}
		}
		long start = 0L;
		long stop = 0L;
		long innerStart = 0L;
		long innerBeforeSecondLookupAndSaving = -1L;
		long innerStop = 0L;
		if(measure){
			start = System.nanoTime();
		}
		byte[] fileHashAsBytes;		
		byte[] inputFile;
		byte[] compressedFile;
		
		for(int x = 0; x < uploadFiles.length; x++) {			
			if(measure) innerStart = System.nanoTime();//TODO document
			inputFile = uploadFiles[x];						
			
			if(uploadFileTypes[x] == FileType.TEXT) {

				if(monitor){
					// KK-Log:
					kkLogger.addLogEntryData(LogType.BranchSelection,
						LogDataType.Timestamp, "true: TEXT file", true);
					
					// KK-Log:
					kkLogger.addLogEntryData(LogType.BeforeExternalAction,
						LogDataType.ParameterValue, "compressFile.In.length", inputFile.length);
					
					logger.debug("Non-Compressed file. Compressing.");
				}
				compressedFile = this.compress(inputFile);
				
				if(monitor){
					// KK-Log:
					kkLogger.addLogEntryData(LogType.AfterExternalAction,
						LogDataType.ParameterValue, "compressFile.Out.length",
							compressedFile.length);
				}

			} else {
				
				if(monitor){
					// KK-Log:
					kkLogger.addLogEntryData(LogType.BranchSelection,
						LogDataType.Timestamp, "false: COMPRESSED file", false);
					
					logger.debug("Compressed file. Doing nothing.");
				}
				compressedFile = inputFile; //do nothing
			}
			
			if(monitor){
				// KK-Log:
				kkLogger.addLogEntryData(LogType.BeforeExternalAction,
					LogDataType.ParameterValue, "compressedFile.length", compressedFile.length);
			}
			fileHashAsBytes = this.getMessageDigest(compressedFile);			
			
			boolean isCopyrighted = isCopyrightedMaterial(fileHashAsBytes);
			if(monitor){
				// KK-Log:
				kkLogger.addLogEntryData(LogType.AfterExternalAction,
					LogDataType.ParameterValue, "isCopyrighted", isCopyrighted);
			}

			if(measure) innerBeforeSecondLookupAndSaving = System.nanoTime();//TODO document
			
			if(isCopyrighted) {
				
				if(monitor) logger.debug("Copyrighted file found. File not stored.");
				//does not store the file, i.e. does NOTHING 
			} else {	
				
				boolean isFileInDB = isFileExistingInDB(fileHashAsBytes);
				if(monitor){
					// KK-Log:
					kkLogger.addLogEntryData(LogType.AfterExternalAction,
						LogDataType.ParameterValue, "isFileInDB", isFileInDB);
				}
				if(isFileInDB) { 
					
					if (monitor) logger.debug("File already in DB.");

				} else {		
					
					addFileToFileExistingDB(fileHashAsBytes);
					if(monitor){
						// KK-Log:
						kkLogger.addLogEntryData(LogType.BeforeReturn,
							LogDataType.ParameterValue, "compressedFile.length", compressedFile.length);
					}

					if(compressedFile.length > SIZE_OF_LARGE_FILES) {
						
						if(monitor){
							// KK-Log:
							kkLogger.addLogEntryData(LogType.BranchSelection,
								LogDataType.Timestamp, "storage if: large", 1);
							logger.debug("Writing large file to storage system.");
						}
						storeLargeFile(compressedFile, fileHashAsBytes);

					} else {
						if(monitor){
							// KK-Log:
							kkLogger.addLogEntryData(LogType.BranchSelection,
								LogDataType.Timestamp, "storage else: small", 0);
							
							logger.debug("Writing small file to storage system.");
						}
						storeSmallFile(compressedFile, fileHashAsBytes);
					}
				}
			}
			if(measure) innerStop = System.nanoTime();//TODO document
			
			if(measure) measurements[2*x] = innerBeforeSecondLookupAndSaving-innerStart;
			if(measure) measurements[2*x+1] = innerStop - innerBeforeSecondLookupAndSaving;
		}
		if(measure){
			stop = System.nanoTime();
			measurements[measurements.length-1] = (stop-start);
			TestDriver.recordPerformance(uploadId, uploadFileIds, measurements);
			return measurements;
		}else{
			return null;
		}
	}
}
