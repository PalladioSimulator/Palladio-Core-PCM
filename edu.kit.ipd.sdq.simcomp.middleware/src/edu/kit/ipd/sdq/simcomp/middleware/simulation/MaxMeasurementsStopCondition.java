package edu.kit.ipd.sdq.simcomp.middleware.simulation;

import de.uka.ipd.sdq.simulation.abstractsimengine.SimCondition;
import edu.kit.ipd.sdq.simcomp.component.ISimulationMiddleware;

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
