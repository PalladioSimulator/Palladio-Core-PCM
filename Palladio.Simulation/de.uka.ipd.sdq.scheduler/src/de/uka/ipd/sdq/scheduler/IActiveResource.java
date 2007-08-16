package de.uka.ipd.sdq.scheduler;

import de.uka.ipd.sdq.scheduler.processes.ActiveProcess;

public interface IActiveResource {

	/**
	 * Processes the specified demand of the process.
	 */
	public abstract void process(ISchedulableProcess process, boolean demand);

	/**
	 * Before a process can process demands on the resource it needs to be
	 * registered.
	 */
	public abstract void registerNewProcess(ActiveProcess process);

}
