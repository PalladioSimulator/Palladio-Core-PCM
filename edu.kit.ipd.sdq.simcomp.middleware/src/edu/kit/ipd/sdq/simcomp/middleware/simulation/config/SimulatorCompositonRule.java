package edu.kit.ipd.sdq.simcomp.middleware.simulation.config;

import java.io.Serializable;
import java.util.Map;

import edu.kit.ipd.sdq.simcomp.component.meta.SimulationComponentImpl;
import edu.kit.ipd.sdq.simcomp.component.meta.SimulationComponentRequiredType;
import edu.kit.ipd.sdq.simcomp.component.meta.SimulationContextField;
import edu.kit.ipd.sdq.simcomp.config.ISimulatorCompositonRule;

/**
 * A simulator composition rule for the dynamic composition of the simulator.
 * The rule specifies a set of context fields with values and a simulation
 * component to be used when a simulation context for the given simulation
 * component type matches.
 * 
 * @author Christoph Föhrdes
 * 
 */
public class SimulatorCompositonRule implements ISimulatorCompositonRule, Serializable {

	private static final long serialVersionUID = 3742251491988062560L;

	private SimulationComponentRequiredType requiredType;
	private Map<SimulationContextField, String> fieldValues;
	private SimulationComponentImpl component;

	public SimulatorCompositonRule(SimulationComponentRequiredType requiredType, Map<SimulationContextField, String> fieldValues, SimulationComponentImpl component) {
		this.requiredType = requiredType;
		this.fieldValues = fieldValues;
		this.component = component;
	}

	@Override
	public SimulationComponentRequiredType getRequiredType() {
		return requiredType;
	}

	@Override
	public Map<SimulationContextField, String> getFieldValues() {
		return fieldValues;
	}

	@Override
	public SimulationComponentImpl getComponent() {
		return component;
	}

}
