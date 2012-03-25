package edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.priority;

import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.processes.impl.ProcessWithPriority;

public interface IPriorityBoost {

	/**
	 * Boosts the priority of the given process. 
	 * If a process is boosted it might also happen that its timeslice is adjusted.
	 */
	public abstract void boost(ProcessWithPriority process);

	public abstract boolean priorityChanges(ProcessWithPriority process);

	void punish(ProcessWithPriority process);

}
