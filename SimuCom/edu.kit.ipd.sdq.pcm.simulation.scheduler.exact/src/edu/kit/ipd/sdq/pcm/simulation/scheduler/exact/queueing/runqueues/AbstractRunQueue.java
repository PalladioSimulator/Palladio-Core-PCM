package edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.queueing.runqueues;

import java.util.Hashtable;
import java.util.Map;

import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.IResourceInstance;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.processes.IActiveProcess;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.queueing.IRunQueue;

public abstract class AbstractRunQueue implements IRunQueue {

	protected Map<IActiveProcess, IResourceInstance> running_on_table;

	protected AbstractRunQueue() {
		running_on_table = new Hashtable<IActiveProcess, IResourceInstance>();
	}

	public int getCurrentLoad() {
		int running = running_on_table.size();
		int waiting = numWaitingProcesses(); 
		return running + waiting ;
	}

	public boolean isEmpty() {
		return getCurrentLoad() == 0;
	}

	public boolean removeProcess(IActiveProcess process) {
		return running_on_table.remove(process) != null
				|| removePendingProcess(process);
	}

	public boolean contains(IActiveProcess process) {
		return running_on_table.containsKey(process) || containsPending(process);
	}

	public void addProcess(IActiveProcess process, boolean inFront) {
		process.setRunQueue(this);
		addProcessToRunQueue(process,inFront);
	}
	
	public boolean containsRunning(IActiveProcess process) {
		return running_on_table.containsKey(process);
	}
	
	public void removeRunning(IActiveProcess process) {
		assert running_on_table.containsKey(process) : "Process '" + process + "' not running.";
		running_on_table.remove(process);
	}
	
	public void setRunningOn(IActiveProcess process, IResourceInstance instance) {
		assert running_on_table.get(process) == null;
		assert !running_on_table.values().contains(instance);
		running_on_table.put(process, instance);
	}
	
	public IResourceInstance runningOn(IActiveProcess process) {
		return running_on_table.get(process);
	}
	
	public boolean isIdle(IResourceInstance instance) {
		return !instance.processAssigned() 
			&& (running_on_table.size() > 1 || numWaitingProcesses() == 0);
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
