package de.uka.ipd.sdq.capra.simulator.resources.scheduling.events;

import de.uka.ipd.sdq.capra.simulator.expressions.SimCapraProcess;
import umontreal.iro.lecuyer.simevents.Event;

/**
 * @author     jens.happe
 */
public class ContinueProcessEvent extends Event{

	SimCapraProcess capraProcess;
	
	public ContinueProcessEvent(SimCapraProcess capraProcess) {
		super();
		capraProcess.setReady(false);
		this.capraProcess = capraProcess;
	}

	@Override
	public void actions() {
		capraProcess.proceed();
	}

}
