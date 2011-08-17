package de.uka.ipd.sdq.probespec.framework.probes.example;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a simple simulation context for demonstration purposes.
 * <p>
 * The simulation context holds the current simulation time as well as available
 * active resources.
 * 
 * @author pmerkle
 * 
 */
public class SimpleSimulationContext {

	private double simulatedTime;

	/** Maps "resource name" -> resource */
	private Map<String, ASimpleActiveResource> activeResourceMap;

	public SimpleSimulationContext() {
		this.activeResourceMap = new HashMap<String, ASimpleActiveResource>();
	}

	public double getSimulatedTime() {
		return simulatedTime;
	}

	public void setSimulatedTime(double simulatedTime) {
		this.simulatedTime = simulatedTime;
	}

	public void addActiveResource(String name, ASimpleActiveResource resource) {
		activeResourceMap.put(name, resource);
	}

	public ASimpleActiveResource getActiveResource(String name) {
		return activeResourceMap.get(name);
	}

}
