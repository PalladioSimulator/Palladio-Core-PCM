package edu.kit.ipd.sdq.simcomp.component.meta;

import java.util.ArrayList;
import java.util.List;

public class SimulationComponentType {

	private String id;
	private String name;
	private String typeInterface;
	private List<SimulationContextField> contextFields;
	private List<SimulationComponentMetaData> availableComponents;

	public SimulationComponentType(String id, String name, String typeInterface) {
		this.id = id;
		this.name = name;
		this.typeInterface = typeInterface;

		contextFields = new ArrayList<SimulationContextField>();
		availableComponents = new ArrayList<SimulationComponentMetaData>();
	}

	public String getTypeInterface() {
		return typeInterface;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<SimulationContextField> getContextFields() {
		return contextFields;
	}

	public void addContextField(SimulationContextField contextType) {
		this.contextFields.add(contextType);
	}

	public List<SimulationComponentMetaData> getAvailableComponents() {
		return availableComponents;
	}

	public void addAvailableComponent(SimulationComponentMetaData contextType) {
		this.availableComponents.add(contextType);
	}

}
