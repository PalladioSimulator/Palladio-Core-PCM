package de.uka.ipd.sdq.scheduler.loaddistribution.selectors.tmp;

import java.util.Iterator;

import de.uka.ipd.sdq.scheduler.IResourceInstance;
import de.uka.ipd.sdq.scheduler.processes.impl.ActiveProcess;
import de.uka.ipd.sdq.scheduler.queueing.strategies.MultipleQueuesStrategy;


public class RoundRobinSelector extends AbstractInstanceSelector {
	
	Iterator<IResourceInstance> instanceIterator;

	public RoundRobinSelector(MultipleQueuesStrategy runQueueHolder) {
		super(runQueueHolder);
		reset();
	}


	@Override
	public IResourceInstance selectInstanceFor(ActiveProcess process) {
		IResourceInstance result = null;
		while(result == null){
			IResourceInstance current = getNext();
			if (process.checkAffinity(current)){
				result = current;
				if (!process.hasIdealInstance()){
					process.setIdealInstance(current);
				}
			}
		}
		return result;
	}

	private IResourceInstance getNext() {
		if (!instanceIterator.hasNext())
			reset();
		return instanceIterator.next();
	}

	private void reset() {
		instanceIterator = runQueueHolder.getResourceInstances().iterator();
	}
}
