package de.uka.ipd.sdq.simucomframework.abstractSimEngine;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public abstract class SimProcess extends SimulationElement implements ISimProcessDelegate {

	ISimProcessDelegate delegate = null;
	
	protected SimProcess(SimuComModel model, String name) {
		super(model, name);
		delegate = model.getSimEngineFactory().createSimProcess(this,model,name);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.simucomframework.abstractSimEngine.ISimProcessDelegate#lifeCycle()
	 */
	public abstract void lifeCycle();

	// Strategy dependent methods
	public void activateAfter(SimProcess p) {
		delegate.activateAfter(p);
	}

	public void hold(double d) {
		delegate.hold(d);
	}

	public boolean isTerminated() {
		return delegate.isTerminated();
	}

	public void passivate() {
		delegate.passivate();
	}

	public void scheduleAt(double d) {
		delegate.scheduleAt(d);
	}
}
