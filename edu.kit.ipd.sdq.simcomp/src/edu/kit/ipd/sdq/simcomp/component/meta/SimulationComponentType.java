package edu.kit.ipd.sdq.simcomp.component.meta;

import java.io.Serializable;

public class SimulationComponentType implements Serializable, Comparable<SimulationComponentType> {

	private static final long serialVersionUID = -7902460415139196101L;

	private String id;
	private String name;
	private String typeInterface;

	public SimulationComponentType(String id, String name, String typeInterface) {
		this.id = id;
		this.name = name;
		this.typeInterface = typeInterface;
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
