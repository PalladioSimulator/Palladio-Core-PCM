package de.uka.ipd.sdq.capra.simulator.expressions;

import java.util.Stack;

import umontreal.iro.lecuyer.simevents.Event;

public class SimCapraProcess {

	SimCapraExpression behaviour;
	String name;
	Stack<SimCapraExpression> executionStack = new Stack<SimCapraExpression>();
	
	public SimCapraProcess(SimCapraExpression capraExpression, String name) {
		super();
		this.behaviour = capraExpression;
		this.name = name;
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
	
	public void proceed(){
		SimAction nextAction = getNextAction();
		if (nextAction == null){ // reset process
			executionStack.clear();
			behaviour.reset();
			executionStack.push(behaviour);
			nextAction = getNextAction();			
		}
		nextAction.execute(this);
	}
	
	private class StartProcessEvent extends Event {
		
		private SimCapraProcess process;
		
		public StartProcessEvent(SimCapraProcess process) {
			super();
			this.process = process;
		}

		@Override
		public void actions() {
			SimAction action = process.getNextAction();
			action.execute(process);
		}
	}

	public String getName() {
		return name;
	}
}
