package de.uka.ipd.sdq.scheduler.loaddistribution.selectors.process;

import de.uka.ipd.sdq.scheduler.loaddistribution.IProcessSelector;
import de.uka.ipd.sdq.scheduler.processes.IActiveProcess;
import de.uka.ipd.sdq.scheduler.queueing.IProcessQueue;
import de.uka.ipd.sdq.scheduler.queueing.IRunQueue;
import de.uka.ipd.sdq.scheduler.resources.IResourceInstance;

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
