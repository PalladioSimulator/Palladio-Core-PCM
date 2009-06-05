package de.uka.ipd.sdq.simucomframework.abstractSimEngine;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public abstract class SimulationElement {
	private String myName;
	private SimuComModel myModel;

	SimulationElement (SimuComModel model, String name) {
		this.myModel = model;
		this.myName = name;
	}
	
	public String getName() {
		return myName;
	}
	
	public SimuComModel getModel() {
		return myModel;
	}
}
