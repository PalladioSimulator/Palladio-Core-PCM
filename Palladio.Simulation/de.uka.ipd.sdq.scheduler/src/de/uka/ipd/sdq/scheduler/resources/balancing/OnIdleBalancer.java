package de.uka.ipd.sdq.scheduler.resources.balancing;

import de.uka.ipd.sdq.scheduler.resources.SimResourceInstance;
import de.uka.ipd.sdq.scheduler.resources.queueing.MultipleRunQueues;


/**
 * Simply moves a single process to an idle resource.
 * @author jens.happe
 *
 */
public class OnIdleBalancer extends AbstractLoadBalancer {

	public OnIdleBalancer(double balanceInterval,
			MultipleRunQueues runQueueHolder) {
		super(balanceInterval, runQueueHolder);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean isBalanced(SimResourceInstance firstInstance,
			SimResourceInstance secondInstance) {
		return !isIdle(firstInstance) && !isIdle(secondInstance);
	}
}
