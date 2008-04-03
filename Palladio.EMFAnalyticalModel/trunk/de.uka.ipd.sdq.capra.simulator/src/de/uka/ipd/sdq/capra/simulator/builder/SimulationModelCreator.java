package de.uka.ipd.sdq.capra.simulator.builder;

import scheduler.SystemConfiguration;
import de.uka.ipd.sdq.capra.CapraModel;
import de.uka.ipd.sdq.capra.experiment.Experiment;
import de.uka.ipd.sdq.capra.simulator.SimulationModel;
import de.uka.ipd.sdq.scheduler.ISchedulingFactory;

public class SimulationModelCreator {

	public static SimulationModel loadSimulation(CapraModel capraModel,
			SystemConfiguration systemConfiguration,
			Experiment exp,
			ISchedulingFactory schedulingFactory) {
		SimulationModel simulation = new SimulationModel(schedulingFactory,exp);

		simulation.loadSystemConfiguration(systemConfiguration);
		
		simulation.loadCapraModel(capraModel);

		return simulation;
	}
}
