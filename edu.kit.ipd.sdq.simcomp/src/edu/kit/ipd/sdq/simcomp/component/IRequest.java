package edu.kit.ipd.sdq.simcomp.component;

import de.uka.ipd.sdq.probespec.framework.RequestContext;

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
	
	public long getId();
	
	public void activate();
	
	public void passivate();
	
	/**
	 * The unique identifier for the probe framework
	 * 
	 * @return A request context
	 */
	public RequestContext getRequestContext();

}
