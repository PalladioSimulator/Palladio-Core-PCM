package de.uka.ipd.sdq.scheduler.resources.passive;

import java.util.ArrayDeque;
import java.util.Deque;

import de.uka.ipd.sdq.scheduler.IPassiveResource;
import de.uka.ipd.sdq.scheduler.IRunningProcess;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.priority.IPriorityBoost;
import de.uka.ipd.sdq.scheduler.processes.IActiveProcess;
import de.uka.ipd.sdq.scheduler.processes.impl.ProcessWithPriority;
import de.uka.ipd.sdq.scheduler.resources.AbstractSimResource;
import de.uka.ipd.sdq.scheduler.resources.active.SimActiveResource;

public abstract class SimAbstractPassiveResource extends AbstractSimResource implements
		IPassiveResource {

	private IPriorityBoost priority_boost;
	protected Deque<WaitingProcess> waiting_queue;
	protected SimActiveResource main_resource;


	public SimAbstractPassiveResource(int capacity, String name, String id,
			IPriorityBoost priority_boost, SimActiveResource managing_resource) {
		super(capacity, name, id);
		this.priority_boost = priority_boost;
		this.main_resource = managing_resource;
		this.waiting_queue = new ArrayDeque<WaitingProcess>();
	}

	@Override
	public void acquire(ISchedulableProcess sched_process, int num) {
		IActiveProcess process = main_resource.lookUp(
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

	protected void grantAccess(IRunningProcess process, int num) {
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
		main_resource.getScheduler().fromWaitingToReady(waiting_process,waiting_queue);
	}

	protected void fromRunningToWaiting(WaitingProcess waiting_process, boolean inFront) {
		main_resource.getScheduler().fromRunningToWaiting(waiting_process, waiting_queue, inFront);
	}

	private void boostPriority(IRunningProcess process) {
		if (priority_boost != null) {
			assert process instanceof ProcessWithPriority : "If priority boosts are used only ProcessWithPriorities can be used!";
			priority_boost.boost((ProcessWithPriority) process);
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
	protected abstract boolean canProceed(IRunningProcess process, int num);
}
