package de.uka.ipd.sdq.palladiofileshare.testdriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

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
			"tiny.txt",
		    "small.txt",
		    "medium.txt",
			"long.txt",
			"superlong.txt",
			"small.jpg",
			"medium.jpg",
			"large.jpg",
			"small.zip",
			"medium.zip",
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
			BusinessFacade.uploadFiles(createTestData(), FileType.COMPRESSED);			
		}
		
	}
	
	private byte[][] createTestData() {
		int numberOfFiles = uploadFiles.length;
		byte[][] inputFiles = new byte[numberOfFiles][];
		
		for(int x = 0; x < numberOfFiles; x++) {		
			inputFiles[x] =
					fillBuffer(uploadFilesLocation + uploadFiles[x]);
		}
		return inputFiles;
	}
	
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
}
