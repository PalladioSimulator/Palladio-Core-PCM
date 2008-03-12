package de.uka.ipd.sdq.palladiofileshare.testdriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.palladiofileshare.businesslogic.BusinessFacade;
import de.uka.ipd.sdq.palladiofileshare.businesslogic.FileType;

public class TestDriver {

	private static Logger logger = Logger.getLogger(TestDriver.class);

	private static final int numberOfUploads = 10;	
	/**
	 * needs to terminate with a "/"
	 */
	private static final String uploadFilesLocation = "testFiles/";
	private static final String[] uploadFiles = {
			"small.txt",
			"long.txt",
			"small.jpg",
			"large.jpg",
			"small.zip",
			"large.zip"
		};
	
	
	public TestDriver() {
	
	}
	
	public static void main(String args[]) {
		logger.info("Starting TestDriver");
		new TestDriver().start();		
		logger.info("Finished TestDriver");
	}
	
	public void start() {
		
		for(int x = 0; x < numberOfUploads; x++) {
			BusinessFacade.uploadFile(createTestData(), FileType.COMPRESSED);			
		}
		
	}
	
	private InputStream[] createTestData() {
		int numberOfFiles = uploadFiles.length;
		InputStream[] streams = new FileInputStream[numberOfFiles];
		
		for(int x = 0; x < numberOfFiles; x++) {		
			try {
				streams[x] =
					new FileInputStream(uploadFilesLocation + uploadFiles[x]);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				logger.error(e);
			}				
		}
		return streams;
	}
	
}
