package de.uka.ipd.sdq.scheduler.loaddistribution.selectors.tmp;

import de.uka.ipd.sdq.scheduler.IResourceInstance;
import de.uka.ipd.sdq.scheduler.loaddistribution.IProcessSelector;
import de.uka.ipd.sdq.scheduler.processes.impl.ActiveProcess;
import de.uka.ipd.sdq.scheduler.queueing.IRunQueue;
import de.uka.ipd.sdq.scheduler.queueing.runqueues.ProcessQueue;

public class DefaultProcessSelector implements IProcessSelector {

	@Override
	public ActiveProcess select(IRunQueue runQueue, IResourceInstance instance) {
		ProcessQueue<ActiveProcess> queue = runQueue.getBestRunnableQueue(instance);
		ActiveProcess result = null;
		if (queue != null) {
			for (ActiveProcess process : queue.ascending()) {
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
