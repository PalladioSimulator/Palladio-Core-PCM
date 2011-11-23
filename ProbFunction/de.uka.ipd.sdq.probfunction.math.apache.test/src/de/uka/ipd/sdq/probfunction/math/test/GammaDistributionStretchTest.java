package de.uka.ipd.sdq.probfunction.math.test;

import de.uka.ipd.sdq.probfunction.math.IGammaDistribution;


public class GammaDistributionStretchTest extends GammaDistributionTest
{
	
	
	public GammaDistributionStretchTest() 
	{
		double alpha = 1.0;
		double theta = 0.5;
		double scalar = 2.0;
		
		a = ssjFactory.createGammaDistribution(alpha, theta);
		b = apacheFactory.createGammaDistribution(alpha, theta);
		
		a = (IGammaDistribution) a.stretchDomain(scalar);
		b = (IGammaDistribution) b.stretchDomain(scalar);
		
		
	}
	
	
}
