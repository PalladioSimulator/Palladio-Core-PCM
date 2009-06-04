package org.somox.analyzer;

public class ModelAnalyzerTabGroupBlackboard {

	static int idCounter = 0;
	private int myId = 0;

	public ModelAnalyzerTabGroupBlackboard() {
		idCounter++;
		myId = idCounter;
	}

	public int getId() {
		return myId;
	}

	private String somoxAnalyzerInputFile = null;

	public String getSomoxAnalyzerInputFile() {
		return somoxAnalyzerInputFile;
	}

	public void setSomoxAnalyzerInputFile(String somoxAnalyzerInputFile) {
		this.somoxAnalyzerInputFile = somoxAnalyzerInputFile;
	}

}
