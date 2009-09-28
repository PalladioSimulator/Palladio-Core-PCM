package de.uka.ipd.sdq.probfunction.math.impl;

import umontreal.iro.lecuyer.probdist.ContinuousDistribution;
import de.uka.ipd.sdq.probfunction.math.IContinousPDF;
import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;

public abstract class AbstractContinousPDF implements IContinousPDF {

	protected ContinuousDistribution internalFunction = null;
	
		
	public AbstractContinousPDF() {
		super();
	}

	
	@Override
	public final double getArithmeticMeanValue() {
		return this.internalFunction.getMean();
	}

	@Override
	public double getCoefficientOfVariance() {
		return this.getStandardDeviation() / this.getArithmeticMeanValue();
	}

	@Override
	public double getStandardDeviation() {
		return this.internalFunction.getStandardDeviation();
	}

	@Override
	public double getVariance() {
		double std = this.getStandardDeviation();
		return std * std;
	}

	@Override
	public double getProbabilitySum() {
		return 1;
	}

	@Override
	public boolean isInFrequencyDomain() {
		return false;
	}

	@Override
	public boolean isInTimeDomain() {
		return true;
	}


}
