package edu.kit.ipd.sdq.simcomp.system.events;

import edu.kit.ipd.sdq.simcomp.component.IRequest;
import edu.kit.ipd.sdq.simcomp.events.SimulationEvent;

public class SystemRequestProcessed extends SimulationEvent {

	public static final String EVENT_ID = SimulationEvent.ID_PREFIX + "system/REQUEST_PROCESSED";

	private IRequest request;

	public SystemRequestProcessed(IRequest request) {
		super(SystemRequestProcessed.EVENT_ID);
		this.request = request;
	}

	public IRequest getRequest() {
		return request;
	}

}
