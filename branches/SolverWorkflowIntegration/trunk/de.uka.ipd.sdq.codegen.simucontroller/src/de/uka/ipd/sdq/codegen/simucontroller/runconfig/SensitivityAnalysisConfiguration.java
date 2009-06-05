package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

public class SensitivityAnalysisConfiguration {
	double max;
	double step;
	private String variableURI;
	private double min;
	private int runNo;
	
	public SensitivityAnalysisConfiguration(String variableURI, int runNo, double min,
			double max, double step) {
		super();
		this.variableURI = variableURI;
		this.runNo = runNo;
		this.max = max;
		this.min = min;
		this.step = step;
	}

	public double getCurrent() {
		return min + runNo * step;
	}
	
	public double getMax() {
		return max;
	}
	
	public double getMin() {
		return min;
	}
	
	public double getStep() {
		return step;
	}

	public String getVariable() {
		return variableURI;
	}
	
	public int getRunNo() {
		return runNo;
	}
}
