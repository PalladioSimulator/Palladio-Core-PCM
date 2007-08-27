package de.uka.ipd.sdq.scheduler.queueing;

import de.uka.ipd.sdq.scheduler.processes.IActiveProcess;
import de.uka.ipd.sdq.scheduler.resources.IResourceInstance;

/**
 * The queuing strategy of a process encapsulates the actual queue(s) of a set
 * of resource instances. Possible parameters are, for example, a single queue
 * for all instance versus a queue for each instance.
 * 
 * @author jens
 * 
 */
public interface IQueueingStrategy {

	/**
	 * Returns the next executable process for the given instance.
	 */
	public abstract IActiveProcess getNextProcessFor(IResourceInstance instance);

	/**
	 * Adds a process to the queue(s).
	 * 
	 * @param inFront
	 *            If true, the process is added at the beginning of its queue,
	 *            otherwise at its end.
	 */
	public abstract void addProcess(IActiveProcess process, boolean inFront);

	/**
	 * Depending on the underlying implementation the load is balanced between
	 * the resource instances.
	 * 
	 * @param instance
	 *            Instance initiating the load balance.
	 */
	public abstract void balance(IResourceInstance instance);

	/**
	 * Removes at the pending queues of the queuing strategy and tries to remove
	 * the process there.
	 * 
	 * @param process
	 *            Process that should be removed.
	 * @return True, if the process was successfully removed. False, if the
	 *         process was not found in the pending queues.
	 */
	public abstract boolean removePendingProcess(IActiveProcess process);

	/**
	 * @param process
	 *            Process looked for.
	 * @return True, if the process is in a pending queue of the strategy.
	 */
	public abstract boolean containsPending(IActiveProcess process);

	/**
	 * Sets the process as executing on the given instance. In order for this
	 * operation to be successful, the process must be in ready state and in the
	 * a pending queue of the strategy.
	 * 
	 * @param process
	 *            Process that shall be executed.
	 * @param instance
	 *            Target instance for the process.
	 */
	public abstract void setRunningOn(IActiveProcess process,
			IResourceInstance instance);

	/**
	 * @param process
	 *            Process of interest.
	 * @return Returns the resource instance the process is currently running
	 *         on. NULL if the process is not assigned to a resource.
	 */
	public abstract IResourceInstance runningOn(IActiveProcess process);

	/**
	 * Removes a process from the running list of the instance.
	 * 
	 * @param process
	 *            Process of interest.
	 */
	public abstract void removeRunning(IActiveProcess process);

}
