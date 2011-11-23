package de.uka.ipd.sdq.probfunction.math.test;


public class LognormalDistributionFromMomentsTest extends LognormalDistributionTest
{
	
	
	public LognormalDistributionFromMomentsTest() 
	{
		double mean = 1.0;
		double variance = 0.5;
		a = ssjFactory.createLognormalDistributionFromMoments(mean, variance);
		b = apacheFactory.createLognormalDistributionFromMoments(mean, variance);
		
	}
	
	
	
	
}
