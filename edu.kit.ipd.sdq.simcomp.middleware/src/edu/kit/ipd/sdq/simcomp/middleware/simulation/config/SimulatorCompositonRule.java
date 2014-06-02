package edu.kit.ipd.sdq.simcomp.middleware.simulation.config;

import java.io.Serializable;
import java.util.Map;

import edu.kit.ipd.sdq.simcomp.component.meta.SimulationComponentMeta;
import edu.kit.ipd.sdq.simcomp.component.meta.SimulationComponentType;
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

	SimulationComponentType componentType;
	Map<SimulationContextField, String> fieldValues;
	SimulationComponentMeta component;

	public SimulatorCompositonRule(SimulationComponentType componentType, Map<SimulationContextField, String> fieldValues, SimulationComponentMeta component) {
		this.componentType = componentType;
		this.fieldValues = fieldValues;
		this.component = component;
	}

	@Override
	public SimulationComponentType getComponentType() {
		return componentType;
	}

	@Override
	public Map<SimulationContextField, String> getFieldValues() {
		return fieldValues;
	}

	@Override
	public SimulationComponentMeta getComponent() {
		return component;
	}

}
