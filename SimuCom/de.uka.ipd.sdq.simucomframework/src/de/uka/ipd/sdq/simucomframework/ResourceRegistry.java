package de.uka.ipd.sdq.simucomframework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.resources.AbstractScheduledResource;
import de.uka.ipd.sdq.simucomframework.resources.AbstractSimulatedResourceContainer;
import de.uka.ipd.sdq.simucomframework.resources.SimulatedLinkingResource;
import de.uka.ipd.sdq.simucomframework.resources.SimulatedLinkingResourceContainer;
import de.uka.ipd.sdq.simucomframework.resources.SimulatedResourceContainer;

public class ResourceRegistry {
	// ResourceContainerID -> ResourceContainer Object
	private HashMap<String, AbstractSimulatedResourceContainer> resourceContainerHash = new HashMap<String, AbstractSimulatedResourceContainer>();
	
	private SimuComModel myModel = null;

	public ResourceRegistry(SimuComModel model) {
		this.myModel = model;
	}

	public AbstractSimulatedResourceContainer createResourceContainer(
			String containerID) {
		if (!resourceContainerHash.containsKey(containerID)) {
			SimulatedResourceContainer container = new SimulatedResourceContainer(
					myModel,
					containerID);
			resourceContainerHash.put(containerID, container);
		}
		return resourceContainerHash.get(containerID);
	}

	public AbstractSimulatedResourceContainer createLinkingResourceContainer(
			String containerID) {
		if (!resourceContainerHash.containsKey(containerID)) {
			SimulatedLinkingResourceContainer container = new SimulatedLinkingResourceContainer(
					myModel,
					containerID);
			resourceContainerHash.put(containerID, container);
		}
		return resourceContainerHash.get(containerID);
	}
	
	public boolean containsResourceContainer(String resourceContainerID) {
		return resourceContainerHash.containsKey(resourceContainerID);
	}

	public AbstractSimulatedResourceContainer getResourceContainer(
			String resourceContainerID) {
		assert containsResourceContainer(resourceContainerID);
		return resourceContainerHash.get(resourceContainerID);
	}

	public void activateAllActiveResources() {
		ArrayList<AbstractScheduledResource> resources = new ArrayList<AbstractScheduledResource>();
		for(AbstractSimulatedResourceContainer src : resourceContainerHash.values())
			resources.addAll(src.getActiveResources());
		for (AbstractScheduledResource sar : resources) {
			sar.activateResource();
		}
	}

	public void deactivateAllActiveResources() {
		ArrayList<AbstractScheduledResource> resources = new ArrayList<AbstractScheduledResource>();
		for(AbstractSimulatedResourceContainer src : resourceContainerHash.values())
			resources.addAll(src.getActiveResources());
		for (AbstractScheduledResource sar : resources) {
			sar.deactivateResource();
		}
	}

}
