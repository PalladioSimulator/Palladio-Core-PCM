package de.uka.ipd.sdq.probfunction.math.test;

public class GammaDistributionFromMomentsTest extends GammaDistributionTest
{

	public GammaDistributionFromMomentsTest() 
	{
		double mean = 1.0;
		double coefficientOfVariance = 0.5;
		a = ssjFactory.createGammaDistributionFromMoments(mean, coefficientOfVariance);
		b = apacheFactory.createGammaDistributionFromMoments(mean, coefficientOfVariance);
	}
	
	
}
