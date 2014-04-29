package edu.kit.ipd.sdq.simcomp.event.workload;

import edu.kit.ipd.sdq.simcomp.component.IUser;
import edu.kit.ipd.sdq.simcomp.event.simulation.SimulationEvent;

public class WorkloadUserSpawn extends SimulationEvent {

	public static final String EVENT_ID = SimulationEvent.ID_PREFIX + "workload/USER_SPAWN";

	private IUser user;

	public WorkloadUserSpawn(IUser user) {
		super(WorkloadUserSpawn.EVENT_ID);
		this.user = user;
	}

	public IUser getUser() {
		return user;
	}

}
