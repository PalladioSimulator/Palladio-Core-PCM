package edu.kit.ipd.sdq.simcomp.component.meta;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Stores the meta information about a simulation component.
 * 
 * @author Christoph Föhrdes
 * 
 */
public class SimulationComponentImpl implements Serializable {

	private static final long serialVersionUID = -2096157018157833990L;

	private String id;
	private String name;
	private String componentClass;
	private List<SimulationComponentType> providedTypes;
	private List<SimulationComponentRequiredType> requiredTypes;

	public SimulationComponentImpl(String id, String name, String componentClass) {
		this.id = id;
		this.name = name;
		this.componentClass = componentClass;

		this.providedTypes = new ArrayList<SimulationComponentType>();
		this.requiredTypes = new ArrayList<SimulationComponentRequiredType>();
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

	public List<SimulationComponentType> getProvidedTypes() {
		return providedTypes;
	}

	public void addProvidedType(SimulationComponentType providedType) {
		this.providedTypes.add(providedType);
	}

	public List<SimulationComponentRequiredType> getRequiredTypes() {
		return requiredTypes;
	}

	public void addRequiredType(SimulationComponentRequiredType requiredType) {
		this.requiredTypes.add(requiredType);
	}

	@Override
	public String toString() {
		return this.name;
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
		SimulationComponentImpl other = (SimulationComponentImpl) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
