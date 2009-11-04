package de.uka.ipd.sdq.probfunction.math;

public interface IContinousPDF extends IProbabilityDensityFunction {
	
	public double getVariance();
	
	public double getStandardDeviation();
	
	public double getCoefficientOfVariance();
	
	/**
	 * Returns the distribution function F(x)
	 * @param x
	 * @return F(x)
	 */
	public double cdf(double x);
	
	/**
	 * Returns f(x), the density evaluated at x
	 * @param x
	 * @return f(x)
	 */
	public double density(double x);
	
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
	public double inverseF(double u);
	

}
