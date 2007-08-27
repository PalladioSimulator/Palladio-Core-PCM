package de.uka.ipd.sdq.scheduler.events;

import de.uka.ipd.sdq.scheduler.resources.SimResourceInstance;
import de.uka.ipd.sdq.scheduler.strategy.IScheduler;
import umontreal.iro.lecuyer.simevents.Event;

public class SchedulingEvent extends Event {
	
	IScheduler scheduler;
	SimResourceInstance instance;
	
	public SchedulingEvent(IScheduler scheduler, SimResourceInstance instance) {
		super();
		this.scheduler = scheduler;
		this.instance = instance;
	}

	@Override
	public void actions() {
		scheduler.schedule(instance);
	}
}
