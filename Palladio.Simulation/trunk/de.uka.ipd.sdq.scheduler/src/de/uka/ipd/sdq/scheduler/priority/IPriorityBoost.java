package de.uka.ipd.sdq.scheduler.priority;

import de.uka.ipd.sdq.scheduler.processes.impl.ProcessWithPriority;

public interface IPriorityBoost {

	/**
	 * Boosts the priority of the given process. Besides changing the priority,
	 * the boosting might also change the process' timeslice.
	 */
	public abstract void boost(ProcessWithPriority process);

}
