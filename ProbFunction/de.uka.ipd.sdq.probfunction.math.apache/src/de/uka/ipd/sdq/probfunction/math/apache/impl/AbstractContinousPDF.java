package de.uka.ipd.sdq.probfunction.math.apache.impl;

import org.apache.commons.math.MathException;
import org.apache.commons.math.distribution.AbstractContinuousDistribution;
import de.uka.ipd.sdq.probfunction.math.IContinousPDF;
import de.uka.ipd.sdq.probfunction.math.IRandomGenerator;
import de.uka.ipd.sdq.probfunction.math.IUnit;
import de.uka.ipd.sdq.probfunction.math.exception.ProbabilityFunctionException;

public abstract class AbstractContinousPDF implements IContinousPDF {

	protected AbstractContinuousDistribution internalFunction = null;
	protected IRandomGenerator sampleDrawer = null;
	
		
	public AbstractContinousPDF() {
		super();
	}

	

	public double getCoefficientOfVariance() {
		return this.getStandardDeviation() / this.getArithmeticMeanValue();
	}


	public double getVariance() {
		double std = this.getStandardDeviation();
		return std * std;
	}

	public double getProbabilitySum() {
		return 1;
	}

	public boolean isInFrequencyDomain() {
		return false;
	}

	public boolean isInTimeDomain() {
		return true;
	}
	
	/**
	 * Returns the distribution function F(x) as defined in 
	 * {@link umontreal.iro.lecuyer.probdist.Distribution#cdf(double)}
	 * @param x
	 * @return F(x)
	 */
	public double cdf(double x){
		try {
			return this.internalFunction.cumulativeProbability(x);
		} catch (MathException e) {
			throw new ProbabilityFunctionException(e.getLocalizedMessage());
		}
	}
	
	/**
	 * Returns f(x), the density evaluated at x, as defined in 
	 * {@link umontreal.iro.lecuyer.probdist.ContinousDistribution#density(double)}
	 * @param x
	 * @return F(x)
	 */
	public double density(double x){
		return this.internalFunction.density(x);
	}
	
	public double drawSample() {
		if (sampleDrawer == null) {
			throw new ProbabilityFunctionException("RNG was not set!");

		}
		try {
			return internalFunction.inverseCumulativeProbability(sampleDrawer.random());
		} catch (MathException e) {
			throw new ProbabilityFunctionException(e.getLocalizedMessage());
		}
	}


	


	/**
	 * Computes and returns the inverse distribution function x = F^{-1}(u). 
	 * This can be used to get the quantiles of the distribution. 
	 * Pass 0.9 to get the x value of this function for which this.cdf(x) = 0.9 holds.
	 * Uses the implementation of the concrete function in the {@link umontreal.iro.lecuyer.probdist} package. 
	 * @param u - value in the interval [0, 1] for which the inverse distribution function is evaluated 
	 * @return the inverse distribution function evaluated at u
	 */
	public double inverseF(double u) {
		
		try {
			return this.internalFunction.inverseCumulativeProbability(u);
		} catch (MathException e) {
			e.printStackTrace();
			throw new ProbabilityFunctionException(e.getLocalizedMessage());
		}
	}


	public IUnit getUnit() {
		return null;
	}
	
	
	
	


}
