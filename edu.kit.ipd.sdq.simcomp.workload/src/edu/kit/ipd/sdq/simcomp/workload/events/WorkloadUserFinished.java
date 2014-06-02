package edu.kit.ipd.sdq.simcomp.workload.events;

import edu.kit.ipd.sdq.simcomp.component.IUser;
import edu.kit.ipd.sdq.simcomp.events.SimulationEvent;

/**
 * The workload user finished event is intended to be fired, when a user spawned
 * by a workload simulation component has finished processing his requests and
 * is about to despawn.
 * 
 * @author Christoph Föhrdes
 * 
 */
public class WorkloadUserFinished extends SimulationEvent {

	public static final String EVENT_ID = SimulationEvent.ID_PREFIX + "workload/USER_FINISHED";

	private IUser user;

	/**
	 * Workload user finished event constructor
	 * 
	 * @param user
	 *            The user object which has finished to process its requests
	 */
	public WorkloadUserFinished(IUser user) {
		super(WorkloadUserFinished.EVENT_ID);
		this.user = user;
	}

	/**
	 * @return The user object which has finished to process its requests
	 */
	public IUser getUser() {
		return user;
	}

}
