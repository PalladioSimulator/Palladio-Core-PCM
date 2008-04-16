package de.uka.ipd.sdq.palladiofileshare.businesslogic;

public class BusinessFacade implements IBusinessFacade {		
		
	/**
	 * 
	 * @param inputFiles
	 * @param fileTypes type per file in array inputfiles
	 */
	public static void uploadFiles(
			long uploadId,
			byte[][] inputFiles, 
			int[] fileTypes,
			boolean measure) {
		
		BusinessRunner businessFacade = new BusinessRunner();
		businessFacade.setUploadId(uploadId);
		businessFacade.setMeasure(measure);
		businessFacade.setInputStreams(inputFiles);
		businessFacade.setFileTypes(fileTypes);
		
        Thread t = new Thread(businessFacade);        
        t.start();

	}	
}
