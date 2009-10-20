package de.uka.ipd.sdq.palladiofileshare.businesslogic;

public class BusinessFacade implements IBusinessFacade {		
		
	/**
	 * Starts a new thread to which the upload is delegated. 
	 * The thread is executing BusinessRunner logic.
	 * @param inputFiles
	 * @param fileTypes type per file in array inputfiles
	 */
	public void uploadFiles(
			long uploadId,
			byte[][] inputFiles, 
			String[] inputFileIds,
			int[] inputFileTypes,
			boolean measure,
			boolean monitor) {
		
		BusinessRunner businessFacade;
		businessFacade= new BusinessRunner(
				uploadId,
				inputFiles,
				inputFileIds,
				inputFileTypes,
				measure,
				monitor);
		
        Thread t = new Thread(businessFacade);        
        t.start();

	}	
}
