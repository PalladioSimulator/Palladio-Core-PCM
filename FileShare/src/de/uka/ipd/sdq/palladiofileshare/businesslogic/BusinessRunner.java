package de.uka.ipd.sdq.palladiofileshare.businesslogic;

import java.io.InputStream;

public class BusinessRunner implements Runnable{

	private BusinessCore businessCore;
	private InputStream[] inputStreams;
	private int fileType;
	
	public BusinessRunner() {
		this.businessCore = new BusinessCore();
	}
	
	/**
	 * delegate
	 * @param inputStreams
	 * @param fileType
	 */
	public void uploadFiles(InputStream[] inputStreams, int fileType) {
		this.businessCore.uploadFiles(inputStreams, fileType);		
	}

	@Override
	public void run() {
		uploadFiles(inputStreams, fileType);
	}

	public InputStream[] getInputStreams() {
		return inputStreams;
	}

	public void setInputStreams(InputStream[] inputStreams) {
		this.inputStreams = inputStreams;
	}

	public int getFileType() {
		return fileType;
	}

	public void setFileType(int fileType) {
		this.fileType = fileType;
	}
	
}
