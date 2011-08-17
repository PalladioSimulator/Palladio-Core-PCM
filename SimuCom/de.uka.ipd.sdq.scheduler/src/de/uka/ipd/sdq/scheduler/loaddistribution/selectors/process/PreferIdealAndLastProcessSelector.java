package de.uka.ipd.sdq.scheduler.loaddistribution.selectors.process;

import de.uka.ipd.sdq.scheduler.loaddistribution.IProcessSelector;
import de.uka.ipd.sdq.scheduler.processes.IActiveProcess;
import de.uka.ipd.sdq.scheduler.queueing.IProcessQueue;
import de.uka.ipd.sdq.scheduler.queueing.IRunQueue;
import de.uka.ipd.sdq.scheduler.resources.IResourceInstance;

public class PreferIdealAndLastProcessSelector implements IProcessSelector {

	public IActiveProcess select(IRunQueue runQueue, IResourceInstance instance) {
		IProcessQueue queue = runQueue.getBestRunnableQueue(instance);
		IActiveProcess result = null;
		if (queue != null) {
			for (IActiveProcess process : queue.ascending()) {
				if (process.checkAffinity(instance)) {
					if (result == null) {
						result = process;
					} else if (isPreferred(process, instance)
							&& !isPreferred(result, instance)) {
						return process;
					}
				}
			}
		}
		return result;
	}

	private boolean isPreferred(IActiveProcess process,
			IResourceInstance instance) {
		return process.isIdealInstance(instance)
				|| process.isLastInstance(instance);
	}
}
