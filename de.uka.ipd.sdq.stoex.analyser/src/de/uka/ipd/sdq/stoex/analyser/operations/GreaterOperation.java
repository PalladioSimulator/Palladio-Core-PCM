package de.uka.ipd.sdq.stoex.analyser.operations;

import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;

/**
 * Implements the operation "greater" for different kinds of operands.
 * @author koziolek
 */
public class GreaterOperation extends CompareOperation {

	protected IProbabilityMassFunction getComparePMF(boolean left, boolean right) {
		throw new UnsupportedOperationException();
	}

	protected IProbabilityMassFunction getComparePMF(double left, double right) {
		if (left > right)
			return getBoolPMF(1.0);
		else
			return getBoolPMF(0.0);
	}

	protected IProbabilityMassFunction getComparePMF(double left, IProbabilityMassFunction right) {
		return new LessOperation().compare(left, right);
	}

	protected IProbabilityMassFunction getComparePMF(IProbabilityMassFunction left, double right) {
		return getBoolPMF(1-getThresholdProbability(left, right, true));
	}

	protected IProbabilityMassFunction getComparePMF(IProbabilityMassFunction left, IProbabilityMassFunction right) {
		return getBoolPMF(comparePointWise(left, right, this));
	}

	protected IProbabilityMassFunction getComparePMF(String left, IProbabilityMassFunction right) {
		throw new UnsupportedOperationException();
	}

	protected IProbabilityMassFunction getComparePMF(String left, String right) {
		throw new UnsupportedOperationException();
	}

}
