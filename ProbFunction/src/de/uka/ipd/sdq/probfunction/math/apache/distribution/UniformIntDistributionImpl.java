/**
 * 
 */
package de.uka.ipd.sdq.probfunction.math.apache.distribution;

import org.apache.commons.math.MathException;
import org.apache.commons.math.distribution.AbstractIntegerDistribution;

/**
 * @author joerg
 *
 */
public class UniformIntDistributionImpl extends AbstractIntegerDistribution {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4771624459254238355L;
	int a,b;
	int intCount;
	
	
	public int getA() {
		return a;
	}


	public int getB() {
		return b;
	}

	
	
	public UniformIntDistributionImpl(int a, int b) throws MathException
	{
		if(b<a)
			throw new MathException("Second value has to be greater than first value of interval");
		
		this.a = a;
		this.b = b;
		intCount = b - a + 1;
		
		
	}
	
	
	/* (non-Javadoc)
	 * @see org.apache.commons.math.distribution.AbstractIntegerDistribution#cumulativeProbability(int)
	 */
	@Override
	public double cumulativeProbability(int x) throws MathException {
		if(x<a)
			return 0;
		else if(x>b)
			return 1;
		
		return (x-a+1)/intCount;
	}

	/* (non-Javadoc)
	 * @see org.apache.commons.math.distribution.AbstractIntegerDistribution#getDomainLowerBound(double)
	 */
	@Override
	protected int getDomainLowerBound(double p) {
		return a;
	}

	/* (non-Javadoc)
	 * @see org.apache.commons.math.distribution.AbstractIntegerDistribution#getDomainUpperBound(double)
	 */
	@Override
	protected int getDomainUpperBound(double p) {
		return b;
	}

	/* (non-Javadoc)
	 * @see org.apache.commons.math.distribution.IntegerDistribution#probability(int)
	 */
	@Override
	public double probability(int x) {
		if(x<a||x>b)
			return 0;
		
		return 1/intCount;
	}
	
	public double getMean()
	{
		return (a+b)/2;
	}
	
	public double getVariance()
	{
		return (-1.0*intCount*intCount)/12.0;
	}

}
