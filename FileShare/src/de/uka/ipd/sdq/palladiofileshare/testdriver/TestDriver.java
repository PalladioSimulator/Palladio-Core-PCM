package de.uka.ipd.sdq.palladiofileshare.testdriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import de.uka.ipd.sdq.palladiofileshare.businesslogic.BusinessFacade;
import de.uka.ipd.sdq.palladiofileshare.businesslogic.FileType;

public class TestDriver {

	private static final int numberOfUploads = 100;	
	private static final String uploadFilesLocation = "./testFiles/";
	private static final String[] uploadFiles = {
			"small.txt",
			"long.txt",
			"small.jpg",
			"large.txt",
			"small.zip",
			"large.zip"
		};
	
	private BusinessFacade businessFacade;
	
	public TestDriver() {
		businessFacade = new BusinessFacade();
	}
	
	public static void main(String args[]) {
		new TestDriver().start();		
	}
	
	public void start() {
		for(int x = 0; x < numberOfUploads; x++) {
			businessFacade.uploadFile(createTestData(), FileType.Archive);
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
			}		
		
		}
		return streams;
	}
	
}
