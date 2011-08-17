package de.uka.ipd.sdq.scheduler.resources.passive;

import de.uka.ipd.sdq.scheduler.IRunningProcess;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.LoggingWrapper;
import de.uka.ipd.sdq.scheduler.factory.SchedulingFactory;
import de.uka.ipd.sdq.scheduler.priority.IPriorityBoost;
import de.uka.ipd.sdq.scheduler.processes.IActiveProcess;
import de.uka.ipd.sdq.scheduler.processes.impl.PreemptiveProcess;
import de.uka.ipd.sdq.scheduler.processes.impl.ProcessWithPriority;
import de.uka.ipd.sdq.scheduler.resources.IResourceInstance;
import de.uka.ipd.sdq.scheduler.resources.active.SimActiveResource;
import de.uka.ipd.sdq.scheduler.sensors.IPassiveResourceSensor;

public class SimFairPassiveResource extends SimAbstractPassiveResource {

	private PassiveResourceObservee observee;
	private int available;

	public SimFairPassiveResource(int capacity, String name, String id,
			IPriorityBoost priority_boost, SimActiveResource managing_resource) {
		super(capacity, name, id, priority_boost, managing_resource);
		observee = new PassiveResourceObservee();
		available = capacity;
	}

	private boolean canProceed(IRunningProcess process, int num) {
		return (waiting_queue.isEmpty() || waiting_queue.peek().getProcess()
				.equals(process))
				&& num <= available;
	}

	public boolean acquire(ISchedulableProcess sched_process, int num,
			boolean timeout, double timeoutValue) {

		// AM: Copied from AbstractActiveResource: If simulation is stopped,
		// allow all processes to finish
		if (SchedulingFactory.getUsedSimulator().isStopped()) {
			// Do nothing, but allows calling process to complete
			return true;
		}

		observee.fireRequest(sched_process, num);
		PreemptiveProcess process = (PreemptiveProcess) main_resource
				.lookUp(sched_process);
		if (canProceed(process, num)) {
			grantAccess(process, num);
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

	public void release(ISchedulableProcess sched_process, int num) {

		// AM: Copied from AbstractActiveResource: If simulation is stopped,
		// allow all processes to finish
		if (SchedulingFactory.getUsedSimulator().isStopped()) {
			// Do nothing, but allows calling process to complete
			return;
		}

		IActiveProcess process = main_resource.lookUp(sched_process);

		LoggingWrapper.log("Process " + process + " releases " + num + " of "
				+ this);
		available += num;
		observee.fireRelease(sched_process, num);
		notifyWaitingProcesses(process.getLastInstance());
	}

	private void notifyWaitingProcesses(IResourceInstance current) {
		WaitingProcess waitingProcess = waiting_queue.peek();
		if (waitingProcess != null) {
			if (tryToDequeueProcess(waitingProcess))
				fromWaitingToReady(waitingProcess, current);
		}
	}

	private void grantAccess(PreemptiveProcess process, int num) {
		LoggingWrapper.log("Process " + process + " acquires " + num + " of "
				+ this);
		punish(process);
		boostPriority(process);
		available -= num;
		observee.fireAquire(process.getSchedulableProcess(), num);
		assert available >= 0 : "More resource than available have been acquired!";
	}

	/**
	 * Tries to remove the given process from the waiting queue and get access
	 * of the required number of passive resources.
	 * 
	 * @param waitingProcess
	 * @return True if the process was successfully dequeued and activated,
	 *         otherwise false.
	 */
	private boolean tryToDequeueProcess(WaitingProcess waitingProcess) {
		if (canProceed(waitingProcess.getProcess(), waitingProcess
				.getNumRequested())) {
			grantAccess((ProcessWithPriority) waitingProcess.getProcess(),
					waitingProcess.getNumRequested());
			return true;
		}
		return false;
	}

	public void addObserver(IPassiveResourceSensor observer) {
		observee.addObserver(observer);
	}

	public void removeObserver(IPassiveResourceSensor observer) {
		observee.removeObserver(observer);
	}

	public int getAvailable() {
		return available;
	}

}
