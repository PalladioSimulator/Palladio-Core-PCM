package de.uka.ipd.sdq.scheduler.loaddistribution.balancers;

import de.uka.ipd.sdq.scheduler.resources.IResourceInstance;

/**
 * Ensures that the load of two resource instances does not differ more than
 * 'threshold'. The threshold is a relative value between 0 and 1. If 0 the load
 * of both instances must be equal, if 1 the load of both instances is never
 * balanced.
 * 
 * @author jens.happe
 * 
 */
public class ToThresholdBalancer extends AbstractLoadBalancer {

	/**
	 * Maximum, relative load difference of two resource instances.
	 */
	private double threshold;

	/**
	 * Creates a new load balancer.
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
	 * 
	 * @param threshold
	 *            Maximum, relative load difference of two resource instances.
	 */
	public ToThresholdBalancer(double balance_interval, boolean global_balance,
			boolean prio_increasing, boolean queue_ascending,
			int max_iterations, double threshold) {
		super(balance_interval, global_balance, prio_increasing,
				queue_ascending, max_iterations);
		this.threshold = threshold;
	}

	@Override
	protected boolean isBalanced(IResourceInstance firstInstance,
			IResourceInstance secondInstance) {
		double firstLoad = load(firstInstance);
		double secondLoad = load(secondInstance);
		double totalLoad = firstLoad + secondLoad;

		if (totalLoad == 0)
			return true;

		firstLoad /= totalLoad;
		secondLoad /= totalLoad;
		double distance = Math.abs(firstLoad - secondLoad);
		return distance <= threshold;
	}
}
