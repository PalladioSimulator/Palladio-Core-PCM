package de.uka.ipd.sdq.dsolver.operations;

import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;

public class ModOperation implements IOperation {

	public double compute(double left, double right) {
		return left % right;
	}

	public int compute(int left, int right) {
		return left % right;
	}

	public IProbabilityMassFunction compute(IProbabilityMassFunction left,
			int right) {
		//TODO
		//return left.mod(right);
		throw new UnsupportedOperationException();
	}

	public IProbabilityMassFunction compute(IProbabilityMassFunction left,
			IProbabilityMassFunction right) {
		//TODO
		//return left.mod(right);
		throw new UnsupportedOperationException();
	}

}
