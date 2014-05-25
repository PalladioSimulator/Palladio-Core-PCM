package edu.kit.ipd.sdq.simcomp.middleware.simulation.config;

import java.io.Serializable;
import java.util.Map;

import edu.kit.ipd.sdq.simcomp.component.meta.SimulationComponentMetaData;
import edu.kit.ipd.sdq.simcomp.component.meta.SimulationComponentType;
import edu.kit.ipd.sdq.simcomp.component.meta.SimulationContextField;

public class SimulatiorCompositonRule implements Serializable {

	private static final long serialVersionUID = 3742251491988062560L;

	SimulationComponentType componentType;
	Map<SimulationContextField, String> fieldValues;
	SimulationComponentMetaData component;

	public SimulatiorCompositonRule(SimulationComponentType componentType, Map<SimulationContextField, String> fieldValues, SimulationComponentMetaData component) {
		this.componentType = componentType;
		this.fieldValues = fieldValues;
		this.component = component;
	}

	public SimulationComponentType getComponentType() {
		return componentType;
	}

	public Map<SimulationContextField, String> getFieldValues() {
		return fieldValues;
	}

	public SimulationComponentMetaData getComponent() {
		return component;
	}

}
