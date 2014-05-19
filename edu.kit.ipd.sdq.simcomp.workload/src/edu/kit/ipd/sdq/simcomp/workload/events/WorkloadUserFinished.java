package edu.kit.ipd.sdq.simcomp.workload.events;

import edu.kit.ipd.sdq.simcomp.component.IUser;
import edu.kit.ipd.sdq.simcomp.events.SimulationEvent;

public class WorkloadUserFinished extends SimulationEvent {

	public static final String EVENT_ID = SimulationEvent.ID_PREFIX + "workload/USER_FINISHED";

	private IUser user;

	public WorkloadUserFinished(IUser user) {
		super(WorkloadUserFinished.EVENT_ID);
		this.user = user;
	}

	public IUser getUser() {
		return user;
	}

}
