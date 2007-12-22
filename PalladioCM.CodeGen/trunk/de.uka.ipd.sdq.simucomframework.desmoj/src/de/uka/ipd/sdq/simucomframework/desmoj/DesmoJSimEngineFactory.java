package de.uka.ipd.sdq.simucomframework.desmoj;

import de.uka.ipd.sdq.simucomframework.abstractSimEngine.Entity;
import de.uka.ipd.sdq.simucomframework.abstractSimEngine.IEntityDelegate;
import de.uka.ipd.sdq.simucomframework.abstractSimEngine.ISimEngineFactory;
import de.uka.ipd.sdq.simucomframework.abstractSimEngine.ISimEventDelegate;
import de.uka.ipd.sdq.simucomframework.abstractSimEngine.ISimProcessDelegate;
import de.uka.ipd.sdq.simucomframework.abstractSimEngine.ISimulationControlDelegate;
import de.uka.ipd.sdq.simucomframework.abstractSimEngine.SimEvent;
import de.uka.ipd.sdq.simucomframework.abstractSimEngine.SimProcess;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public class DesmoJSimEngineFactory implements ISimEngineFactory {

	public ISimulationControlDelegate createSimulationControl(SimuComModel model) {
		ISimulationControlDelegate delegate = new DesmoJExperiment(model);
		model.setSimulationControl(delegate);
		model.setSimulationEngineFactory(this);
		
		return delegate;
	}

	public ISimProcessDelegate createSimProcess(SimProcess myProcess, SimuComModel model, String name) {
		return new DesmoJSimProcess(
				myProcess,
				((DesmoJExperiment)model.getSimulationControl()).getDesmoJModel(), 
				name);
	}

	public ISimEventDelegate createSimEvent(SimEvent myEvent, SimuComModel model, String name) {
		return new DesmoJSimEvent(
				myEvent,
				((DesmoJExperiment)model.getSimulationControl()).getDesmoJModel(), 
				name);
	}

	public IEntityDelegate createEntity(Entity e, SimuComModel model, String name) {
		return new DesmoJEntity(
				e,
				((DesmoJExperiment)model.getSimulationControl()).getDesmoJModel(), 
				name);
	}

}
