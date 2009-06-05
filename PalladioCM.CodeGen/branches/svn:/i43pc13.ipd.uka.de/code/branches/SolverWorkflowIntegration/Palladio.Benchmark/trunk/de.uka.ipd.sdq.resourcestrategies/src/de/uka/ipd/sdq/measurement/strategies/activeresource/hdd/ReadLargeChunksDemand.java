package de.uka.ipd.sdq.measurement.strategies.activeresource.hdd;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.measurement.strategies.activeresource.DegreeOfAccuracyEnum;
import de.uka.ipd.sdq.measurement.strategies.activeresource.IDemandStrategy;
import de.uka.ipd.sdq.measurement.strategies.activeresource.ResourceTypeEnum;

/**
 * Reads large chunks of data up to MAX_FILE_SIZE Byte (default 8 MB) from a
 * predefined hard disk drive. The existing hard disk drive must comply with the
 * processing rate given. Thus, the processing rate is ignored during
 * initialisation.
 * 
 * During initialisation, it is checked whether there is a directory
 * fileDirectory. If yes, it is used to read data from the hard disk drive. If
 * not, the directory is created and a number of files given by numberOfFiles
 * are written. The files size is maxFileSize.
 * 
 * It is recommended to restart the application or even the whole machine if the
 * files are written during intialisation.
 * 
 * To avoid caching effects, each consume reads from another file until all
 * files of the list are read. Then, the first file is read again.
 * 
 * 
 * @author Anne
 * 
 * TODO: Initialisation of the HD, variable file sizes, variable number of
 * files, scattered reads, writes, variable file sizes.
 * 
 */
public class ReadLargeChunksDemand implements IDemandStrategy {

	public long time = 0;

	/* Configuration */
	private int maxFileSize = 8 * 1000 * 1000;

	private File fileDirectory;
	private int numberOfFiles = 1000;

	private double factor = 0.692;

	/** Stores some files sorted by size for fast access */
	private List<File> files = new LinkedList<File>();
	private Iterator<File> iterator = null;

	// byte[] byteArray = new byte[1000000];

	/** Or just store lots of files that are large enough in a linked list. */

	private static Logger logger = Logger.getLogger(ReadLargeChunksDemand.class
			.getName());

	public ReadLargeChunksDemand(String path) {
		fileDirectory = new File(path);
	}

	// @Override
	public void consume(double demand) {
		logger.debug("Consume HDD demand of: " + demand);
		try {
			FileInputStream fis = new FileInputStream(nextFile());

			// This is much slower
			// for (int i = 0; i < demand; i++)
			// fis.read();

			/*
			 * Measurements here only lead to slightly shorter times as if the
			 * whole consume method is measured. The difference averages to 1 %
			 * (reading 1 to 8 MB of data). Thus, the overhead of the method
			 * invocation is negligible.
			 */
			byte[] byteArray = new byte[(int) (demand * factor)];
			int success = fis.read(byteArray);

			logger.debug("Adjusted demand consumed: " + success);

		} catch (FileNotFoundException e) {
			logger.error(e);
			e.printStackTrace();
		} catch (IOException e) {
			logger.error(e);
			e.printStackTrace();
		}

	}

	/**
	 * Returns the next file. The next file after the last one in the list is
	 * the first. Note that this method will throw a NullPointerException if the
	 * list is empty. For performance reasons, however, this is not checked.
	 * 
	 * @return The next file.
	 */
	private synchronized File nextFile() {
		if (iterator.hasNext())
			return iterator.next();
		iterator = this.files.iterator();
		return iterator.next();
	}

	// @Override
	public ResourceTypeEnum getStrategysResource() {
		return ResourceTypeEnum.HDD;
	}

	// @Override
	public void initializeStrategy(DegreeOfAccuracyEnum degreeOfAccuracy,
			double processingRate) {
		logger
				.debug("Initialising strategy reading from "
						+ this.fileDirectory);
		if (!fileDirectory.exists()) {
			try {
				writeTestFiles();
				logger.debug("Wrote files to be read.");
			} catch (IOException e) {
				logger.error(e);
				e.printStackTrace();
			}
		} else if (fileDirectory.isDirectory()) {
			logger.debug("Reading in file list.");
			initialiseFileList(fileDirectory);
		} else {
			logger.error("There already is a file at "
					+ fileDirectory.getAbsolutePath());
		}

		if (this.files.size() < 1) {
			logger
					.error("The strategy could not be initialised as there are no files to read.");
		} else {
			this.iterator = this.files.iterator();
			logger.debug("Strategy initialised with " + files.size()
					+ " files.");
		}

	}

	private boolean writeTestFiles() throws IOException {

		if (!fileDirectory.mkdirs()) {
			logger
					.error("File directory could not be created during initialisation.");
			return false;
		}

		File childFile;

		for (int i = 0; i < this.numberOfFiles; i++) {
			childFile = new File(fileDirectory, "file" + i);

			FileOutputStream fos = new FileOutputStream(childFile);
			byte[] bytes = new byte[maxFileSize];
			fos.write(bytes);
			fos.flush();

			files.add(childFile);

		}

		return true;
	}

	private void initialiseFileList(File files) {
		File[] childFiles = files.listFiles();
		logger.debug("Found " + childFiles.length
				+ " files in the first directory.");
		for (File file : childFiles) {

			if (file.isDirectory()) {
				initialiseFileList(file);
			} else {
				if (file.length() >= this.maxFileSize) {
					this.files.add(file);
				} else {
					logger.debug("File is too small");
				}
			}
		}
	}

	public int getMaxFileSize() {
		return maxFileSize;
	}

	// @Override
	public String getName() {
		return "Read Large Chunks";
	}

}
