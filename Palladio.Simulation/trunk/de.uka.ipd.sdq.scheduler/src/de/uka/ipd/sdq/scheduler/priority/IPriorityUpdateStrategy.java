package de.uka.ipd.sdq.scheduler.priority;

import de.uka.ipd.sdq.scheduler.processes.impl.ProcessWithPriority;

public interface IPriorityUpdateStrategy {

	/**
	 * Updates the priority of the given process. If false is returned the
	 * update strategy is no longer needed for the process, otherwise the update
	 * is not yet finished.
	 */
	public abstract boolean update(ProcessWithPriority process);

}
