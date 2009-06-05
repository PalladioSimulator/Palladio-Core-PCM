package de.uka.ipd.sdq.capra.simulator.resources;

import de.uka.ipd.sdq.capra.simulator.expressions.SimCapraProcess;
import umontreal.iro.lecuyer.simevents.Event;

public class ProceedEvent extends Event{

	SimCapraProcess capraProcess;
	
	public ProceedEvent(SimCapraProcess capraProcess) {
		super();
		this.capraProcess = capraProcess;
	}

	@Override
	public void actions() {
		capraProcess.proceed();
	}

}
