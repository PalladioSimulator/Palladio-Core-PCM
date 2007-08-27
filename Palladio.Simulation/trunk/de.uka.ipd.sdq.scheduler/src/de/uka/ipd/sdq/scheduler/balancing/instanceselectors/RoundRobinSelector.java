package de.uka.ipd.sdq.scheduler.balancing.instanceselectors;

import java.util.Iterator;

import de.uka.ipd.sdq.scheduler.processes.ActiveProcess;
import de.uka.ipd.sdq.scheduler.queueing.strategies.MultipleQueuesStrategy;
import de.uka.ipd.sdq.scheduler.resources.SimResourceInstance;


public class RoundRobinSelector extends AbstractInstanceSelector {
	
	Iterator<SimResourceInstance> instanceIterator;

	public RoundRobinSelector(MultipleQueuesStrategy runQueueHolder) {
		super(runQueueHolder);
		reset();
	}


	@Override
	public SimResourceInstance selectInstanceFor(ActiveProcess process) {
		SimResourceInstance result = null;
		while(result == null){
			SimResourceInstance current = getNext();
			if (process.checkAffinity(current)){
				result = current;
				if (!process.hasIdealInstance()){
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

	private void reset() {
		instanceIterator = runQueueHolder.getResourceInstances().iterator();
	}
}
