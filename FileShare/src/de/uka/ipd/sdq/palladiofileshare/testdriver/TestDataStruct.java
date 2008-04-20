package de.uka.ipd.sdq.palladiofileshare.testdriver;

public class TestDataStruct {
	
	private String[] inputFileIds;
	private byte[][] inputFiles;
	private int[] inputFileTypes;
	private long uploadId;
	
	/**
	 * @deprecated because parametrised constructor should be used instead
	 */
	public TestDataStruct() {
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.uploadId = System.currentTimeMillis();
		this.inputFiles = new byte[0][];
		this.inputFileIds = new String[0];
		this.inputFileTypes = new int[0];
	}
	
	public TestDataStruct(
			String[] inputFileIds,
			byte[][] inputFiles,
			int[] inputFileTypes) {
		try {
			Thread.sleep(50); //make sure test data struct ids are not identical
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.uploadId = System.currentTimeMillis();
		this.inputFiles = inputFiles;
		this.inputFileIds = inputFileIds;
		this.inputFileTypes = inputFileTypes;
	}
	
	public String[] getInputFileIds() {
		return inputFileIds;
	}
	
	public byte[][] getInputFiles() {
		return inputFiles;
	}
	
	public int[] getInputFileTypes() {
		return inputFileTypes;
	}
	
	public long getUploadId() {
		return uploadId;
	}
	
	public void setInputFileIds(String[] inputFileIds) {
		this.inputFileIds = inputFileIds;
	}

	public void setInputFiles(byte[][] inputFiles) {
		this.inputFiles = inputFiles;
	}	

	public void setInputFileTypes(int[] inputFileTypes) {
		this.inputFileTypes = inputFileTypes;
	}	
}
