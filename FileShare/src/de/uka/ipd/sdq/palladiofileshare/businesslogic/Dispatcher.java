package de.uka.ipd.sdq.palladiofileshare.businesslogic;

import java.io.InputStream;


public class Dispatcher {		
	
	public static void uploadFile(InputStream[] inputStream, int fileType) {
		
		BusinessRunner businessFacade = new BusinessRunner();
		businessFacade.setInputStream(inputStream);
		businessFacade.setFileType(fileType);
		
        Thread t = new Thread(businessFacade);        
        t.start();

	}	
}
