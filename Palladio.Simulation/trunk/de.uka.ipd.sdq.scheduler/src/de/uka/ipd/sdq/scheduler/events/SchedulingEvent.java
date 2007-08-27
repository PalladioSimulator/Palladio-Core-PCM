package de.uka.ipd.sdq.scheduler.events;

import de.uka.ipd.sdq.scheduler.resources.IResourceInstance;
import de.uka.ipd.sdq.scheduler.strategy.IScheduler;
import umontreal.iro.lecuyer.simevents.Event;

/**
 * Event causing a call to the schedule method of the specified scheduling
 * strategy. Used to trigger a scheduling at a specific time.
 * 
 * @author jens
 * 
 */
public class SchedulingEvent extends Event {

	IScheduler scheduler;
	IResourceInstance instance;

	public SchedulingEvent(IScheduler scheduler, IResourceInstance instance) {
		super();
		this.scheduler = scheduler;
		this.instance = instance;
	}

	@Override
	public void actions() {
		scheduler.schedule(instance);
	}
}
