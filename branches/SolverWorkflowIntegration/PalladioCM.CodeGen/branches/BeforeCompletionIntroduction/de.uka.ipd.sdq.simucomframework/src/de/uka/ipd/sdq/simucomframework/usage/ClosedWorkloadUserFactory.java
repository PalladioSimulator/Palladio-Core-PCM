package de.uka.ipd.sdq.simucomframework.usage;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public abstract class ClosedWorkloadUserFactory implements IUserFactory {

	private String thinkTime;
	private SimuComModel model;

	public ClosedWorkloadUserFactory(SimuComModel model, String thinkTimeSpec) {
		this.thinkTime = thinkTimeSpec;
		this.model = model;
	}
	
	public IUser createUser() {
		IScenarioRunner scenarioRunner = this.createScenarioRunner();
		return new ClosedWorkloadUser(model, "ClosedUser", scenarioRunner,thinkTime);
	}
	
	public abstract IScenarioRunner createScenarioRunner();
	
}
