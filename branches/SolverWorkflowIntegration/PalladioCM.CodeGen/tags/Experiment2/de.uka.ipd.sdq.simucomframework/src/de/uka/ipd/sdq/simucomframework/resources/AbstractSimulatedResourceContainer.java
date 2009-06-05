package de.uka.ipd.sdq.simucomframework.resources;

import java.util.Collection;
import java.util.HashMap;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.simucomframework.exceptions.ResourceContainerIsMissingRequiredResourceType;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import desmoj.core.simulator.SimProcess;

public abstract class AbstractSimulatedResourceContainer {
	
	protected static Logger logger = 
		Logger.getLogger(AbstractSimulatedResourceContainer.class.getName());
	protected SimuComModel myModel = null;
	protected String myContainerID = null;

	// ResourceTypeID -> SimulatedActiveResource
	// TODO: Multiple Resources with Scheduler
	protected HashMap<String, AbstractScheduledResource> activeResources = new HashMap<String, AbstractScheduledResource>();
	
	public AbstractSimulatedResourceContainer(SimuComModel myModel, String myContainerID) {
		super();
		this.myModel = myModel;
		this.myContainerID = myContainerID;
		logger.info("Simulated Resource Container created. ContainerID "+myContainerID);
	}

	public void loadActiveResource(SimProcess requestingProcess, String typeID, double demand) {
		logger.info(typeID + " loaded with "+demand);
		AbstractScheduledResource resource = activeResources.get(typeID);
		if (resource == null) {
			logger.error("Resource container is missing a resource which was attempted to be loaded"+
					" by a component. ID of resource type was: "+typeID);
			throw new ResourceContainerIsMissingRequiredResourceType(typeID);
		}
		resource.consumeResource(requestingProcess, demand);
	}

	public Collection<AbstractScheduledResource> getActiveResources() {
		return activeResources.values();
	}

	public String getResourceContainerID() {
		return myContainerID;
	}
	
}
