package de.uka.ipd.sdq.capra.simulator.resources;

public abstract class AbstractWaitingPolicy {

	/**
	 * @uml.property   name="waitingQueue"
	 * @uml.associationEnd   aggregation="composite" inverse="abstractWaitingPolicy:de.uka.ipd.sdq.capra.simulator.resources.ProcessQueue"
	 */
	private ProcessQueue<WaitingProcess> waitingQueue;

	/**
	 * Getter of the property <tt>waitingQueue</tt>
	 * 
	 * @return Returns the waitingQueue.
	 * @uml.property name="waitingQueue"
	 */
	public ProcessQueue<WaitingProcess> getWaitingQueue() {
		return waitingQueue;
	}

	/**
	 * Setter of the property <tt>waitingQueue</tt>
	 * 
	 * @param waitingQueue
	 *            The waitingQueue to set.
	 * @uml.property name="waitingQueue"
	 */
	public void setWaitingQueue(ProcessQueue<WaitingProcess> waitingQueue) {
		this.waitingQueue = waitingQueue;
	}

	public abstract boolean canProceed(ActiveProcess currentProcess);

	public abstract void notifyWaiting();

	/**
	 * @uml.property   name="passiveResource"
	 * @uml.associationEnd   inverse="waitingPolicy:de.uka.ipd.sdq.capra.simulator.resources.SimPassiveResource"
	 */
	private SimPassiveResource passiveResource;

	/**
	 * Getter of the property <tt>passiveResource</tt>
	 * 
	 * @return Returns the passiveResource.
	 * @uml.property name="passiveResource"
	 */
	public SimPassiveResource getPassiveResource() {
		return passiveResource;
	}

	/**
	 * Setter of the property <tt>passiveResource</tt>
	 * 
	 * @param passiveResource
	 *            The passiveResource to set.
	 * @uml.property name="passiveResource"
	 */
	public void setPassiveResource(SimPassiveResource passiveResource) {
		this.passiveResource = passiveResource;
	}

	/**
	 */
	public void enqueue(ActiveProcess process, int numRequested) {
	}

}
