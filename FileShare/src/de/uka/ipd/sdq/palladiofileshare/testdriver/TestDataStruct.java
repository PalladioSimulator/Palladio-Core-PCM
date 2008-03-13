package de.uka.ipd.sdq.palladiofileshare.testdriver;

public class TestDataStruct {
	private byte[][] inputFiles;
	private int[] inputFileTypes;
	
	public TestDataStruct() {
		this.inputFiles = new byte[0][];
		this.inputFileTypes = new int[0];
	}
	
	public byte[][] getInputFiles() {
		return inputFiles;
	}
	public void setInputFiles(byte[][] inputFiles) {
		this.inputFiles = inputFiles;
	}
	public int[] getInputFileTypes() {
		return inputFileTypes;
	}
	public void setInputFileTypes(int[] inputFileTypes) {
		this.inputFileTypes = inputFileTypes;
	}	

}
