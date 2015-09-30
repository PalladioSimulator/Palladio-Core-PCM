package edu.kit.ipd.sdq.simcomp.controller.runconfig;

import java.util.Map;

import de.uka.ipd.sdq.codegen.simucontroller.runconfig.AbstractSimulationWorkflowConfiguration;
import de.uka.ipd.sdq.simulation.AbstractSimulationConfig;
import edu.kit.ipd.sdq.simcomp.middleware.simulation.config.SimulationConfiguration;

/**
 * A workflow configuration which contains a simulation configuration for the
 * simulation components.
 * 
 * This class is based on {@link EventSimWorkflowConfiguration}. Some code has
 * been reused.
 * 
 * @author Christoph Föhrdes
 */
public class SimulationComponentWorkflowConfiguration extends AbstractSimulationWorkflowConfiguration {

	private SimulationConfiguration simulationConfig = null;

	public SimulationComponentWorkflowConfiguration(Map<String, Object> attributes) {
		super(attributes);
	}

	@Override
	public String getErrorMessage() {
		// must be null; otherwise a non-empty error message will result in
		// a workflow config being considered invalid
		return null;
	}

	@Override
	public void setDefaults() {
		throw new RuntimeException("Not implemented. No defaults defined.");
	}

	@Override
	public SimulationConfiguration getSimulationConfiguration() {
		return this.simulationConfig;
	}

	public void setSimulationConfiguration(SimulationConfiguration simulationConfig) {
		this.simulationConfig = simulationConfig;
	}

}
