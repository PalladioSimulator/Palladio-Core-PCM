package de.uka.ipd.sdq.scheduler.queueing.strategies;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;

import de.uka.ipd.sdq.scheduler.balancing.IInstanceSelector;
import de.uka.ipd.sdq.scheduler.balancing.ILoadBalancer;
import de.uka.ipd.sdq.scheduler.processes.ActiveProcess;
import de.uka.ipd.sdq.scheduler.queueing.IQueueingStrategy;
import de.uka.ipd.sdq.scheduler.queueing.IRunQueue;
import de.uka.ipd.sdq.scheduler.resources.SimResourceInstance;

public class MultipleQueuesStrategy implements IQueueingStrategy {

	private ILoadBalancer loadBalancer;
	private IInstanceSelector instanceSelector;
	private Hashtable<SimResourceInstance, IRunQueue> runQueueTable;

	public MultipleQueuesStrategy(Collection<SimResourceInstance> allInstances,
			IRunQueue prototypeRunQueue,
			IInstanceSelector initialInstanceSelector,
			ILoadBalancer loadBalancer) {
		runQueueTable = new Hashtable<SimResourceInstance, IRunQueue>();
		this.instanceSelector = initialInstanceSelector;
		this.loadBalancer = loadBalancer;
		for (SimResourceInstance resourceInstance : allInstances) {
			runQueueTable.put(resourceInstance, prototypeRunQueue
					.createNewInstance());
		}
	}

	/**
	 * Returns the RunQueue for a resource instance.
	 */
	public IRunQueue getRunQueueFor(SimResourceInstance instance) {
		return runQueueTable.get(instance);
	}

	/**
	 * Returns the next runnable process for the resource instance.
	 */
	@Override
	public ActiveProcess getNextProcessFor(SimResourceInstance instance) {
		return getRunQueueFor(instance).getNextRunnableProcess();
	}

	/**
	 * Adds a process to the runqueue. The process is added using the strategy
	 * of the runqueue.
	 * 
	 * A process is added after its creation or after waiting.
	 */
	@Override
	public void addProcess(ActiveProcess process, boolean inFront) {
		SimResourceInstance instance = process.getLastInstance();
		if (instance == null) {
			instance = instanceSelector.selectInstanceFor(process);
			process.setLastInstance(instance);
		}
		getRunQueueFor(instance).addProcess(process, inFront);
	}

	/**
	 * Moves the given process from the runqueue of the src instance to the
	 * runqueue of the dest instance.
	 * 
	 * @param process
	 *            Process to be moved.
	 * @param src
	 *            Source resource instance.
	 * @param dest
	 *            Destination resource instance.
	 */
	public void move(ActiveProcess process, SimResourceInstance src,
			SimResourceInstance dest) {
		assert process.getLastInstance().equals(src);
		assert getRunQueueFor(src).contains(process) : "Process '" + process
				+ "' is not in the runqueue of '" + src + "'";
		assert process.getRunQueue() == getRunQueueFor(src) : "Invalid state of runqueues!";

		getRunQueueFor(src).removeProcess(process);
		getRunQueueFor(dest).addProcess(process, false);
	}

	@Override
	public void balance(SimResourceInstance instance) {
		loadBalancer.balance(instance);
	}

	public Collection<SimResourceInstance> getResourceInstances() {
		return this.runQueueTable.keySet();
	}

	public boolean isIdle(SimResourceInstance instance) {
		return getRunQueueFor(instance).isEmpty();
	}

	/**
	 * Returns all queues without jobs.
	 * 
	 * @param runQueueCollection
	 * @return
	 */
	public List<SimResourceInstance> getIdleInstances() {
		List<SimResourceInstance> idleInstances = new ArrayList<SimResourceInstance>();
		for (SimResourceInstance instance : getResourceInstances()) {
			if (isIdle(instance))
				idleInstances.add(instance);
		}
		return idleInstances;
	}

	@Override
	public boolean removePendingProcess(ActiveProcess process) {
		return getRunQueueFor(process.getLastInstance()).removePendingProcess(
				process);

	}

	@Override
	public boolean containsPending(ActiveProcess process) {
		return getRunQueueFor(process.getLastInstance()).containsPending(
				process);
	}

	@Override
	public void removeRunning(ActiveProcess process) {
		getRunQueueFor(process.getLastInstance()).removeRunning(process);
	}

	@Override
	public SimResourceInstance runningOn(ActiveProcess process) {
		for (SimResourceInstance instance : runQueueTable.keySet()) {
			if (runQueueTable.get(instance).containsRunning(process)) {
				return instance;
			}
		}
		return null;
	}

	@Override
	public void setRunningOn(ActiveProcess process, SimResourceInstance instance) {
		getRunQueueFor(instance).setRunningOn(process, instance);
	}
}