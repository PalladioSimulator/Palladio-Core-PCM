/**
 * 
 */
package de.uka.ipd.sdq.probfunction.math.impl;

import de.uka.ipd.sdq.probfunction.math.ISample;

/**
 * @author Ihssane
 * 
 */
public class SampleImpl implements ISample {

	private double probability;
	private Object value;

	/**
	 * @param value
	 * @param probability
	 */
	protected SampleImpl(Object value, double probability) {
		super();
		this.probability = probability;
		this.value = value;
	}


	public double getProbability() {
		return probability;
	}

	public void setProbability(double probability) {
		this.probability = probability;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

}
