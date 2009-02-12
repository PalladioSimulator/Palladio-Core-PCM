package de.uka.ipd.sdq.simucomframework.resources;

import java.util.Collection;
import java.util.HashMap;

import de.uka.ipd.sdq.simucomframework.abstractSimEngine.SimProcess;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public class SimulatedResourceContainer extends AbstractSimulatedResourceContainer {
	
	// ResourceTypeID -> SimulatedPassiveResource
	// TODO: Becomes soon deprecated
	private HashMap<String, SimulatedPassiveResource> passiveResources = new HashMap<String, SimulatedPassiveResource>();

	public SimulatedResourceContainer(SimuComModel myModel, String containerID) {
		super(myModel,containerID);
	}

	public void acquirePassiveResource(SimProcess requestingProcess, String typeID) {
		logger.info(typeID + " acquire request");
		SimulatedPassiveResource resource = passiveResources.get(typeID);
		resource.acquire(requestingProcess);
	}
	
	public void releasePassiveResource(String typeID) {
		logger.info(typeID + " release request");
		SimulatedPassiveResource resource = passiveResources.get(typeID);
		resource.release();
	}
		
	public void addPassiveResource(String typeID, int capacity) {
		passiveResources.put(typeID, 
				new SimulatedPassiveResource(myModel, typeID, capacity));
	}
	
	public Collection<SimulatedPassiveResource> getPassiveResources() {
		return passiveResources.values();
	}

	public void addActiveResource(String typeID, String description, String processingRate, String units, SchedulingStrategy strategy, int numberOfReplicas) {
		if (true || typeID.equals("CPU") && strategy == SchedulingStrategy.PROCESSOR_SHARING) { // TODO!! Change to a new Enum Entry
			// Use Jens Simulator to simulate exact CPUs
			// TODO: Ask Jens whether his simulator can be combined with my simulator for the other resource types!
			activeResources.put(typeID, 
					new ExactCPUResource(myModel, typeID, description, processingRate, units, strategy, numberOfReplicas));
		} else {
			activeResources.put(typeID, 
					new SimulatedActiveResource(myModel, typeID, description, processingRate, units, strategy));
		}
	}
	
}
