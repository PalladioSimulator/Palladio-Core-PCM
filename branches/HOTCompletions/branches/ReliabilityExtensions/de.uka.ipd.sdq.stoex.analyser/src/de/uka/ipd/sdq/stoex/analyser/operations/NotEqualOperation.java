package de.uka.ipd.sdq.stoex.analyser.operations;

import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;

/**
 * Implements the operation "not equals" for different kinds of operands.
 * @author koziolek
 */
public class NotEqualOperation extends CompareOperation {

	public IProbabilityMassFunction compare(double left, double right) {
		if (left != right)
			return getBoolPMF(1.0);
		else
			return getBoolPMF(0.0);
	}

	public IProbabilityMassFunction compare(IProbabilityMassFunction left,
			double right) {
		return getBoolPMF(1-getProbabilityForValue(left, right));
	}

	public IProbabilityMassFunction compare(double left, IProbabilityMassFunction right) {
		return compare(right, left);
	}

	public IProbabilityMassFunction compare(IProbabilityMassFunction left,
			IProbabilityMassFunction right) {
		return getBoolPMF(comparePointWise(left, right, this));
	}

	@Override
	public IProbabilityMassFunction compare(String left, String right) {
		if (left.equals(right))
			return getBoolPMF(0.0);
		else
			return getBoolPMF(1.0);
	}

	@Override
	public IProbabilityMassFunction compare(String left,
			IProbabilityMassFunction right) {
		throw new UnsupportedOperationException();
	}
}
