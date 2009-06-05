package de.uka.ipd.sdq.probfunction.math;

/**
 * A ConinuousSample is used to describe the interfals in a BoxedPDF. It
 * contains the x and y coordinates of the upper right corner of each box (or
 * interval) in the BoxedPDF. There, the x-coordinate is given by the "value"
 * and the y coordinate by the probability.
 * 
 * @author ihssane, jens
 * 
 */
public interface IContinuousSample {

	/**
	 * Probability that a sample lies in the interval specified by the
	 * ContinuousSample.
	 * 
	 * @return Probability for the interval.
	 */
	Double getProbability();


	/**
	 * Value represents the right border of the specified interval. (The left is
	 * given by the ContinuousSample with the next smaller value).
	 * 
	 * @return Right border of the interval.
	 */
	double getValue();

}
