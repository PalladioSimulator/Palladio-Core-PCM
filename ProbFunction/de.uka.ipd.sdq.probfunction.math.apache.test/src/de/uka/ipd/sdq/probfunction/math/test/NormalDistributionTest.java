package de.uka.ipd.sdq.probfunction.math.test;


import org.junit.Assert;
import org.junit.Test;

import de.uka.ipd.sdq.probfunction.math.INormalDistribution;



public class NormalDistributionTest extends AbstractContinousPDFTest <INormalDistribution>
{

	public NormalDistributionTest() 
	{
		double mean = 0.9;
		double sigma = 0.5;
		a = ssjFactory.createNormalDistribution(mean, sigma);
		b = apacheFactory.createNormalDistribution(mean, sigma);
	}
	
	@Test
	public void testMean()
	{
		Assert.assertEquals("Mean is differing!", a.getMean(), b.getMean(), EPSILON);
	}
	
	@Test
	public void testSigma()
	{
		Assert.assertEquals("Sigma is differing!", a.getSigma(), b.getSigma(), EPSILON);
	}
	
	
}
