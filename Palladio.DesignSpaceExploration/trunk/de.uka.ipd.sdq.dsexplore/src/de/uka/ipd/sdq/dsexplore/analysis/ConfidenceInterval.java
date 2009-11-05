package de.uka.ipd.sdq.dsexplore.analysis;


public class ConfidenceInterval {
	private double lowerBound;
	
	private double upperBound;
	
	private double mean;
	
	private double alpha;

	private long numberOfObservations;

	public ConfidenceInterval(double mean, double lowerBound, double upperBound, double alpha, long noOfObservations) {
		super();
		this.mean = mean;
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
		this.alpha = alpha;
		this.numberOfObservations = noOfObservations;
	}
	
	public long getNumberOfObservations() {
		return numberOfObservations;
	}

	public ConfidenceInterval(ConfidenceInterval confidence, double alpha, long noOfObservations) {
		super();
		this.mean = confidence.getMean();
		this.lowerBound = confidence.getLowerBound();
		this.upperBound = confidence.getUpperBound();
		this.alpha = alpha;
		this.numberOfObservations = noOfObservations;
	}

	public double getLowerBound() {
		return lowerBound;
	}


	public double getUpperBound() {
		return upperBound;
	}


	public double getMean() {
		return mean;
	}

	public double getAlpha() {
		return alpha;
	}
	
}
