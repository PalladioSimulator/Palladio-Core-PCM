/**
 * 
 */
package de.uka.ipd.sdq.probfunction.math.impl;

import de.uka.ipd.sdq.probfunction.math.IProbabilityFunction;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.IUnit;

/**
 * @author Ihssane
 * 
 */
public abstract class ProbabilityFunctionImpl implements IProbabilityFunction {

	private IUnit unit;
	private boolean hasOrderedDomain;
	private boolean isInFrequencyDomain;
	
	protected static final IProbabilityFunctionFactory pfFactory = IProbabilityFunctionFactory.eINSTANCE;
	
	
	public ProbabilityFunctionImpl(IUnit unit, boolean hasOrderedDomain, boolean isInFrequencyDomain) {
		super();
		this.unit = unit;
		this.hasOrderedDomain = hasOrderedDomain;
		this.isInFrequencyDomain = isInFrequencyDomain;
	}

	// hide constructor
	protected ProbabilityFunctionImpl(){
	}


	public IUnit getUnit() {
		return unit;
	}


	public boolean hasOrderedDomain() {
		return hasOrderedDomain;
	}


	public boolean isInFrequencyDomain() {
		return isInFrequencyDomain;
	}


	public boolean isInTimeDomain() {
		return !isInFrequencyDomain;
	}

	protected void setInFrequencyDomain(boolean isInFrequencyDomain) {
		this.isInFrequencyDomain = isInFrequencyDomain;
	}

	protected void setUnit(IUnit unit) {
		this.unit = unit;
	}

	

}
