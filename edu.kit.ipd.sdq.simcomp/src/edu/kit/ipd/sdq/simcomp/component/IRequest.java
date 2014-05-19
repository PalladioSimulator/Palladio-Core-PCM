package edu.kit.ipd.sdq.simcomp.component;

import de.uka.ipd.sdq.probespec.framework.RequestContext;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEventDelegator;

/**
 * Represents a request processed in a system simulation component.
 * 
 * @author Christoph Föhrdes
 */
public interface IRequest {
	
	public long getId();
	
	/**
	 * The unique identifier for the probe framework
	 * 
	 * @return A request context
	 */
	public RequestContext getRequestContext();

	/**
	 * Returns the user who initiated the request.
	 * 
	 * @return The creator of the request
	 */
	public IUser getUser();
	
	public void activate();
	
	public void passivate(AbstractSimEventDelegator<?> activationEvent);

}
