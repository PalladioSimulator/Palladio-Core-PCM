package de.uka.ipd.sdq.stoex.analyser.operations;

import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;

/**
 * Implements the operation "greater" for different kinds of operands.
 * @author koziolek
 */
public class GreaterOperation extends CompareOperation {

	public IProbabilityMassFunction compare(double left, double right) {
		if (left > right)
			return getBoolPMF(1.0);
		else
			return getBoolPMF(0.0);
	}

	public IProbabilityMassFunction compare(IProbabilityMassFunction left, double right) {
		return getBoolPMF(1-getProbabilitySumUntil(left, right, true));
	}

	public IProbabilityMassFunction compare(double left, IProbabilityMassFunction right) {
		return compare(right,left);
	}

	public IProbabilityMassFunction compare(IProbabilityMassFunction left,
			IProbabilityMassFunction right) {
		return getBoolPMF(comparePointWise(left, right, this));
	}

}
