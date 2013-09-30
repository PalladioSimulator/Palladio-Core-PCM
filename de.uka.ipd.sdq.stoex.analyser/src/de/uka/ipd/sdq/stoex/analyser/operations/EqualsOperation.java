package de.uka.ipd.sdq.stoex.analyser.operations;

import java.util.List;

import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.ISample;

/**
 * Implements the operation "equals" for different kinds of operands.
 * 
 * @author koziolek
 */
public class EqualsOperation extends CompareOperation {

	protected IProbabilityMassFunction getComparePMF(boolean left, boolean right) {
		if (left == right)
			return getBoolPMF(1.0);
		else
			return getBoolPMF(0.0);
	}

	protected IProbabilityMassFunction getComparePMF(double left, double right) {
		if (left == right)
			return getBoolPMF(1.0);
		else
			return getBoolPMF(0.0);
	}

	protected IProbabilityMassFunction getComparePMF(double left,
			IProbabilityMassFunction right) {
		return compare(right, left);
	}

	protected IProbabilityMassFunction getComparePMF(
			IProbabilityMassFunction left, double right) {
		return getBoolPMF(getProbabilityForValue(left, right));
	}

	protected IProbabilityMassFunction getComparePMF(
			IProbabilityMassFunction left, IProbabilityMassFunction right) {
		return getBoolPMF(comparePointWise(left, right, this));
	}

	protected IProbabilityMassFunction getComparePMF(String left,
			IProbabilityMassFunction right) {
		List<ISample> list = right.getSamples();
		for (ISample sample : list) {
			String sampleString = (String) sample.getValue();
			if (left.equals(sampleString)) {
				return getBoolPMF(sample.getProbability());
			}
		}
		return getBoolPMF(0.0);
	}

	protected IProbabilityMassFunction getComparePMF(String left, String right) {
		if (left.equals(right))
			return getBoolPMF(1.0);
		else
			return getBoolPMF(0.0);
	}
}
