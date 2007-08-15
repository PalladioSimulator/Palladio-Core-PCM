package de.uka.ipd.sdq.capra.simulator.resources_new;


public class SimpleRunQueue extends AbstractRunQueue {

	
	public SimpleRunQueue(){
		this.queue = new ProcessQueue<ActiveProcess>();
	}
	
	/** 
	 * @uml.property name="processQueue"
	 * @uml.associationEnd aggregation="composite" inverse="simpleRunQueue:de.uka.ipd.sdq.capra.simulator.resources_new.ProcessQueue"
	 */
	private ProcessQueue<ActiveProcess> queue;

	
	/**
	 * Adds a process at the end of the run queue.
	 */
	@Override
	public void addProcess(ActiveProcess process) {
		queue.addLast(process);
	}

	@Override
	protected int numWaitingProcesses() {
		return queue.getNumberOfProcesses();
	}

	@Override
	protected ActiveProcess pollNextRunnableProcess() {
		// TODO: Consider Instances!
		return queue.poll();
	}

	@Override
	protected void removePendingProcess(ActiveProcess process) {
		queue.remove(process);
	}

	@Override
	public void returnActiveProcess(ActiveProcess process, boolean inFront) {
		returnProcess(process,inFront);
	}

	@Override
	public void returnExpiredProcess(ActiveProcess process, boolean inFront) {
		returnProcess(process,inFront);
	}

	private void returnProcess(ActiveProcess process, boolean inFront) {
		if (inFront){
			queue.addFirst(process);
		} else {
			queue.addLast(process);
		}
	}

	@Override
	public IRunQueue createNewInstance() {
		return new SimpleRunQueue();
	}
}
