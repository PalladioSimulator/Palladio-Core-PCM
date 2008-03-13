package de.uka.ipd.sdq.palladiofileshare.businesslogic;

public class BusinessRunner implements Runnable{

	private BusinessCore businessCore;
	private byte[][] inputFiles;
	private int[] fileTypes;
	
	public BusinessRunner() {
		this.businessCore = new BusinessCore();
	}
	
	/**
	 * delegate
	 * @param inputStreams
	 * @param fileType
	 */
	public void uploadFiles(byte[][] inputStreams, int[] fileTypes) {
		this.businessCore.uploadFiles(inputStreams, fileTypes);		
	}

	@Override
	public void run() {
		uploadFiles(inputFiles, fileTypes);
	}

	public byte[][] getInputStreams() {
		return inputFiles;
	}

	public void setInputStreams(byte[][] inputFiles) {
		this.inputFiles = inputFiles;
	}

	public int[] getFileType() {
		return fileTypes;
	}

	public void setFileTypes(int[] fileTypes) {
		this.fileTypes = fileTypes;
	}
	
}
