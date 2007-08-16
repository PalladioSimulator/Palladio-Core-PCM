package de.uka.ipd.sdq.scheduler.resources.queueing;

import de.uka.ipd.sdq.scheduler.processes.ActiveProcess;


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
	 * @param inFront TODO
	 */
	public abstract void returnActiveProcess(ActiveProcess process, boolean inFront);

	/**
	 * Returns a process to the runqueue whose timeslice expired.
	 */
	public abstract void returnExpiredProcess(ActiveProcess process, boolean inFront);

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
	 * @return
	 */
	public abstract IRunQueue createNewInstance();

}
