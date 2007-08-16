package de.uka.ipd.sdq.scheduler.resources.balancing;

import de.uka.ipd.sdq.scheduler.processes.ActiveProcess;
import de.uka.ipd.sdq.scheduler.resources.SimResourceInstance;

public interface IInitialInstanceSelector {

	/**
	 * Selects the initial instance to execute on for a process.
	 */
	public abstract SimResourceInstance selectInstanceFor(ActiveProcess process);

}
