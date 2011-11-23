package de.uka.ipd.sdq.probfunction.math.ssj.impl;

import umontreal.iro.lecuyer.probdist.GammaDistFromMoments;
import de.uka.ipd.sdq.probfunction.math.IGammaDistribution;

public class GammaDistributionFromMoments extends GammaDistribution  implements IGammaDistribution {
	
	/**
	 * Constructs a GammaDist object based on the distribution mean and 
	 * distribution coefficient of variance. 
	 * @param distribution mean 
	 * @param coefficient of variance ( = standard deviation / mean)  
	 */
	public GammaDistributionFromMoments(double mean, double coefficientOfVariance) {
		/* Note that there is an error in the umontreal.iro.lecuyer.probdist.GammaDist
		 * documentation: They name the second parameter lambda the scale parameter,
		 * but it acts as the rate parameter beta, not the scale parameter theta (terms as defined at 
		 * wikipedia version http://en.wikipedia.org/w/index.php?title=Gamma_distribution&oldid=413746510),
		 * as becomes visible when comparing the function definition in the documentation 
		 * with the function defined on the Wikipedia page. 
		 */ 
		double variance = coefficientOfVariance * coefficientOfVariance * mean * mean ;
		this.internalFunction = new GammaDistFromMoments(mean, variance);
	}


}
