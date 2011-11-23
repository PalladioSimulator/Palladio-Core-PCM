package de.uka.ipd.sdq.probfunction.math.test;

import org.junit.Assert;
import org.junit.Test;

import de.uka.ipd.sdq.probfunction.math.IExponentialDistribution;


public class ExponentialDistributionTest extends AbstractContinousPDFTest <IExponentialDistribution>
{

	public ExponentialDistributionTest() 
	{
		double mean = 0.5;
		a = ssjFactory.createExponentialDistribution(mean);
		b = apacheFactory.createExponentialDistribution(mean);
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
