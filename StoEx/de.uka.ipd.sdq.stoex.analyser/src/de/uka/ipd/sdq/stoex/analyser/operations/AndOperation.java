package de.uka.ipd.sdq.stoex.analyser.operations;

import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;

/**
 * Implements the logical "AND" operation.
 * 
 * @author brosch
 * 
 */
public class AndOperation extends LogicalOperation {

	/**
	 * Evaluates two Boolean PMFs.
	 * 
	 * Other PMFs than Boolean are not accepted.
	 */
	protected IProbabilityMassFunction getEvaluatedPMF(
			IProbabilityMassFunction left, IProbabilityMassFunction right) {
		return getBoolPMF(findBooleanProbability(left, true)
				* findBooleanProbability(right, true));
	}
}
