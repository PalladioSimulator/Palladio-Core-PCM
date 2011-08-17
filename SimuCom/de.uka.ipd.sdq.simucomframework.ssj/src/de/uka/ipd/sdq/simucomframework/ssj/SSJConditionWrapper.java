package de.uka.ipd.sdq.simucomframework.ssj;

import de.uka.ipd.sdq.simulation.abstractSimEngine.SimCondition;
import de.uka.ipd.sdq.simulation.abstractSimEngine.ISimulationModel;

public class SSJConditionWrapper<T extends ISimulationModel<T>> {

	private SimCondition<T> abstractCondition;

	public SSJConditionWrapper(SimCondition<T> abstractCondition) {
		// super(owner, abstractCondition.getName(), false);
		this.abstractCondition = abstractCondition;
	}
	
}
