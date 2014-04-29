package edu.kit.ipd.sdq.simcomp.component;

/**
 * Represents a request processed in a system simulation component.
 * 
 * @author Christoph Föhrdes
 */
public interface IRequest {

	/**
	 * Returns the user who initiated the request.
	 * 
	 * @return The creator of the request
	 */
	public IUser getUser();

}
