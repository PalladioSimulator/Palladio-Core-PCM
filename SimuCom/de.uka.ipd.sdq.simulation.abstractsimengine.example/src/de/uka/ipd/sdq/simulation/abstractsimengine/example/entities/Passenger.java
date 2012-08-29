package de.uka.ipd.sdq.simulation.abstractsimengine.example.entities;

import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEntityDelegator;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationModel;

public class Passenger extends AbstractSimEntityDelegator {

	protected Passenger(ISimulationModel model, String name) {
		super(model, name);
	}

}
