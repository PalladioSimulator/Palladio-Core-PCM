package de.uka.ipd.sdq.stoex.analyser.operations;

import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;

public class EqualsOperation extends CompareOperation {

	public IProbabilityMassFunction compare(double left, double right) {
		if (left == right)
			return getBoolPMF(1.0);
		else
			return getBoolPMF(0.0);
	}

	/** 
	 * Checks, whether the PMF contains a sampling point with a value equal
	 * to the passed "double" parameter. If such a point is found, its
	 * probability is returned. 
	 */
	public IProbabilityMassFunction compare(IProbabilityMassFunction left,
			double right) {
		return getBoolPMF(getProbabilityForValue(left, right));
	}

	public IProbabilityMassFunction compare(IProbabilityMassFunction left,
			IProbabilityMassFunction right) {
		return getBoolPMF(comparePointWise(left, right, this));
	}

	public IProbabilityMassFunction compare(double left,
			IProbabilityMassFunction right) {
		return compare(right, left);
	}

}
