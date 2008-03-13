package de.uka.ipd.sdq.palladiofileshare.businesslogic;

import java.security.MessageDigest;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.logger.Log;
import de.uka.ipd.sdq.logger.enums.LogDataType;
import de.uka.ipd.sdq.logger.enums.LogType;
import de.uka.ipd.sdq.palladiofileshare.algorithms.compress.CompressionRunner;
import de.uka.ipd.sdq.palladiofileshare.algorithms.hash.Hash;
import de.uka.ipd.sdq.palladiofileshare.businesslogic.storage.IStorage;
import de.uka.ipd.sdq.palladiofileshare.businesslogic.storage.Storage;

public class BusinessCore {
	
	/**
	 * Size in bytes; if larger than this value, a different 
	 * storage system is used
	 */
	private static final int SIZE_OF_LARGE_FILES = 50000;	
	/**
	 * log4j logger
	 */
	private static Logger logger = Logger.getLogger(BusinessCore.class);
	
	// KK-Log:
	private de.uka.ipd.sdq.logger.Logger kkLogger = Log.getLogger("BusinessCore", this.getClass().getName());
	
	// sub-components (internal)
	private CopyrightedMaterialDatabase copyDB;
	private ExistingFilesDatabase fileDB;
	private CompressionRunner compression;
	private Hash hash;
	
	// other components
	private IStorage storageSubSystemSmallFiles;
	private IStorage storageSubSystemLargeFiles;
		
	public BusinessCore() {		
		this.copyDB = CopyrightedMaterialDatabase.getSingleton();
		this.fileDB = ExistingFilesDatabase.getSingleton();
		this.compression = new CompressionRunner();
		this.hash = new Hash();
		this.storageSubSystemLargeFiles = new Storage();
		this.storageSubSystemSmallFiles = new Storage();

		// KK-Log:
		kkLogger.setAutomaticLogLineAndMethodMode(true);    	
	}

	/**
	 * 
	 * @param inputStream
	 * @param fileType FileType static ints
	 */
	public void uploadFiles(byte[][] inputFiles, int[] inputFileTypes) {				
		kkLogger.newMethodInvocation();
		kkLogger.addLogEntryData(LogType.MethodCall, LogDataType.ParameterValue, "inputFiles.length", inputFiles.length);
		kkLogger.addLogEntryData(LogType.MethodCall, LogDataType.ParameterValue, "inputFileTypes.length", inputFiles.length);
		
		byte[] fileHashAsBytes;		
		byte[] inputFile;
		byte[] compressedFile;
		
		for(int x = 0; x < inputFiles.length; x++) {			
			inputFile = inputFiles[x];
			
			if(inputFileTypes[x] == FileType.TEXT)
			{
				logger.debug("Non-Compressed file. Compressing.");
				compressedFile = this.compress(inputFile);
			} else {
				logger.debug("Compressed file. Doing nothing.");
				compressedFile = inputFile; //do nothing
			}
			
			fileHashAsBytes = this.getMessageDigest(compressedFile);
			
			if(isCopyrightedMaterial(fileHashAsBytes)) {
				logger.debug("Copyrighted file found. File not stored.");
				//reject file // do not store
			} else {
				if(isFileExistingInDB(fileHashAsBytes)) { 
					logger.debug("File already in DB.");
				} else {
					addFileToFileExistingDB(fileHashAsBytes);
					this.storeFileWithStrategy(compressedFile, fileHashAsBytes);					
				}
			}
		}
	}

	private byte[] getMessageDigest(byte[] inputBytes) {
		// KK-Log:
		kkLogger.addLogEntryData(LogType.BeforeExternalAction, LogDataType.ParameterValue, "inputFile.length", inputBytes.length);

		return hash.getMessageDigest(inputBytes);		
	}

	private byte[] compress(byte[] inputFile) {		
		// KK-Log:
		kkLogger.addLogEntryData(LogType.BeforeExternalAction, LogDataType.ParameterValue, "inputFile.length", inputFile.length);
		
		byte[] compressedFile = compression.compress(inputFile);
		
		// KK-Log:
		kkLogger.addLogEntryData(LogType.AfterExternalAction, LogDataType.ParameterValue, "compressedFile.length", compressedFile.length);
		
		return compressedFile;
	}	
	
	private boolean isCopyrightedMaterial(byte[] hash) {

		boolean isCopyrighted = this.copyDB.isCopyrightedMaterial(hash);		
		// KK-Log:
		kkLogger.addLogEntryData(LogType.AfterExternalAction, LogDataType.ParameterValue, "isCopyrighted", isCopyrighted);
		
		return isCopyrighted;
	}
	
	private boolean isFileExistingInDB(byte[] hash) {
		
		boolean isFileInDB = this.fileDB.existsInDatabase(hash);
		// KK-Log:
		kkLogger.addLogEntryData(LogType.AfterExternalAction, LogDataType.ParameterValue, "isFileInDB", isFileInDB);

		return isFileInDB;
	}
	
	private void addFileToFileExistingDB(byte[] hash) {
		this.fileDB.addNewFileHash(hash);				
	}
	
	private void storeFileWithStrategy(byte[] file, byte[] fileHash) {
		// KK-Log:
		kkLogger.addLogEntryData(LogType.BeforeReturn, LogDataType.ParameterValue, "file.length", file.length);

		if(file.length > SIZE_OF_LARGE_FILES) {
			// KK-Log:
			kkLogger.addLogEntryData(LogType.BranchSelection, LogDataType.Timestamp, "storage if: large", 1);
			
			logger.debug("Writing large file to storage system.");
			this.storageSubSystemLargeFiles.storeFile(file, fileHash);
		} else {
			// KK-Log:
			kkLogger.addLogEntryData(LogType.BranchSelection, LogDataType.Timestamp, "storage else: small", 0);
			
			logger.debug("Writing small file to storage system.");
			this.storageSubSystemSmallFiles.storeFile(file, fileHash);
		}
	}
}
