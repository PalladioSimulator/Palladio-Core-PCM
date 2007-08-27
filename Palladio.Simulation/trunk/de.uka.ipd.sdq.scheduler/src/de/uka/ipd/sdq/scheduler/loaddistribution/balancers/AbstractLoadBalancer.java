package de.uka.ipd.sdq.scheduler.loaddistribution.balancers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import umontreal.iro.lecuyer.simevents.Sim;
import de.uka.ipd.sdq.scheduler.IResourceInstance;
import de.uka.ipd.sdq.scheduler.loaddistribution.ILoadBalancer;
import de.uka.ipd.sdq.scheduler.processes.impl.ActiveProcess;
import de.uka.ipd.sdq.scheduler.queueing.strategies.MultipleQueuesStrategy;

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
	protected abstract boolean isBalanced(IResourceInstance firstInstance,
			IResourceInstance secondInstance);


	@Override
	public void balance(IResourceInstance instance) {
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
	protected void balanceTwoInstances(IResourceInstance src,
			IResourceInstance dest, int max_processes_needed) {
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
	protected void move(ActiveProcess process, IResourceInstance src,
			IResourceInstance dest) {
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
			IResourceInstance sourceInstance,
			IResourceInstance targetInstance, int processes_needed) {
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
	protected int load(IResourceInstance instance) {
		return queueHolder.getRunQueueFor(instance).getCurrentLoad();
	}
	
	/**
	 * Returns the busiest queue in the given list.
	 * 
	 * @param runQueues
	 * @return
	 */
	protected IResourceInstance getBusiest(Collection<IResourceInstance> instanceList) {
		IResourceInstance busiest = null;
		for (IResourceInstance instance : instanceList) {
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
	protected IResourceInstance getLaziest(Collection<IResourceInstance> instanceList) {
		IResourceInstance laziest = null;
		for (IResourceInstance instance : instanceList) {
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
	protected List<IResourceInstance> getInstancesWithMoreThanOneProcess() {
		List<IResourceInstance> busyQueues = new ArrayList<IResourceInstance>();
		for (IResourceInstance instance : queueHolder.getResourceInstances()) {
			if (load(instance) > 1)
				busyQueues.add(instance);
		}
		return busyQueues;
	}
	
	protected int numProcessedNeeded(IResourceInstance firstInstance,
			IResourceInstance secondInstance) {
		int firstLoad = load(firstInstance);
		int secondLoad = load(secondInstance);
		return Math.abs(firstLoad - secondLoad) / 2;
	}

	protected void doBalance(IResourceInstance instance) {
		IResourceInstance busiest = getBusiest(queueHolder.getResourceInstances());
		if( !busiest.equals(instance) && !isBalanced(busiest, instance) && load(busiest) > 1 ){
			int max_processes_needed = numProcessedNeeded(busiest, instance);
			balanceTwoInstances(busiest, instance, max_processes_needed);
		}
	}

	protected void doBalanceAll() {
		IResourceInstance busiest = getBusiest(queueHolder.getResourceInstances());
		IResourceInstance laziest = getLaziest(queueHolder.getResourceInstances());
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
