package de.uka.ipd.sdq.palladiofileshare.businesslogic;

/**
 * @author Michael
 * The class NOT containing the main logic (see BusinessCore for it... WHY so much delegating?)
 */
public class BusinessRunner implements Runnable{

	private BusinessCore businessCore;
	private int[] fileTypes;
	private byte[][] inputFiles;
	private boolean measure;
	private long uploadId;
	
	public BusinessRunner() {
		this.businessCore = new BusinessCore();
		this.fileTypes = null;
		this.inputFiles = null;
		this.measure = false;
		this.uploadId = -1L;
	}
	
	public int[] getFileType() {
		return fileTypes;
	}

	public byte[][] getInputStreams() {
		return inputFiles;
	}

	@Override
	public void run() {
		uploadFiles(inputFiles, fileTypes, this.measure, this.uploadId);
	}

	public void setFileTypes(int[] fileTypes) {
		this.fileTypes = fileTypes;
	}

	public void setInputStreams(byte[][] inputFiles) {
		this.inputFiles = inputFiles;
	}

	public void setMeasure(boolean measure) {
		this.measure = measure;
	}

	public void setUploadId(long uploadId) {
		this.uploadId = uploadId;
	}

	/**
	 * delegate to BusinessCore
	 * @param inputStreams
	 * @param fileType
	 */
	public void uploadFiles(
			byte[][] inputStreams, 
			int[] fileTypes,
			boolean measure,
			long uploadId) {
		this.businessCore.uploadFiles(
				inputStreams, 
				fileTypes,
				measure,
				uploadId);		
	}
	
}
