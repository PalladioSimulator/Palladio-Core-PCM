package de.uka.ipd.sdq.simucomframework.resources;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public class SimulatedLinkingResourceContainer extends
		AbstractSimulatedResourceContainer {

	public SimulatedLinkingResourceContainer(SimuComModel myModel, String id) {
		super(myModel, id);
	}

	public void addActiveResource(String typeID, String description, String throughput,
			String latencySpec, Double failureProbability) {
		SimulatedLinkingResource r = new SimulatedLinkingResource(myModel,
				typeID, description, throughput, latencySpec, failureProbability);
		activeResources.put(typeID, r);
		
		// setup calculators 
//		TODO: setup waiting time calculator 
//		CalculatorHelper.setupWaitingTimeCalculator(r);
		CalculatorHelper.setupDemandCalculator(r);
		CalculatorHelper.setupStateCalculator(r);
	}

}
