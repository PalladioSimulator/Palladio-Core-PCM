package de.uka.ipd.sdq.capra.simulator.resources_new;


public class SimpleRunQueue implements IRunQueue {

	/** 
	 * @uml.property name="processQueue"
	 * @uml.associationEnd aggregation="composite" inverse="simpleRunQueue:de.uka.ipd.sdq.capra.simulator.resources_new.ProcessQueue"
	 */
	private ProcessQueue<ActiveProcess> processQueue;

	/** 
	 * Getter of the property <tt>processQueue</tt>
	 * @return  Returns the processQueue.
	 * @uml.property  name="processQueue"
	 */
	public ProcessQueue<ActiveProcess> getProcessQueue() {
		return processQueue;
	}

	/** 
	 * Setter of the property <tt>processQueue</tt>
	 * @param processQueue  The processQueue to set.
	 * @uml.property  name="processQueue"
	 */
	public void setProcessQueue(ProcessQueue<ActiveProcess> processQueue) {
		this.processQueue = processQueue;
	}

	@Override
	public int getCurrentLoad() {
		// TODO Auto-generated method stub
		return 0;
	}

}
