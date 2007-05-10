package de.uka.ipd.sdq.simucomframework.usage;

import de.uka.ipd.sdq.simucomframework.Context;
import de.uka.ipd.sdq.simucomframework.SimuComStatus;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import desmoj.core.exception.SimFinishedException;
import desmoj.core.simulator.Model;
import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.SimTime;

public class ClosedWorkloadUser extends SimProcess implements IUser {

	private IScenarioRunner scenarioRunner;
	private String thinkTime;

	public ClosedWorkloadUser(Model owner, String name, IScenarioRunner scenarioRunner2, String thinkTimeSpec) {
		super(owner, name, true);
		this.scenarioRunner = scenarioRunner2;
		this.thinkTime = thinkTimeSpec;
	}

	@Override
	public void lifeCycle() {
		try {
			while (true) {
				scenarioRunner(this);
			}
		} catch (SimFinishedException ex) {
		} catch (Exception e) {
			this.getModel().getExperiment().stop();
			((SimuComModel)getModel()).setStatus(SimuComStatus.ERROR,
					e.getMessage());
		}
	}

	public void scenarioRunner(SimProcess thread) {
		double thinkTime = (Double)Context.evaluate(this.thinkTime,Double.class,null);
		this.hold(new SimTime(thinkTime));
		this.scenarioRunner.scenarioRunner(thread);
	}

	public void startUserLife() {
		this.activate(SimTime.NOW);
	}

}
