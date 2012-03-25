package edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.priority;

import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.processes.impl.ProcessWithPriority;

public interface IPriorityUpdateStrategy  {

	/**
	 * Updates the priority of the given process according to the implemented
	 * strategy. If true is returned an update was performed, otherwise the
	 * priority of the process did not change.
	 */
	public abstract boolean update(ProcessWithPriority process);

	public abstract IPriorityUpdateStrategy cloneFor(ProcessWithPriority process);

}
