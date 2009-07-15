package de.uka.ipd.sdq.simucomframework.abstractSimEngine;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public abstract class SimEvent extends SimulationElement implements ISimEventDelegate {

	ISimEventDelegate delegate = null;
	
	protected SimEvent(SimuComModel model, String name) {
		super(model, name);
		delegate = model.getSimEngineFactory().createSimEvent(this,model,name);
	}

	public abstract void eventRoutine(IEntityDelegate who);

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.simucomframework.abstractSimEngine.ISimEventDelegate#schedule(de.uka.ipd.sdq.simucomframework.abstractSimEngine.Entity, double)
	 */
	public void schedule(IEntityDelegate resource,
			double timeWhenNextJobIsDone) {
		delegate.schedule(((Entity)resource).delegate, timeWhenNextJobIsDone);
	}
	
	public void removeEvent(){
		delegate.removeEvent();
	}
}
