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

	
	public double getInterval() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public boolean isIdle(IResourceInstance instance) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public void schedule(IResourceInstance instance) {
		// TODO Auto-generated method stub
		
	}

	
	public void scheduleNextEvent(IResourceInstance instance) {
		// TODO Auto-generated method stub
		//return 0;
	}


	
	public void schedule(IResourceInstance instance, boolean quantum_finished) {
		// TODO Auto-generated method stub
		
	}



	public void postSchedule(IResourceInstance instance) {
		// TODO Auto-generated method stub
		
	}


}
