package de.uka.ipd.sdq.simulation.abstractsimengine.example.entities;

import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEntityDelegator;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationModel;

public class BusStop extends AbstractSimEntityDelegator {
	
	private int waitingPassengers;
	
	public BusStop(ISimulationModel model, String name) {
		super(model, name);
	}

	public int getWaitingPassengers() {
		return waitingPassengers;
	}

	public void setWaitingPassengers(int waitingPassengers) {
		this.waitingPassengers = waitingPassengers;
	}

	@Override
	public String toString() {
		return getName();
	}
	
}
