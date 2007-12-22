package de.uka.ipd.sdq.simucomframework.abstractSimEngine;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public interface ISimEngineFactory {
	ISimulationControlDelegate createSimulationControl(SimuComModel model);

	ISimProcessDelegate createSimProcess(SimProcess myProcess, SimuComModel model, String name);

	ISimEventDelegate createSimEvent(SimEvent myEvent, SimuComModel model, String name);

	IEntityDelegate createEntity(Entity e, SimuComModel model, String name);
}
