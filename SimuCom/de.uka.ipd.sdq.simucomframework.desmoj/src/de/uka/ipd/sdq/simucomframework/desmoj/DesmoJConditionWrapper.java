package de.uka.ipd.sdq.simucomframework.desmoj;

import desmoj.core.simulator.Condition;
import desmoj.core.simulator.Entity;
import desmoj.core.simulator.Model;

public class DesmoJConditionWrapper extends Condition {

	private de.uka.ipd.sdq.simucomframework.abstractSimEngine.Condition abstractCondition;

	public DesmoJConditionWrapper(
			de.uka.ipd.sdq.simucomframework.abstractSimEngine.Condition abstractCondition, 
			Model owner) {
		super(owner, abstractCondition.getName(), false);
		this.abstractCondition = abstractCondition;
	}

	@Override
	public boolean check() {
		return abstractCondition.check();
	}

	@Override
	public boolean check(Entity arg0) {
		return false;
	}

}
