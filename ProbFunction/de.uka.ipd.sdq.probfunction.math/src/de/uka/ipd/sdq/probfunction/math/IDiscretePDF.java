package de.uka.ipd.sdq.probfunction.math;

public interface IDiscretePDF extends IProbabilityDensityFunction {
	
	public double getVariance();
	
	public double getStandardDeviation();
	
	public double getMean();
	
	/**
	 * Returns the distribution function F(x)
	 * @param x
	 * @return F(x)
	 */
	public double cdf(int x);
	
	/**
	 * Returns f(x), the probability evaluated at x
	 * @param x
	 * @return f(x)
	 */
	public double probability(int x);
	
	/**
	 * Returns xa such that the probability density is 0 everywhere outside the interval [xa, xb]
	 * @return upper limit of support
	 */
	public double getXsup();
	
	/**
	 * Returns xb such that the probability density is 0 everywhere outside the interval [xa, xb],
	 * @return lower limit of support
	 */
	public double getXinf();
	
	/**
	 * Computes and returns the inverse distribution function x = F^{-1}(u). 
	 * This can be used to get the quantiles of the distribution. 
	 * Pass 0.9 to get the x value of this function for which this.cdf(x) = 0.9 holds. 
	 * @param u - value in the interval [0, 1] for which the inverse distribution function is evaluated 
	 * @return the inverse distribution function evaluated at u
	 */
	public int inverseF(double u);
	

}
