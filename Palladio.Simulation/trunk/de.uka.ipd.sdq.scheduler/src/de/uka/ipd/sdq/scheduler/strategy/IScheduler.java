package de.uka.ipd.sdq.scheduler.strategy;

import de.uka.ipd.sdq.scheduler.passiveresources.WaitingProcess;
import de.uka.ipd.sdq.scheduler.processes.ActiveProcess;
import de.uka.ipd.sdq.scheduler.queueing.runqueues.ProcessQueue;
import de.uka.ipd.sdq.scheduler.resources.SimResourceInstance;

public interface IScheduler {

	/**
	 * Executes the next processes on the available resource instances.
	 * 
	 * @param instance
	 *            TODO
	 */
	public abstract void schedule(SimResourceInstance instance);

	/**
	 * Registers a new process and adds it to the scheduler's ready queues.
	 * 
	 * @param process
	 */
	public abstract void addProcess(ActiveProcess process);

	/**
	 * Notifies the scheduler, that the process issued a demand that needs to be
	 * processed.
	 * 
	 * @param process
	 */
	public abstract void fromWaitingToReady(WaitingProcess waiting_process, ProcessQueue<WaitingProcess> waitingQueue);

	/**
	 * Notifies the scheduler, that the process is waiting for an other resource.
	 * @param process
	 */
	public abstract void fromRunningToWaiting(WaitingProcess waiting_process, ProcessQueue<WaitingProcess> waitingQueue, boolean inFront);

	public abstract void scheduleNextEvent(SimResourceInstance instance);

}
