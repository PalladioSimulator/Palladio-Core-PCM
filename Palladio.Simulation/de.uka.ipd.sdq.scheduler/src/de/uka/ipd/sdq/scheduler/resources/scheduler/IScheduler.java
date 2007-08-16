package de.uka.ipd.sdq.scheduler.resources.scheduler;

import de.uka.ipd.sdq.scheduler.processes.ActiveProcess;
import de.uka.ipd.sdq.scheduler.resources.SimResourceInstance;

public interface IScheduler {

	/**
	 * Executes the next processes on the available resource instances.
	 * @param instance TODO
	 */
	public abstract void schedule(SimResourceInstance instance);

	/**
	 * Registers a new process and adds it to the scheduler's ready queues.
	 * 
	 * @param process
	 */
	public abstract void registerProcess(ActiveProcess process);

}
