package de.uka.ipd.sdq.scheduler.resources.queueing.runqueues;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.scheduler.processes.ActiveProcess;
import de.uka.ipd.sdq.scheduler.resources.SimResourceInstance;
import de.uka.ipd.sdq.scheduler.resources.queueing.IRunQueue;
import de.uka.ipd.sdq.scheduler.resources.queueing.ProcessQueue;


public class SimpleRunQueue extends AbstractRunQueue {

	
	public SimpleRunQueue(){
		this.queue = new ProcessQueue<ActiveProcess>();
	}
	
	/**
	 * @uml.property   name="processQueue"
	 * @uml.associationEnd   aggregation="composite" inverse="simpleRunQueue:de.uka.ipd.sdq.capra.simulator.resources.ProcessQueue"
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

	@Override
	public List<ActiveProcess> identifyMovableProcesses(
			SimResourceInstance targetInstance) {
		List<ActiveProcess> processList = new ArrayList<ActiveProcess>();
		for (ActiveProcess process : this.queue) {
			if (process.checkAffinity(targetInstance)){
				processList.add(process);
			}
		}
		return processList;
	}

	@Override
	public ProcessQueue<ActiveProcess> getUrgentQueue(
			SimResourceInstance instance) {
		if (this.queue.containsRunnableFor(instance))
			return this.queue;
		return null;
	}

	@Override
	public ActiveProcess getNextRunnableProcess() {
		return queue.peek();
	}
}
