/**
 * 
 */
package de.uka.ipd.sdq.codegen.simudatavisualization.birt;

/**
 * @author admin
 *
 */
public class Entity {
	
	private double probability;
	private Object value;

	/**
	 * @param probability
	 * @param value
	 */
	public Entity(double probability, Object value) {
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
	public Object getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(Object value) {
		this.value = value;
	}

}
