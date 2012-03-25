package edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.loaddistribution.balancers;

import java.util.List;

import de.uka.ipd.sdq.scheduler.SchedulerModel;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.IResourceInstance;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.processes.IActiveProcess;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.processes.impl.PreemptiveProcess;

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

    private SchedulerModel model;
	private double last_balanced = 0;
	private int threshold;

	public ToThresholdBalancer(SchedulerModel model, double balancing_interval,
			boolean prio_increasing, boolean queue_ascending, int threshold) {
		super(balancing_interval, prio_increasing, queue_ascending);
		this.model = model;
		this.threshold = threshold;
	}

	public void activelyBalance(IResourceInstance instance) {
		double now = model.getSimulationControl().getCurrentSimulationTime();
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
						fakeThreadLoadBalancing(process, sender, receiver);
						//queue_holder.move(process, sender, receiver);
					}
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
