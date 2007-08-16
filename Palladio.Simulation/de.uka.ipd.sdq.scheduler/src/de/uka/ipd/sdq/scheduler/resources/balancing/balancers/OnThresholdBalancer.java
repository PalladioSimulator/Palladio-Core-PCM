package de.uka.ipd.sdq.scheduler.resources.balancing.balancers;

import de.uka.ipd.sdq.probfunction.math.util.MathTools;
import de.uka.ipd.sdq.scheduler.resources.SimResourceInstance;
import de.uka.ipd.sdq.scheduler.resources.queueing.strategies.MultipleQueuesStrategy;

/**
 * Ensures that the load of two resource instances does not differ more than
 * 'threshold'. The threshold is a relative value between 0 and 1. If 0 the load
 * of both instances must be equal, if 1 the load of both instances is never
 * balanced.
 * 
 * @author jens.happe
 * 
 */
public class OnThresholdBalancer extends AbstractLoadBalancer {

	/**
	 * If the number of tasks differs more than this value, tasks are moved.
	 * 
	 * @uml.property name="threshold"
	 */
	private double threshold;

	public OnThresholdBalancer(double balanceInterval,
			MultipleQueuesStrategy runQueueHolder) {
		super(balanceInterval, runQueueHolder);
	}

	@Override
	protected boolean isBalanced(SimResourceInstance firstInstance,
			SimResourceInstance secondInstance) {
		double firstLoad = load(firstInstance);
		double secondLoad = load(secondInstance);
		double totalLoad = firstLoad + secondLoad;
		firstLoad /= totalLoad;
		secondLoad /= totalLoad;
		double difference = Math.abs(firstLoad - secondLoad);
		return MathTools.lessOrEqual(difference, threshold);
	}

}
