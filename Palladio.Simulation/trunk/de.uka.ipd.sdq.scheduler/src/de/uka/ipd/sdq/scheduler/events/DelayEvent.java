package de.uka.ipd.sdq.scheduler.events;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.factory.SchedulingFactory;
import umontreal.iro.lecuyer.simevents.Event;

public class DelayEvent extends Event {
	
	ISchedulableProcess process;
	
	public DelayEvent(ISchedulableProcess process) {
		super(SchedulingFactory.getUsedSimulator());
		this.process = process;
	}

	@Override
	public void actions() {
		process.activate();
	}

}
