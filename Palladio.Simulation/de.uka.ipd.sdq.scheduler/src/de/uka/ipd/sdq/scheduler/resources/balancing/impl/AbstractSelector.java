package de.uka.ipd.sdq.scheduler.resources.balancing.impl;

import de.uka.ipd.sdq.scheduler.processes.ActiveProcess;
import de.uka.ipd.sdq.scheduler.resources.SimResourceInstance;
import de.uka.ipd.sdq.scheduler.resources.balancing.IInstanceSelector;
import de.uka.ipd.sdq.scheduler.resources.queueing.MultipleQueuesStrategy;


public class AbstractSelector implements IInstanceSelector {
	
	protected MultipleQueuesStrategy runQueueHolder;
	
	public AbstractSelector(MultipleQueuesStrategy runQueueHolder) {
		super();
		this.runQueueHolder = runQueueHolder;
	}


	@Override
	public SimResourceInstance selectInstanceFor(ActiveProcess process) {
		return null;
	}


}
