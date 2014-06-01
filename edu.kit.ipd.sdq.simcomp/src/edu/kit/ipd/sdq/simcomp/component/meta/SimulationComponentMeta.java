package edu.kit.ipd.sdq.simcomp.component.meta;

import java.io.Serializable;

/**
 * Stores the meta information about a simulation component.
 * 
 * @author Christoph Föhrdes
 * 
 */
public class SimulationComponentMeta implements Serializable {

	private static final long serialVersionUID = -2096157018157833990L;

	private String id;
	private String name;
	private String componentClass;
	private SimulationComponentType type;

	public SimulationComponentMeta(String id, String name, String componentClass, SimulationComponentType type) {
		this.id = id;
		this.name = name;
		this.componentClass = componentClass;
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getComponentClass() {
		return this.componentClass;
	}

	public SimulationComponentType getSimulationComponentType() {
		return type;
	}

	@Override
	public String toString() {
		return this.name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((componentClass == null) ? 0 : componentClass.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		SimulationComponentMeta other = (SimulationComponentMeta) obj;
		if (componentClass == null) {
			if (other.componentClass != null)
				return false;
		} else if (!componentClass.equals(other.componentClass))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
