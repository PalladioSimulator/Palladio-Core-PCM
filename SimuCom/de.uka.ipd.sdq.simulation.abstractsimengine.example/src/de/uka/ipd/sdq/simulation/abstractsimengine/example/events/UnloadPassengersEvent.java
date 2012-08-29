package de.uka.ipd.sdq.simulation.abstractsimengine.example.events;

import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEventDelegator;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationModel;
import de.uka.ipd.sdq.simulation.abstractsimengine.example.entities.Bus;
import de.uka.ipd.sdq.simulation.abstractsimengine.example.entities.BusStop;
import de.uka.ipd.sdq.simulation.abstractsimengine.example.util.Utils;

public class UnloadPassengersEvent extends AbstractSimEventDelegator<Bus> {

	protected UnloadPassengersEvent(ISimulationModel model, String name) {
		super(model, name);
	}

	@Override
	public void eventRoutine(Bus bus) {
		BusStop position = bus.getPosition();
		int occupiedSeats = bus.getOccupiedSeats();

		Utils.log(bus, "Unloading " + occupiedSeats + " passengers at station " + position + "...");
		bus.unload();

		// wait for the passengers to leave the bus
		double unloadingTime = occupiedSeats * Bus.UNLOADING_TIME_PER_PASSENGER.toSeconds().value();
		
		UnloadingFinishedEvent e = new UnloadingFinishedEvent(unloadingTime, this.getModel(), "Unload Finished");
		e.schedule(bus, unloadingTime);

		
		
	}

}
