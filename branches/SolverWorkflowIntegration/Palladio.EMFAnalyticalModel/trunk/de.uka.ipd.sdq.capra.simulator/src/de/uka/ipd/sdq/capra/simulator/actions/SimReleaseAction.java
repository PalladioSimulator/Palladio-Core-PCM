package de.uka.ipd.sdq.capra.simulator.actions;

import de.uka.ipd.sdq.capra.simulator.expressions.IFinishingListener;
import de.uka.ipd.sdq.capra.simulator.expressions.SimCapraExpression;
import de.uka.ipd.sdq.capra.simulator.processes.SimCapraProcess;
import de.uka.ipd.sdq.scheduler.IPassiveResource;

/**
 * @author     jens.happe
 */
public class SimReleaseAction implements SimAction {

	private IPassiveResource resource;
	private int numberReleased;
	
	public SimReleaseAction(IPassiveResource resource, int numberReleased) {
		super();
		this.resource = resource;
		this.numberReleased = numberReleased;
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
		resource.release(capraProcess, numberReleased);
		capraProcess.activate();
	}
	
	@Override
	public SimReleaseAction clone(){
		return new SimReleaseAction(resource,numberReleased);
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
