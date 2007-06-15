package de.uka.ipd.sdq.simucomframework.resources;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public class SimulatedLinkingResourceContainer extends
		AbstractSimulatedResourceContainer {

	public SimulatedLinkingResourceContainer(SimuComModel myModel, String id) {
		super(myModel, id);
	}

	public void addActiveResource(String typeID, double d, String latencySpec) {
		activeResources.put(typeID, 
				new SimulatedLinkingResource(myModel, typeID, d, latencySpec));
	}
	
}
