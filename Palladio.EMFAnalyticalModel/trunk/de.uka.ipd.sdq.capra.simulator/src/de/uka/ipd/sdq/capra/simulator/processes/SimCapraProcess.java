package de.uka.ipd.sdq.capra.simulator.processes;

import java.util.Stack;

import umontreal.iro.lecuyer.simevents.Event;
import de.uka.ipd.sdq.capra.simulator.actions.SimAction;
import de.uka.ipd.sdq.capra.simulator.expressions.SimCapraExpression;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;

/**
 * @author     jens.happe
 */
public class SimCapraProcess implements ISchedulableProcess {

	protected String name;
	protected String id;
	protected int number;
	protected SimCapraExpression behaviour;
	protected Stack<SimCapraExpression> executionStack = new Stack<SimCapraExpression>();

	public SimCapraProcess(SimCapraExpression capraExpression, String name, String id, int number) {
		super();
		this.behaviour = capraExpression;
		this.name = name;
		this.id = id;
		this.number = number;
	}
	
	/*
	 * Simplified Iterator Pattern. Null if there is no further action.
	 */
	public SimAction getNextAction(){
		SimCapraExpression nextExpression = executionStack.peek().getNext();
		while ((nextExpression == null) && ( executionStack.size() > 1)){
			executionStack.pop();
			nextExpression = executionStack.peek().getNext();
		}
		if (nextExpression != null){
			while (!nextExpression.isAction()){
				nextExpression.reset();
				executionStack.push(nextExpression);
				nextExpression = nextExpression.getNext();
			}
			return (SimAction)nextExpression;
		} else {
			return null;
		}
	}
	
	public void start(double startTime){
		executionStack.clear();
		behaviour.reset();
		executionStack.push(behaviour);
		new StartProcessEvent(this).schedule(startTime);
	}
	
	public void activate(){
		SimAction nextAction = getNextAction();
		if (nextAction == null){ // reset process
			executionStack.clear();
			behaviour.reset();
			executionStack.push(behaviour);
			nextAction = getNextAction();			
		}
		nextAction.execute(this);
	}
	
	@Override
	public void passivate() {
		// nothing to do.
	}

	public String getName() {
		return name +  "_" + number;
	}
	
	public String getId(){
		return id + number;
	}

	@Override
	public boolean equals(Object arg0) {
		if (arg0 instanceof SimCapraProcess) {
			SimCapraProcess process = (SimCapraProcess) arg0;
			return this.getId().equals(process.getId());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return getId().hashCode();
	}

	@Override
	public String toString() {
		return getName();
	}

	private class StartProcessEvent extends Event {
		
		private SimCapraProcess process;
		
		public StartProcessEvent(SimCapraProcess process) {
			super();
			this.process = process;
		}

		@Override
		public void actions() {
			process.activate();
		}
	}
}
