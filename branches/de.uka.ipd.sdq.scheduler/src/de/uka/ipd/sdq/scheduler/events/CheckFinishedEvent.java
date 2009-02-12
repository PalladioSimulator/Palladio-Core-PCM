package de.uka.ipd.sdq.scheduler.events;

import de.uka.ipd.sdq.scheduler.factory.SchedulingFactory;
import umontreal.iro.lecuyer.simevents.Event;

public class CheckFinishedEvent extends Event {
	
	ProceedEvent proceedEvent;
	
	public CheckFinishedEvent(ProceedEvent proceedEvent){
		super(SchedulingFactory.getUsedSimulator());
		this.proceedEvent = proceedEvent;
		this.priority = 9999;
	}

	@Override
	public void actions() {
		if (proceedEvent.process.getSchedulableProcess().isFinished()){
			proceedEvent.scheduler.terminateProcess(proceedEvent.process, proceedEvent.process.getLastInstance());
		}
	}
}
