package de.uka.ipd.sdq.simucomframework.usage;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public abstract class OpenWorkloadUserFactory implements IUserFactory {

	private SimuComModel model;

	public OpenWorkloadUserFactory(SimuComModel model) {
		this.model = model;
	}
	
	public IUser createUser() {
		IScenarioRunner scenarioRunner = this.createScenarioRunner();
		return new OpenWorkloadUser(model, "OpenUser", scenarioRunner);
	}
	
	public abstract IScenarioRunner createScenarioRunner();
	
}
