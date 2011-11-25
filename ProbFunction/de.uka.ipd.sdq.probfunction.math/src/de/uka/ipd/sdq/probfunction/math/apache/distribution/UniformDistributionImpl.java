/**
 * 
 */
package de.uka.ipd.sdq.probfunction.math.apache.distribution;

import org.apache.commons.math.MathException;
import org.apache.commons.math.distribution.AbstractContinuousDistribution;


/**
 * @author joerg
 *
 */
public class UniformDistributionImpl extends AbstractContinuousDistribution {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4771624459254238355L;
	double a,b;
	
	
	
	public double getA() {
		return a;
	}


	public double getB() {
		return b;
	}

	
	
	public UniformDistributionImpl(double a, double b) throws MathException
	{
		if(b<a)
			throw new MathException("Second value has to be greater than first value of interval");
		
		this.a = a;
		this.b = b;
	
		
		
	}
	
	
	/* (non-Javadoc)
	 * @see org.apache.commons.math.distribution.AbstractIntegerDistribution#cumulativeProbability(int)
	 */
	@Override
	public double cumulativeProbability(double x) throws MathException {
		if(x<a)
			return 0;
		else if(x>b)
			return 1;
		
		return (x-a)/(b-a);
	}

	/* (non-Javadoc)
	 * @see org.apache.commons.math.distribution.AbstractIntegerDistribution#getDomainLowerBound(double)
	 */
	@Override
	protected double getDomainLowerBound(double p) {
		return a;
	}

	/* (non-Javadoc)
	 * @see org.apache.commons.math.distribution.AbstractIntegerDistribution#getDomainUpperBound(double)
	 */
	@Override
	protected double getDomainUpperBound(double p) {
		return b;
	}

	
	
	public double getMean()
	{
		return (a+b)/2;
	}
	
	public double getVariance()
	{
		return 1/12.0*(b-a)*(b-a);
	}


	@Override
	protected double getInitialDomain(double p) {
		return getMean();
	}

}
