package de.uka.ipd.sdq.capra.simulator.resources_new;


public class SimpleRunQueue implements IRunQueue {

	/** 
	 * @uml.property name="processQueue"
	 * @uml.associationEnd aggregation="composite" inverse="simpleRunQueue:de.uka.ipd.sdq.capra.simulator.resources_new.IProcessQueue"
	 */
	private IProcessQueue processQueue;

	/** 
	 * Getter of the property <tt>processQueue</tt>
	 * @return  Returns the processQueue.
	 * @uml.property  name="processQueue"
	 */
	public IProcessQueue getProcessQueue() {
		return processQueue;
	}

	/** 
	 * Setter of the property <tt>processQueue</tt>
	 * @param processQueue  The processQueue to set.
	 * @uml.property  name="processQueue"
	 */
	public void setProcessQueue(IProcessQueue processQueue) {
		this.processQueue = processQueue;
	}

}
