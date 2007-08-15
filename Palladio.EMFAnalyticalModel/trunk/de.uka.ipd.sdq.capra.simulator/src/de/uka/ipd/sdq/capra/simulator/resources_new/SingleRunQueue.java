package de.uka.ipd.sdq.capra.simulator.resources_new;



public class SingleRunQueue implements IQueueingStrategy  {

	/** 
	 * @uml.property name="runQueue"
	 * @uml.associationEnd aggregation="composite" inverse="singleRunQueueScheduler:de.uka.ipd.sdq.capra.simulator.resources_new.IRunQueue"
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
		return null;
	}

	@Override
	public void addNewProcess(ActiveProcess process) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @uml.property  name="processSelector"
	 * @uml.associationEnd  inverse="singleRunQueue:de.uka.ipd.sdq.capra.simulator.resources_new.IProcessSelector"
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
