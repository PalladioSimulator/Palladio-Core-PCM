package de.uka.ipd.sdq.simucomframework.abstractSimEngine;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public abstract class Entity extends SimulationElement implements IEntityDelegate {

	IEntityDelegate delegate = null;
	
	protected Entity(SimuComModel model, String name) {
		super(model, name);
		delegate = model.getSimEngineFactory().createEntity(this,model,name);
	}
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.simucomframework.abstractSimEngine.IEntityDelegate#isScheduled()
	 */
	public boolean isScheduled() {
		return delegate.isScheduled();
	}
	
	public void reschedule(double d){
		delegate.reschedule(d);
	}

}
