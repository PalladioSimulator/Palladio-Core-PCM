package edu.kit.ipd.sdq.simcomp.middleware.simulation.config;

import java.io.Serializable;
import java.util.Map;

import edu.kit.ipd.sdq.simcomp.component.meta.SimulationComponentMeta;
import edu.kit.ipd.sdq.simcomp.component.meta.SimulationComponentType;
import edu.kit.ipd.sdq.simcomp.component.meta.SimulationContextField;
import edu.kit.ipd.sdq.simcomp.config.ISimulatorCompositonRule;

public class SimulatiorCompositonRule implements ISimulatorCompositonRule, Serializable {

	private static final long serialVersionUID = 3742251491988062560L;

	SimulationComponentType componentType;
	Map<SimulationContextField, String> fieldValues;
	SimulationComponentMeta component;

	public SimulatiorCompositonRule(SimulationComponentType componentType, Map<SimulationContextField, String> fieldValues, SimulationComponentMeta component) {
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
