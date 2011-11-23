package de.uka.ipd.sdq.probfunction.math.apache.impl;


import de.uka.ipd.sdq.probfunction.math.IGammaDistribution;
import de.uka.ipd.sdq.probfunction.math.apache.distribution.GammaDistributionFromMomentsImpl;

public class GammaDistributionFromMoments extends GammaDistribution  implements IGammaDistribution {
	
	/**
	 * Constructs a GammaDist object based on the distribution mean and 
	 * distribution coefficient of variance. 
	 * @param distribution mean 
	 * @param coefficient of variance ( = standard deviation / mean)  
	 */
	public GammaDistributionFromMoments(double mean, double coefficientOfVariance) {
		
		double variance = coefficientOfVariance * coefficientOfVariance * mean * mean ;
		this.internalFunction = new GammaDistributionFromMomentsImpl(mean, variance);
	}


}
