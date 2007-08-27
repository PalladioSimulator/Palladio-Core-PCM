package de.uka.ipd.sdq.scheduler.queueing.runqueues;

import java.util.Hashtable;
import java.util.Map;

import de.uka.ipd.sdq.scheduler.processes.ActiveProcess;
import de.uka.ipd.sdq.scheduler.queueing.IRunQueue;
import de.uka.ipd.sdq.scheduler.resources.SimResourceInstance;

public abstract class AbstractRunQueue implements IRunQueue {

	protected Map<ActiveProcess, SimResourceInstance> runningOnTable;

	protected AbstractRunQueue() {
		runningOnTable = new Hashtable<ActiveProcess, SimResourceInstance>();
	}

	public int getCurrentLoad() {
		return runningOnTable.size() + numWaitingProcesses();
	}

	public boolean isEmpty() {
		return getCurrentLoad() == 0;
	}

	public boolean removeProcess(ActiveProcess process) {
		return runningOnTable.remove(process) != null
				|| removePendingProcess(process);
	}

	@Override
	public boolean contains(ActiveProcess process) {
		return runningOnTable.containsKey(process) || containsPending(process);
	}

	public void addProcess(ActiveProcess process, boolean inFront) {
		process.setRunQueue(this);
		addProcessToRunQueue(process,inFront);
	}
	
	@Override
	public boolean containsRunning(ActiveProcess process) {
		return runningOnTable.containsKey(process);
	}
	
	@Override
	public void removeRunning(ActiveProcess process) {
		runningOnTable.remove(process);
	}
	
	@Override
	public void setRunningOn(ActiveProcess process, SimResourceInstance instance) {
		runningOnTable.put(process, instance);
	}
	
	@Override
	public SimResourceInstance runningOn(ActiveProcess process) {
		return runningOnTable.get(process);
	}

	public abstract ActiveProcess getNextRunnableProcess(
			SimResourceInstance instance);

	/**
	 * Template Method. Returns
	 * 
	 * @param process
	 * @return
	 */
	public abstract boolean containsPending(ActiveProcess process);

	/**
	 * Template Method. Returns the number of processs waiting in the queue.
	 * 
	 * @return
	 */
	protected abstract int numWaitingProcesses();

	/**
	 * Template method. Removes the given process from the queue.
	 * 
	 * @param process
	 */
	public abstract boolean removePendingProcess(ActiveProcess process);

	/**
	 * Template method.
	 * 
	 * @param process
	 * @param inFront TODO
	 */
	protected abstract void addProcessToRunQueue(ActiveProcess process, boolean inFront);

}
