/**
 * 
 */
package de.uka.ipd.sdq.probfunction.math.impl;

import de.uka.ipd.sdq.probfunction.math.IContinuousSample;
import de.uka.ipd.sdq.probfunction.math.util.MathTools;

/**
 * @author Ihssane
 * 
 */
public class ContinuousSampleImpl implements IContinuousSample {

	private Double value;
	private Double probability;
	/**
	 * @param value
	 * @param probability
	 */
	protected ContinuousSampleImpl(Double value, Double probability) {
		this.value = value;
		this.probability = probability;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.math.probfunction.impl.IContinuousSampel#getProbability()
	 */
	public Double getProbability() {
		return probability;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.math.probfunction.impl.IContinuousSampel#setProbability(java.lang.Double)
	 */
	public void setProbability(Double probability) {
		this.probability = probability;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.math.probfunction.impl.IContinuousSampel#getValue()
	 */
	public double getValue() {
		return value;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.math.probfunction.impl.IContinuousSampel#setValue(java.lang.Double)
	 */
	public void setValue(Double value) {
		this.value = value;
	}
	/**
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof IContinuousSample) {
			IContinuousSample s = (IContinuousSample) obj;
			return MathTools.equalsDouble(this.getValue(), s.getValue())
					&& MathTools.equalsDouble(this.getProbability(), s
							.getProbability());
		}
		return false;
	}

}
