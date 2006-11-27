package de.uka.ipd.sdq.simucomframework;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public interface IUsageScenario {
	
	void init(SimuComModel model);
	void doInitialSchedules();
	void scenarioRunner();

}
