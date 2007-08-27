package de.uka.ipd.sdq.scheduler.loaddistribution.selectors.process;

import de.uka.ipd.sdq.scheduler.loaddistribution.IProcessSelector;
import de.uka.ipd.sdq.scheduler.processes.IActiveProcess;
import de.uka.ipd.sdq.scheduler.queueing.IRunQueue;
import de.uka.ipd.sdq.scheduler.queueing.runqueues.ProcessQueue;
import de.uka.ipd.sdq.scheduler.resources.IResourceInstance;

public class DefaultProcessSelector implements IProcessSelector {

	@Override
	public IActiveProcess select(IRunQueue runQueue, IResourceInstance instance) {
		ProcessQueue<IActiveProcess> queue = runQueue.getBestRunnableQueue(instance);
		IActiveProcess result = null;
		if (queue != null) {
			for (IActiveProcess process : queue.ascending()) {
				if (process.checkAffinity(instance)) {
					if (result == null) {
						result = process;
					} else if (process.isIdealInstance(instance)
							|| process.isLastInstance(instance)) {
						return process;
					}
				}
			}
		}
		return result;
	}
}
