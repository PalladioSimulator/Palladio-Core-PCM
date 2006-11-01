package de.uka.ipd.sdq.dsolver.operations;

import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.exception.DifferentDomainsException;

public interface IOperation {

	public IProbabilityMassFunction compute(IProbabilityMassFunction left,
			IProbabilityMassFunction right) throws DifferentDomainsException;
	
	public int compute(int left, int right);
	
	public double compute(double left, double right);
	
	public IProbabilityMassFunction compute(IProbabilityMassFunction left,
			int right);
}
