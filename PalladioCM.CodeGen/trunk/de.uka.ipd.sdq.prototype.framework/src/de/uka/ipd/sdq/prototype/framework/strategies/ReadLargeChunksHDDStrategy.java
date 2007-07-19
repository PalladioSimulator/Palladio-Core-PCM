package de.uka.ipd.sdq.prototype.framework.strategies;

import de.uka.ipd.sdq.prototype.framework.resourcetypes.ResourceTypeEnum;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * Reads large chunks of data up to MAX_FILE_SIZE Byte (default 8 MB) from a predefined hard disk drive. The existing hard disk drive must comply with the processing rate given. Thus, the processing rate is ignored during initialisation.
 * 
 * During initialisation, it is checked whether there is a directory fileDirectory. If yes, it is used to read data from the hard disk drive. If not, the directory is created and a number of files given by numberOfFiles are written. The files size is maxFileSize. 
 * 
 * It is recommended to restart the application or even the whole machine if the files are written during intialisation. 
 * 
 * To avoid caching effects, each consume reads from another file until all files of the list are read. Then, the first file is read again.  
 * 
 *  
 * @author Anne
 *
 */
public class ReadLargeChunksHDDStrategy implements IConsumerStrategy {

	/* Configuration */
	private int maxFileSize = 8000000;

	private File fileDirectory = new File("C:/tmp/"+ReadLargeChunksHDDStrategy.class.getName());
	private int numberOfFiles = 100;

	/** Stores some files sorted by size for fast access */
	private List<File> files = new LinkedList<File>();
	private Iterator<File> iterator = null;
	
	/** Or just store lots of files that are large enough in a linked list.*/

	private static Logger logger = Logger
			.getLogger(ReadLargeChunksHDDStrategy.class.getName());
	
	@Override
	public void consume(double demand) {
		try {
			FileInputStream fis = new FileInputStream(nextFile());
			
			//TODO: So oder doch lieber in ein Array einlesen dass groß genug ist?
			// müsste aber auch erst angelegt werden, da Demand im Voraus unbekannt. 
			for (int i = 0; i < demand; i++)
				fis.read();
			
		} catch (FileNotFoundException e) {
			logger.error(e);
			e.printStackTrace();
		} catch (IOException e) {
			logger.error(e);
			e.printStackTrace();
		}

	}

	/** Returns the next file. The next file after the last one in the list is the first. Note that this method will throw a NullPointerException if 
	 * the list is empty. For performance reasons, however, this is not checked. 
	 * @return The next file. 
	 */
	private synchronized File nextFile() {
		if (iterator.hasNext())
			return iterator.next();
		iterator = this.files.iterator();
		return iterator.next();
	}

	@Override
	public ResourceTypeEnum getStrategysResource() {
		return ResourceTypeEnum.HDD;
	}

	@Override
	public void initialiseStrategy(double processingRate) {
		logger.debug("Initialising strategy writing to "+this.fileDirectory);
		if (!fileDirectory.exists()) {
			try {
				writeTestFiles();
			} catch (IOException e) {
				logger.error(e);
				e.printStackTrace();
			}
		} else if (fileDirectory.isDirectory()){
			initialiseFileList(fileDirectory); 
		} else {
			logger.error("There already is a file at "+fileDirectory.getAbsolutePath());
		}
		
		if (this.files.size() < 1){
			logger.error("The strategy could not be initialised as there are no files to read.");
		} else {
			this.iterator = this.files.iterator(); 
			logger.debug("Strategy initialised with "+files.size() + " files.");
		}
		
	}

	private boolean writeTestFiles() throws IOException {

		if (!fileDirectory.mkdirs()) {
			logger.error("File directory could not be created during initialisation.");
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
		for (File file : childFiles){
			if (file.isDirectory()){
				initialiseFileList(file);
			} else {
				if (file.length() >= this.maxFileSize){
					this.files.add(file);
				}
			}
		}
	}

}
