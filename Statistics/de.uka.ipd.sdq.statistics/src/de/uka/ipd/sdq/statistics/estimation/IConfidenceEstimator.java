package de.uka.ipd.sdq.statistics.estimation;

import java.util.List;

/**
 * Interface for classes which are capable of estimating a confidence interval
 * around a point estimation.
 * 
 * @author Philipp Merkle
 * 
 */
public interface IConfidenceEstimator {

	/**
	 * Estimates the confidence interval.
	 * 
	 * @param samples
	 *            the values for which a confidence interval is to be estimated.
	 * @param level
	 *            the confidence level. Use values between 0 and 1. For instance
	 *            use 0.95 to estimate the 95% confidence interval.
	 * @return
	 */
	public ConfidenceInterval estimateConfidence(List<Double> samples, double level);

}
