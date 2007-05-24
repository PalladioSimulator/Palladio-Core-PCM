package de.uka.ipd.sdq.simucomframework.usage;

import org.apache.log4j.Logger;

import desmoj.core.simulator.Model;
import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.SimTime;

public class OpenWorkloadUser extends SimProcess implements IUser {

	private IScenarioRunner scenarioRunner;
	private static Logger logger = 
		Logger.getLogger(OpenWorkloadUser.class.getName());

	public OpenWorkloadUser(Model owner, String name, IScenarioRunner scenarioRunner) {
		super(owner, name, true);
		this.scenarioRunner = scenarioRunner;
	}

	@Override
	public void lifeCycle() {
		logger.debug(this.getName()+" started! I'm alive!!!");
		scenarioRunner(this);
		logger.debug(this.getName()+" done! I'm dying!!!");
	}

	public void scenarioRunner(SimProcess thread) {
		this.scenarioRunner.scenarioRunner(thread);
	}

	public void startUserLife() {
		this.activate(SimTime.NOW);
	}
}
