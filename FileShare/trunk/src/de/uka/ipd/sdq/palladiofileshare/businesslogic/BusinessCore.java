package de.uka.ipd.sdq.palladiofileshare.businesslogic;

import org.apache.log4j.Logger;

import spec.benchmarks.compress.Harness;
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
	 * Size in bytes; if larger than this value, a different 
	 * storage system is used
	 */
	private static final int SIZE_OF_LARGE_FILES = 50000; //TODO test	
	
	/**
	 * internal sub-component
	 */
	private CopyrightedMaterialDatabase copyDB;
	
//	private CompressionRunner compression;
	
	/**
	 * internal sub-component
	 */
	private ExistingFilesDatabase fileDB;

	/**
	 * internal sub-component
	 */
	private Hash hash;
	
	/**
	 * log4j logger
	 */
	private Logger logger;
	
	/**
	 * external sub-component
	 */
	private IStorage storageSubSystemLargeFiles;
	
	/**
	 * external sub-component
	 */
	private IStorage storageSubSystemSmallFiles;
		
	/**
	 * Use SPECjvm2008 compress; otherwise use handwritten LZW compress.
	 * Note that when using compress, some setup effort is co-measured.
	 * TODO make this setting from {@link TestDriver#setUseSpec(boolean useSPEC)}
	 */
	private boolean useSPEC = true;

	public BusinessCore(long uploadId) {		
		this.copyDB = CopyrightedMaterialDatabase.getSingleton();
		this.fileDB = ExistingFilesDatabase.getSingleton();
		this.hash = new Hash();
		this.logger = Logger.getLogger(BusinessCore.class);
		this.storageSubSystemLargeFiles = new Storage();
		this.storageSubSystemSmallFiles = new Storage();
	}

	/**
	 * Results in an external service call
	 * @param hash fileHash
	 */
	private void addHashToFileExistingDB(byte[] hash) {
		this.fileDB.addNewFileHash(hash);				
	}
	
	/**
	 * Depending on {@link #useSPEC}, use SPEC or hand-written LZW.
	 * In the measurements, we are ignoring method invocation setup etc.
	 * @param inputFile 
	 * @param fileIndex for passing to SPEC's compress benchmark harness
	 * @return
	 */
	private byte[] compress(byte[] inputFile, int fileIndex) {				
		//byte[] compressedFile = compression.compress(inputFile);	
		byte[] compressedFile; //FIXME: avoid static call!
		if(this.useSPEC){
			compressedFile = Harness.MK_getLastOutput();
		}else{
			compressedFile = SimpleLZW.lzwcompress_inlined(inputFile, 512);
		}
		return compressedFile;
	}

	/**
	 * Simple getter.
	 * @param inputBytes
	 * @return
	 */
	private byte[] getMessageDigest(byte[] inputBytes) {
		return hash.getMessageDigest(inputBytes);		
	}	
	
	/**
	 * @param hash
	 * @return
	 */
	private boolean isCopyrightedMaterial(byte[] hash) {
		boolean isCopyrighted;
		isCopyrighted = this.copyDB.isCopyrightedMaterial(hash);				
		return isCopyrighted;
	}
	
	/**
	 * @param hash
	 * @return
	 */
	private boolean isFileExistingInDB(byte[] hash) {		
		boolean isFileInDB;
		isFileInDB = this.fileDB.existsInDatabase(hash);
		return isFileInDB;
	}
	
	/**
	 * Results in an external service call
	 * @param file
	 * @param fileHash
	 */
	private void storeLargeFile(byte[] file, byte[] fileHash) {
		this.storageSubSystemLargeFiles.storeFile(file, fileHash, true);
	}
	
	/**
	 * Results in an external service call
	 * @param file
	 * @param fileHash
	 */
	private void storeSmallFile(byte[] file, byte[] fileHash) {
		this.storageSubSystemSmallFiles.storeFile(file, fileHash, true);
	}
	
	/**
	 * 
	 * @param uploadFiles
	 * @param uploadFileIds
	 * @param uploadFileTypes
	 * @param measure
	 * @param monitor
	 * @return 
	 */
	public long uploadFiles(
			byte[][] uploadFiles, 
			String[] uploadFileIds, 
			int[] uploadFileTypes, 
			boolean measure,
			boolean monitor
			) {	
		
		byte[] fileHashAsBytes;		
		byte[] inputFile;
		byte[] compressedFile = null;

		for(int x = 0; x < uploadFiles.length; x++) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			logger.debug("\n\n\n"+"File "+x+" ("+uploadFileIds[x]+"), size/length "+uploadFiles[x].length);

			inputFile = uploadFiles[x];						
			
			if(uploadFileTypes[x] == FileType.TEXT) {
				compressedFile = this.compress(inputFile, x);
			} else {				
				logger.debug("Compressed file. Doing nothing.");
				compressedFile = inputFile; //do nothing
			}					
			
			fileHashAsBytes = this.getMessageDigest(compressedFile);						
			boolean isCopyrighted = isCopyrightedMaterial(fileHashAsBytes);

			if(isCopyrighted) {
				logger.debug("Copyrighted file found. File not stored.");				
				//does not store the file, i.e. does NOTHING 
			} else {					
				boolean isFileInDB = isFileExistingInDB(fileHashAsBytes);
				if(isFileInDB) { 
					if(monitor){
						logger.debug("File already in DB.");
					}
				} else {		
					addHashToFileExistingDB(fileHashAsBytes);

					if(compressedFile.length > SIZE_OF_LARGE_FILES) {
						logger.debug("Writing large file to storage system.");
						storeLargeFile(compressedFile, fileHashAsBytes);

					} else {
						logger.debug("Writing small file to storage system.");
						storeSmallFile(compressedFile, fileHashAsBytes);
					}
				}
			}		
		}		
		return 0L;
	}


}
