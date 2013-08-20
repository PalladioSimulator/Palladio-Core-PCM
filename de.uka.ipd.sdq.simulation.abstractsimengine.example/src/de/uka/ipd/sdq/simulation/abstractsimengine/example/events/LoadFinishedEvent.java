package de.uka.ipd.sdq.simulation.abstractsimengine.example.events;

import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEventDelegator;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationModel;
import de.uka.ipd.sdq.simulation.abstractsimengine.example.entities.Bus;
import de.uka.ipd.sdq.simulation.abstractsimengine.example.util.Utils;

public class LoadFinishedEvent extends AbstractSimEventDelegator<Bus> {

	private int remainingPassengers;
	
	private double loadingTime;
	
	public LoadFinishedEvent(double loadingTime, int remainingPassengers, ISimulationModel model, String name) {
		super(model, name);
		this.loadingTime = loadingTime;
		this.remainingPassengers = remainingPassengers;
	}

	@Override
	public void eventRoutine(Bus bus) {
		Utils.log(bus, "Loading finished. Took " + loadingTime + " seconds.");
		
		if (remainingPassengers > 0) {
			Utils.log(bus, "Bus is full. Remaining passengers at bus station: " + bus.getPosition().getWaitingPassengers());
		}
		
		new TravelEvent(this.getModel(), "Travel").schedule(bus, 0);
	}

}
