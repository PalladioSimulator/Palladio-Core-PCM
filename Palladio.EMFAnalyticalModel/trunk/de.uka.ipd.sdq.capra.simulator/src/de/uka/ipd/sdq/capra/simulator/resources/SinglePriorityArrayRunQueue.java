package de.uka.ipd.sdq.capra.simulator.resources;


public class SinglePriorityArrayRunQueue extends AbstractRunQueue {
	
	private IPriorityManager priorityManager;
	
	public SinglePriorityArrayRunQueue(IPriorityManager priorityManager){
		this.priorityManager = priorityManager;
		this.priorityArray = new PriorityArray(priorityManager);
	}
	

	/**
	 * @uml.property   name="priorityArray"
	 * @uml.associationEnd   aggregation="composite" inverse="singlePriorityArrayRunQueue:de.uka.ipd.sdq.capra.simulator.resources.PriorityArray"
	 */
	private PriorityArray priorityArray;

	/** 
	 * Getter of the property <tt>priorityArray</tt>
	 * @return  Returns the priorityArray.
	 * @uml.property  name="priorityArray"
	 */
	public PriorityArray getPriorityArray() {
		return priorityArray;
	}

	/** 
	 * Setter of the property <tt>priorityArray</tt>
	 * @param priorityArray  The priorityArray to set.
	 * @uml.property  name="priorityArray"
	 */
	public void setPriorityArray(PriorityArray priorityArray) {
		this.priorityArray = priorityArray;
	}

	/**
	 * Adds the process to the end of the priority array's queue.
	 */
	@Override
	public void addProcess(ActiveProcess process) {
		priorityArray.addLast(process);
	}

	@Override
	protected int numWaitingProcesses() {
		return priorityArray.getNumberOfProcesses();
	}

	@Override
	protected ActiveProcess pollNextRunnableProcess() {
		if(priorityArray.isEmpty())
			return null;
		return priorityArray.getNonEmptyQueueWithHighestPriority().poll();
	}

	@Override
	protected void removePendingProcess(ActiveProcess process) {
		priorityArray.removeProcess(process);
	}

	@Override
	public void returnExpiredProcess(ActiveProcess process, boolean inFront) {
		returnProcess(process,inFront);
	}

	@Override
	public void returnActiveProcess(ActiveProcess process, boolean inFront) {
		returnProcess(process, inFront);
		
	}
	private void returnProcess(ActiveProcess process, boolean inFront) {
		if(inFront){
			priorityArray.addFirst(process);
		} else {
			priorityArray.addLast(process);
		}
	}

	@Override
	public IRunQueue createNewInstance() {
		return new SinglePriorityArrayRunQueue(priorityManager);
	}
}
