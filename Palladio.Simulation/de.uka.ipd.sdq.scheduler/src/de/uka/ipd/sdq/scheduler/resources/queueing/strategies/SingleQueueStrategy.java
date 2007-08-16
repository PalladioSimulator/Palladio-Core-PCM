package de.uka.ipd.sdq.scheduler.resources.queueing.strategies;

import de.uka.ipd.sdq.scheduler.processes.ActiveProcess;
import de.uka.ipd.sdq.scheduler.resources.SimResourceInstance;
import de.uka.ipd.sdq.scheduler.resources.balancing.IProcessSelector;
import de.uka.ipd.sdq.scheduler.resources.queueing.IQueueingStrategy;
import de.uka.ipd.sdq.scheduler.resources.queueing.IRunQueue;



public class SingleQueueStrategy implements IQueueingStrategy  {
	
	/**
	 * @uml.property   name="runQueue"
	 * @uml.associationEnd   aggregation="composite" inverse="singleRunQueueScheduler:de.uka.ipd.sdq.capra.simulator.resources.IRunQueue"
	 */
	private IRunQueue runQueue;
	
	/**
	 * @uml.property   name="processSelector"
	 * @uml.associationEnd   inverse="singleRunQueue:de.uka.ipd.sdq.capra.simulator.resources.IProcessSelector"
	 */
	private IProcessSelector processSelector;

	public SingleQueueStrategy(IRunQueue runQueue, IProcessSelector processSelector) {
		super();
		this.runQueue = runQueue;
		this.processSelector = processSelector;
	}
	
	@Override
	public ActiveProcess getNextProcessFor(SimResourceInstance instance) {
		return processSelector.select(runQueue, instance);
	}

	@Override
	public void addProcess(ActiveProcess process) {
		runQueue.addProcess(process);
	}

	@Override
	public void balance() {
		// nothing to do.
	}

	@Override
	public ActiveProcess getProcessRunningOn(SimResourceInstance instance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void returnActive(ActiveProcess running, boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void returnExpired(ActiveProcess running, boolean b) {
		// TODO Auto-generated method stub
		
	}
}
