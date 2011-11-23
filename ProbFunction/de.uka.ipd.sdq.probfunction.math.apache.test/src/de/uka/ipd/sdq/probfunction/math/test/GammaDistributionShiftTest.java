package de.uka.ipd.sdq.probfunction.math.test;

import de.uka.ipd.sdq.probfunction.math.IGammaDistribution;


public class GammaDistributionShiftTest extends GammaDistributionTest
{
	
	
	public GammaDistributionShiftTest() 
	{
		double alpha = 1.0;
		double theta = 0.5;
		double scalar = 2.0;
		
		a = ssjFactory.createGammaDistribution(alpha, theta);
		b = apacheFactory.createGammaDistribution(alpha, theta);
		
		a = (IGammaDistribution) a.shiftDomain(scalar);
		b = (IGammaDistribution) b.shiftDomain(scalar);
		
		
	}
	
	
}
