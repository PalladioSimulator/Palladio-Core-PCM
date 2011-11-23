package de.uka.ipd.sdq.probfunction.math.test;

import org.junit.Assert;
import org.junit.Test;

import de.uka.ipd.sdq.probfunction.math.ILognormalDistribution;



public class LognormalDistributionTest extends AbstractContinousPDFTest <ILognormalDistribution> 
{

	public LognormalDistributionTest() 
	{
		double mu = Math.exp(0.9);
		double sigma = Math.exp(0.5);
		a = ssjFactory.createLognormalDistribution(mu, sigma);
		b = apacheFactory.createLognormalDistribution(mu, sigma);
	}
	
	@Test
	public void testMu()
	{
		Assert.assertEquals("Mu is differing!", a.getMu(), b.getMu(), EPSILON);
	}
	
	@Test
	public void testSigma()
	{
		Assert.assertEquals("Sigma is differing!", a.getSigma(), b.getSigma(), EPSILON);
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testMedian() 
	{
		super.testMedian();
	}
	
	
}
