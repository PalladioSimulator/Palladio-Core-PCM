package edu.kit.ipd.sdq.simcomp.ui.data;

import java.util.ArrayList;
import java.util.List;

public class SimulationComponentType {

	private Class<?> typeClass;
	private String id;
	private String title;
	private List<SimulationContextField> contextFields;
	private List<SimulationComponentMetaData> availableComponents;

	public SimulationComponentType(Class<?> typeClass, String title) {
		this.typeClass = typeClass;
		this.id = typeClass.getName();
		this.title = title;

		contextFields = new ArrayList<SimulationContextField>();
		availableComponents = new ArrayList<SimulationComponentMetaData>();
	}

	public Class<?> getTypeClass() {
		return typeClass;
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
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
