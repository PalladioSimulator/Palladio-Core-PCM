package de.uka.ipd.sdq.simucomframework;

public class ConfidenceInterval {

	private double lowerBound;
	
	private double upperBound;
	
	private double mean;

	public ConfidenceInterval(double mean, double lowerBound, double upperBound) {
		super();
		this.mean = mean;
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}
	
	public double getLowerBound() {
		return lowerBound;
	}

	public void setLowerBound(double lowerBound) {
		this.lowerBound = lowerBound;
	}

	public double getUpperBound() {
		return upperBound;
	}

	public void setUpperBound(double upperBound) {
		this.upperBound = upperBound;
	}

	public double getMean() {
		return mean;
	}

	public void setMean(double mean) {
		this.mean = mean;
	}
	
}
