package de.uka.ipd.sdq.scheduler.balancing.instanceselectors;

import de.uka.ipd.sdq.scheduler.balancing.IInstanceSelector;
import de.uka.ipd.sdq.scheduler.processes.ActiveProcess;
import de.uka.ipd.sdq.scheduler.queueing.strategies.MultipleQueuesStrategy;
import de.uka.ipd.sdq.scheduler.resources.SimResourceInstance;


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
