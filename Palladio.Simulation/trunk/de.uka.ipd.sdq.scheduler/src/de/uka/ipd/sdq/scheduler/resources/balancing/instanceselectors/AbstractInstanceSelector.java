package de.uka.ipd.sdq.scheduler.resources.balancing.instanceselectors;

import de.uka.ipd.sdq.scheduler.processes.ActiveProcess;
import de.uka.ipd.sdq.scheduler.resources.SimResourceInstance;
import de.uka.ipd.sdq.scheduler.resources.balancing.IInstanceSelector;
import de.uka.ipd.sdq.scheduler.resources.queueing.strategies.MultipleQueuesStrategy;


public class AbstractInstanceSelector implements IInstanceSelector {
	
	protected MultipleQueuesStrategy runQueueHolder;
	
	public AbstractInstanceSelector(MultipleQueuesStrategy runQueueHolder) {
		super();
		this.runQueueHolder = runQueueHolder;
	}


	@Override
	public SimResourceInstance selectInstanceFor(ActiveProcess process) {
		return null;
	}


}
