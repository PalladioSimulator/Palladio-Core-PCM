package edu.kit.ipd.sdq.simcomp.workload.events;

import edu.kit.ipd.sdq.simcomp.component.IUser;
import edu.kit.ipd.sdq.simcomp.events.SimulationEvent;

/**
 * The workload user spawn event is intended to be fired, when a workload
 * simulation component has spawned a new user which will start a request to the
 * system.
 * 
 * @author Christoph Föhrdes
 * 
 */
public class WorkloadUserSpawn extends SimulationEvent {

	public static final String EVENT_ID = SimulationEvent.ID_PREFIX + "workload/USER_SPAWN";

	private IUser user;

	/**
	 * Workload user spawn event constructor
	 * 
	 * @param user
	 *            The user object which was spawned by the workload
	 */
	public WorkloadUserSpawn(IUser user) {
		super(WorkloadUserSpawn.EVENT_ID);
		this.user = user;
	}

	/**
	 * @return The user object which was spawned by the workload
	 */
	public IUser getUser() {
		return user;
	}

}
