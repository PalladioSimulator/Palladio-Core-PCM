package de.uka.ipd.sdq.simucomframework.usage;

import desmoj.core.simulator.Model;
import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.SimTime;

public class OpenWorkloadUser extends SimProcess implements IUser {

	private IScenarioRunner scenarioRunner;

	public OpenWorkloadUser(Model owner, String name, IScenarioRunner scenarioRunner) {
		super(owner, name, true);
		this.scenarioRunner = scenarioRunner;
	}

	@Override
	public void lifeCycle() {
		scenarioRunner(this);
	}

	public void scenarioRunner(SimProcess thread) {
		this.scenarioRunner.scenarioRunner(thread);
	}

	public void startUserLife() {
		this.activate(SimTime.NOW);
	}
}
