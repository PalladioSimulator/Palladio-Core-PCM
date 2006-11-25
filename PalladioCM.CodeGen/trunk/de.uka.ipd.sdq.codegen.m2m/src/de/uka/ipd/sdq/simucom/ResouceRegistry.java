package de.uka.ipd.sdq.simucom;

import java.util.HashMap;

public class ResouceRegistry {
	// ResourceContainerID -> ResourceContainer Object
	private HashMap<String, SimulatedResourceContainer> resourceContainerHash = new HashMap<String, SimulatedResourceContainer>();

	private static ResouceRegistry singleton;

	static {
		singleton = new ResouceRegistry();
	}

	private ResouceRegistry() {

	}

	protected SimulatedResourceContainer createResourceContainer(
			String containerID) {
		if (!resourceContainerHash.containsKey(containerID)) {
			SimulatedResourceContainer container = new SimulatedResourceContainer(
					containerID);
			resourceContainerHash.put(containerID, container);
		}
		return resourceContainerHash.get(containerID);
	}

	public static ResouceRegistry singleton() {
		return singleton;
	}

	public boolean containsResourceContainer(String resourceContainerID) {
		return resourceContainerHash.containsKey(resourceContainerID);
	}

	public SimulatedResourceContainer getResourceContainer(
			String resourceContainerID) {
		assert containsResourceContainer(resourceContainerID);
		return resourceContainerHash.get(resourceContainerID);
	}
}
