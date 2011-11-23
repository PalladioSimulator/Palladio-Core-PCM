package de.uka.ipd.sdq.probfunction.math.apache.distribution;

import org.apache.commons.math.MathException;


/**
 * SDQ implementation of LogNormalDistFromMoments based on apache.commons.math
 * 
 * @author joerg
 *
 */
public class LognormalDistributionFromMomentsImpl extends LognormalDistributionImpl
{
	
	/** Serializable version identifier */
	private static final long serialVersionUID = -7504569402218262740L;

	public LognormalDistributionFromMomentsImpl (double mean, double variance) throws MathException 
	 {
	     super (calculateMu (mean, variance), calculateSigma (mean, variance));
	   }

	/**
	 * Calculate mu from mean and variance.
	 * u=e^(M+S^2 /2)
	 * M=ln(u)-S^2/2
	 * 
	 * @param mean The mean value
	 * @param var The variance
	 * @return The value of mu
	 * @throws MathException 
	 */
	   private static double calculateMu (double mean, double var) throws MathException {
	      final double sigma2 = calculateSigma2 (mean, var);
	      return Math.log (mean) - sigma2 / 2.0;
	   }
	   
	   
	   /**
	    * Calculate sigma from mean and variance.
	    * 
	    * @param mean The mean value
	    * @param var The variance
	    * @return The value of sigma
	    * @throws MathException 
	    */
	   private static double calculateSigma (double mean, double var) throws MathException {
		      final double sigma2 = calculateSigma2 (mean, var);
		      return Math.sqrt(sigma2);
		   }

	   /**
	    * Calculate value of sigma^2 from mean and variance.
	    * 
	    * for x = sigma^2
	    * and M=ln(u)-S^2/2
	    * 
	    * o^2 = e^(x+2M)*(e^x-1)
	    * u^2*e^3x/2 = o^2+u^2*e^x/2
	    * e^x*e^x/2 = o^2/u^2 + e^x/2
	    * x=ln(o^2/u^2 +1)
	    * 
	    * @param mean The mean value
	    * @param var The variance
	    * @return The value of sigma^2
	    * @throws MathException 
	    */
	   private static double calculateSigma2 (double mean, double var) throws MathException 
	   {
	      if (mean <= 0)
	         throw new MathException ("Mean has to be positive");
	      if (var <= 0)
	         throw new MathException ("Variance has to be positive");

	      double o2 = var;
	      double u2 = (mean * mean);
	      return Math.log (o2 / u2  + 1);
	   }


}
