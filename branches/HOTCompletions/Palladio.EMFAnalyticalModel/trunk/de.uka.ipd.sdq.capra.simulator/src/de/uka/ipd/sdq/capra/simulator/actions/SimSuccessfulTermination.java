package de.uka.ipd.sdq.capra.simulator.actions;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.capra.simulator.expressions.IFinishingListener;
import de.uka.ipd.sdq.capra.simulator.expressions.SimCapraExpression;
import de.uka.ipd.sdq.capra.simulator.processes.SimCapraProcess;
import de.uka.ipd.sdq.scheduler.LoggingWrapper;

public class SimSuccessfulTermination implements SimAction {
	
	List<IFinishingListener> finishingListener = new ArrayList<IFinishingListener>();

	@Override
	public SimSuccessfulTermination clone(){
		return new SimSuccessfulTermination();
	}

	@Override
	public void reset() {
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
	public void execute(SimCapraProcess capraProcess) {
		// nothing to do
		
		LoggingWrapper.log("Terminating Process: " + capraProcess);
		
		for (IFinishingListener listener : finishingListener) {
			listener.notifyFinished();
		}
		capraProcess.activate();

		SimCapraProcess parent = capraProcess.getParent();
		if (parent != null){
			parent.activate();
		}
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
		this.finishingListener.add(listener);
	}

}
