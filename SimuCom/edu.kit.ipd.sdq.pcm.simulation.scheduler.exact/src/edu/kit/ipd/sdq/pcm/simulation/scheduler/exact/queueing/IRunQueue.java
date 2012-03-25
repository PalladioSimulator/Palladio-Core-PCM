package edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.queueing;

import java.util.List;

import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.IResourceInstance;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.processes.IActiveProcess;


/**
 * Interface for process queues used by more general queuing strategies.
 * 
 * @author jens
 * 
 */
public interface IRunQueue {

	/**
	 * Returns the current number of processes in the ready queues.
	 */
	public abstract int getCurrentLoad();

	/**
	 * Returns the next process runnable on the given instance.
	 */
	public abstract IActiveProcess getNextRunnableProcess(
			IResourceInstance instance);

	/**
	 * Returns the next runnable process.
	 * 
	 * @return
	 */
	public abstract IActiveProcess getNextRunnableProcess();

	/**
	 * @return True, if there are no processes in the runqueue.
	 */
	public abstract boolean isEmpty();

	/**
	 * Removes a process from the runqueue.
	 * 
	 * @param process
	 * @return True, if the process was removed. False, if the process was not
	 *         found in the queue.
	 */
	public abstract boolean removeProcess(IActiveProcess process);

	/**
	 * Adds a process to the runqueue.
	 * 
	 * @param inFront
	 *            If true, the process is added at the beginning of its queue,
	 *            otherwise it is added at the queue's end.
	 */
	public abstract void addProcess(IActiveProcess process, boolean inFront);

	/**
	 * Prototype Object Pattern. Creates a new instance of the given runqueue.
	 * 
	 * @return
	 */
	public abstract IRunQueue createNewInstance();

	/**
	 * @param instance
	 *            Resource instance a process is needed for.
	 * @return Returns the most urgent queue which contains at least one process
	 *         which can run on the given instance. NULL if no such queue
	 *         exists.
	 */
	public abstract IProcessQueue getBestRunnableQueue(
			IResourceInstance instance);

	/**
	 * Composes a list of processes movable to the specified target. The list is
	 * ordered in terms of what suits best for the target resource instance. The
	 * first element is better than the second which is better than the third
	 * and so on. Note that currently running processes are never added to the
	 * movable list.
	 * 
	 * @param targetInstance
	 *            Resource instance the processes shall be moved to.
	 * @param prio_increasing
	 *            If true, the processes in the resulting list are ordered with
	 *            an increasing priority, otherwise with a decreasing priority.
	 * @param queue_ascending
	 *            If true, processes in the resulting list are in the same order
	 *            as in the queue, otherwise they are in reverse order.
	 * @param processes_needed
	 *            The maximum number of processes needed for the resource.
	 * @return An ordered list of processes movable to the target resource.
	 */
	public abstract List<IActiveProcess> identifyMovableProcesses(
			IResourceInstance targetInstance, boolean prio_increasing,
			boolean queue_ascending, int processes_needed);

	/**
	 * @param process
	 *            Process of interest.
	 * @return True, if the process is in this runqueue, otherwise false.
	 */
	public abstract boolean contains(IActiveProcess process);

	/**
	 * Removes a process from the pending queue of the runqueue, i.e. the
	 * process is in ready state.
	 * 
	 * @param process
	 *            Process of interest.
	 * @return True, if the process was successfully removed, otherwise (if the
	 *         process was not found) false.
	 */
	public abstract boolean removePendingProcess(IActiveProcess process);

	/**
	 * @param process
	 *            Process of interest.
	 * @return True, if the process is pending in the runqueue.
	 */
	public abstract boolean containsPending(IActiveProcess process);

	/**
	 * Removes a running process from the runqueue.
	 * 
	 * @param process
	 *            Process of interest.
	 */
	public abstract void removeRunning(IActiveProcess process);

	/**
	 * Checks if the runqueue contains a running process.
	 * 
	 * @param process
	 *            Process of interest.
	 * @return True, if the process is in the running list of the runqueue,
	 *         otherwise false.
	 */
	public abstract boolean containsRunning(IActiveProcess process);

	/**
	 * Sets the given process as running on the specified instance. Note that
	 * the process must not be marked as running on another instance.
	 * 
	 * @param process
	 *            Process to run.
	 * @param instance
	 *            Instance the process shall run on.
	 */
	public abstract void setRunningOn(IActiveProcess process,
			IResourceInstance instance);

	/**
	 * @param process
	 *            Process of interest.
	 * @return The resource instance the given process is running on.
	 */
	public abstract IResourceInstance runningOn(IActiveProcess process);

	/**
	 * True, if there is no process running on the given resource. Furthermore, the
	 * pending queue has to be empty if there is only one instance.
	 * 
	 * @param instance
	 * @return
	 */
	public abstract boolean isIdle(IResourceInstance instance);

	public abstract boolean processStarving(double threshold);

	public abstract double getWaitingTime(IActiveProcess process);

	void setWaitingTime(IActiveProcess process, double waiting);

	public abstract List<IActiveProcess> getStarvingProcesses(
			double starvationLimit);

	public abstract void resetStarvationInfo();

}
