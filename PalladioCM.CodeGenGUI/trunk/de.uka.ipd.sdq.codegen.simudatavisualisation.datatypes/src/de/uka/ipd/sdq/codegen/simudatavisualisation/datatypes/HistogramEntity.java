/**
 * 
 */
package de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes;

/**
 * @author admin
 *
 */
public class HistogramEntity {
	
	private double probability;
	private double value;

	/**
	 * @param probability
	 * @param value
	 */
	public HistogramEntity(double probability, double value) {
		this.probability = probability;
		this.value = value;
	}
	
	/**
	 * @return the probability
	 */
	public double getProbability() {
		return probability;
	}
	/**
	 * @param probability the probability to set
	 */
	public void setProbability(double probability) {
		this.probability = probability;
	}
	/**
	 * @return the value
	 */
	public double getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(double value) {
		this.value = value;
	}

}
