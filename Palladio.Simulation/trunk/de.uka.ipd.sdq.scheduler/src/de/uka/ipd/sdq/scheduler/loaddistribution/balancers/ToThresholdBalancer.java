package de.uka.ipd.sdq.scheduler.loaddistribution.balancers;

import java.util.List;

import de.uka.ipd.sdq.scheduler.processes.IActiveProcess;
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

	private double last_balanced = 0;
	private int threshold;

	public ToThresholdBalancer(double balancing_interval,
			boolean prio_increasing, boolean queue_ascending, int threshold) {
		super(balancing_interval, prio_increasing, queue_ascending);
		this.threshold = threshold;
	}

	public void activelyBalance(IResourceInstance instance) {
		double now = simulator.time();
		if ((now - last_balanced) > balancing_interval) {
			balance(getBusiest(), getLaziest());
			last_balanced = now;
		}
	}

	public void onFork(IResourceInstance instance) {
		balance(instance, getLaziest());
	}

	public void onSleep(IResourceInstance instance) {
		if (load(instance) == 0) {
			balance(getBusiest(), instance);
		}
	}

	public void onTerminate(IResourceInstance instance) {
		if (load(instance) == 0) {
			balance(getBusiest(), instance);
		}
	}

	public void onWake(IResourceInstance instance) {
		balance(instance,getLaziest());
	}

	private void balance(IResourceInstance sender, IResourceInstance receiver) {
		if (sender != null && receiver != null) {
			if (!sender.equals(receiver)) {
				int distance = load(sender) - load(receiver);
				if (distance > threshold) {
					List<IActiveProcess> processList = queue_holder
							.getRunQueueFor(sender).identifyMovableProcesses(
									receiver, prio_increasing, queue_ascending,
									distance / 2);
					for (IActiveProcess process : processList) {
						queue_holder.move(process, sender, receiver);
					}
				}
			}
		}
	}

	private IResourceInstance getLaziest() {
		IResourceInstance result = null;
		for (IResourceInstance ri : queue_holder.getResourceInstances()) {
			if (result == null || load(ri) < load(result)) {
				result = ri;
			}
		}
		return result;
	}

	private IResourceInstance getBusiest() {
		IResourceInstance result = null;
		for (IResourceInstance ri : queue_holder.getResourceInstances()) {
			if (result == null || load(ri) > load(result)) {
				result = ri;
			}
		}
		return result;
	}
}
