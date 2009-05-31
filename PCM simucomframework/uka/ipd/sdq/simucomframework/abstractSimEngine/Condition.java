package de.uka.ipd.sdq.simucomframework.abstractSimEngine;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public abstract class Condition extends SimulationElement {
	protected Condition(SimuComModel model, String name) {
		super(model, name);
	}

	public abstract boolean check();
}
