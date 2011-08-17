/**
 *
 */
package de.fzi.se.accuracy.transformation;

import org.apache.log4j.Logger;

import de.fzi.se.quality.qualityannotation.ExactlyAsSpecifiedPrecision;
import de.fzi.se.quality.qualityannotation.LimitedDeviationPrecision;
import de.fzi.se.quality.qualityannotation.NoPrecision;
import de.fzi.se.quality.qualityannotation.util.QualityAnnotationSwitch;

import static java.lang.Math.*;

/**Provides the minimum long value for a given absolute long value and validation precision.
 * @author groenda
 *
 */
public class ValidationPrecisionToMinimumLongValue extends
		QualityAnnotationSwitch<Long> {
	/** Logger for this class. */
	private static final Logger logger = Logger.getLogger(PCMRandomVariableSpecificationAccuracyMinimumTrafo.class);

	/** Absolute value used to calculate the minimum value. */
	private Long absoluteValue;

	/**Sets the absolute value.
	 * Value must be set prior to calling {@link #doSwitch(org.eclipse.emf.ecore.EObject)}.
	 * Value is reset after an invocation of {@link #doSwitch(org.eclipse.emf.ecore.EObject)}.
	 * @param absoluteValue Absolute value.
	 */
	public void setAbsoluteValue(Long absoluteValue) {
		this.absoluteValue = absoluteValue;
	}

	@Override
	public Long caseNoPrecision(NoPrecision object) {
		checkAbsoluteValue();
		absoluteValue = null;
		return Long.MIN_VALUE;
	}

	@Override
	public Long caseExactlyAsSpecifiedPrecision(
			ExactlyAsSpecifiedPrecision object) {
		checkAbsoluteValue();
		long abs = absoluteValue;
		absoluteValue = null;
		return abs;
	}

	@Override
	public Long caseLimitedDeviationPrecision(LimitedDeviationPrecision object) {
		checkAbsoluteValue();
		long min = min((long) (absoluteValue-ceil(object.getAbsolute())),
						(long) (absoluteValue-ceil(((double)absoluteValue*object.getRelative()))));
		absoluteValue = null;
		return min;
	}

	/**Ensure that the absolute value is not null.
	 */
	private void checkAbsoluteValue() {
		if (absoluteValue == null) {
			String msg = "You have to set the absolute value before invoking doSwitch(). Note: The absolute value is reset after an execution of doSwitch() to prevent accidental re-use.";
			logger.error(msg);
			throw new IllegalArgumentException(msg);
		}
	}
}
