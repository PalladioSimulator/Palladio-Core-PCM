package de.uka.ipd.sdq.scheduler.queueing;

import de.uka.ipd.sdq.scheduler.processes.ActiveProcess;
import de.uka.ipd.sdq.scheduler.resources.SimResourceInstance;

public interface IQueueingStrategy {

	/**
	 * Returns the next executable process for the given instance.
	 */
	public abstract ActiveProcess getNextProcessFor(SimResourceInstance instance);

	/**
	 * Adds a new process to the queue(s).
	 * @param inFront TODO
	 */
	public abstract void addProcess(ActiveProcess process, boolean inFront);

	/**
	 * Depending on the underlying implementation the load is balanced between
	 * multiple resource instances.
	 * @param instance 
	 */
	public abstract void balance(SimResourceInstance instance);

	/**
	 * 
	 * @param process
	 * @return TODO
	 */
	public abstract boolean removePendingProcess(ActiveProcess process);

	public abstract boolean containsPending(ActiveProcess process);

	public abstract void setRunningOn(ActiveProcess process,
			SimResourceInstance instance);

	public abstract SimResourceInstance runningOn(ActiveProcess process);

	public abstract void removeRunning(ActiveProcess process);

}
