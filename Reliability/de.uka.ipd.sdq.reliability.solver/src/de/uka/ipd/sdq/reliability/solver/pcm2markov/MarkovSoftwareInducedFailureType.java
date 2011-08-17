package de.uka.ipd.sdq.reliability.solver.pcm2markov;

/**
 * Represents a failure due to a software fault.
 * 
 * @author brosch
 * 
 */
public class MarkovSoftwareInducedFailureType extends MarkovFailureType {

	/**
	 * The application failure id.
	 */
	private String id;

	/**
	 * Sets the application failure id.
	 * 
	 * @param id
	 *            the application failure id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Retrieves the application failure id.
	 * 
	 * @return the application failure id
	 */
	public String getId() {
		return id;
	}

}
