package de.uka.ipd.sdq.stoex.analyser.operations;

import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;

/**
 * Implements the logical "OR" operation.
 * 
 * @author brosch
 * 
 */
public class OrOperation extends LogicalOperation {

	/**
	 * Evaluates two Boolean PMFs.
	 * 
	 * Other PMFs than Boolean are not accepted.
	 */
	protected IProbabilityMassFunction getEvaluatedPMF(
			IProbabilityMassFunction left, IProbabilityMassFunction right) {
		return getBoolPMF(1.0 - findBooleanProbability(left, false)
				* findBooleanProbability(right, false));
	}

}
