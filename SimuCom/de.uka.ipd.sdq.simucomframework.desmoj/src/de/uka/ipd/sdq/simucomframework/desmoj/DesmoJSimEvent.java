package de.uka.ipd.sdq.simucomframework.desmoj;

import com.sun.xml.internal.ws.server.UnsupportedMediaException;

import de.uka.ipd.sdq.simucomframework.abstractSimEngine.ISimEventDelegate;
import de.uka.ipd.sdq.simucomframework.abstractSimEngine.SimEvent;
import desmoj.core.simulator.Entity;
import desmoj.core.simulator.Model;
import desmoj.core.simulator.SimTime;

public class DesmoJSimEvent extends desmoj.core.simulator.Event implements
		ISimEventDelegate {

	SimEvent myAbstractEvent = null;

	public DesmoJSimEvent(SimEvent myEvent, Model owner, String name) {
		super(owner, name, false);
		this.myAbstractEvent = myEvent;
	}

	/*
	 * (non-Javadoc)
	 * @see de.uka.ipd.sdq.simucomframework.abstractSimEngine.ISimEventDelegate#schedule(de.uka.ipd.sdq.simucomframework.abstractSimEngine.IEntityDelegate, double)
	 */
	public void schedule(
			de.uka.ipd.sdq.simucomframework.abstractSimEngine.IEntityDelegate resource,
			double time) {
		this.schedule(((DesmoJEntity) resource), new SimTime(time));
	}

	@Override
	public void eventRoutine(Entity who) {
		DesmoJEntity dWho = (DesmoJEntity) who;
		myAbstractEvent.eventRoutine(dWho.getEntity());
	}

	public void removeEvent() {
		if (this.isScheduled()) {
			this.cancel();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see de.uka.ipd.sdq.simucomframework.abstractSimEngine.ISimEventDelegate#schedule(double)
	 */
	public void schedule(double timeWhenNextJobIsDone) {
		throw new UnsupportedMediaException();
	}
}
