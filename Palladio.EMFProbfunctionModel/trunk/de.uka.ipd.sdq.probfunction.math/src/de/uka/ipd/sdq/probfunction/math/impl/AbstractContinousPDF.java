package de.uka.ipd.sdq.probfunction.math.impl;

import umontreal.iro.lecuyer.probdist.ContinuousDistribution;
import de.uka.ipd.sdq.probfunction.math.IContinousPDF;

public abstract class AbstractContinousPDF implements IContinousPDF {

	protected ContinuousDistribution internalFunction = null;
	
		
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


}
