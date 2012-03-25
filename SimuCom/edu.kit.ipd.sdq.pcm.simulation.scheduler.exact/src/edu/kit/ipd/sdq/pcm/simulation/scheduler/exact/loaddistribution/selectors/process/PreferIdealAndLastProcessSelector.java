package edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.loaddistribution.selectors.process;

import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.IResourceInstance;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.loaddistribution.IProcessSelector;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.processes.IActiveProcess;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.queueing.IProcessQueue;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.queueing.IRunQueue;

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
