package de.uka.ipd.sdq.scheduler.loaddistribution.selectors.instance;

import java.util.Iterator;

import de.uka.ipd.sdq.scheduler.processes.IActiveProcess;
import de.uka.ipd.sdq.scheduler.queueing.strategies.MultipleQueuesStrategy;
import de.uka.ipd.sdq.scheduler.resources.IResourceInstance;


public class RoundRobinSelector extends AbstractInstanceSelector {
	
	Iterator<IResourceInstance> instance_iterator;

	public RoundRobinSelector(MultipleQueuesStrategy run_queue_holder) {
		super(run_queue_holder);
		reset();
	}


	@Override
	public IResourceInstance selectInstanceFor(IActiveProcess process) {
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
		if (!instance_iterator.hasNext())
			reset();
		return instance_iterator.next();
	}

	private void reset() {
		instance_iterator = queue_holder.getResourceInstances().iterator();
	}
}
