package de.uka.ipd.sdq.palladiofileshare.businesslogic;

import java.io.InputStream;

public class BusinessRunner implements Runnable{

	private BusinessCore businessCore;
	private InputStream[] inputStream;
	private int fileType;
	
	public BusinessRunner() {
		this.businessCore = new BusinessCore();
	}
	
	/**
	 * delegate
	 * @param inputStream
	 * @param fileType
	 */
	public void uploadFile(InputStream[] inputStream, int fileType) {
		this.businessCore.uploadFiles(inputStream, fileType);		
	}

	@Override
	public void run() {
		uploadFile(inputStream, fileType);
	}

	public InputStream[] getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream[] inputStream) {
		this.inputStream = inputStream;
	}

	public int getFileType() {
		return fileType;
	}

	public void setFileType(int fileType) {
		this.fileType = fileType;
	}
	
}
