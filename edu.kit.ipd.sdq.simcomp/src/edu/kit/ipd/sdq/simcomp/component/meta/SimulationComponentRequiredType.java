package edu.kit.ipd.sdq.simcomp.component.meta;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SimulationComponentRequiredType implements Serializable {

	private static final long serialVersionUID = -7334428861355013323L;

	private SimulationComponentImpl component;
	private SimulationComponentType type;
	private List<SimulationContextField> contextFields;

	public SimulationComponentRequiredType(SimulationComponentImpl component, SimulationComponentType type) {
		this.component = component;
		this.type = type;

		contextFields = new ArrayList<SimulationContextField>();
	}

	public SimulationComponentImpl getComponent() {
		return component;
	}

	public SimulationComponentType getType() {
		return type;
	}

	public List<SimulationContextField> getContextFields() {
		return contextFields;
	}

	public void addContextField(SimulationContextField contextField) {
		this.contextFields.add(contextField);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((component == null) ? 0 : component.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		SimulationComponentRequiredType other = (SimulationComponentRequiredType) obj;
		if (component == null) {
			if (other.component != null)
				return false;
		} else if (!component.equals(other.component))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

}
