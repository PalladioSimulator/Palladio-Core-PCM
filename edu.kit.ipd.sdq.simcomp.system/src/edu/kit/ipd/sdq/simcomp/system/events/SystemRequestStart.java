package edu.kit.ipd.sdq.simcomp.system.events;

import edu.kit.ipd.sdq.simcomp.component.IRequest;
import edu.kit.ipd.sdq.simcomp.events.SimulationEvent;

/**
 * The system request start event is intended to be fired when a user service
 * call has entered the system and a new request was createn to be processed by
 * the system simulation component.
 * 
 * @author Christoph Föhrdes
 * 
 */
public class SystemRequestStart extends SimulationEvent {

	public static final String EVENT_ID = SimulationEvent.ID_PREFIX + "system/REQUEST_START";

	private IRequest request;

	/**
	 * System request start event constructor
	 * 
	 * @param request
	 *            The request which has been created and is about to be
	 *            processed
	 */
	public SystemRequestStart(IRequest request) {
		super(SystemRequestStart.EVENT_ID);
		this.request = request;
	}

	/**
	 * @return The request which has been created and is about to be processed
	 */
	public IRequest getRequest() {
		return request;
	}

}
