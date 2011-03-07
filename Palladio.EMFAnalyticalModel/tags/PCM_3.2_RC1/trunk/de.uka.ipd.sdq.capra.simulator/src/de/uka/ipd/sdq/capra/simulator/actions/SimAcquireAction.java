package de.uka.ipd.sdq.capra.simulator.actions;

import de.uka.ipd.sdq.capra.simulator.expressions.IFinishingListener;
import de.uka.ipd.sdq.capra.simulator.expressions.SimCapraExpression;
import de.uka.ipd.sdq.capra.simulator.processes.SimCapraProcess;
import de.uka.ipd.sdq.scheduler.IPassiveResource;

/**
 * @author     jens.happe
 */
public class SimAcquireAction implements SimAction {

	private IPassiveResource resource;
	private int numberRequested;
	
	public SimAcquireAction(IPassiveResource resource, int numberRequested) {
		super();
		this.resource = resource;
		this.numberRequested = numberRequested;
	}

	@Override
	public SimCapraExpression getNext(SimCapraProcess process) {
		return null;
	}

	@Override
	public boolean isAction() {
		return true;
	}

	@Override
	public void reset() {
	}

	@Override
	public void execute(SimCapraProcess capraProcess) {
		if (resource.acquire(capraProcess,numberRequested)){
			capraProcess.activate();
		}
	}
	
	@Override
	public SimAcquireAction clone(){
		return new SimAcquireAction(resource,numberRequested);
	}

	@Override
	public void setVarUsages(String name, SimCapraExpression behaviour) {
	}

	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public void addFinishingListener(IFinishingListener listener) {
	}

}
