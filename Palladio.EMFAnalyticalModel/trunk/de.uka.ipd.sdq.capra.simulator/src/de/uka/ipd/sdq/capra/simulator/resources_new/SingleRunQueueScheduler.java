package de.uka.ipd.sdq.capra.simulator.resources_new;


public class SingleRunQueueScheduler implements IScheduler {

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
	public void schedule() {
		// TODO Auto-generated method stub
		
	}

}
