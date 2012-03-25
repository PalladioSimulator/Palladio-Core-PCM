package edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.loaddistribution.balancers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import de.uka.ipd.sdq.probfunction.math.util.MathTools;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.IResourceInstance;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.loaddistribution.ILoadBalancer;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.processes.IActiveProcess;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.queueing.strategies.MultipleQueuesStrategy;

public abstract class OriginalAbstractLoadBalancer implements ILoadBalancer {

	/**
	 * Minimum time that needs to pass between two load balancing attempts
	 */
	protected double balance_interval;

	/**
	 * If !do_global_balance, this table is used to track the time that passed
	 * since the last execution of a load balancer for an instance.
	 */
	protected Hashtable<IResourceInstance, Double> last_load;

	/**
	 * Holder of the runqueues that need to be balanced.
	 */
	protected MultipleQueuesStrategy queue_holder;

	/**
	 * Determines the order how movable processes are returned. If true, the
	 * priority of the processes is increasing, otherwise decreasing.
	 */
	protected boolean prio_increasing;

	/**
	 * Determines the order how movable processes are returned. If true, the
	 * first processes are returned in the same order of the queue, otherwise
	 * they are returned in reverse order.
	 */
	protected boolean queue_ascending;

	/**
	 * Creates a new instance of a load balancer.
	 * 
	 * @param balance_interval
	 *            Minimum time that needs to pass between two executions of the
	 *            load balancer.
	 * 
	 * @param do_global_balance
	 *            Indicates whether all instances should be balanced or only the
	 *            specified and busiest one.
	 * 
	 * @param prio_increasing
	 *            Determines the order how movable processes are returned. If
	 *            true, the priority of the processes is increasing, otherwise
	 *            decreasing.
	 * 
	 * @param queue_ascending
	 *            Determines the order how movable processes are returned. If
	 *            true, the first processes are returned in the same order of
	 *            the queue, otherwise they are returned in reverse order.
	 * 
	 * @param max_iterations
	 *            Gives the maximum number of iterations for a global balancing.
	 */
	protected OriginalAbstractLoadBalancer(double balance_interval,
			boolean do_global_balance, boolean prio_increasing,
			boolean queue_ascending, int max_iterations) {
		super();
		this.balance_interval = balance_interval;
		this.prio_increasing = prio_increasing;
		this.queue_ascending = queue_ascending;
		this.queue_holder = null;
		this.last_load = new Hashtable<IResourceInstance, Double>();
	}

	public void setQueueHolder(MultipleQueuesStrategy queue_holder) {
		this.queue_holder = queue_holder;
		for (IResourceInstance instance : queue_holder.getResourceInstances()) {
			this.last_load.put(instance, 0.0);
		}
	}

	/**
	 * Template Method. Checks if both queues are balanced with respect to a
	 * given criteria.
	 * 
	 * @param busyQueue
	 * @param idleQueue
	 * @return
	 */
	protected abstract boolean isBalanced(IResourceInstance firstInstance,
			IResourceInstance secondInstance);

	public void activelyBalance(IResourceInstance instance) {
		double load = queue_holder.getRunQueueFor(instance).getCurrentLoad();
		if (MathTools.less(0, Math.abs(load - last_load.get(instance)))) {
			doBalance(instance);
		}
		last_load.put(instance, load);
	}

	/**
	 * Moves processes from the src instance to the dest instance until both are
	 * balanced.
	 * 
	 * @param src
	 *            source instance of the processes moved
	 * @param dest
	 *            destination instance of the processes moved
	 */
	protected void balanceTwoInstances(IResourceInstance src,
			IResourceInstance dest, int max_processes_needed) {
		List<IActiveProcess> movable_process_list = identifyMovableProcesses(
				src, dest, max_processes_needed);
		Iterator<IActiveProcess> iterator = movable_process_list.iterator();

		while (iterator.hasNext() && load(src) > 1 && !isBalanced(src, dest)) {
			queue_holder.move(iterator.next(), src, dest);
		}

		src.schedulingInterrupt(0);
		dest.schedulingInterrupt(0);
	}

	/**
	 * Returns an ordered list of movable processes. The processes are ordered
	 * with respect to their "movability".
	 * 
	 * @return Ordered list of movable processes.
	 */
	protected List<IActiveProcess> identifyMovableProcesses(
			IResourceInstance source_instance,
			IResourceInstance target_instance, int processes_needed) {
		return queue_holder.getRunQueueFor(source_instance)
				.identifyMovableProcesses(target_instance, prio_increasing,
						queue_ascending, processes_needed);
	}

	/**
	 * Returns the load of the given instance.
	 * 
	 * @param instance
	 * @return
	 */
	protected int load(IResourceInstance instance) {
		int queueLength = queue_holder.getRunQueueFor(instance).getCurrentLoad();
		if(instance.getRunningProcess() != null){
			queueLength ++;
		} 
		return queueLength;
	}

	/**
	 * Returns the busiest queue in the given list.
	 * 
	 * @param runQueues
	 * @return
	 */
	protected IResourceInstance getBusiest(
			Collection<IResourceInstance> instance_list) {
		IResourceInstance busiest = null;
		for (IResourceInstance instance : instance_list) {
			if (busiest == null || load(instance) > load(busiest))
				busiest = instance;
		}
		return busiest;
	}

	/**
	 * Returns the idlest queue in the given list.
	 * 
	 * @param runQueues
	 * @return
	 */
	protected IResourceInstance getLaziest(
			Collection<IResourceInstance> instance_list) {
		IResourceInstance laziest = null;
		for (IResourceInstance instance : instance_list) {
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
		for (IResourceInstance instance : queue_holder.getResourceInstances()) {
			if (load(instance) > 1)
				busyQueues.add(instance);
		}
		return busyQueues;
	}

	/**
	 * Returns the maximum number of processes needed to balance both queues.
	 * 
	 * @param first_instance
	 * @param second_instance
	 * @return
	 */
	protected int numProcessedNeeded(IResourceInstance first_instance,
			IResourceInstance second_instance) {
		int firstLoad = load(first_instance);
		int secondLoad = load(second_instance);
		return Math.abs(firstLoad - secondLoad) / 2;
	}

	/**
	 * Balances the queue of the given instance and the queue of the busiest
	 * instance.
	 * 
	 * @param instance
	 */
	protected void doBalance(IResourceInstance instance) {
		IResourceInstance busiest = getBusiest(queue_holder
				.getResourceInstances());
		IResourceInstance idlest = getLaziest(queue_holder
				.getResourceInstances());
		if (!busiest.equals(instance) && !isBalanced(busiest, instance)
				&& load(busiest) > 1) {
			int max_processes_needed = numProcessedNeeded(busiest, instance);
			balanceTwoInstances(busiest, instance, max_processes_needed);
		} else if (!idlest.equals(instance) && !isBalanced(idlest, instance)
				&& load(instance) > 1) {
			int max_processes_needed = numProcessedNeeded(instance, idlest);
			balanceTwoInstances(instance, idlest, max_processes_needed);
		}
	}
}
