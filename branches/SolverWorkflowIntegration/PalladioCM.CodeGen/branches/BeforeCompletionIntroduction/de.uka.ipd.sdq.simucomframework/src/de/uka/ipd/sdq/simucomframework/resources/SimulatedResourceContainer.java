package de.uka.ipd.sdq.simucomframework.resources;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.simucomframework.exceptions.ResourceContainerIsMissingRequiredResourceType;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import desmoj.core.simulator.SimProcess;

public class SimulatedResourceContainer {

	private static Logger logger = 
		Logger.getLogger(SimulatedResourceContainer.class.getName());
	
	private String myContainerID = null;
	private SimuComModel myModel = null;

	// ResourceTypeID -> SimulatedActiveResource
	// TODO: Multiple Resources with Scheduler
	private HashMap<String, SimulatedActiveResource> activeResources = new HashMap<String, SimulatedActiveResource>();

	// ResourceTypeID -> SimulatedPassiveResource
	private HashMap<String, SimulatedPassiveResource> passiveResources = new HashMap<String, SimulatedPassiveResource>();

	public SimulatedResourceContainer(SimuComModel myModel, String containerID) {
		myContainerID = containerID;
		this.myModel = myModel;
	}

	public void loadActiveResource(SimProcess requestingProcess, String typeID, double demand) {
		logger.info(typeID + " loaded with "+demand);
		SimulatedActiveResource resource = activeResources.get(typeID);
		if (resource == null) {
			logger.error("Resource container is missing a resource which was attempted to be loaded"+
					" by a component. ID of resource type was: "+typeID);
			throw new ResourceContainerIsMissingRequiredResourceType(typeID);
		}
		resource.consumeResource(requestingProcess, demand);
	}

	public void aquirePassiveResource(SimProcess requestingProcess, String typeID) {
		logger.info(typeID + " aquire request");
		SimulatedPassiveResource resource = passiveResources.get(typeID);
		resource.aquire(requestingProcess);
	}
	
	public void releasePassiveResource(String typeID) {
		logger.info(typeID + " release request");
		SimulatedPassiveResource resource = passiveResources.get(typeID);
		resource.release();
	}
	
	public void addActiveResource(String typeID, double d, String units) {
		activeResources.put(typeID, 
				new SimulatedActiveResource(myModel, typeID, d, units));
	}
	
	public void addPassiveResource(String typeID, int capacity) {
		passiveResources.put(typeID, 
				new SimulatedPassiveResource(myModel, typeID, capacity));
	}
	
	public String getResourceContainerID() {
		return myContainerID;
	}

	public Collection<SimulatedActiveResource> getActiveResources() {
		return activeResources.values();
	}

	public Collection<SimulatedPassiveResource> getPassiveResources() {
		return passiveResources.values();
	}
}
