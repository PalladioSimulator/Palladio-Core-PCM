package de.uka.ipd.sdq.scheduler.strategy.impl;

import de.uka.ipd.sdq.scheduler.queueing.IQueueingStrategy;
import de.uka.ipd.sdq.scheduler.resources.IResourceInstance;
import de.uka.ipd.sdq.scheduler.resources.active.SimActiveResource;


public class FCFSScheduler extends AbstractScheduler {

	public FCFSScheduler(SimActiveResource resource,
			IQueueingStrategy queueingStrategy, boolean in_front_after_waiting) {
		super(resource, queueingStrategy, in_front_after_waiting);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void schedule(IResourceInstance instance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void scheduleNextEvent(IResourceInstance instance) {
		// TODO Auto-generated method stub
		
	}




}
