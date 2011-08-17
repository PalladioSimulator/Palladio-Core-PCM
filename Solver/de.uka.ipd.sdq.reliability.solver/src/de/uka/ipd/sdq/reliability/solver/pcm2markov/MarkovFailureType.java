package de.uka.ipd.sdq.reliability.solver.pcm2markov;

/**
 * Represents a generic type of failure.
 * 
 * @author brosch
 * 
 */
public abstract class MarkovFailureType {

	/**
	 * The name of this failure type.
	 */
	protected String name;

	/**
	 * Sets the name of the failure type.
	 * 
	 * @param name
	 *            the name of the failure type
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Retrieves the name of the failure type.
	 * 
	 * @return the name of the failure type
	 */
	public String getName() {
		return name;
	}

}
