package edu.kit.ipd.sdq.simcomp.component.meta;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SimulationComponentType implements Serializable, Comparable<SimulationComponentType> {

	private static final long serialVersionUID = -7902460415139196101L;

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

	@Override
	public String toString() {
		return "SimulationComponentType [id=" + id + ", name=" + name + ", contextFields=" + contextFields.size() + ", availableComponents=" + availableComponents.size() + "]";
	}

	@Override
	public int compareTo(SimulationComponentType o) {
		return this.name.compareTo(o.getName());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SimulationComponentType other = (SimulationComponentType) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
