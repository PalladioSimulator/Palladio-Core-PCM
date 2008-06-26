package de.uka.ipd.sdq.scheduler.loaddistribution.balancers;

import java.util.Hashtable;

import umontreal.iro.lecuyer.simevents.Simulator;
import de.uka.ipd.sdq.scheduler.factory.SchedulingFactory;
import de.uka.ipd.sdq.scheduler.loaddistribution.ILoadBalancer;
import de.uka.ipd.sdq.scheduler.queueing.strategies.MultipleQueuesStrategy;
import de.uka.ipd.sdq.scheduler.resources.IResourceInstance;

public abstract class AbstractLoadBalancer implements ILoadBalancer {

	/**
	 * Minimum time that needs to pass between two load balancing attempts
	 */
	protected double balancing_interval;

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
	
	protected Simulator simulator;

	protected Hashtable<IResourceInstance, Double> last_balanced;

	

	/**
	 * Creates a new instance of a load balancer.
	 * 
	 * @param balancing_interval
	 *            Minimum time that needs to pass between two executions of the
	 *            load balancer.
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
	 */
	protected AbstractLoadBalancer(double balancing_interval,
			boolean prio_increasing,
			boolean queue_ascending) {
		super();
		this.balancing_interval = balancing_interval;
		this.prio_increasing = prio_increasing;
		this.queue_ascending = queue_ascending;
		this.queue_holder = null;
		this.last_balanced = new Hashtable<IResourceInstance, Double>();
		this.simulator = SchedulingFactory.getUsedSimulator();
	}
	
	
	protected int load(IResourceInstance instance) {
		return queue_holder.getRunQueueFor(instance).getCurrentLoad();
	}
	
	public void setQueueHolder(MultipleQueuesStrategy queue_holder) {
		this.queue_holder = queue_holder;
		for (IResourceInstance instance : queue_holder.getResourceInstances()) {
			this.last_balanced.put(instance, 0.0);
		}
	}


}
