package de.uka.ipd.sdq.stoex.analyser.operations;

import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;

/**
 * Implements the operation "not equals" for different kinds of operands.
 * @author koziolek
 */
public class NotEqualOperation extends CompareOperation {

	protected IProbabilityMassFunction getComparePMF(boolean left, boolean right) {
		if (left != right)
			return getBoolPMF(1.0);
		else
			return getBoolPMF(0.0);
	}

	public IProbabilityMassFunction getComparePMF(double left, double right) {
		if (left != right)
			return getBoolPMF(1.0);
		else
			return getBoolPMF(0.0);
	}

	public IProbabilityMassFunction getComparePMF(double left, IProbabilityMassFunction right) {
		return compare(right, left);
	}

	public IProbabilityMassFunction getComparePMF(IProbabilityMassFunction left, double right) {
		return getBoolPMF(1-getProbabilityForValue(left, right));
	}

	public IProbabilityMassFunction getComparePMF(IProbabilityMassFunction left, IProbabilityMassFunction right) {
		return getBoolPMF(comparePointWise(left, right, this));
	}

	public IProbabilityMassFunction getComparePMF(String left, IProbabilityMassFunction right) {
		throw new UnsupportedOperationException();
	}

	public IProbabilityMassFunction getComparePMF(String left, String right) {
		if (left.equals(right))
			return getBoolPMF(0.0);
		else
			return getBoolPMF(1.0);
	}
}
