package de.uka.ipd.sdq.scheduler.priority;

import de.uka.ipd.sdq.scheduler.processes.ProcessWithPriority;

public interface IPriorityBoost {

	/**
	 * Boosts the priority of the given process.
	 */
	public abstract void boost(ProcessWithPriority process);

}
