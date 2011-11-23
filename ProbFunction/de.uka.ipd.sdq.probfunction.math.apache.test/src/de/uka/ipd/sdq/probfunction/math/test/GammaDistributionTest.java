package de.uka.ipd.sdq.probfunction.math.test;

import org.junit.Assert;
import org.junit.Test;

import de.uka.ipd.sdq.probfunction.math.IGammaDistribution;



public class GammaDistributionTest extends AbstractContinousPDFTest <IGammaDistribution>
{

	public GammaDistributionTest() 
	{
		double alpha = 1.0;
		double theta = 0.5;
		a = ssjFactory.createGammaDistribution(alpha, theta);
		b = apacheFactory.createGammaDistribution(alpha, theta);
	}
	
	
	@Test
	public void testAlpha()
	{
		Assert.assertEquals("Alpha is differing!", a.getAlpha(), b.getAlpha(), EPSILON);
	}
	
	@Test
	public void testTheta()
	{
		Assert.assertEquals("Theta is differing!", a.getTheta(), b.getTheta(), EPSILON);
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testMedian() 
	{
		super.testMedian();
	}
	
}
