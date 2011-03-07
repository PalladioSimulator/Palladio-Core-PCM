package de.uka.ipd.sdq.capra.simulator.processes;

import java.util.Stack;

import umontreal.iro.lecuyer.simevents.Event;
import de.uka.ipd.sdq.capra.simulator.actions.SimAction;
import de.uka.ipd.sdq.capra.simulator.expressions.IFinishingListener;
import de.uka.ipd.sdq.capra.simulator.expressions.SimCapraExpression;
import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.factory.SchedulingFactory;
import de.uka.ipd.sdq.scheduler.resources.active.SimActiveResource;

/**
 * @author jens.happe
 */
public class SimCapraProcess implements ISchedulableProcess, Cloneable {

	protected String name;
	protected String id;
	protected int number;
	protected SimCapraExpression behaviour;
	protected Stack<SimCapraExpression> executionStack = new Stack<SimCapraExpression>();
	protected static int global_number = 0;
	protected SimCapraProcess ancestor;
	private SimCapraProcess parent;
	private SimActiveResource last_resource;

	public SimCapraProcess(SimCapraExpression capraExpression, String name,
			String id, SimCapraProcess ancestor) {
		super();
		this.behaviour = capraExpression;
		this.name = name;
		global_number++;
		this.number = global_number;
		this.id = id;
		this.ancestor = ancestor;
		this.parent = null;
	}

	/*
	 * Simplified Iterator Pattern. Null if there is no further action.
	 */
	public SimAction getNextAction() {
		SimCapraExpression nextExpression = executionStack.peek().getNext(this);
		while ((nextExpression == null) && (executionStack.size() > 1)) {
			executionStack.pop();
			nextExpression = executionStack.peek().getNext(this);
		}
		while (nextExpression != null && !nextExpression.isAction()) {
			nextExpression.reset();
			executionStack.push(nextExpression);
			nextExpression = nextExpression.getNext(this);
		}
		return (SimAction) nextExpression;
	}

	public void start(double startTime) {
		executionStack.clear();
		behaviour.reset();
		executionStack.push(behaviour);
		new StartProcessEvent(this).schedule(startTime);
	}

	public void activate() {
		SimAction nextAction = getNextAction();
		if (nextAction != null)
			nextAction.execute(this);
	}

	@Override
	public void passivate() {
	}

	public String getName() {
		return name + "_" + number;
	}
	
	public String getPlainName() {
		return name;
	}

	public String getId() {
		return id + number;
	}
	
	public String getPlainId(){
		return id;
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
			super(SchedulingFactory.getUsedSimulator());
			this.process = process;
		}

		@Override
		public void actions() {
			process.activate();
		}
	}

	@Override
	public SimCapraProcess clone() {
		return new SimCapraProcess(behaviour.clone(), name, id, ancestor);
	}

	public void reset() {
		behaviour.reset();
	}

	public SimCapraExpression getBehaviour() {
		return behaviour;
	}

	public SimCapraProcess getAncestor() {
		return ancestor;
	}

	public void setAncestor(SimCapraProcess parent) {
		this.ancestor = parent;
	}
	
	public void setBehaviour(SimCapraExpression behaviour){
		this.behaviour = behaviour;
		this.executionStack.clear();
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public boolean isFinished() {
		return executionStack.size() <= 1 &&  !executionStack.peek().hasNext();
	}

	public void setParent(SimCapraProcess process) {
		parent = process;
	}

	public void addFinishingListener(
			IFinishingListener listener) {
		this.behaviour.addFinishingListener(listener);
	}

	public SimCapraProcess getParent() {
		return  parent;
	}

	public void setMainResource(SimActiveResource resource) {
		last_resource = resource;
	}
	
	public SimActiveResource getMainResource(){
		return last_resource;
	}

}
