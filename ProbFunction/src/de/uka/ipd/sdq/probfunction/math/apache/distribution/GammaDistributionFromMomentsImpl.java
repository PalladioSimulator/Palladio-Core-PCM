package de.uka.ipd.sdq.probfunction.math.apache.distribution;

import org.apache.commons.math.distribution.GammaDistributionImpl;

/**
 * SDQ implementation of GammaDistFromMoments based on apache.commons.math
 * 
 * @author joerg
 *
 */
public class GammaDistributionFromMomentsImpl extends GammaDistributionImpl
{
	/** Serializable version identifier */
	private static final long serialVersionUID = -6141545702288594591L;

	/**
	 * Create a new gamma distribution with the given mean and variance values.
	 * 
	 * @param mean The mean value
	 * @param variance The variance value
	 */
	 public GammaDistributionFromMomentsImpl (double mean, double variance) 
	 {
	     super (calculateAlpha (mean, variance), calculateTheta (mean, variance));
	   }

	 /**
	  * Calculate alpha from mean and variance.
	  * mean = alpha*theta
	  * 
	  * alpha = mean/theta
	  * 
	 * @param mean The mean value
	 * @param variance The variance value
	  * @return alpha The alpha value
	  */
	   private static double calculateAlpha (double mean, double variance) {
		  // return (mean*mean)/variance;
	      return mean/calculateTheta (mean, variance);
	   }
	  
	   /**
	   * Calculate theta from mean and variance.
	   * variance = alpha*theta2
	   * alpha = mean/theta
	   * variance = mean*theta
	   * theta = variance/mean
	   * 
	   * @param mean The mean value
	   * @param variance The variance value
	   * @return theta The theta value
	   */
	   private static double calculateTheta (double mean, double variance) {
		      
		      return variance/mean;
		   }

	   


}
