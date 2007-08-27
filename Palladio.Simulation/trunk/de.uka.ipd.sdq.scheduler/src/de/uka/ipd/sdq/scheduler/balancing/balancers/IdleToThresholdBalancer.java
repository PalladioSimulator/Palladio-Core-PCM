package de.uka.ipd.sdq.scheduler.balancing.balancers;

import de.uka.ipd.sdq.scheduler.queueing.strategies.MultipleQueuesStrategy;
import de.uka.ipd.sdq.scheduler.resources.active.SimResourceInstance;

/**
 * For all idle resource instances it ensures that the load is shared so that
 * the load of two the resource instances does not differ more than
 * 'threshold'. The threshold is a relative value between 0 and 1. If 0 the load
 * of both instances must be equal, if 1 the load of both instances is never
 * balanced.
 * 
 * @author jens.happe
 * 
 */
public class IdleToThresholdBalancer extends AbstractLoadBalancer {

	/**
	 * If the number of tasks differs more than this value, tasks are moved.
	 */
	private double threshold;


	public IdleToThresholdBalancer(double balanceInterval,
			MultipleQueuesStrategy queueHolder, boolean prio_increasing,
			boolean queue_ascending, int max_iterations, double threshold) {
		super(balanceInterval, queueHolder, prio_increasing, queue_ascending,
				max_iterations);
		this.threshold = threshold;
	}


	@Override
	protected boolean isBalanced(SimResourceInstance firstInstance,
			SimResourceInstance secondInstance) {
		
		if (queueHolder.isIdle(firstInstance) != queueHolder
				.isIdle(secondInstance)){
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
		return true;
	}
}
