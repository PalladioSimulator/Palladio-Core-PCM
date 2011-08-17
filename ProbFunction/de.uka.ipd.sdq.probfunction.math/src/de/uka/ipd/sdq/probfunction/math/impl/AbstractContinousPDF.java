package de.uka.ipd.sdq.probfunction.math.impl;

import umontreal.iro.lecuyer.probdist.ContinuousDistribution;
import umontreal.iro.lecuyer.randvar.RandomVariateGen;
import umontreal.iro.lecuyer.rng.MRG32k3a;
import de.uka.ipd.sdq.probfunction.math.IContinousPDF;
import de.uka.ipd.sdq.probfunction.math.IUnit;

public abstract class AbstractContinousPDF implements IContinousPDF {

	protected ContinuousDistribution internalFunction = null;
	protected RandomVariateGen sampleDrawer = null;
	
		
	public AbstractContinousPDF() {
		super();
	}

	
	public final double getArithmeticMeanValue() {
		return this.internalFunction.getMean();
	}

	public double getCoefficientOfVariance() {
		return this.getStandardDeviation() / this.getArithmeticMeanValue();
	}

	public double getStandardDeviation() {
		return this.internalFunction.getStandardDeviation();
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
		return this.internalFunction.cdf(x);
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
			sampleDrawer = new RandomVariateGen(new MRG32k3a(),
					internalFunction);
		}

		return sampleDrawer.nextDouble();
	}


	/**
	 * Returns xa such that the probability density is 0 everywhere outside the interval [xa, xb], 
	 * as defined in 
	 * {@link umontreal.iro.lecuyer.probdist.ContinousDistribution#density(double)}
	 * @return lower limit of support
	 */
	public double getXinf() {
		return this.internalFunction.getXinf();
	}


	/**
	 * Returns xb such that the probability density is 0 everywhere outside the interval [xa, xb], 
	 * as defined in 
	 * {@link umontreal.iro.lecuyer.probdist.ContinousDistribution#density(double)}
	 * @return upper limit of support
	 */
	public double getXsup() {
		return this.internalFunction.getXsup();
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
		return this.internalFunction.inverseF(u);
	}


	public IUnit getUnit() {
		return null;
	}
	
	
	
	


}
