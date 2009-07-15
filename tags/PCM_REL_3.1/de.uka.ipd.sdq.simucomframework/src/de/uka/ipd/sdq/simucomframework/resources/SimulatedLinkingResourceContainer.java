package de.uka.ipd.sdq.simucomframework.resources;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public class SimulatedLinkingResourceContainer extends
		AbstractSimulatedResourceContainer {

	public SimulatedLinkingResourceContainer(SimuComModel myModel, String id) {
		super(myModel, id);
	}

	public void addActiveResource(String typeID, String description, String d, String latencySpec, Double failureProbability) {
		activeResources.put(typeID, 
				new SimulatedLinkingResource(myModel, typeID, description, d, latencySpec, failureProbability));
	}
	
}
