package de.uka.ipd.sdq.workflow.pcm.runconfig;

public class ParameterDescriptor {

	private String name;
	private double value;
	private int runNo;
	private String uri;

	public ParameterDescriptor(String name, String uri, double value, int runNo) {
		this.name = name;
		this.value = value;
		this.runNo = runNo;
		this.uri = uri;
	}

	public String getName() {
		return name;
	}

	public double getValue() {
		return value;
	}

	public int getRunNo() {
		return runNo;
	}
	
	public String getUri(){
		return uri;
	}

}
