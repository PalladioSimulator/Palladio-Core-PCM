package edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.loaddistribution;

import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.IResourceInstance;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.processes.IActiveProcess;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.queueing.IRunQueue;

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
