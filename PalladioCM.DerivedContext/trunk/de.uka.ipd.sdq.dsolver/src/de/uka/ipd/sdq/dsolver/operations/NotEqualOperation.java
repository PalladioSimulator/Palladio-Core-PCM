package de.uka.ipd.sdq.dsolver.operations;

import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;

public class NotEqualOperation implements ICompareOperation {

	public double compare(double left, double right) {
		if (left != right)
			return 1.0;
		else
			return 0.0;
	}

	public double compare(IProbabilityMassFunction left, double right) {
		// TODO Auto-generated method stub
		return 0;
	}

	public double compare(double left, IProbabilityMassFunction right) {
		// TODO Auto-generated method stub
		return 0;
	}

	public double compare(IProbabilityMassFunction left,
			IProbabilityMassFunction right) {
		// TODO Auto-generated method stub
		return 0;
	}

}
