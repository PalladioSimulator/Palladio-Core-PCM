package edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.loaddistribution.balancers;

import java.util.List;

import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.IResourceInstance;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.processes.IActiveProcess;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.processes.impl.PreemptiveProcess;

/**
 * Moves one process to each idle resource, if possible.
 * 
 * @author jens.happe
 * 
 */
public class OneToIdleBalancer extends AbstractLoadBalancer {

	private int upperBound = 1;

	private int lowerBound = 1;

	public OneToIdleBalancer(double balance_interval, boolean prio_increasing,
			boolean queue_ascending) {
		super(balance_interval, prio_increasing, queue_ascending);
	}

	public void activelyBalance(IResourceInstance instance) {
		// double now = simulator.time();
		// if ((now - last_balanced.get(instance)) > balancing_interval) {
		// balanceAsReceiver(instance);
		// last_balanced.put(instance, now);
		// }
	}

	public void onFork(IResourceInstance instance) {
		balanceAsSender(instance);
	}

	public void onSleep(IResourceInstance instance) {
		balanceAsReceiver(instance);
	}

	public void onTerminate(IResourceInstance instance) {
		balanceAsReceiver(instance);
	}

	public void onWake(IResourceInstance instance) {
		balanceAsSender(instance);
	}

	private void balanceAsSender(IResourceInstance instance) {
		if (load(instance) > upperBound) {
			balance(instance, getReceiver());
		}
	}

	private void balanceAsReceiver(IResourceInstance instance) {
		if (load(instance) < lowerBound) {
			balance(getSender(), instance);
		}
	}

	private IResourceInstance getSender() {
		IResourceInstance result = null;
		for (IResourceInstance ri : queue_holder.getResourceInstances()) {
			if (result == null || load(ri) > load(result)) {
				result = ri;
			}
		}
		if (load(result) > upperBound) {
			return result;
		} else {
			return null;
		}
	}

	private IResourceInstance getReceiver() {
		IResourceInstance result = null;
		for (IResourceInstance ri : queue_holder.getResourceInstances()) {
			if (result == null || load(ri) < load(result)) {
				result = ri;
			}
		}
		if (load(result) < lowerBound) {
			return result;
		} else {
			return null;
		}
	}

	private void balance(IResourceInstance sender, IResourceInstance receiver) {
		if (sender != null && receiver != null) {
			if (!sender.equals(receiver)) {
				List<IActiveProcess> processList = queue_holder.getRunQueueFor(
						sender).identifyMovableProcesses(receiver,
						prio_increasing, queue_ascending, 1);

				if (processList.size() > 0) {
					fakeThreadLoadBalancing(processList.get(0), sender,
							receiver);
				}
			}
		}
	}

	/**
	 * From the beautiful method name, the careful reader might have guessed
	 * that things get a bit, well, messy at this point. Fact is, that Windows
	 * (or Java ?) balances threads differently from processes by simply
	 * changing the association between light weight processes and (user level)
	 * threads. That makes things a bit difficult as heavy weight and light
	 * weight processes as well as threads would have to be reflected in the
	 * model.
	 * 
	 * Sorry for anyone responsible fixing this, but I hope this comment helps.
	 * Further discussion can be found in class 'SimResourceInstance' at
	 * variable 'last_running_process'.
	 * 
	 * @param process
	 *            moved process
	 * @param sender
	 *            sending resource instance
	 * @param receiver
	 *            receiving resource instance
	 */
	private void fakeThreadLoadBalancing(IActiveProcess process,
			IResourceInstance sender, IResourceInstance receiver) {
		if (receiver.getLastRunningProcess() != null) {
			PreemptiveProcess p = (PreemptiveProcess) receiver.getLastRunningProcess();

			// here we assume that the waiting process is in fact a thread that
			// belongs to the same process as the thread (process) to move.
			// the following assigns the waiting thread to the resource of
			// the sender. This fakes the switch of LWPs.
			if (p.isWaiting()) {
				p.setLastInstance(process.getLastInstance());
				p.setIdealInstance(process.getIdealInstance());
			}
		}
		queue_holder.move(process, sender, receiver);
	}
}
