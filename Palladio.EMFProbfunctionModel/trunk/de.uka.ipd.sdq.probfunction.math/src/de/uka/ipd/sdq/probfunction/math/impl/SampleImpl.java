/**
 * 
 */
package de.uka.ipd.sdq.probfunction.math.impl;

import de.uka.ipd.sdq.probfunction.math.ISample;
import de.uka.ipd.sdq.probfunction.math.util.MathTools;

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

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof ISample) {
		return this.getValue().equals(((ISample) obj).getValue())
				&& MathTools.equalsDouble(this.getProbability(),
						((ISample) obj).getProbability());
		}
		return false;
	}
	

	@Override
	public String toString() {
		return "(" + getValue() + ", " + MathTools.asString( getProbability() ) + ")";
	}

}
