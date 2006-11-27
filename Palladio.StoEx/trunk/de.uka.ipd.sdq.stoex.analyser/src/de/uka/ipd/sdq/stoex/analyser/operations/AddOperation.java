package de.uka.ipd.sdq.stoex.analyser.operations;

import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.exception.DifferentDomainsException;

public class AddOperation implements IOperation {

	public IProbabilityMassFunction compute(IProbabilityMassFunction left,
			IProbabilityMassFunction right) throws DifferentDomainsException {
		return left.add(right);
	}

	public int compute(int left, int right) {
		return left+right;
	}

	public double compute(double left, double right) {
		return left+right;
	}

	public IProbabilityMassFunction compute(IProbabilityMassFunction left, int right) {
		// TODO
		// return left.shiftDomain(right);
		throw new UnsupportedOperationException();
	}

}
