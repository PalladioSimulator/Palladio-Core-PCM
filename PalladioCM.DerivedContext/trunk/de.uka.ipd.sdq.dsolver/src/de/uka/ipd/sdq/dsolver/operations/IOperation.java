package de.uka.ipd.sdq.dsolver.operations;

import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.exception.DifferentDomainsException;

public interface IOperation {

	public IProbabilityMassFunction opPMFPMF(IProbabilityMassFunction left,
			IProbabilityMassFunction right) throws DifferentDomainsException;
	
	public int opIntInt(int left, int right);
	
	public double opDoubleDouble(double left, double right);
	
	public IProbabilityMassFunction opPMFInt(IProbabilityMassFunction left,
			int right);
}
