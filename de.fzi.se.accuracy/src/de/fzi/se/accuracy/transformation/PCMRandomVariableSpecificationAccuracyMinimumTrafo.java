/**
 *
 */
package de.fzi.se.accuracy.transformation;

import org.apache.log4j.Logger;

import de.fzi.se.quality.qualityannotation.ExactlyAsSpecifiedPrecision;
import de.fzi.se.quality.qualityannotation.LimitedDeviationPrecision;
import de.fzi.se.quality.qualityannotation.NoPrecision;
import de.fzi.se.quality.qualityannotation.Precision;
import de.fzi.se.quality.qualityannotation.util.QualityAnnotationSwitch;
import static de.fzi.se.quality.util.StoExHelper.*;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;

/**Modifies a given PCM Random Variable according to the minimum allowed by a precision.
 * First set the random variable by {@link #setModifiedVariable(PCMRandomVariable)} then transform it by {@link PCMRandomVariableSpecificationAccuracyMinimumTrafo#doSwitch(org.eclipse.emf.ecore.EObject)}.

 * @author groenda
 *
 */
public class PCMRandomVariableSpecificationAccuracyMinimumTrafo extends
		QualityAnnotationSwitch<Boolean> {
	/** Logger for this class. */
	private static final Logger logger = Logger.getLogger(PCMRandomVariableSpecificationAccuracyMinimumTrafo.class);

	/** The variable modified by the transformation when {@link #doSwitch(org.eclipse.emf.ecore.EObject)} is called. */
	private PCMRandomVariable modifiedVariable;

	/** Minimum value reported will not be smaller than this bound.*/
	private String lowerLimit;

	/**Sets the lower bound for the minimum.
	 * The transformation will not result in values below this bound.
	 * The bound is automatically reset after an invocation of {@link #doSwitch(org.eclipse.emf.ecore.EObject)}.
	 * @param lowerLimit The lower bound.
	 */
	public void setLowerLimit(String lowerLimit) {
		this.lowerLimit = lowerLimit;
	}

	/**Set the variable to modify upon invocation of {@link #doSwitch(org.eclipse.emf.ecore.EObject)}.
	 * @param modifiedVariable The variable.
	 */
	public void setModifiedVariable(PCMRandomVariable modifiedVariable) {
		this.modifiedVariable = modifiedVariable;
	}

	@Override
	public Boolean caseNoPrecision(NoPrecision object) {
		checkModifiedVariable();
		if (lowerLimit == null) {
			String msg = "Dynamic type inference of specifications to determine minimal value is not implemented (yet).";
			logger.error(msg);
			throw new IllegalArgumentException(msg);
		} else {
			modifiedVariable.setSpecification(lowerLimit);
		}
		reset();
		return true;
	}

	@Override
	public Boolean caseExactlyAsSpecifiedPrecision(
			ExactlyAsSpecifiedPrecision object) {
		checkModifiedVariable();
		reset();
		// nothing to do
		return true;
	}

	@Override
	public Boolean caseLimitedDeviationPrecision(
			LimitedDeviationPrecision object) {
		checkModifiedVariable();
		// newSpec = max(min(noc.specification - absolute, noc.specification - noc.specification * relative, 0);
		String spec = modifiedVariable.getSpecification();
		String abs = "" + object.getAbsolute();
		String rel = "" + object.getRelative();
		String min = "MinDeviation(" + spec + ", " + abs + ", " + rel + ")";
		if (lowerLimit == null) {
			modifiedVariable.setSpecification(min);
		} else {
			modifiedVariable.setSpecification(stoExMax(min, lowerLimit));
		}
		reset();
		return true;
	}

	@Override
	public Boolean casePrecision(Precision object) {
		checkModifiedVariable();
		String msg = "The handling of the provided Precision " + object + " is not implemented.";
		logger.error(msg);
		reset();
		throw new IllegalArgumentException(msg);
	}

	/**Checks that the modified variable is set.
	 *
	 */
	private void checkModifiedVariable() {
		if (modifiedVariable == null) {
			String msg = "You have to set the modified variable before invoking doSwitch(). Note: The modified variable is reset after an execution of doSwitch() to prevent accidental transformations of the same variable.";
			logger.error(msg);
			throw new IllegalArgumentException(msg);
		}
	}

	/**Prevent accidental re-transformation by resetting this classes instance variables.
	 */
	private void reset() {
		modifiedVariable = null;
		lowerLimit = null;
	}
}
