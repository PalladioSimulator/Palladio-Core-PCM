package de.uka.ipd.sdq.scheduler.balancing;

import de.uka.ipd.sdq.scheduler.processes.ActiveProcess;
import de.uka.ipd.sdq.scheduler.resources.active.SimResourceInstance;

public interface IInstanceSelector {

	/**
	 * Selects the initial instance to execute on for a process.
	 */
	public abstract SimResourceInstance selectInstanceFor(ActiveProcess process);

}
