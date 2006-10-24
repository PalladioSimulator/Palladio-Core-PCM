package de.uka.ipd.sdq.dsolver.operations;

import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.exception.DifferentDomainsException;

public class ModOperation implements IOperation {

	public double opDoubleDouble(double left, double right) {
		return left % right;
	}

	public int opIntInt(int left, int right) {
		return left % right;
	}

	public IProbabilityMassFunction opPMFInt(IProbabilityMassFunction left,
			int right) {
		//return left.mod(right);
		return null;
	}

	public IProbabilityMassFunction opPMFPMF(IProbabilityMassFunction left,
			IProbabilityMassFunction right) throws DifferentDomainsException {
		//return left.mod(right);
		return null; 
	}

}
