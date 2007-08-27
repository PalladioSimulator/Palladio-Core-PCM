package de.uka.ipd.sdq.scheduler.resources.passive;

import de.uka.ipd.sdq.scheduler.IPassiveResource;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.priority.IPriorityBoost;
import de.uka.ipd.sdq.scheduler.processes.impl.ActiveProcess;
import de.uka.ipd.sdq.scheduler.processes.impl.ProcessWithPriority;
import de.uka.ipd.sdq.scheduler.queueing.runqueues.ProcessQueue;
import de.uka.ipd.sdq.scheduler.resources.active.AbstractSimResource;
import de.uka.ipd.sdq.scheduler.resources.active.SimActiveResource;

public abstract class SimPassiveResource extends AbstractSimResource implements
		IPassiveResource {

	private IPriorityBoost priorityBoost;
	protected ProcessQueue<WaitingProcess> waitingQueue;
	protected SimActiveResource mainResource;

	public SimPassiveResource(int capacity, String name, String id) {
		super(capacity, name, id);
	}

	@Override
	public void acquire(ISchedulableProcess sched_process, int num) {
		ActiveProcess process = mainResource.lookUp(
				sched_process);
		if (canProceed(process, num)) {
			grantAccess(process, num);
		} else {
			WaitingProcess waiting_process = new WaitingProcess(process, num);
			fromRunningToWaiting(waiting_process, false);
			process.getSchedulableProcess().passivate();
		}
	}

	@Override
	public void release(ISchedulableProcess process, int num) {
		capacity += num;
		notifyWaitingProcesses();
	}

	protected void grantAccess(ActiveProcess process, int num) {
		capacity -= num;
		assert capacity >= 0 : "More resource than available have been acquired!";
		boostPriority(process);
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
		if (canProceed(waitingProcess.getProcess(), waitingProcess
				.getNumRequested())) {
			grantAccess(waitingProcess.getProcess(), waitingProcess
					.getNumRequested());
			fromWaitingToReady(waitingProcess);
			// Process is activated automatically by the scheduler.
			return true;
		}
		return false;
	}

	protected void fromWaitingToReady(WaitingProcess waiting_process) {
		mainResource.getScheduler().fromWaitingToReady(waiting_process,waitingQueue);
	}

	protected void fromRunningToWaiting(WaitingProcess waiting_process, boolean inFront) {
		mainResource.getScheduler().fromRunningToWaiting(waiting_process, waitingQueue, inFront);
	}

	private void boostPriority(ActiveProcess process) {
		if (priorityBoost != null) {
			assert process instanceof ProcessWithPriority : "If priority boosts are used only ProcessWithPriorities can be used!";
			priorityBoost.boost((ProcessWithPriority) process);
		}
	}

	/**
	 * Template Method. Depending on the type of resource, processes are
	 * notified differently.
	 */
	protected abstract void notifyWaitingProcesses();

	/**
	 * Template Method. Depending on the type of resource, processes are
	 * notified differently.
	 */
	protected abstract boolean canProceed(ActiveProcess process, int num);
}
