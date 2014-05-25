package edu.kit.ipd.sdq.simcomp.component.meta;

import java.io.Serializable;

public class SimulationContextField implements Serializable {

	private static final long serialVersionUID = 8608625145516507996L;

	private String id;
	private String name;
	private IContextFieldValueProvider valueProvider;

	public SimulationContextField(String id, String name, IContextFieldValueProvider valueProvider) {
		this.id = id;
		this.name = name;
		this.valueProvider = valueProvider;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public IContextFieldValueProvider getValueProvider() {
		return valueProvider;
	}

	@Override
	public String toString() {
		return "SimulationContextField [id=" + id + ", name=" + name + "]";
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
		SimulationContextField other = (SimulationContextField) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
