package de.uka.ipd.sdq.capra.simulator.actions;

import de.uka.ipd.sdq.capra.simulator.expressions.IFinishingListener;
import de.uka.ipd.sdq.capra.simulator.expressions.SimCapraExpression;
import de.uka.ipd.sdq.capra.simulator.processes.SimCapraProcess;
import de.uka.ipd.sdq.scheduler.strategy.impl.AbstractScheduler;

public class WaitAction implements SimAction {
	

	@Override
	public void execute(SimCapraProcess capraProcess) {
	}

	@Override
	public SimCapraExpression getNext(SimCapraProcess process) {
		return null;
	}

	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public boolean isAction() {
		return true;
	}

	@Override
	public void reset() {
	}

	@Override
	public void setVarUsages(String name, SimCapraExpression behaviour) {
	}
	
	@Override
	public WaitAction clone(){
		return this;
	}

	@Override
	public void addFinishingListener(IFinishingListener listener) {		
	}

}
