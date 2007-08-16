package de.uka.ipd.sdq.capra.simulator.resources;



public class SingleRunQueue implements IQueueingStrategy  {
	
	
	public SingleRunQueue(IRunQueue runQueue, IProcessSelector processSelector) {
		super();
		this.runQueue = runQueue;
		this.processSelector = processSelector;
	}
	

	/**
	 * @uml.property   name="runQueue"
	 * @uml.associationEnd   aggregation="composite" inverse="singleRunQueueScheduler:de.uka.ipd.sdq.capra.simulator.resources.IRunQueue"
	 */
	private IRunQueue runQueue;

	/** 
	 * Getter of the property <tt>runQueue</tt>
	 * @return  Returns the runQueue.
	 * @uml.property  name="runQueue"
	 */
	public IRunQueue getRunQueue() {
		return runQueue;
	}

	/** 
	 * Setter of the property <tt>runQueue</tt>
	 * @param runQueue  The runQueue to set.
	 * @uml.property  name="runQueue"
	 */
	public void setRunQueue(IRunQueue runQueue) {
		this.runQueue = runQueue;
	}

	@Override
	public ActiveProcess getNextProcessFor(SimResourceInstance instance) {
		return processSelector.select(instance);
	}

	@Override
	public void addNewProcess(ActiveProcess process) {
		runQueue.addProcess(process);
	}

	/**
	 * @uml.property   name="processSelector"
	 * @uml.associationEnd   inverse="singleRunQueue:de.uka.ipd.sdq.capra.simulator.resources.IProcessSelector"
	 */
	private IProcessSelector processSelector;

	/**
	 * Getter of the property <tt>processSelector</tt>
	 * @return  Returns the processSelector.
	 * @uml.property  name="processSelector"
	 */
	public IProcessSelector getProcessSelector() {
		return processSelector;
	}

	/**
	 * Setter of the property <tt>processSelector</tt>
	 * @param processSelector  The processSelector to set.
	 * @uml.property  name="processSelector"
	 */
	public void setProcessSelector(IProcessSelector processSelector) {
		this.processSelector = processSelector;
	}

}
