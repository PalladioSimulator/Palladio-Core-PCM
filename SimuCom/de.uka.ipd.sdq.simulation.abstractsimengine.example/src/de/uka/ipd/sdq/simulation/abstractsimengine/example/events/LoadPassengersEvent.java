package de.uka.ipd.sdq.simulation.abstractsimengine.example.events;

import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEventDelegator;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationModel;
import de.uka.ipd.sdq.simulation.abstractsimengine.example.Duration;
import de.uka.ipd.sdq.simulation.abstractsimengine.example.entities.Bus;
import de.uka.ipd.sdq.simulation.abstractsimengine.example.entities.BusStop;
import de.uka.ipd.sdq.simulation.abstractsimengine.example.util.Utils;

public class LoadPassengersEvent extends AbstractSimEventDelegator<Bus> {

	public static final Duration LOADING_TIME_PER_PASSENGER = Duration.seconds(3);
	
	public LoadPassengersEvent(ISimulationModel model, String name) {
		super(model, name);
	}

	@Override
	public void eventRoutine(Bus bus) {
		BusStop position = bus.getPosition();
		int waitingPassengers = position.getWaitingPassengers();

		int servedPassengers = Math.min(waitingPassengers, bus.getTotalSeats());

		Utils.log(bus, "Loading " + servedPassengers + " passengers at bus stop " + position + "...");
		bus.load(servedPassengers);

		int remainingPassengers = waitingPassengers - servedPassengers;
		position.setWaitingPassengers(remainingPassengers);

		// wait until all passengers have entered the bus
		double loadingTime = servedPassengers * LOADING_TIME_PER_PASSENGER.toSeconds().value();
		
		// schedule load finished event
		LoadFinishedEvent e = new LoadFinishedEvent(loadingTime, remainingPassengers, this.getModel(), "LoadFinished");
		e.schedule(bus, loadingTime);
		
	}

}
