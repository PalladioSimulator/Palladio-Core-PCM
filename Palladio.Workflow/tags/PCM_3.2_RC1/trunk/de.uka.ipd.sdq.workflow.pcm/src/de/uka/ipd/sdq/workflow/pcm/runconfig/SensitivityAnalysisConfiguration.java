package de.uka.ipd.sdq.workflow.pcm.runconfig;

public class SensitivityAnalysisConfiguration {
	double max;
	double step;
	private String variableURI;
	private double min;
	private int runNo;
	private String shortName;
	
	public SensitivityAnalysisConfiguration(String shortName, String variableURI, double min,
			double max, double step) {
		super();
		if (shortName == null || shortName.equals("")){
			this.shortName = variableURI;
		} else {
			this.shortName = shortName;
		}
		this.variableURI = variableURI;
		this.runNo = 0;
		this.max = max;
		this.min = min;
		this.step = step;
	}

	public double getCurrent() {
		return Math.min(min + runNo * step, max);
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
	
	public SensitivityAnalysisConfiguration getNext() {
		SensitivityAnalysisConfiguration result = new SensitivityAnalysisConfiguration(shortName, variableURI, min, max, step);
		result.runNo = this.runNo + 1;
		return result;
	}
	
	public SensitivityAnalysisConfiguration getFirst(){
		return new SensitivityAnalysisConfiguration(shortName, variableURI, min, max, step);
	}
	
	@Override
	public String toString() {
		return shortName+ "(" + this.runNo + ", " + this.getCurrent() + ")"; 
	}
	
	public String getShortName() {
		return this.shortName;
	}
}
