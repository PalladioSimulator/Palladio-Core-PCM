package de.uka.ipd.sdq.scheduler.resources.queueing;

import java.util.List;

import de.uka.ipd.sdq.scheduler.processes.ActiveProcess;
import de.uka.ipd.sdq.scheduler.resources.SimResourceInstance;

public interface IRunQueue {

	/**
	 * Returns the current number of tasks in the ready queues.
	 */
	public abstract int getCurrentLoad();

	/**
	 * Returns the next process runnable on the given instance. The process is
	 * marked as STANDBY and cannot be selected by other resources.
	 */
	public abstract ActiveProcess getNextRunnableProcess();

	/**
	 * Returns a process to the runqueue that was interrupted before it finished
	 * its timeslice.
	 * 
	 * @param inFront
	 *            TODO
	 */
	public abstract void returnActiveProcess(ActiveProcess process,
			boolean inFront);

	/**
	 * Returns a process to the runqueue whose timeslice expired.
	 */
	public abstract void returnExpiredProcess(ActiveProcess process,
			boolean inFront);

	/**
	 * @return TODO
	 */
	public abstract boolean isEmpty();

	/**
	 */
	public abstract void removeProcess(ActiveProcess process);

	/**
	 */
	public abstract void addProcess(ActiveProcess process);

	/**
	 * Notifies the queue that the process is currently in running state.
	 */
	public abstract void notifyRunning(ActiveProcess process);

	/**
	 * Creates a new instance of the given runqueue. Prototype Object Pattern.
	 * 
	 * @return
	 */
	public abstract IRunQueue createNewInstance();

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
			SimResourceInstance targetInstance);

	/**
	 * Returns the most urgent queue which contains at least one process which
	 * can run on the given instance. NULL if no such queue exists.
	 * 
	 * @param instance
	 * @return
	 */
	public abstract ProcessQueue<ActiveProcess> getUrgentQueue(
			SimResourceInstance instance);

}
