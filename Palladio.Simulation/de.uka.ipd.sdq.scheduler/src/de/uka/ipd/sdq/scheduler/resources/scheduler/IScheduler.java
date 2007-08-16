package de.uka.ipd.sdq.scheduler.resources.scheduler;

import de.uka.ipd.sdq.scheduler.processes.ActiveProcess;


public interface IScheduler {

	/**
	 */
	public abstract void schedule();
	
	public abstract void registerNewProcess(ActiveProcess process);

}
