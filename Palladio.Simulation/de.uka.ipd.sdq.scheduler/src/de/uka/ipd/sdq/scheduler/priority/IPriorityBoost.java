package de.uka.ipd.sdq.scheduler.priority;

import de.uka.ipd.sdq.scheduler.processes.ProcessWithPriority;

public interface IPriorityBoost {

	/**
	 */
	public abstract void boost(ProcessWithPriority process);

	public IPriorityUpdateStrategy getPriorityDecayStrategy();

}
