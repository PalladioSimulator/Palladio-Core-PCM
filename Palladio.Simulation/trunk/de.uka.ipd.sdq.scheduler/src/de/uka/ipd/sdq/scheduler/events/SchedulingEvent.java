package de.uka.ipd.sdq.scheduler.events;

import de.uka.ipd.sdq.scheduler.IResourceInstance;
import de.uka.ipd.sdq.scheduler.strategy.IScheduler;
import umontreal.iro.lecuyer.simevents.Event;

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
