package de.uka.ipd.sdq.probfunction.math.apache.distribution;

import org.apache.commons.math.MathException;
import org.apache.commons.math.distribution.NormalDistribution;
import org.apache.commons.math.distribution.NormalDistributionImpl;

public class LognormalDistributionImpl extends NormalDistributionImpl implements NormalDistribution
{
	
//	final double mu, sigma;
	
	/** Serializable version identifier */
	private static final long serialVersionUID = -4630735663414796584L;

	/**
     * Create a normal distribution using the given mean and standard deviation.
     * @param mean mean for this distribution
     * @param sd standard deviation for this distribution
     */
    public LognormalDistributionImpl(double mu, double sigma)
    {
    	super(mu, sigma);
//    	this.mu = mu;
//    	this.sigma = sigma;
//        
    }

    @Override
    public double cumulativeProbability(double x) throws MathException 
    {
    	if(x == 0)
    		return 0.0;
    	
		return super.cumulativeProbability(Math.log(x));
	}

    @Override
	public double cumulativeProbability(double x0, double x1) 	throws MathException 
	{
		return super.cumulativeProbability(Math.log(x0), Math.log(x1));
	}

	@Override
	public double getMean() {
		return super.getMean();
	}

	@Override
	public double density(double x) 
	{
		return super.density(Math.log(x))/x;
	}


	@Override
	public double getStandardDeviation() {
		return  super.getStandardDeviation();
	}

	@Override
	public double inverseCumulativeProbability(double p) throws MathException {
		return super.inverseCumulativeProbability(p);
	}

	@Override
	protected double getInitialDomain(double p) {
		// TODO Auto-generated method stub
		return Math.exp(super.getInitialDomain(p));
	}

	@Override
	protected double getDomainLowerBound(double p) {
		// TODO Auto-generated method stub
		return  Math.exp(super.getDomainLowerBound(p));
	}

	@Override
	protected double getDomainUpperBound(double p) {
		// TODO Auto-generated method stub
		return  Math.exp(super.getDomainUpperBound(p));
	}

	

}
