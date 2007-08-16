package de.uka.ipd.sdq.scheduler.resources.queueing;

import de.uka.ipd.sdq.scheduler.processes.ActiveProcess;
import de.uka.ipd.sdq.scheduler.resources.SimResourceInstance;
import de.uka.ipd.sdq.scheduler.resources.balancing.IProcessSelector;



public class SingleRunQueue implements IQueueingStrategy  {
	
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

	public SingleRunQueue(IRunQueue runQueue, IProcessSelector processSelector) {
		super();
		this.runQueue = runQueue;
		this.processSelector = processSelector;
	}
	
	@Override
	public ActiveProcess getNextProcessFor(SimResourceInstance instance) {
		return processSelector.select(instance);
	}

	@Override
	public void addNewProcess(ActiveProcess process) {
		runQueue.addProcess(process);
	}

	@Override
	public void balance() {
		// nothing to do.
	}
}
