package de.uka.ipd.sdq.scheduler.balancing.balancers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import umontreal.iro.lecuyer.simevents.Sim;
import de.uka.ipd.sdq.scheduler.balancing.ILoadBalancer;
import de.uka.ipd.sdq.scheduler.processes.ActiveProcess;
import de.uka.ipd.sdq.scheduler.queueing.strategies.MultipleQueuesStrategy;
import de.uka.ipd.sdq.scheduler.resources.SimResourceInstance;

public abstract class AbstractLoadBalancer implements ILoadBalancer {

	protected double balanceInterval;

	protected double lastBalanced;

	protected MultipleQueuesStrategy queueHolder;

	protected boolean prio_increasing;

	protected boolean queue_ascending;

	private int max_iterations;
	

	public AbstractLoadBalancer(double balanceInterval,
			MultipleQueuesStrategy queueHolder, boolean prio_increasing,
			boolean queue_ascending, int max_iterations) {
		super();
		this.lastBalanced = 0;
		this.balanceInterval = balanceInterval;
		this.queueHolder = queueHolder;
		this.prio_increasing = prio_increasing;
		this.queue_ascending = queue_ascending;
		this.max_iterations = max_iterations;
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
	public void balance(SimResourceInstance instance) {
		double now = Sim.time();
		if (now - lastBalanced >= balanceInterval) {
			doBalance(instance);
			lastBalanced = now;
		}
	}

	/**
	 * Moves processes from the busy instance to the idle instance until both
	 * are balanced.
	 * 
	 * @param src
	 * @param dest
	 */
	protected void balanceTwoInstances(SimResourceInstance src,
			SimResourceInstance dest, int max_processes_needed) {
		List<ActiveProcess> movableProcesseList = identifyMovableProcesses(src,
				dest, max_processes_needed);
		Iterator<ActiveProcess> iterator = movableProcesseList.iterator();

		while ( iterator.hasNext() && load(src) > 1 && !isBalanced(src, dest) ) {
			move(iterator.next(), src, dest);
		}
		dest.scheduleSchedulingEvent(0);
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
		queueHolder.move(process, src, dest);
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
			SimResourceInstance targetInstance, int processes_needed) {
		return queueHolder.getRunQueueFor(sourceInstance)
				.identifyMovableProcesses(targetInstance, prio_increasing,
						queue_ascending, processes_needed);
	}

	/**
	 * Returns the load of the given instance.
	 * 
	 * @param instance
	 * @return
	 */
	protected int load(SimResourceInstance instance) {
		return queueHolder.getRunQueueFor(instance).getCurrentLoad();
	}
	
	/**
	 * Returns the busiest queue in the given list.
	 * 
	 * @param runQueues
	 * @return
	 */
	protected SimResourceInstance getBusiest(Collection<SimResourceInstance> instanceList) {
		SimResourceInstance busiest = null;
		for (SimResourceInstance instance : instanceList) {
			if (busiest == null || load(instance) > load(busiest))
				busiest = instance;
		}
		return busiest;
	}

	
	/**
	 * Returns the laziest queue in the given list.
	 * 
	 * @param runQueues
	 * @return
	 */
	protected SimResourceInstance getLaziest(Collection<SimResourceInstance> instanceList) {
		SimResourceInstance laziest = null;
		for (SimResourceInstance instance : instanceList) {
			if (laziest == null || load(instance) < load(laziest))
				laziest = instance;
		}
		return laziest;
	}
	
	/**
	 * Returns all queues with more than one job.
	 * 
	 * @param runQueueCollection
	 * @return
	 */
	protected List<SimResourceInstance> getInstancesWithMoreThanOneProcess() {
		List<SimResourceInstance> busyQueues = new ArrayList<SimResourceInstance>();
		for (SimResourceInstance instance : queueHolder.getResourceInstances()) {
			if (load(instance) > 1)
				busyQueues.add(instance);
		}
		return busyQueues;
	}
	
	protected int numProcessedNeeded(SimResourceInstance firstInstance,
			SimResourceInstance secondInstance) {
		int firstLoad = load(firstInstance);
		int secondLoad = load(secondInstance);
		return Math.abs(firstLoad - secondLoad) / 2;
	}

	protected void doBalance(SimResourceInstance instance) {
		SimResourceInstance busiest = getBusiest(queueHolder.getResourceInstances());
		if( !busiest.equals(instance) && !isBalanced(busiest, instance) && load(busiest) > 1 ){
			int max_processes_needed = numProcessedNeeded(busiest, instance);
			balanceTwoInstances(busiest, instance, max_processes_needed);
		}
	}

	protected void doBalanceAll() {
		SimResourceInstance busiest = getBusiest(queueHolder.getResourceInstances());
		SimResourceInstance laziest = getLaziest(queueHolder.getResourceInstances());
		int i=0;
		while( !busiest.equals(laziest) && !isBalanced(busiest, laziest) && load(busiest) > 1 && i < max_iterations){
			int max_processes_needed = numProcessedNeeded(busiest, laziest);
			balanceTwoInstances(busiest, laziest, max_processes_needed);
			busiest = getBusiest(queueHolder.getResourceInstances());
			laziest = getLaziest(queueHolder.getResourceInstances());
			i++;
		}
	}
}
