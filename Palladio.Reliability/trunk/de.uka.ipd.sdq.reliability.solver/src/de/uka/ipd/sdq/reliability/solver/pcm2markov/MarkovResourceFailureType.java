package de.uka.ipd.sdq.reliability.solver.pcm2markov;

/**
 * This class represents a failure due to an unavailable processing resource.
 * 
 * @author brosch
 * 
 */
public class MarkovResourceFailureType extends MarkovFailureType {

	/**
	 * The type of the failing resource.
	 */
	private MarkovResourceType resourceType;

	/**
	 * Sets the type of the failing resource.
	 * 
	 * @param resourceType
	 *            the type of the failing resource
	 */
	public void setResourceType(MarkovResourceType resourceType) {
		this.resourceType = resourceType;
		this.name = resourceType.getName();
	}

	/**
	 * Retrieves the type of the failing resource.
	 * 
	 * @return the type of the failing resource
	 */
	public MarkovResourceType getResourceType() {
		return resourceType;
	}
}
