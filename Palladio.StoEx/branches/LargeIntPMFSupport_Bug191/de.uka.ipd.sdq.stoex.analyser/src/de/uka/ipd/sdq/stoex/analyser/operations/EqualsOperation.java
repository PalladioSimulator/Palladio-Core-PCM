package de.uka.ipd.sdq.stoex.analyser.operations;

import java.util.List;

import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.ISample;

/**
 * Implements the operation "equals" for different kinds of operands.
 * @author koziolek
 */
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

	@Override
	public IProbabilityMassFunction compare(String left, String right) {
		if (left.equals(right))
			return getBoolPMF(1.0);
		else
			return getBoolPMF(0.0);
	}

	@Override
	public IProbabilityMassFunction compare(String left,
			IProbabilityMassFunction right) {
		List<ISample> list = right.getSamples();
		for (ISample sample : list){
			String sampleString = (String)sample.getValue();
			if (left.equals(sampleString)){
				return getBoolPMF(sample.getProbability());
			}
		}
		return getBoolPMF(0.0);
	}

}
