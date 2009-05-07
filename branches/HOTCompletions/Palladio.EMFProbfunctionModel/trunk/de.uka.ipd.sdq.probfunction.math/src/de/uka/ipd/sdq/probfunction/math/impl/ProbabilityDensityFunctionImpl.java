/**
 * 
 */
package de.uka.ipd.sdq.probfunction.math.impl;

import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.IUnit;

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
	
	
	protected enum CompareOperation {
		GREATER, LESS, EQUALS
	};
}
