package edu.kit.ipd.sdq.simcomp.system.events;

import edu.kit.ipd.sdq.simcomp.component.IRequest;
import edu.kit.ipd.sdq.simcomp.events.SimulationEvent;

public class SystemRequestStart extends SimulationEvent {

	public static final String EVENT_ID = SimulationEvent.ID_PREFIX + "system/REQUEST_START";

	private IRequest request;

	public SystemRequestStart(IRequest request) {
		super(SystemRequestStart.EVENT_ID);
		this.request = request;
	}

	public IRequest getRequest() {
		return request;
	}

}
