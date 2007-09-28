package de.uka.ipd.sdq.capra.simulator.builder;

import scheduler.SystemConfiguration;
import de.uka.ipd.sdq.capra.CapraModel;
import de.uka.ipd.sdq.capra.simulator.SimulationModel;

public class SimulationModelCreator {
	
	public static SimulationModel loadSimulation(CapraModel capraModel, SystemConfiguration systemConfiguration){
		SimulationModel simulation = new SimulationModel();
		
		simulation.loadSystemConfiguration(systemConfiguration);
		simulation.loadCapraModel(capraModel);

		return simulation;
	}
}
