package de.uka.ipd.sdq.simulation.abstractsimengine.example.events;

import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEventDelegator;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationModel;
import de.uka.ipd.sdq.simulation.abstractsimengine.example.Duration;
import de.uka.ipd.sdq.simulation.abstractsimengine.example.Route.RouteSegment;
import de.uka.ipd.sdq.simulation.abstractsimengine.example.entities.Bus;
import de.uka.ipd.sdq.simulation.abstractsimengine.example.util.Utils;

public class TravelEvent extends AbstractSimEventDelegator<Bus> {

	public TravelEvent(ISimulationModel model, String name) {
		super(model, name);
	}

	@Override
	public void eventRoutine(Bus bus) {
		RouteSegment segment = bus.travel();

		Utils.log(bus, "Travelling to station " + segment.getTo());

		double drivingTime = Duration.hours(segment.getDistance() / (double) segment.getAverageSpeed()).toSeconds()
				.value();

		// wait for the bus to arrive at the next station^
		ArriveEvent e = new ArriveEvent(drivingTime, this.getModel(), "Arrive Event");
		e.schedule(bus, drivingTime);		
	}

}
