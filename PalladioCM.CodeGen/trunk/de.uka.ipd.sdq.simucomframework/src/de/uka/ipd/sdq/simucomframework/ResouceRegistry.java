package de.uka.ipd.sdq.simucomframework;

import java.util.HashMap;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.resources.SimulatedActiveResource;
import de.uka.ipd.sdq.simucomframework.resources.SimulatedResourceContainer;

public class ResouceRegistry {
	// ResourceContainerID -> ResourceContainer Object
	private HashMap<String, SimulatedResourceContainer> resourceContainerHash = new HashMap<String, SimulatedResourceContainer>();
	
	private SimuComModel myModel = null;

	public ResouceRegistry(SimuComModel model) {
		this.myModel = model;
	}

	public SimulatedResourceContainer createResourceContainer(
			String containerID) {
		if (!resourceContainerHash.containsKey(containerID)) {
			SimulatedResourceContainer container = new SimulatedResourceContainer(
					myModel,
					containerID);
			resourceContainerHash.put(containerID, container);
		}
		return resourceContainerHash.get(containerID);
	}

	public boolean containsResourceContainer(String resourceContainerID) {
		return resourceContainerHash.containsKey(resourceContainerID);
	}

	public SimulatedResourceContainer getResourceContainer(
			String resourceContainerID) {
		assert containsResourceContainer(resourceContainerID);
		return resourceContainerHash.get(resourceContainerID);
	}

	public void activateAllActiveResources() {
		for(SimulatedResourceContainer src : resourceContainerHash.values()) {
			for (SimulatedActiveResource sar : src.getActiveResources()) {
				sar.activateResource();
			}
		}
	}

	public void deactivateAllActiveResources() {
		for(SimulatedResourceContainer src : resourceContainerHash.values()) {
			for (SimulatedActiveResource sar : src.getActiveResources()) {
				sar.deactivateResource();
			}
		}
	}
}
