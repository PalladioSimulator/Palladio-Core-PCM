package de.uka.ipd.sdq.scheduler.strategy.impl;

import de.uka.ipd.sdq.scheduler.processes.IActiveProcess;
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
	public void scheduleNextEvent(IResourceInstance instance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isIdle(IResourceInstance instance) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void initialiseProcess(IActiveProcess process) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getInterval() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void schedule(IResourceInstance instance, boolean quantum_finished) {
		// TODO Auto-generated method stub
		
	}

}
