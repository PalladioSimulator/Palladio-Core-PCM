package de.uka.ipd.sdq.simucomframework.abstractSimEngine;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.resources.active.SimActiveResource;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public abstract class SimProcess extends SimulationElement 
implements ISimProcessDelegate, ISchedulableProcess {

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

	public void hold(double d) {
		delegate.hold(d);
	}

	public boolean isTerminated() {
		return delegate.isTerminated();
	}

	public void passivate() {
		delegate.passivate();
	}
	
	public void activate() {
		this.scheduleAt(0);
	}

	public void scheduleAt(double d) {
		delegate.scheduleAt(d);
	}
	
	public String getId() {
		return Thread.currentThread().getName();
	}
	
	public ISchedulableProcess getAncestor(){
		// TODO: What is expected here?
		return null;
	}
	
	public boolean isFinished() {
		return isTerminated();
	}

	public void setMainResource(SimActiveResource resource) {
		// TODO: What does this method do?
	}
	
}
