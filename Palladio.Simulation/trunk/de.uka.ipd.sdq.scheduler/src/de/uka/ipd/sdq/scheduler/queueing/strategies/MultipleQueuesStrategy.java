package de.uka.ipd.sdq.scheduler.queueing.strategies;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;

import de.uka.ipd.sdq.scheduler.loaddistribution.IInstanceSelector;
import de.uka.ipd.sdq.scheduler.loaddistribution.ILoadBalancer;
import de.uka.ipd.sdq.scheduler.processes.IActiveProcess;
import de.uka.ipd.sdq.scheduler.queueing.IQueueingStrategy;
import de.uka.ipd.sdq.scheduler.queueing.IRunQueue;
import de.uka.ipd.sdq.scheduler.resources.IResourceInstance;

public class MultipleQueuesStrategy implements IQueueingStrategy {

	private ILoadBalancer loadBalancer;
	private IInstanceSelector instanceSelector;
	private Hashtable<IResourceInstance, IRunQueue> runQueueTable;

	public MultipleQueuesStrategy(Collection<IResourceInstance> allInstances,
			IRunQueue prototypeRunQueue,
			IInstanceSelector initialInstanceSelector,
			ILoadBalancer loadBalancer) {
		runQueueTable = new Hashtable<IResourceInstance, IRunQueue>();
		this.instanceSelector = initialInstanceSelector;
		this.loadBalancer = loadBalancer;
		for (IResourceInstance resourceInstance : allInstances) {
			runQueueTable.put(resourceInstance, prototypeRunQueue
					.createNewInstance());
		}
	}

	/**
	 * Returns the RunQueue for a resource instance.
	 */
	public IRunQueue getRunQueueFor(IResourceInstance instance) {
		return runQueueTable.get(instance);
	}

	/**
	 * Returns the next runnable process for the resource instance.
	 */
	@Override
	public IActiveProcess getNextProcessFor(IResourceInstance instance) {
		return getRunQueueFor(instance).getNextRunnableProcess();
	}

	/**
	 * Adds a process to the runqueue. The process is added using the strategy
	 * of the runqueue.
	 * 
	 * A process is added after its creation or after waiting.
	 */
	@Override
	public void addProcess(IActiveProcess process, boolean inFront) {
		IResourceInstance instance = process.getLastInstance();
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
	public void move(IActiveProcess process, IResourceInstance src,
			IResourceInstance dest) {
		assert process.getLastInstance().equals(src);
		assert getRunQueueFor(src).contains(process) : "Process '" + process
				+ "' is not in the runqueue of '" + src + "'";
		assert process.getRunQueue() == getRunQueueFor(src) : "Invalid state of runqueues!";

		getRunQueueFor(src).removeProcess(process);
		getRunQueueFor(dest).addProcess(process, false);
		// Set the ideal instance of the process to the new resource instance.
		// TODO Is this necessary?
		process.setIdealInstance(dest);
	}

	@Override
	public void balance(IResourceInstance instance) {
		loadBalancer.balance(instance);
	}

	public Collection<IResourceInstance> getResourceInstances() {
		return this.runQueueTable.keySet();
	}

	public boolean isIdle(IResourceInstance instance) {
		return getRunQueueFor(instance).isEmpty();
	}

	/**
	 * Returns all queues without jobs.
	 * 
	 * @param runQueueCollection
	 * @return
	 */
	public List<IResourceInstance> getIdleInstances() {
		List<IResourceInstance> idleInstances = new ArrayList<IResourceInstance>();
		for (IResourceInstance instance : getResourceInstances()) {
			if (isIdle(instance))
				idleInstances.add(instance);
		}
		return idleInstances;
	}

	@Override
	public boolean removePendingProcess(IActiveProcess process) {
		return getRunQueueFor(process.getLastInstance()).removePendingProcess(
				process);

	}

	@Override
	public boolean containsPending(IActiveProcess process) {
		return getRunQueueFor(process.getLastInstance()).containsPending(
				process);
	}

	@Override
	public void removeRunning(IActiveProcess process) {
		getRunQueueFor(process.getLastInstance()).removeRunning(process);
	}

	@Override
	public IResourceInstance runningOn(IActiveProcess process) {
		for (IResourceInstance instance : runQueueTable.keySet()) {
			if (runQueueTable.get(instance).containsRunning(process)) {
				return instance;
			}
		}
		return null;
	}

	@Override
	public void setRunningOn(IActiveProcess process, IResourceInstance instance) {
		getRunQueueFor(instance).setRunningOn(process, instance);
	}
}