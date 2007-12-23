package de.uka.ipd.sdq.scheduler.loaddistribution.balancers;

import de.uka.ipd.sdq.scheduler.resources.IResourceInstance;

/**
 * Moves one process to each idle resource, if possilbe.
 * 
 * @author jens.happe
 * 
 */
public class OneToIdleBalancer extends AbstractLoadBalancer {

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
	public OneToIdleBalancer(double balance_interval, boolean global_balance,
			boolean prio_increasing, boolean queue_ascending, int max_iterations) {
		super(balance_interval, global_balance, prio_increasing,
				queue_ascending, max_iterations);
	}

	protected boolean isBalanced(IResourceInstance firstInstance,
			IResourceInstance secondInstance) {
		return (queue_holder.isIdle(firstInstance) == queue_holder
				.isIdle(secondInstance));
	}
}
