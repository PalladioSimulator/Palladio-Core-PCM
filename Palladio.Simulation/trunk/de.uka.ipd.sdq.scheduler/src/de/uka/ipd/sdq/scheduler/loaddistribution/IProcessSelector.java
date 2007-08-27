package de.uka.ipd.sdq.scheduler.loaddistribution;

import de.uka.ipd.sdq.scheduler.processes.IActiveProcess;
import de.uka.ipd.sdq.scheduler.queueing.IRunQueue;
import de.uka.ipd.sdq.scheduler.resources.IResourceInstance;

public interface IProcessSelector {

	/**
	 * Selects a process from the given runqueue that best suits the execution
	 * on the specified instance.
	 * 
	 * @param run_queue
	 * @param instance
	 * @return
	 */
	IActiveProcess select(IRunQueue run_queue, IResourceInstance instance);

}
