package de.uka.ipd.sdq.capra.simulator.expressions;

import umontreal.iro.lecuyer.rng.MRG32k3a;
import umontreal.iro.lecuyer.rng.RandomStream;
import de.uka.ipd.sdq.capra.simulator.actions.SimAction;
import de.uka.ipd.sdq.capra.simulator.processes.SimCapraProcess;

/**
 * @author     jens.happe
 */
public class SimProbabilisticPrefix implements SimCapraExpression {

	private SimAction action;
	/**
	 * @uml.property  name="targetOptions"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 */
	private SimInternalSelector[] targetOptions;
	private RandomStream stream;
	
	private SimCapraExpression selectedExpression = null;
	
	/**
	 * @uml.property  name="next"
	 */
	private int next = 0;
	
	
	public SimProbabilisticPrefix(SimAction action,
			SimInternalSelector[] targetOptions, RandomStream stream) {
		super();
		this.action = action;
		this.targetOptions = targetOptions;
		this.stream = stream;
	}

	public SimProbabilisticPrefix(SimAction action,
			SimInternalSelector[] targetOptions) {
		this(action, targetOptions, new MRG32k3a());
	}


	@Override
	public SimProbabilisticPrefix clone(){
		SimInternalSelector[] newTargetOptions = new SimInternalSelector[targetOptions.length];
		for (int i=0; i<targetOptions.length; i++) {
			newTargetOptions[i] = targetOptions[i].clone();
		}
		return new SimProbabilisticPrefix(action.clone(), newTargetOptions);
	}

	@Override
	public void reset() {
		double choice = stream.nextDouble();
		double current = 0;
		for (SimInternalSelector selector : targetOptions) {
			current += selector.getProbability();
			if (choice <= current){
				selectedExpression = selector.getCapraExpression();
				break;
			}
		}
		next = 1;
	}

	/**
	 * @return
	 * @uml.property  name="next"
	 */
	@Override
	public SimCapraExpression getNext(SimCapraProcess process) {
		SimCapraExpression result = null;
		switch (next) {
		case 1:
			result = action;
			next++;
			break;
		case 2:
			result = selectedExpression;
			next++;
			break;
		}
		return result;
	}

	@Override
	public boolean isAction() {
		return false;
	}

	@Override
	public void setVarUsages(String name, SimCapraExpression behaviour) {
		for (SimInternalSelector option : targetOptions) {
			option.getCapraExpression().setVarUsages(name, behaviour);
		}
	}

	@Override
	public boolean hasNext() {
		return next < 3;
	}

	@Override
	public void addFinishingListener(IFinishingListener listener) {
		for (SimInternalSelector option : targetOptions) {
			option.getCapraExpression().addFinishingListener(listener);
		}
	}

}
