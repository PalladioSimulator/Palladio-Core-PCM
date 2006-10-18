/**
 * 
 */
package de.uka.ipd.sdq.probfunction.math.impl;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.ISamplePDF;
import de.uka.ipd.sdq.probfunction.math.IUnit;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionNotInFrequencyDomainException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionNotInTimeDomainException;
import de.uka.ipd.sdq.probfunction.math.exception.NegativeDistanceException;
import de.uka.ipd.sdq.probfunction.math.util.MathTools;

/**
 * @author Ihssane
 * 
 */
public abstract class ProbabilityDensityFunctionImpl extends
		ProbabilityFunctionImpl implements IProbabilityDensityFunction {

	protected ProbabilityDensityFunctionImpl(IUnit unit,
			boolean isInFrequencyDomain) {
		super(unit, true, isInFrequencyDomain);
	}

	// hide constructor
	protected ProbabilityDensityFunctionImpl() {
	}

}
