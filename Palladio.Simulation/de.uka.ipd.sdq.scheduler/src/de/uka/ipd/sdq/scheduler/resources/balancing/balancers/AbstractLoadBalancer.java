package de.uka.ipd.sdq.scheduler.resources.balancing.balancers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import umontreal.iro.lecuyer.simevents.Sim;
import de.uka.ipd.sdq.scheduler.processes.ActiveProcess;
import de.uka.ipd.sdq.scheduler.resources.SimResourceInstance;
import de.uka.ipd.sdq.scheduler.resources.balancing.ILoadBalancer;
import de.uka.ipd.sdq.scheduler.resources.queueing.IRunQueue;
import de.uka.ipd.sdq.scheduler.resources.queueing.strategies.MultipleQueuesStrategy;

public abstract class AbstractLoadBalancer implements ILoadBalancer {

	/**
	 * @uml.property name="balanceInterval"
	 */
	protected double balanceInterval;

	/**
	 * @uml.property name="lastBalanced"
	 */
	protected double lastBalanced;

	protected MultipleQueuesStrategy runQueueHolder;

	public AbstractLoadBalancer(double balanceInterval,
			MultipleQueuesStrategy runQueueHolder) {
		super();
		this.balanceInterval = balanceInterval;
		this.lastBalanced = 0;
		this.runQueueHolder = runQueueHolder;
	}

	/**
	 * Checks if both queues are balanced with respect to a given criteria.
	 * Template Method.
	 * 
	 * @param busyQueue
	 * @param idleQueue
	 * @return
	 */
	protected abstract boolean isBalanced(SimResourceInstance firstInstance,
			SimResourceInstance secondInstance);

	@Override
	public void balance() {
		double now = Sim.time();
		if (now - lastBalanced >= balanceInterval) {
			doBalance();
			lastBalanced = now;
		}
	}

	/**
	 * Idle Processors look for the busiest runqueue. If the queue contains more
	 * than one task, they steal one.
	 */
	protected void doBalance() {
		Collection<SimResourceInstance> idleInstances = runQueueHolder.getIdleInstances();
		Collection<SimResourceInstance> busyInstances = getBusyInstances();
		for (Iterator<SimResourceInstance> iterator = idleInstances.iterator(); iterator
				.hasNext()
				&& !busyInstances.isEmpty();) {
			SimResourceInstance idleInstance = iterator.next();
			SimResourceInstance busiestInstance = getBusiestQueue(busyInstances);
			balanceTwoInstances(busiestInstance, idleInstance);
			if (!isBusy(busiestInstance))
				busyInstances.remove(busiestInstance);
		}

	}

	/**
	 * True, if the queue contains more than one process.
	 * 
	 * @param runQueue
	 * @return
	 */
	protected boolean isBusy(SimResourceInstance instance) {
		return runQueueHolder.getRunQueueFor(instance).getCurrentLoad() > 1;
	}

	/**
	 * Moves processes from the busy instance to the idle instance until both are balanced.
	 * @param busyInstance
	 * @param idleInstance
	 */
	protected void balanceTwoInstances(SimResourceInstance busyInstance,
			SimResourceInstance idleInstance) {
		List<ActiveProcess> movableProcesseList = identifyMovableProcesses(
				busyInstance, idleInstance);
		Iterator<ActiveProcess> iterator = movableProcesseList.iterator();

		while (!isBalanced(busyInstance, idleInstance) && iterator.hasNext()) {
			move(iterator.next(), busyInstance, idleInstance);
		}
	}

	/**
	 * Moves a process from the source to the destination queue.
	 * 
	 * @param process
	 * @param sourceQueue
	 * @param destinationQueue
	 */
	protected void move(ActiveProcess process, SimResourceInstance src,
			SimResourceInstance dest) {
		runQueueHolder.move(process, src, dest);
	}

	/**
	 * Returns an ordered list of movable processes. The processes are ordered
	 * with respect to their movability.
	 * 
	 * @param busyQueue
	 * @return Ordered list of movable processes.
	 */
	protected List<ActiveProcess> identifyMovableProcesses(
			SimResourceInstance sourceInstance,
			SimResourceInstance targetInstance) {
		return runQueueHolder.getRunQueueFor(sourceInstance).identifyMovableProcesses(targetInstance);
	}

	/**
	 * Returns the busiest queue in the given collection.
	 * 
	 * @param runQueues
	 * @return
	 */
	protected SimResourceInstance getBusiestQueue(
			Collection<SimResourceInstance> instances) {
		SimResourceInstance busiestInstance = null;
		Iterator<SimResourceInstance> iterator = instances.iterator();
		while (iterator.hasNext()) {
			SimResourceInstance currentInstance = iterator.next();
			if (busiestInstance == null
					|| load(busiestInstance) < load(currentInstance)) {
				busiestInstance = currentInstance;
			}
		}
		return busiestInstance;
	}

	/**
	 * Returns the load of the given instance.
	 * 
	 * @param instance
	 * @return
	 */
	protected int load(SimResourceInstance instance) {
		return runQueueHolder.getRunQueueFor(instance).getCurrentLoad();
	}

	/**
	 * Returns all queues with more than one job.
	 * 
	 * @param runQueueCollection
	 * @return
	 */
	protected Collection<SimResourceInstance> getBusyInstances() {
		Collection<SimResourceInstance> busyQueues = new ArrayList<SimResourceInstance>();
		for (SimResourceInstance instance : runQueueHolder
				.getResourceInstances()) {
			if (isBusy(instance))
				busyQueues.add(instance);
		}
		return busyQueues;
	}

}
