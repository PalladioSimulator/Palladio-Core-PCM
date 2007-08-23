package de.uka.ipd.sdq.scheduler.resources.scheduler.impl;

import de.uka.ipd.sdq.scheduler.processes.ActiveProcess;
import de.uka.ipd.sdq.scheduler.resources.SimActiveResource;
import de.uka.ipd.sdq.scheduler.resources.SimResourceInstance;
import de.uka.ipd.sdq.scheduler.resources.queueing.IQueueingStrategy;

public class PreemptiveScheduler extends AbstractScheduler {

	public PreemptiveScheduler(SimActiveResource resource,
			IQueueingStrategy queueingStrategy) {
		super(resource, queueingStrategy);
	}

	@Override
	public void schedule(SimResourceInstance instance) {
		ActiveProcess running = queueingStrategy.getProcessRunningOn(instance);
		if (running != null) {
			running.toNow();
			running.setReady();
			if (running.timeSliceExpired()) {
				running.resetTimeSlice();
				queueingStrategy.returnExpired(running, false);
			} else {
				// timeslice is not yet expired, but the process is interrupted
				// and needs to queue up again.
				queueingStrategy.returnActive(running, false);
			}
		} else {
			// if there is no running process the instance is assumed to be
			// idle. Load balancing necessary.
			queueingStrategy.balance();
		}
		running = queueingStrategy.getNextProcessFor(instance);
		if (running != null){
			if (running.getRemainingDemand() < running.getRemainingTimeSlice())
				running.scheduleProceedEvent();
			else
				instance.scheduleSchedulingEvent();
		}
	}



}
