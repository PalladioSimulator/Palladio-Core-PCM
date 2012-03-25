package edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.loaddistribution.selectors.process;

import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.IResourceInstance;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.loaddistribution.IProcessSelector;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.processes.IActiveProcess;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.queueing.IProcessQueue;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.queueing.IRunQueue;

public class NextRunnableProcessSelector implements IProcessSelector {

	public IActiveProcess select(IRunQueue runQueue, IResourceInstance instance) {
		IProcessQueue queue = runQueue.getBestRunnableQueue(instance);
		if (queue != null) {
			for (IActiveProcess process : queue.ascending()) {
				if (process.checkAffinity(instance)) {
						return process;
				}
			}
		}
		return null;
	}
}
