package de.uka.ipd.sdq.simucomframework.usage;

import de.uka.ipd.sdq.simucomframework.IUsageScenario;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.SimTime;

public abstract class AbstractUsageScenario extends SimProcess implements
		IUsageScenario {

	protected SimuComModel myModel = null;

	public AbstractUsageScenario(SimuComModel model, String name) {
		super(model, name, false);
	}

	public void doInitialSchedules() {
		this.activate(SimTime.NOW);
	}

	public void init(SimuComModel model) {
		this.myModel = model;
	}

	@Override
	public void lifeCycle() {
		// Closed workload without think time
		while(true) {
			this.scenarioRunner();
		}
	}

	public abstract void scenarioRunner();
}
