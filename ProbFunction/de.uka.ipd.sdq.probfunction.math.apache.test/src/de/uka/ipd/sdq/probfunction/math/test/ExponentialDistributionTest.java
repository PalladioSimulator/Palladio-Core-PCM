package de.uka.ipd.sdq.probfunction.math.test;

import org.junit.Assert;
import org.junit.Test;

import de.uka.ipd.sdq.probfunction.math.IExponentialDistribution;


public class ExponentialDistributionTest extends AbstractContinousPDFTest <IExponentialDistribution>
{

	public ExponentialDistributionTest() 
	{
		double rate = 10000;
		a = ssjFactory.createExponentialDistribution(rate);
		b = apacheFactory.createExponentialDistribution(rate);
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testMedian() 
	{
		super.testMedian();
	}
	
	@Test
	public void testRate()
	{
		Assert.assertEquals("Rate is differing!", a.getRate(), b.getRate(), EPSILON);
	}
	
	
}
