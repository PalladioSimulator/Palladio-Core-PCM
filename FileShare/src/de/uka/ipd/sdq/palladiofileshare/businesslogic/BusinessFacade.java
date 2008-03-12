package de.uka.ipd.sdq.palladiofileshare.businesslogic;

import java.io.InputStream;


public class BusinessFacade implements IBusinessFacade {		
	
	public static void uploadFiles(byte[][] inputFiles, int fileType) {
		
		BusinessRunner businessFacade = new BusinessRunner();
		businessFacade.setInputStreams(inputFiles);
		businessFacade.setFileType(fileType);
		
        Thread t = new Thread(businessFacade);        
        t.start();

	}	
}
