package edu.kit.ipd.sdq.simcomp.system.events;

import edu.kit.ipd.sdq.simcomp.component.IRequest;
import edu.kit.ipd.sdq.simcomp.events.SimulationEvent;

/**
 * The system request processed event is intended to be fired, when a request of
 * a user was entirely processed.
 * 
 * @author Christoph Föhrdes
 * 
 */
public class SystemRequestProcessed extends SimulationEvent {

	public static final String EVENT_ID = SimulationEvent.ID_PREFIX + "system/REQUEST_PROCESSED";

	private IRequest request;

	/**
	 * System request processed event constructor
	 * 
	 * @param request
	 *            The request which was entirely processed
	 */
	public SystemRequestProcessed(IRequest request) {
		super(SystemRequestProcessed.EVENT_ID);
		this.request = request;
	}

	/**
	 * @return The request which was entirely processed
	 */
	public IRequest getRequest() {
		return request;
	}

}
