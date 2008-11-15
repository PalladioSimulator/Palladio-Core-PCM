package de.uka.ipd.sdq.scheduler.resources.passive;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.LoggingWrapper;
import de.uka.ipd.sdq.scheduler.events.IDelayedAction;
import de.uka.ipd.sdq.scheduler.priority.IPriorityBoost;
import de.uka.ipd.sdq.scheduler.processes.IActiveProcess;
import de.uka.ipd.sdq.scheduler.processes.impl.ProcessWithPriority;
import de.uka.ipd.sdq.scheduler.resources.active.SimActiveResource;

public class SimUnfairPassiveResource extends SimAbstractPassiveResource {

	private double acquisition_demand;

	public SimUnfairPassiveResource(int capacity, String name, String id,
			IPriorityBoost priority_boost, SimActiveResource managing_resource,
			double acquisition_demand) {
		super(capacity, name, id, priority_boost, managing_resource);
		this.acquisition_demand = acquisition_demand;
	}

	public boolean acquire(ISchedulableProcess sched_process, int num) {
		ProcessWithPriority process = (ProcessWithPriority) main_resource
				.lookUp(sched_process);
		if (num <= capacity) {
			grantAccess(num, process);
			return true;
		} else {
			LoggingWrapper.log("Process " + process + " is waiting for " + num
					+ " of " + this);
			WaitingProcess waiting_process = new WaitingProcess(process, num);
			fromRunningToWaiting(waiting_process, false);
			process.getSchedulableProcess().passivate();
			return false;
		}
	}

	private void grantAccess(int num, ProcessWithPriority process) {
		LoggingWrapper.log("Process " + process + " acquires " + num + " of "
				+ this);
		punish(process);
		boostPriority(process);
		capacity -= num;
		assert capacity >= 0 : "More resource than available have been acquired!";
	}

	public void release(ISchedulableProcess sched_process, int num) {
		LoggingWrapper.log("Process " + sched_process + " releases " + num
				+ " of " + this);
		capacity += num;
		notifyNextWaitingProcess();
	}

	private void notifyNextWaitingProcess() {
		WaitingProcess waiting_process = waiting_queue.peek();
		if (waiting_process != null) {
			IActiveProcess process = waiting_process.getProcess();
			process.setCurrentDemand(acquisition_demand);
			process.setDelayedAction(new UnfairAccessAction(waiting_process));
			fromWaitingToReady(waiting_process, process.getLastInstance());
		}
	}

	/**
	 * Tries to remove the given process from the waiting queue and get access
	 * of the required number of passive resources.
	 * 
	 * @param waitingProcess
	 * @return True if the process was successfully dequeued and activated,
	 *         otherwise false.
	 */
	protected boolean tryToDequeueProcess(WaitingProcess waitingProcess) {
		if (waitingProcess.getNumRequested() <= capacity) {
			grantAccess(waitingProcess.getNumRequested(),
					(ProcessWithPriority) waitingProcess.getProcess());
			if (capacity > 0)
				notifyNextWaitingProcess();
			return true;
		} else {
			return false;
		}
	}

	private class UnfairAccessAction implements IDelayedAction {
		private WaitingProcess waiting_process;

		public UnfairAccessAction(WaitingProcess waiting_process) {
			super();
			this.waiting_process = waiting_process;
		}

		public boolean perform() {
			if (!tryToDequeueProcess(waiting_process)) {
				fromRunningToWaiting(waiting_process, true);
				return false;
			} else {
				waiting_process.getProcess().getSchedulableProcess().activate();
				return true;
			}
		}
	}

}
