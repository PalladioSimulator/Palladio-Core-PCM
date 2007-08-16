package de.uka.ipd.sdq.scheduler.resources.balancing.instanceselectors;

import java.util.Iterator;

import de.uka.ipd.sdq.scheduler.processes.ActiveProcess;
import de.uka.ipd.sdq.scheduler.resources.SimResourceInstance;
import de.uka.ipd.sdq.scheduler.resources.queueing.strategies.MultipleQueuesStrategy;


public class RoundRobinSelector extends AbstractInstanceSelector {
	
	Iterator<SimResourceInstance> instanceIterator;

	public RoundRobinSelector(MultipleQueuesStrategy runQueueHolder) {
		super(runQueueHolder);
		reset();
	}

	private void reset() {
		instanceIterator = runQueueHolder.getResourceInstances().iterator();
	}

	@Override
	public SimResourceInstance selectInstanceFor(ActiveProcess process) {
		SimResourceInstance result = null;
		while(result == null){
			SimResourceInstance current = getNext();
			if (process.checkAffinity(current)){
				result = current;
				if (process.hasIdealInstance()){
					process.setIdealInstance(current);
				}
			}
		}
		return result;
	}

	private SimResourceInstance getNext() {
		if (!instanceIterator.hasNext())
			reset();
		return instanceIterator.next();
	}
}
