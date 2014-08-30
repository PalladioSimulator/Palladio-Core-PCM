package de.uka.ipd.sdq.stoex.analyser.operations;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.ISample;
import de.uka.ipd.sdq.probfunction.math.IUnit;

/**
 * Abstract class with interface for logical operations (AND, OR).
 * 
 * @author brosch
 * 
 */
public abstract class LogicalOperation {

	/**
	 * String constant for FALSE value.
	 */
	private static final Object FALSE_STRING = "false";

	/**
	 * String constant for TRUE value.
	 */
	private static final Object TRUE_STRING = "true";

	/**
	 * Evaluates two objects that represent the left-hand side and the
	 * right-hand side of a logical expression.
	 * 
	 * @param left
	 *            left-hand side of expression
	 * @param right
	 *            right-hand side of expression
	 * @return evaluation result
	 */
	public IProbabilityMassFunction evaluate(Object left, Object right) {

		// Assure proper handling of boolean values:
		if (left instanceof String) {
			if (((String) left).toLowerCase().equals(TRUE_STRING)) {
				left = new Boolean(true);
			} else if (((String) left).toLowerCase().equals(FALSE_STRING)) {
				left = new Boolean(false);
			}
		}
		if (right instanceof String) {
			if (((String) right).toLowerCase().equals(TRUE_STRING)) {
				right = new Boolean(true);
			} else if (((String) right).toLowerCase().equals(FALSE_STRING)) {
				right = new Boolean(false);
			}
		}

		// Propagate to the type-dependent handling:
		if ((left instanceof IProbabilityMassFunction)
				&& (right instanceof IProbabilityMassFunction)) {
			return getEvaluatedPMF((IProbabilityMassFunction) left,
					(IProbabilityMassFunction) right);
		}
		if ((left instanceof Boolean)
				&& (right instanceof IProbabilityMassFunction)) {
			return getEvaluatedPMF((Boolean) left,
					(IProbabilityMassFunction) right);
		}
		if ((left instanceof IProbabilityMassFunction)
				&& (right instanceof Boolean)) {
			return getEvaluatedPMF((IProbabilityMassFunction) left,
					(Boolean) right);
		}
		if ((left instanceof Boolean) && (right instanceof Boolean)) {
			return getEvaluatedPMF((Boolean) left, (Boolean) right);
		}

		// Type not supported:
		throw new UnsupportedOperationException();
	}

	/**
	 * Retrieves the probability of the given boolean value from the given
	 * Boolean PMF.
	 * 
	 * @param left
	 * @return
	 */
	protected double findBooleanProbability(
			final IProbabilityMassFunction left, final boolean value) {

		// Search for the sample that represents the TRUE value:
		for (ISample leftSamplingPoint : left.getSamples()) {
			if (!(leftSamplingPoint.getValue() instanceof String)) {
				// Found non-boolean sample:
				throw new UnsupportedOperationException();
			}
			if (((String) leftSamplingPoint.getValue()).toUpperCase().equals(
					Boolean.toString(value).toUpperCase())) {
				return leftSamplingPoint.getProbability();
			}
		}

		// Did not find a sample for the requested boolean value:
		throw new UnsupportedOperationException();
	}

	/**
	 * Converts a boolean value to a boolean PMF.
	 * 
	 * @param value
	 * @return
	 */
	protected IProbabilityMassFunction getBoolPMF(boolean value) {
		return (value) ? getBoolPMF(1.0) : getBoolPMF(0.0);
	}

	/**
	 * Converts a probability into a boolean PMF.
	 * 
	 * @param left
	 * @param right
	 * @return
	 */
	protected IProbabilityMassFunction getBoolPMF(double trueProb) {
		IProbabilityFunctionFactory probFac = IProbabilityFunctionFactory.eINSTANCE;

		IUnit unit = probFac.createUnit("bool");

		List<ISample> sampleList = new ArrayList<ISample>();
		sampleList.add(probFac.createSample(TRUE_STRING, trueProb));
		sampleList.add(probFac.createSample(FALSE_STRING, 1 - trueProb));

		IProbabilityMassFunction boolPMF = probFac
				.createProbabilityMassFunction(sampleList, unit, true);

		return boolPMF;
	}

	/**
	 * Evaluates two boolean values.
	 */
	protected IProbabilityMassFunction getEvaluatedPMF(Boolean left,
			Boolean right) {
		return getBoolPMF(new Boolean(left && right));
	}

	/**
	 * Evaluates a boolean value and a PMF.
	 */
	protected IProbabilityMassFunction getEvaluatedPMF(Boolean left,
			IProbabilityMassFunction right) {
		return getEvaluatedPMF(getBoolPMF(left), right);
	}

	/**
	 * Evaluates a boolean value and a PMF.
	 */
	protected IProbabilityMassFunction getEvaluatedPMF(
			IProbabilityMassFunction left, Boolean right) {
		return getEvaluatedPMF(left, getBoolPMF(right));
	}

	protected abstract IProbabilityMassFunction getEvaluatedPMF(
			IProbabilityMassFunction left, IProbabilityMassFunction right);
}
