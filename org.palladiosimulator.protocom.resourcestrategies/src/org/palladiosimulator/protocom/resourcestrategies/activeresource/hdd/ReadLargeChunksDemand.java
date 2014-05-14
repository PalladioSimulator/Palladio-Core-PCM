package org.palladiosimulator.protocom.resourcestrategies.activeresource.hdd;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.palladiosimulator.protocom.resourcestrategies.activeresource.AbstractDemandStrategy;
import org.palladiosimulator.protocom.resourcestrategies.activeresource.DegreeOfAccuracyEnum;
import org.palladiosimulator.protocom.resourcestrategies.activeresource.IDemandStrategy;
import org.palladiosimulator.protocom.resourcestrategies.activeresource.ResourceTypeEnum;
import org.palladiosimulator.protocom.resourcestrategies.system.SystemResourcesUtil;

/**
 * Reads large chunks of data up to MAX_FILE_SIZE Byte (default 8 MB) from a
 * predefined hard disk drive. 
 * 
 * During initialisation, it is checked whether there is a directory
 * fileDirectory. If yes, it is used to read data from the hard disk drive. If
 * not, the directory is created and a number of files given by numberOfFiles
 * are written. The files size is maxFileSize.
 * 
 * It is recommended to restart the application or even the whole machine if the
 * files are written during initialisation.
 * 
 * To avoid caching effects, each consume reads from another file until all
 * files of the list are read. Then, the first file is read again.
 * 
 *         TODO: Initialisation of the HD, variable file sizes, <s>variable number
 *         of files</s>, scattered reads, writes, variable file sizes.
 * 
 * @author Anne, Sebastian Lehrig
 * 
 * 
 */
public class ReadLargeChunksDemand extends AbstractDemandStrategy implements
		IDemandStrategy {

	/**
	 * Maximum size of files to be created or searched
	 */
	private final int maxFileSize;
	private static final int DEFAULT_MAX_FILE_SIZE = 8 * 1000 * 1000; // 8 MB

	/**
	 * Maximum number of files to include into the calibration
	 */
	private final long numberOfFiles;

	/**
	 * Root directory from where the files will be read
	 */
	private final File fileDirectory;

	/** Stores some files sorted by size for fast access */
	private List<File> files = new LinkedList<File>();
	private List<File> cleanupFiles = new LinkedList<File>();
	private Iterator<File> iterator = null;

	private static final Logger logger = Logger
			.getLogger(ReadLargeChunksDemand.class.getName());

	public ReadLargeChunksDemand() {
		this(SystemResourcesUtil.TEMP_DIR, DEFAULT_MAX_FILE_SIZE);
	}

	public ReadLargeChunksDemand(File path, int maxFileSize)
	{
		super(-2,0,2,100,10);
		this.fileDirectory = path;
		this.maxFileSize = maxFileSize;
		this.numberOfFiles = calculateDefaultNumberOfFiles();
	}

	/**
	 * Calculates the number of files needed for the calibration.
	 * 
	 * Since the OS can use the RAM for saving time when files are
	 * read over and over again, this function calculates the number
	 * of files such that it holds:
	 * 
	 * RAM size < Sum of file sizes
	 * 
	 * @return System dependent number of files for calibration. 
	 */
	private static long calculateDefaultNumberOfFiles()
	{
		long ramSize = SystemResourcesUtil.getTotalPhysicalMemorySize();
		long number = (ramSize/DEFAULT_MAX_FILE_SIZE);
		
		// increase number by 10% to assure RAM size < Sum of file sizes
		number = (long)(number*1.1f);
		
		return number;
	}
	
	@Override
	protected void run(long load) {
		logger.debug("Consume HDD demand of: " + load);
		try	{
			long remainingLoad = load;
			do {
				FileInputStream fis = new FileInputStream(nextFile());

				long consume = remainingLoad > this.maxFileSize ? maxFileSize : remainingLoad; 
				byte[] byteArray = new byte[(int) consume];
				int success = fis.read(byteArray);
				fis.close();
				logger.trace("Adjusted demand consumed: " + success);

				remainingLoad -= success;
			} while (remainingLoad > 0);
		} catch (FileNotFoundException e) {
			logger.error("HDD demand strategy failed", e);
			System.exit(-1);
		} catch (IOException e) {
			logger.error("HDD demand strategy failed", e);
			System.exit(-1);
		}
		logger.debug("Complete HDD demand consumed");
	}

	/**
	 * Returns the next file. The next file after the last one in the list is
	 * the first. Note that this method will throw a NullPointerException if the
	 * list is empty. For performance reasons, however, this is not checked.
	 * 
	 * @return The next file.
	 */
	private synchronized File nextFile() {
		assert this.files.size() > 0;
		assert iterator != null;

		if (!iterator.hasNext()) // Reset the file iterator at the end
			iterator = this.files.iterator();

		return iterator.next();
	}

	@Override
	public ResourceTypeEnum getStrategysResource() {
		return ResourceTypeEnum.HDD;
	}

	@Override
	public void initializeStrategy(DegreeOfAccuracyEnum degreeOfAccuracy,
			double processingRate, String calibrationPath) {
		preInitHDDStrategy();
		super.initializeStrategy(degreeOfAccuracy,processingRate,calibrationPath);
	}

	@Override
	public void initializeStrategy(DegreeOfAccuracyEnum degreeOfAccuracy,
			double processingRate) {
		preInitHDDStrategy();
		super.initializeStrategy(degreeOfAccuracy,processingRate);
	}
	
	private void preInitHDDStrategy() {
		if (this.files.size() > 0)
			return; // Already pre-init done
		
		logger.debug("Pre-Initialising strategy reading from "
						+ this.fileDirectory);
		if (!fileDirectory.exists()) {
			logger.info("Directory given for reading files does not exist. Trying to prepare one");
			try {
				createFileDirectory();
				writeTestFiles();
				logger.info("Wrote files to be read.");
			} catch (IOException e) {
				logger.error("Failed creating files for HDD strategy. Maybe missing permission?", e);
				System.exit(-1);
			}
		} else if (fileDirectory.isDirectory()) {
			logger.info("Reading file list from "+fileDirectory.getAbsolutePath());
			initialiseFileList(fileDirectory);
		} else {
			logger.error("There already is a file at " + fileDirectory.getAbsolutePath());
		}

		// The strategy could not be initialised as there are no files to read
		// -> try to create files
		if (this.files.isEmpty()) {
			try {
				writeTestFiles();
				logger.debug("Wrote files to be read.");
			} catch (IOException e) {
				logger.error("Failed reading files for HDD strategy",e);
				System.exit(-1);
			}
		}

		if (this.files.size() < 1) {
			logger.error("The strategy could not be initialised as there are no files to read.");
			System.exit(-1);
		} else {
			this.iterator = this.files.iterator();
			logger.info("HDD Strategy initialised with " + files.size()
					+ " files in folder "+fileDirectory.getAbsolutePath());
		}
	}

	private void createFileDirectory() throws IOException {
		if (!fileDirectory.mkdirs()) {
			logger.error("File directory could not be created during initialisation.");
			throw new IOException("Directory for files store could not be created");
		}
	}

	private boolean writeTestFiles() throws IOException {
		long neededSize = this.numberOfFiles*DEFAULT_MAX_FILE_SIZE;
		long tmpSize = SystemResourcesUtil.getFreeTempDirectorySize();
		if(neededSize > tmpSize)
		{
			logger.error("The required storage space for calibration exceeds the free space in " 
					+ SystemResourcesUtil.TEMP_DIR.getAbsolutePath());
			System.exit(-1);
		}
		
		File childFile;
		for (int i = 0; i < this.numberOfFiles; i++) {
			childFile = new File(fileDirectory, "file" + i);
			childFile.createNewFile();

			FileOutputStream fos = new FileOutputStream(childFile);
			byte[] bytes = new byte[maxFileSize];
			fos.write(bytes);
			fos.flush();
			fos.close();

			files.add(childFile); cleanupFiles.add(childFile);

		}

		return true;
	}

	private void initialiseFileList(File files) {
		File[] childFiles = files.listFiles();

		if (childFiles != null) // childFiles may be null, if we do not have a
								// permission for a directory
		{
			logger.debug("Found " + childFiles.length + " files in the first directory("
							+ files.getAbsolutePath() + ").");
			for (File file : childFiles) {

				if (file.isDirectory()) {
					initialiseFileList(file);
				} else {
					if (file.length() >= this.maxFileSize) {
						this.files.add(file);
					} else {
						logger.debug("File is too small: "+file.getAbsolutePath()+". We skip it...");
					}
				}
			}
		}
	}

	public int getMaxFileSize() {
		return maxFileSize;
	}

	public String getName() {
		return "Read Large Chunks";
	}

	public void cleanup() {
		for (File file : cleanupFiles) {
			logger.debug("Trying to delete file " + file.getName());
			if (!file.delete()) {
				logger.error("Failed to delete file " + file.getName());
			}
		}
	}

}
