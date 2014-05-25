package edu.kit.ipd.sdq.simcomp.component;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a simulation context for the dynamic composition of simulation
 * components. Basically is a simulation context a key value storage.
 * 
 * This class should be extended for each simulation component type and provide
 * the values by clearly defined setField methods.
 * 
 * @author Christoph Föhrdes
 * 
 */
public abstract class AbstractSimulationContext {

	Map<String, String> contextFields;

	public AbstractSimulationContext() {
		contextFields = new HashMap<String, String>();
	}

	/**
	 * Returns the value for a given key.
	 * 
	 * @param fieldKey
	 *            The key for the context field to lookup
	 * @return The value for the given key or null
	 */
	public String getValue(String fieldKey) {
		return contextFields.get(fieldKey);
	}

	/**
	 * Sets a given field to a specified value. The field key is the unique
	 * identifier of the simulation context field provided at registration of
	 * the simulation component type. The component types are registered using
	 * the middleware extension point
	 * "edu.kit.ipd.sdq.simcomp.middleware.simulationComponentType".
	 * 
	 * @param fieldKey
	 * @param value
	 */
	protected void setValue(String fieldKey, String value) {
		contextFields.put(fieldKey, value);
	}

}