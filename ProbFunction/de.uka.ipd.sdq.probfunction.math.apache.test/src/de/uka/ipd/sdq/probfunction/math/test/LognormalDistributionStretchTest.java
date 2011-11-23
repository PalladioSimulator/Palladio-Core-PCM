package de.uka.ipd.sdq.probfunction.math.test;

import de.uka.ipd.sdq.probfunction.math.ILognormalDistribution;

public class LognormalDistributionStretchTest extends LognormalDistributionTest
{
	
	
	public LognormalDistributionStretchTest() 
	{
		double mu = Math.exp(0.9);
		double sigma = Math.exp(0.5);
		double scalar = 2.0;
		
		a = ssjFactory.createLognormalDistribution(mu, sigma);
		b = apacheFactory.createLognormalDistribution(mu, sigma);
		
		a = (ILognormalDistribution) a.stretchDomain(scalar);
		b = (ILognormalDistribution) b.stretchDomain(scalar);
		
		
	}
	
	
}
