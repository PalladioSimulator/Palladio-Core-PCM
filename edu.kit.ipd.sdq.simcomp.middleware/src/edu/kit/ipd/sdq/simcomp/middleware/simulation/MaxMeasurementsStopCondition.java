package edu.kit.ipd.sdq.simcomp.middleware.simulation;

import de.uka.ipd.sdq.simulation.abstractsimengine.SimCondition;
import edu.kit.ipd.sdq.simcomp.component.ISimulationMiddleware;
import edu.kit.ipd.sdq.simcomp.middleware.simulation.config.SimulationConfiguration;

/**
 * Stop condition which stops the simulation based on the amount of processed
 * measurements. One measurement is one user whose requests are entirely
 * processed.
 * 
 * @author Christoph Föhrdes
 * 
 */
public class MaxMeasurementsStopCondition implements SimCondition {

	private ISimulationMiddleware middleware;
	private long maxMeasurements;

	public MaxMeasurementsStopCondition(ISimulationMiddleware middleware) {
		this.middleware = middleware;

		SimulationConfiguration config = (SimulationConfiguration) middleware.getSimulationConfiguration();
		this.maxMeasurements = config.getMaxMeasurementsCount();
	}

	@Override
	public boolean check() {
		return (this.maxMeasurements > 0) && (this.middleware.getMeasurementCount() >= this.maxMeasurements);
	}

}
