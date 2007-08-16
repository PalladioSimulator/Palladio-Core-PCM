package de.uka.ipd.sdq.scheduler.resources.balancing.impl;

import de.uka.ipd.sdq.scheduler.resources.SimResourceInstance;
import de.uka.ipd.sdq.scheduler.resources.queueing.MultipleQueuesStrategy;


/**
 * Simply moves a single process to an idle resource.
 * @author jens.happe
 *
 */
public class OnIdleBalancer extends AbstractLoadBalancer {

	public OnIdleBalancer(double balanceInterval,
			MultipleQueuesStrategy runQueueHolder) {
		super(balanceInterval, runQueueHolder);
	}

	@Override
	protected boolean isBalanced(SimResourceInstance firstInstance,
			SimResourceInstance secondInstance) {
		return !runQueueHolder.isIdle(firstInstance) && !runQueueHolder.isIdle(secondInstance);
	}
}
