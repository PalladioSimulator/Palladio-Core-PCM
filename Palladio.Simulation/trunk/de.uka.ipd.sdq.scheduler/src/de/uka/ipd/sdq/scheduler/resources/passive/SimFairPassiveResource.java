package de.uka.ipd.sdq.scheduler.resources.passive;

import de.uka.ipd.sdq.probfunction.math.util.MathTools;
import de.uka.ipd.sdq.scheduler.IRunningProcess;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.LoggingWrapper;
import de.uka.ipd.sdq.scheduler.priority.IPriorityBoost;
import de.uka.ipd.sdq.scheduler.processes.IActiveProcess;
import de.uka.ipd.sdq.scheduler.resources.active.SimActiveResource;

public class SimFairPassiveResource extends SimAbstractPassiveResource {

	public SimFairPassiveResource(int capacity, String name, String id,
			IPriorityBoost priority_boost, SimActiveResource managing_resource) {
		super(capacity, name, id, priority_boost, managing_resource);
	}


	private boolean canProceed(IRunningProcess process, int num) {
		return (waiting_queue.isEmpty() || waiting_queue.peek().getProcess()
				.equals(process))
				&& num <= capacity;
	}
	
	@Override
	public boolean acquire(ISchedulableProcess sched_process, int num) {
		IActiveProcess process = main_resource.lookUp(sched_process);
		if (canProceed(process, num) && grantAccessAcquire(process, num)){
				LoggingWrapper.log("Process " + process + " acquires " + num + " of " + this);
				// the boost might has changed the remaining time for the process. Thus,
				// the next scheduling or proceed event needs to be newly determined.
				main_resource.getScheduler().scheduleNextEvent(
						((IActiveProcess) process).getLastInstance());
				return true;
		} else {
			LoggingWrapper.log("Process " + process + " is waiting for " + num + " of " + this);
			WaitingProcess waiting_process = new WaitingProcess(process, num);
			fromRunningToWaiting(waiting_process, false);
			process.getSchedulableProcess().passivate();
			return false;
		}
	}

	@Override
	public void release(ISchedulableProcess process, int num) {
		LoggingWrapper.log("Process " + process + " releases " + num + " of " + this);
		capacity += num;
		notifyWaitingProcesses();
	}
	
	private void notifyWaitingProcesses() {
		WaitingProcess waitingProcess = waiting_queue.peek();
		if (waitingProcess != null) {
			if (tryToDequeueProcess(waitingProcess))
				fromWaitingToReady(waitingProcess);
		}
	}

	


	private boolean grantAccessAcquire(IActiveProcess process, int num) {
		if (!MathTools.equalsDouble(((IActiveProcess)process).getTimeUntilNextInterruption(), 0)) {
			boostPriority(process);
			capacity -= num;
			assert capacity >= 0 : "More resource than available have been acquired!";
			return true;
		} else {
			process.update();
			return false;
		}
	}

	private void grantAccessAfterWaiting(IActiveProcess process, int num) {
		if (MathTools.equalsDouble(((IActiveProcess)process).getTimeUntilNextInterruption(), 0)) {
			process.update();
		} 
		boostPriority(process);
		capacity -= num;
		assert capacity >= 0 : "More resource than available have been acquired!";
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
			LoggingWrapper.log("Process " + waitingProcess.getProcess() + " acquires " + waitingProcess.getNumRequested() + " of " + this + " after waiting.");
			grantAccessAfterWaiting(waitingProcess.getProcess(), waitingProcess
					.getNumRequested());
			return true;
		}
		return false;
	}

}
