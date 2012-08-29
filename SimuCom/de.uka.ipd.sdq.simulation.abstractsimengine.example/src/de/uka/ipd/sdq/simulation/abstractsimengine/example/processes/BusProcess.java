package de.uka.ipd.sdq.simulation.abstractsimengine.example.processes;

import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimProcessDelegator;
import de.uka.ipd.sdq.simulation.abstractsimengine.example.Duration;
import de.uka.ipd.sdq.simulation.abstractsimengine.example.Route.RouteSegment;
import de.uka.ipd.sdq.simulation.abstractsimengine.example.entities.Bus;
import de.uka.ipd.sdq.simulation.abstractsimengine.example.entities.BusStop;
import de.uka.ipd.sdq.simulation.abstractsimengine.example.util.Utils;

public class BusProcess extends AbstractSimProcessDelegator {

	private Bus bus;

	public BusProcess(Bus bus) {
		super(bus.getModel(), bus.getName());
		this.bus = bus;
	}

	@Override
	public void lifeCycle() {
		// transport passengers between the different stations
		while (getModel().getSimulationControl().isRunning()) {
			loadPassengers();
			travelToNextStation();
			unloadPassengers();
		}
	}

	private void loadPassengers() {
		BusStop position = bus.getPosition();
		int waitingPassengers = position.getWaitingPassengers();

		int servedPassengers = Math.min(waitingPassengers, bus.getTotalSeats());

		Utils.log(bus, "Loading " + servedPassengers + " passengers at bus stop " + position + "...");
		bus.load(servedPassengers);

		int remainingPassengers = waitingPassengers - servedPassengers;
		position.setWaitingPassengers(remainingPassengers);

		// wait until all passengers have entered the bus
		double loadingTime = servedPassengers * Bus.LOADING_TIME_PER_PASSENGER.toSeconds().value();
		passivate(loadingTime);

		Utils.log(bus, "Loading finished. Took " + loadingTime + " seconds.");

		if (remainingPassengers > 0) {
			Utils.log(bus, "Bus is full. Remaining passengers at bus station: " + position.getWaitingPassengers());
		}
	}

	private void travelToNextStation() {
		RouteSegment segment = bus.travel();

		Utils.log(bus, "Travelling to station " + segment.getTo());

		double drivingTime = Duration.hours(segment.getDistance() / (double) segment.getAverageSpeed()).toSeconds()
				.value();

		// wait for the bus to arrive at the next station
		passivate(drivingTime);

		// arrive at the target station
		BusStop currentStation = bus.arrive();
		Utils.log(bus, "Arrived at station " + currentStation + ". Travelling took " + drivingTime / 60.0 + " minutes.");
	}

	private void unloadPassengers() {
		BusStop position = bus.getPosition();
		int occupiedSeats = bus.getOccupiedSeats();

		Utils.log(bus, "Unloading " + occupiedSeats + " passengers at station " + position + "...");
		bus.unload();

		// wait for the passengers to leave the bus
		double unloadingTime = occupiedSeats * Bus.UNLOADING_TIME_PER_PASSENGER.toSeconds().value();
		passivate(unloadingTime);

		Utils.log(bus, "Unloading finished. Took " + unloadingTime + " seconds.");
	}

}