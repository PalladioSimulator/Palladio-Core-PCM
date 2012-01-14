/**
 * 
 */
package de.uka.ipd.sdq.reliability.solver.sensitivity;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.sensitivity.DoubleParameterRange;
import de.uka.ipd.sdq.sensitivity.DoubleParameterSequence;
import de.uka.ipd.sdq.sensitivity.DoubleParameterVariation;
import de.uka.ipd.sdq.sensitivity.SensitivityParameterVariation;
import de.uka.ipd.sdq.sensitivity.StringParameterSequence;

/**
 * @author brosch
 * 
 */
public class SensitivityCalculator {

	/**
	 * Log4J logging support.
	 */
	private static Logger logger = Logger.getLogger(SensitivityCalculator.class
			.getName());

	/**
	 * Calculates the current double value from a given parameter variation and
	 * step number.
	 * 
	 * @param variation
	 *            the parameter variation
	 * @param stepNumber
	 *            the step number
	 * @return the current value
	 */
	public double calculateCurrentDoubleValue(
			final DoubleParameterVariation variation, final int stepNumber) {
		if (variation instanceof DoubleParameterSequence) {
			DoubleParameterSequence sequence = (DoubleParameterSequence) variation;
			return sequence.getDoubleValues().get(stepNumber - 1);
		} else if (variation instanceof DoubleParameterRange) {
			DoubleParameterRange range = (DoubleParameterRange) variation;
			if (range.isConsiderStepSize()) {
				return range.getFirstValue()
						+ ((range.getLastValue() - range.getFirstValue()) / (range
								.getStepCount() - 1)) * (stepNumber - 1);
			} else {
				return range.getFirstValue() + range.getStepSize()
						* (stepNumber - 1);
			}
		} else {
			logger.error("Parameter variation type \""
					+ variation.eClass().toString() + "\" not yet supported.");
			return 0.0;
		}
	}

	/**
	 * Calculates the current string value from a given parameter variation and
	 * step number.
	 * 
	 * @param sequence
	 *            the parameter variation
	 * @param stepNumber
	 *            the step number
	 * @return the current value
	 */
	public String calculateCurrentStringValue(
			final StringParameterSequence sequence, final int stepNumber) {
		return sequence.getStringValues().get(stepNumber - 1);
	}

	/**
	 * Calculates the number of steps to perform for a given parameter
	 * variation.
	 * 
	 * @param variation
	 *            the parameter variation
	 * @return the number of steps to perform
	 */
	public int calculateNumberOfSteps(
			final SensitivityParameterVariation variation) {
		if (variation instanceof DoubleParameterRange) {
			if (((DoubleParameterRange) variation).isConsiderStepSize()) {
				DoubleParameterRange range = (DoubleParameterRange) variation;
				return (int) Math.floor(Math.abs(range.getLastValue()
						- range.getFirstValue())
						/ Math.abs(range.getStepSize()));
			} else {
				return ((DoubleParameterRange) variation).getStepCount();
			}
		} else if (variation instanceof DoubleParameterSequence) {
			return ((DoubleParameterSequence) variation).getDoubleValues()
					.size();
		} else if (variation instanceof StringParameterSequence) {
			return ((StringParameterSequence) variation).getStringValues()
					.size();
		} else {
			logger.error("Parameter variation type \""
					+ variation.eClass().toString() + "\" not yet supported.");
			return 0;
		}
	}
}
