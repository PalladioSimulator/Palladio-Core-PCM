package de.uka.ipd.sdq.scheduler.resources.queueing;

import de.uka.ipd.sdq.scheduler.processes.ActiveProcess;
import de.uka.ipd.sdq.scheduler.resources.SimResourceInstance;

public interface IQueueingStrategy {

	/**
	 * Returns the executable process for the given instance.
	 */
	public abstract ActiveProcess getNextProcessFor(SimResourceInstance instance);

	/**
	 * Adds a new process to the queue(s).
	 */
	public abstract void addNewProcess(ActiveProcess process);

	/**
	 * Depending on the underlying implementation the load is balanced between
	 * multiple resource instances.
	 */
	public abstract void balance();

}
