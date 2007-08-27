package de.uka.ipd.sdq.scheduler.loaddistribution.selectors.instance;

import de.uka.ipd.sdq.scheduler.IResourceInstance;
import de.uka.ipd.sdq.scheduler.loaddistribution.IInstanceSelector;
import de.uka.ipd.sdq.scheduler.processes.impl.ActiveProcess;
import de.uka.ipd.sdq.scheduler.queueing.strategies.MultipleQueuesStrategy;


public class AbstractInstanceSelector implements IInstanceSelector {
	
	protected MultipleQueuesStrategy runQueueHolder;
	
	public AbstractInstanceSelector(MultipleQueuesStrategy runQueueHolder) {
		super();
		this.runQueueHolder = runQueueHolder;
	}


	@Override
	public IResourceInstance selectInstanceFor(ActiveProcess process) {
		return null;
	}


}
