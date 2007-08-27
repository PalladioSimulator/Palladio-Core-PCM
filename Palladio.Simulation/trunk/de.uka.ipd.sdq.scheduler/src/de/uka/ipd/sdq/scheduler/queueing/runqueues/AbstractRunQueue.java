package de.uka.ipd.sdq.scheduler.queueing.runqueues;

import java.util.Hashtable;
import java.util.Map;

import de.uka.ipd.sdq.scheduler.processes.IActiveProcess;
import de.uka.ipd.sdq.scheduler.queueing.IRunQueue;
import de.uka.ipd.sdq.scheduler.resources.IResourceInstance;

public abstract class AbstractRunQueue implements IRunQueue {

	protected Map<IActiveProcess, IResourceInstance> running_on_table;

	protected AbstractRunQueue() {
		running_on_table = new Hashtable<IActiveProcess, IResourceInstance>();
	}

	public int getCurrentLoad() {
		return running_on_table.size() + numWaitingProcesses();
	}

	public boolean isEmpty() {
		return getCurrentLoad() == 0;
	}

	public boolean removeProcess(IActiveProcess process) {
		return running_on_table.remove(process) != null
				|| removePendingProcess(process);
	}

	@Override
	public boolean contains(IActiveProcess process) {
		return running_on_table.containsKey(process) || containsPending(process);
	}

	public void addProcess(IActiveProcess process, boolean inFront) {
		process.setRunQueue(this);
		addProcessToRunQueue(process,inFront);
	}
	
	@Override
	public boolean containsRunning(IActiveProcess process) {
		return running_on_table.containsKey(process);
	}
	
	@Override
	public void removeRunning(IActiveProcess process) {
		running_on_table.remove(process);
	}
	
	@Override
	public void setRunningOn(IActiveProcess process, IResourceInstance instance) {
		assert running_on_table.get(process) == null;
		running_on_table.put(process, instance);
	}
	
	@Override
	public IResourceInstance runningOn(IActiveProcess process) {
		return running_on_table.get(process);
	}

	public abstract IActiveProcess getNextRunnableProcess(
			IResourceInstance instance);

	/**
	 * Template Method. Returns
	 * 
	 * @param process
	 * @return
	 */
	public abstract boolean containsPending(IActiveProcess process);

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
	public abstract boolean removePendingProcess(IActiveProcess process);

	/**
	 * Template method.
	 * 
	 * @param process
	 * @param inFront 
	 */
	protected abstract void addProcessToRunQueue(IActiveProcess process, boolean inFront);

}
