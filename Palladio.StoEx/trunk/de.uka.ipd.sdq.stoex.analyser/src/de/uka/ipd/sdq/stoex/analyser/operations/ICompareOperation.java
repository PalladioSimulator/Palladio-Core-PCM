package de.uka.ipd.sdq.stoex.analyser.operations;

import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;

public interface ICompareOperation {

	public IProbabilityMassFunction compare(double left, double right);
	
	public IProbabilityMassFunction compare(IProbabilityMassFunction left, double right);
	
	public IProbabilityMassFunction compare(double left, IProbabilityMassFunction right);
	
	public IProbabilityMassFunction compare(IProbabilityMassFunction left, IProbabilityMassFunction right);
	
}
