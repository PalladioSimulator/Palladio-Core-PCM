package de.uka.ipd.sdq.simucomframework.desmoj;

import de.uka.ipd.sdq.simucomframework.abstractSimEngine.IEntityDelegate;
import de.uka.ipd.sdq.simucomframework.abstractSimEngine.ISimEventDelegate;
import de.uka.ipd.sdq.simucomframework.abstractSimEngine.SimEvent;
import desmoj.core.simulator.Entity;
import desmoj.core.simulator.Model;
import desmoj.core.simulator.SimTime;

public class DesmoJSimEvent extends desmoj.core.simulator.Event implements ISimEventDelegate {
	
	SimEvent myAbstractEvent = null;
	
	public DesmoJSimEvent(SimEvent myEvent, Model owner, String name) {
		super(owner, name, false);
		this.myAbstractEvent = myEvent;
	}

	public void schedule(de.uka.ipd.sdq.simucomframework.abstractSimEngine.IEntityDelegate resource, double time) {
		this.schedule(((DesmoJEntity)resource), new SimTime(time));
	}

	@Override
	public void eventRoutine(Entity who) {
		DesmoJEntity dWho = (DesmoJEntity) who;
		myAbstractEvent.eventRoutine(dWho.getEntity());
	}
}
