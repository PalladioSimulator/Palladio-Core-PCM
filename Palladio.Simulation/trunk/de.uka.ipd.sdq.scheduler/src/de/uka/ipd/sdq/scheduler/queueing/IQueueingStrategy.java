package de.uka.ipd.sdq.scheduler.queueing;

import de.uka.ipd.sdq.scheduler.IResourceInstance;
import de.uka.ipd.sdq.scheduler.processes.impl.ActiveProcess;

public interface IQueueingStrategy {

	/**
	 * Returns the next executable process for the given instance.
	 */
	public abstract ActiveProcess getNextProcessFor(IResourceInstance instance);

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
	public abstract void balance(IResourceInstance instance);

	/**
	 * 
	 * @param process
	 * @return TODO
	 */
	public abstract boolean removePendingProcess(ActiveProcess process);

	public abstract boolean containsPending(ActiveProcess process);

	public abstract void setRunningOn(ActiveProcess process,
			IResourceInstance instance);

	public abstract IResourceInstance runningOn(ActiveProcess process);

	public abstract void removeRunning(ActiveProcess process);

}
