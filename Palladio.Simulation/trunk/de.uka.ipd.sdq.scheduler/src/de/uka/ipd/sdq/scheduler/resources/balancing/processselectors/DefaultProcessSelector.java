package de.uka.ipd.sdq.scheduler.resources.balancing.processselectors;

import de.uka.ipd.sdq.scheduler.processes.ActiveProcess;
import de.uka.ipd.sdq.scheduler.resources.SimResourceInstance;
import de.uka.ipd.sdq.scheduler.resources.balancing.IProcessSelector;
import de.uka.ipd.sdq.scheduler.resources.queueing.IRunQueue;
import de.uka.ipd.sdq.scheduler.resources.queueing.runqueues.ProcessQueue;

public class DefaultProcessSelector implements IProcessSelector {

	@Override
	public ActiveProcess select(IRunQueue runQueue, SimResourceInstance instance) {
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
