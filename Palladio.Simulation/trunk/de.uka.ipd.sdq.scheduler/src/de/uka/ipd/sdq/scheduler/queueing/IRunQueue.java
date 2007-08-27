package de.uka.ipd.sdq.scheduler.queueing;

import java.util.List;

import de.uka.ipd.sdq.scheduler.processes.ActiveProcess;
import de.uka.ipd.sdq.scheduler.queueing.runqueues.ProcessQueue;
import de.uka.ipd.sdq.scheduler.resources.active.SimResourceInstance;

public interface IRunQueue {

	/**
	 * Returns the current number of tasks in the ready queues.
	 */
	public abstract int getCurrentLoad();

	/**
	 * Returns the next process runnable on the given instance.
	 */
	public abstract ActiveProcess getNextRunnableProcess(
			SimResourceInstance instance);

	/**
	 * Returns the next runnable process.
	 * 
	 * @return
	 */
	public abstract ActiveProcess getNextRunnableProcess();

	/**
	 * @return True, if there are no processes in the runqueue.
	 */
	public abstract boolean isEmpty();

	/**
	 * Removes a process from the runqueue.
	 */
	public abstract boolean removeProcess(ActiveProcess process);

	/**
	 * Adds a process at the very end of the runqueue.
	 * 
	 * @param inFront
	 *            TODO
	 */
	public abstract void addProcess(ActiveProcess process, boolean inFront);

	/**
	 * Creates a new instance of the given runqueue. Prototype Object Pattern.
	 * 
	 * @return
	 */
	public abstract IRunQueue createNewInstance();

	/**
	 * Returns the most urgent queue which contains at least one process which
	 * can run on the given instance. NULL if no such queue exists.
	 * 
	 * @param instance
	 * @return
	 */
	public abstract ProcessQueue<ActiveProcess> getBestRunnableQueue(
			SimResourceInstance instance);

	/**
	 * Composes a list of processes movable to the specified target. The list is
	 * ordered in terms of what suits best for the target resource instance. The
	 * first element is better than the second which is better than the third
	 * and so on.
	 * 
	 * @param targetInstance
	 * @return
	 */
	public abstract List<ActiveProcess> identifyMovableProcesses(
			SimResourceInstance targetInstance, boolean prio_increasing,
			boolean queue_ascending, int processes_needed);

	/**
	 * True, if the process is in this runqueue, otherwise false.
	 * 
	 * @param process
	 * @return
	 */
	public abstract boolean contains(ActiveProcess process);

	public abstract boolean removePendingProcess(ActiveProcess process);

	public abstract boolean containsPending(ActiveProcess process);

	public abstract void removeRunning(ActiveProcess process);

	public abstract boolean containsRunning(ActiveProcess process);

	public abstract void setRunningOn(ActiveProcess process,
			SimResourceInstance instance);

	public abstract SimResourceInstance runningOn(ActiveProcess process);

}
