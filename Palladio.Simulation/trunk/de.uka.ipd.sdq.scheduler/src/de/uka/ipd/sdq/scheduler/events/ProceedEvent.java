package de.uka.ipd.sdq.scheduler.events;

import umontreal.iro.lecuyer.simevents.Event;
import de.uka.ipd.sdq.scheduler.processes.ActiveProcess;
import de.uka.ipd.sdq.scheduler.resources.passive.IDelayedAction;

public class ProceedEvent extends Event {

	ActiveProcess process;
	private IDelayedAction action;
	
	public ProceedEvent(ActiveProcess process) {
		super();
		this.process = process;
		this.action = null;
	}
	
	public void setDelayedAction(IDelayedAction action){
		this.action = action;
	}

	@Override
	public void actions() {
		process.toNow();
		if (action != null) {
			// once the action has been successfully executed it is removed.
			if (action.perform())
				action = null;
		}
		else
			process.getSchedulableProcess().activate();
	}
}
