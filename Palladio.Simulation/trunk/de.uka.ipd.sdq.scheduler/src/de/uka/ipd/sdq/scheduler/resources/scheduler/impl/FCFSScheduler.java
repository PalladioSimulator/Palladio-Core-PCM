package de.uka.ipd.sdq.scheduler.resources.scheduler.impl;

import de.uka.ipd.sdq.scheduler.resources.SimActiveResource;
import de.uka.ipd.sdq.scheduler.resources.SimResourceInstance;
import de.uka.ipd.sdq.scheduler.resources.queueing.IQueueingStrategy;


public class FCFSScheduler extends AbstractScheduler {

	public FCFSScheduler(SimActiveResource resource,
			IQueueingStrategy queueingStrategy, boolean in_front_after_waiting) {
		super(resource, queueingStrategy, in_front_after_waiting);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void schedule(SimResourceInstance instance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void scheduleNextEvent(SimResourceInstance instance) {
		// TODO Auto-generated method stub
		
	}




}
