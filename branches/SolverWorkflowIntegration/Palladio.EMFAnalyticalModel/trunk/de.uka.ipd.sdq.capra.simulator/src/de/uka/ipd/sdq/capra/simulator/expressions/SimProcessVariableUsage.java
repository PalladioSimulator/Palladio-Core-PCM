package de.uka.ipd.sdq.capra.simulator.expressions;

import de.uka.ipd.sdq.capra.simulator.processes.SimCapraProcess;

public class SimProcessVariableUsage implements SimCapraExpression {


	protected String name;
	protected SimCapraExpression behaviour;
	
 	public SimProcessVariableUsage(String name) {
		super();
		this.name = name;
		this.behaviour = null;
	}
 	
 	
	@Override
	public SimCapraExpression getNext(SimCapraProcess process) {
		assert (behaviour != null);
		process.setBehaviour(behaviour);
		process.start(0);
		return null;
	}

	@Override
	public boolean isAction() {
		return false;
	}

	@Override
	public void reset() {
	}

	@Override
	public void setVarUsages(String name, SimCapraExpression behaviour) {
		if (name.equals(this.name)){
			this.behaviour = behaviour;
		}
	}

	@Override
	public SimProcessVariableUsage clone() {
		SimProcessVariableUsage pvu =  new SimProcessVariableUsage(name);
		pvu.behaviour = this.behaviour;
		return pvu;
	}


	@Override
	public boolean hasNext() {
		return true;
	}


	@Override
	public void addFinishingListener(IFinishingListener listener) {
		//this.behaviour.addFinishingListener(listener);
	}
}
