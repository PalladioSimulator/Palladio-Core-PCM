package de.uka.ipd.sdq.palladiofileshare.businesslogic;

public class BusinessFacade implements IBusinessFacade {		
		
	/**
	 * 
	 * @param inputFiles
	 * @param fileTypes type per file in array inputfiles
	 */
	public static void uploadFiles(byte[][] inputFiles, int[] fileTypes) {
		
		BusinessRunner businessFacade = new BusinessRunner();
		businessFacade.setInputStreams(inputFiles);
		businessFacade.setFileTypes(fileTypes);
		
        Thread t = new Thread(businessFacade);        
        t.start();

	}	
}
