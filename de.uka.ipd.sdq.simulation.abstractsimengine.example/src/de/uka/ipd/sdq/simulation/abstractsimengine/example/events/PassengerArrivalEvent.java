package de.uka.ipd.sdq.simulation.abstractsimengine.example.events;

import de.uka.ipd.sdq.probfunction.math.apache.impl.PoissonDistribution;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEventDelegator;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationModel;
import de.uka.ipd.sdq.simulation.abstractsimengine.example.Duration;
import de.uka.ipd.sdq.simulation.abstractsimengine.example.entities.BusStop;

public class PassengerArrivalEvent extends AbstractSimEventDelegator<BusStop> {

	private PoissonDistribution d;

	private Duration interarrivalTime;

	public PassengerArrivalEvent(Duration interarrivalTime, ISimulationModel model, String name) {
		super(model, name);

		this.interarrivalTime = interarrivalTime;
		this.d = new PoissonDistribution(interarrivalTime.toSeconds().value());
	}

	@Override
	public void eventRoutine(BusStop busStop) {
		// One passenger arrives at the associated bus stop
		int waiting = busStop.getWaitingPassengers();
		busStop.setWaitingPassengers(waiting + 1);

		// schedule new arrival according to interarrival time
		double s = d.drawSample();
		PassengerArrivalEvent e = new PassengerArrivalEvent(interarrivalTime, this.getModel(), "Passenger Arrival");
		e.schedule(busStop, s);

	}

}
