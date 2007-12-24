package de.uka.ipd.sdq.scheduler.events;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import umontreal.iro.lecuyer.simevents.Event;

public class DelayEvent extends Event {
	
	ISchedulableProcess process;
	
	public DelayEvent(ISchedulableProcess process) {
		super();
		this.process = process;
	}

	@Override
	public void actions() {
		process.activate();
	}

}
