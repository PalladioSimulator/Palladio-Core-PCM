package de.uka.ipd.sdq.stoex.analyser.operations;

import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;

public interface ICompareOperation {

	public double compare(double left, double right);
	
	public double compare(IProbabilityMassFunction left, double right);
	
	public double compare(double left, IProbabilityMassFunction right);
	
	public double compare(IProbabilityMassFunction left, IProbabilityMassFunction right);
	
}
