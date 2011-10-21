package de.uka.ipd.sdq.statistics.estimation;

/**
 * Represents a confidence interval. Whether one confidence interval contains
 * another can be checked by using the {@link #contains(ConfidenceInterval)}
 * method.
 * 
 * @author Philipp Merkle
 * 
 */
public class ConfidenceInterval {

	private double lowerBound;

	private double upperBound;

	private double mean;
	
	private double level;

	/**
	 * Constructs a confidence interval around the specified mean, having bounds
	 * lowerBound and upperBound.
	 * 
	 * @param mean
	 *            the center of the confidence interval
	 * @param lowerBound
	 *            the confidence interval's lower bound
	 * @param upperBound
	 *            the confidence interval's upper bound
	 * @param level 
	 * 			  the confidence level. Use values between 0 and 1. For instance
	 *            use 0.95 to estimate the 95% confidence interval.
	 * @param noOfObservations
	 * 			  the number of observations this confidence interval is constructed from           
	 */
	public ConfidenceInterval(double mean, double lowerBound, double upperBound, double level) {
		this.mean = mean;
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
		this.level = level;
	}
	
	/**
	 * Constructs a confidence interval around the specified mean having width
	 * (2 * mean * halfWidth).
	 * 
	 * @param mean
	 *            the center of the confidence interval
	 * @param halfWidth
	 *            the relative half-width. Use values between 0 and 1. For
	 *            instance use 0.1 in order to specify a 10% half-width.
	 */
	public ConfidenceInterval(double mean, double halfWidth, double level) {
		this(mean, mean - mean * halfWidth, mean + mean * halfWidth, level);
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
	

	public double getLevel() {
		return level;
	}

	/**
	 * Checks, whether the specified confidence interval lies within the bounds
	 * of this confidence interval.
	 * 
	 * @param ci
	 *            the confidence interval
	 * @return true if this confidence interval contains the specified one;
	 *         false else.
	 */
	public boolean contains(ConfidenceInterval ci) {
		return ci != null
				&& this.lowerBound <= ci.getLowerBound()
				&& this.upperBound >= ci.getUpperBound();
	}

}
