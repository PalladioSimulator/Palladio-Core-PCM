package de.uka.ipd.sdq.scheduler.loaddistribution.selectors.instance;

import de.uka.ipd.sdq.scheduler.loaddistribution.IInstanceSelector;
import de.uka.ipd.sdq.scheduler.processes.IActiveProcess;
import de.uka.ipd.sdq.scheduler.queueing.strategies.MultipleQueuesStrategy;
import de.uka.ipd.sdq.scheduler.resources.IResourceInstance;


public class AbstractInstanceSelector implements IInstanceSelector {
	
	protected MultipleQueuesStrategy queue_holder;
	
	public AbstractInstanceSelector(MultipleQueuesStrategy runQueueHolder) {
		super();
		this.queue_holder = runQueueHolder;
	}


	@Override
	public IResourceInstance selectInstanceFor(IActiveProcess process) {
		return null;
	}


}
