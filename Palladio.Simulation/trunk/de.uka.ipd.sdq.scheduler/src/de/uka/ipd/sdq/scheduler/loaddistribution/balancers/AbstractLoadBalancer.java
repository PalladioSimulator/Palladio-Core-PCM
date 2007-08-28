package de.uka.ipd.sdq.scheduler.loaddistribution.balancers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import umontreal.iro.lecuyer.simevents.Sim;
import de.uka.ipd.sdq.scheduler.loaddistribution.ILoadBalancer;
import de.uka.ipd.sdq.scheduler.processes.IActiveProcess;
import de.uka.ipd.sdq.scheduler.queueing.strategies.MultipleQueuesStrategy;
import de.uka.ipd.sdq.scheduler.resources.IResourceInstance;

public abstract class AbstractLoadBalancer implements ILoadBalancer {

	/**
	 * Indicates whether all instances should be balanced or only the specified
	 * and busiest one.
	 */
	protected boolean do_global_balance;

	/**
	 * Minimum time that needs to pass between two executions of the load
	 * balancer.
	 */
	protected double balance_interval;

	/**
	 * If !do_global_balance, this table is used to track the time that passed
	 * since the last execution of a load balancer for an instance.
	 */
	protected Hashtable<IResourceInstance, Double> last_balanced_table;

	/**
	 * If do_global_balance, this value is used to track the time passed since
	 * the last balancing.
	 */
	protected double last_balanced;

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
	 * Gives the maximum number of iterations for a global balancing.
	 */
	protected int max_iterations;

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
	protected AbstractLoadBalancer(double balance_interval,
			boolean do_global_balance, boolean prio_increasing, boolean queue_ascending, int max_iterations) {
		super();
		this.balance_interval = balance_interval;
		this.do_global_balance = do_global_balance;
		this.prio_increasing = prio_increasing;
		this.queue_ascending = queue_ascending;
		this.max_iterations = max_iterations;
		this.queue_holder = null;
		this.last_balanced = 0;
		this.last_balanced_table = new Hashtable<IResourceInstance, Double>();
	}
	
	
	public void setQueueHolder(MultipleQueuesStrategy queue_holder){
		this.queue_holder = queue_holder;
		for (IResourceInstance instance : queue_holder.getResourceInstances()) {
			this.last_balanced_table.put(instance, 0.0);
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

	@Override
	public void balance(IResourceInstance instance) {
		double now = Sim.time();
		if (do_global_balance) {
			if (now - last_balanced >= balance_interval) {
				doGlobalBalance();
				last_balanced = now;
			}
		} else {
			if (now - last_balanced_table.get(instance) >= balance_interval) {
				doBalance(instance);
				last_balanced_table.put(instance, now);
			}
		}
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

		src.scheduleSchedulingEvent(0);
		dest.scheduleSchedulingEvent(0);
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
		return queue_holder.getRunQueueFor(instance).getCurrentLoad();
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
	 * Returns the laziest queue in the given list.
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
		if (!busiest.equals(instance) && !isBalanced(busiest, instance)
				&& load(busiest) > 1) {
			int max_processes_needed = numProcessedNeeded(busiest, instance);
			balanceTwoInstances(busiest, instance, max_processes_needed);
		}
	}

	/**
	 * Performs a global load balancing of all instances. The laziest and
	 * busiest instance are selected and balanced until all instances are balanced or the
	 * maximum of iterations is reached.
	 */
	protected void doGlobalBalance() {
		IResourceInstance busiest = getBusiest(queue_holder
				.getResourceInstances());
		IResourceInstance laziest = getLaziest(queue_holder
				.getResourceInstances());
		int i = 0;
		while (!busiest.equals(laziest) && !isBalanced(busiest, laziest)
				&& load(busiest) > 1 && i < max_iterations) {
			int max_processes_needed = numProcessedNeeded(busiest, laziest);
			balanceTwoInstances(busiest, laziest, max_processes_needed);
			busiest = getBusiest(queue_holder.getResourceInstances());
			laziest = getLaziest(queue_holder.getResourceInstances());
			i++;
		}
	}
}
