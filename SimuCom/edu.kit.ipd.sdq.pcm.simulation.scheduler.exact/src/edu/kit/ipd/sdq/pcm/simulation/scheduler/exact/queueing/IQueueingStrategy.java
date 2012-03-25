package edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.queueing;

import java.util.List;

import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.IResourceInstance;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.processes.IActiveProcess;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.resources.active.SimResourceInstance;

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
	public abstract void addProcess(IActiveProcess process, IResourceInstance current, boolean inFront);

	/**
	 * Depending on the underlying implementation the load is balanced between
	 * the resource instances.
	 * 
	 * @param instance
	 *            Instance initiating the load balance.
	 */
	public abstract void activelyBalance(IResourceInstance instance);

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

	/**
	 * True, if the given resource has no running or pending jobs, otherwise false.
	 * 
	 * @param instance
	 */
	public abstract boolean isIdle(IResourceInstance instance);

	public abstract void forkProcess(IActiveProcess process,
			IResourceInstance current, boolean b);

	public abstract void terminateProcess(IActiveProcess process);

	public abstract void fromRunningToWaiting(IActiveProcess process);

	public abstract void fromWaitingToReady(IActiveProcess process,
			IResourceInstance current, boolean in_front_after_waiting);

	public abstract void onSleep(IResourceInstance lastInstance);

	public abstract void registerProcess(IActiveProcess p,
			IResourceInstance instance);

	public abstract List<IActiveProcess> getStarvingProcesses(IResourceInstance instance,
			double starvationLimit);

	public abstract void resetStarvationInfo();

	public abstract int getQueueLengthFor(
			SimResourceInstance simResourceInstance);

}
