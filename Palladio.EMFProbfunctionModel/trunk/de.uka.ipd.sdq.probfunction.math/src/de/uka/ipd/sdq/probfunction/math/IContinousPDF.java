package de.uka.ipd.sdq.probfunction.math;

public interface IContinousPDF extends IProbabilityDensityFunction {
	
	public double getVariance();
	
	public double getStandardDeviation();
	
	public double getCoefficientOfVariance();

}
