package de.uka.ipd.sdq.dsolver.operations;

import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.exception.DifferentDomainsException;

public class SubOperation implements IOperation {

	public double compute(double left, double right) {
		return left-right;
	}

	public int compute(int left, int right) {
		return left-right;
	}

	public IProbabilityMassFunction compute(IProbabilityMassFunction left,
			int right) {
		//TODO
		// return left.shiftDomain(-right);
		throw new UnsupportedOperationException();
	}

	public IProbabilityMassFunction compute(IProbabilityMassFunction left,
			IProbabilityMassFunction right) throws DifferentDomainsException {
		return left.sub(right);
	}

}
