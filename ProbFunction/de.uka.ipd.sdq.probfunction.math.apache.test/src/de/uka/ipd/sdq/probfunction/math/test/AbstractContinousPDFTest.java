package de.uka.ipd.sdq.probfunction.math.test;

import org.apache.commons.math.random.MersenneTwister;
import org.apache.commons.math.random.RandomGenerator;
import org.junit.Test;
import org.junit.Assert;

import de.uka.ipd.sdq.probfunction.math.IContinousPDF;
import de.uka.ipd.sdq.probfunction.math.apache.impl.ApacheMathRandomGenerator;
import de.uka.ipd.sdq.probfunction.math.impl.IContinousPDFFactory;


public abstract class AbstractContinousPDFTest <T extends IContinousPDF>
{
	
	T a,b;
	static final IContinousPDFFactory ssjFactory = new de.uka.ipd.sdq.probfunction.math.ssj.impl.ContinousPDFFactory();
	static final IContinousPDFFactory apacheFactory = new de.uka.ipd.sdq.probfunction.math.apache.impl.ContinousPDFFactory();
	
	final static double EPSILON = 0.000000001; 
	RandomGenerator random = new MersenneTwister(42);
	ApacheMathRandomGenerator rng = new ApacheMathRandomGenerator(random);
	
	@Test
	public void testArithmeticMeanValue()
	{
		Assert.assertEquals("ArithmeticMeanValue is differing!", a.getArithmeticMeanValue(), b.getArithmeticMeanValue(), EPSILON);
		
	}
	
	@Test
	public void testMedian()
	{
		//Continuous PDFs have no median element
		double aVal = (Double) a.getMedian();
		double bVal = (Double) b.getMedian();
		
		Assert.assertEquals("Median is differing!", aVal, bVal, EPSILON);
	}
	
	@Test
	public void testVariance()
	{
		Assert.assertEquals("Variance is differing!", a.getVariance(), b.getVariance(), EPSILON);
	}
	
	@Test
	public void testStandardDeviation()
	{
		Assert.assertEquals("StandardDeviation is differing!", a.getStandardDeviation(), b.getStandardDeviation(), EPSILON);
		
	}
	
	@Test
	public void testCoefficientOfVariance()
	{
		Assert.assertEquals("CoefficientOfVariance is differing!", a.getCoefficientOfVariance(), b.getCoefficientOfVariance(), EPSILON);
		
	}
	
	@Test
	public void testXsup()
	{
		Assert.assertEquals("Xsup is differing!", a.getXsup(), b.getXsup(), EPSILON);
		
	}
	
	@Test
	public void testXinf()
	{
		Assert.assertEquals("Xinf is differing!", a.getXinf(), b.getXinf(), EPSILON);
		
	}
	
	/**
	 * Test distribution itself
	 */
	
	@Test
	public void testCDF()
	{
		double[] testValues = {0.0,0.1,0.5,0.9,1.0};
		for(double x : testValues)
			Assert.assertEquals("CDF is differing! For x = " + x, a.cdf(x), b.cdf(x), EPSILON);
		
		for(int i=0;i<500;i++)
		{
			double x = rng.nextDouble();
			Assert.assertEquals("CDF is differing! For x = " + x, a.cdf(x), b.cdf(x), EPSILON);
		}
		
	}
	
	@Test
	public void testDensity()
	{
		double[] testValues = {0.0,0.1,0.5,0.9,1.0};
		for(double x : testValues)
			Assert.assertEquals("Density is differing! For x = " + x, a.density(x), b.density(x), EPSILON);
		
		for(int i=0;i<500;i++)
		{
			double x = rng.nextDouble();
			Assert.assertEquals("Density is differing! For x = " + x, a.density(x), b.density(x), EPSILON);
		}
	}

	
	@Test
	public void testInverseF()
	{
		double[] testValues = {0.0,0.1,0.5,0.9,1.0};
		for(double u : testValues)
			Assert.assertEquals("InverseF is differing! For u = " + u, a.inverseF(u), b.inverseF(u), EPSILON);
		
		for(int i=0;i<500;i++)
		{
			double u = rng.nextDouble();
			Assert.assertEquals("InverseF is differing! For u = " + u, a.inverseF(u), b.inverseF(u), EPSILON);
		}
	}
}
