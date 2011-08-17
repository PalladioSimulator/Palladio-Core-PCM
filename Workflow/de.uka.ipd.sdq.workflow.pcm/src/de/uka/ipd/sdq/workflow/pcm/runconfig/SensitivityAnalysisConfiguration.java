package de.uka.ipd.sdq.workflow.pcm.runconfig;

public class SensitivityAnalysisConfiguration implements Cloneable {
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

	@Override
	protected Object clone() throws CloneNotSupportedException {
		SensitivityAnalysisConfiguration config = (SensitivityAnalysisConfiguration) super.clone();
		config.max = this.max;
		config.min = this.min;
		config.runNo = this.runNo;
		config.shortName = new String(this.shortName);
		config.step = this.step;
		config.variableURI = new String(this.variableURI);
		return config;
	}

	/**
	 * @return A clone of this instance.
	 */
	public SensitivityAnalysisConfiguration getClone() {
		try {
			return (SensitivityAnalysisConfiguration) this.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
}
