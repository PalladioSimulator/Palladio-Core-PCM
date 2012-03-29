package edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.resources.passive;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.LoggingWrapper;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.scheduler.resources.passive.PassiveResourceObservee;
import de.uka.ipd.sdq.scheduler.sensors.IPassiveResourceSensor;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.SimActiveResource;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.events.IDelayedAction;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.priority.IPriorityBoost;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.processes.IActiveProcess;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.processes.impl.ProcessWithPriority;

public class SimUnfairPassiveResource extends SimAbstractPassiveResource {

	private double acquisition_demand;
	private boolean isFifo;
	private int available;
	private PassiveResourceObservee observee;

	public SimUnfairPassiveResource(SchedulerModel model, int capacity, String name, String id,
			IPriorityBoost priority_boost, SimActiveResource managing_resource,
			double acquisition_demand, boolean isFifo) {
		super(model, capacity, name, id, priority_boost, managing_resource);
		this.acquisition_demand = acquisition_demand;
		this.isFifo = isFifo;
		available = capacity;
		observee = new PassiveResourceObservee();
	}

	public boolean acquire(ISchedulableProcess sched_process, int num,
			boolean timeout, double timeoutValue) {

		// AM: Copied from AbstractActiveResource: If simulation is stopped,
		// allow all processes to finish
		if (!getModel().getSimulationControl().isRunning()) {
			// Do nothing, but allows calling process to complete
			return true;
		}

		observee.fireRequest(sched_process, num);
		ProcessWithPriority process = (ProcessWithPriority) main_resource
				.lookUp(sched_process);
		if (num <= available) {
			grantAccess(num, process);
			return true;
		} else {
			LoggingWrapper.log("Process " + process + " is waiting for " + num
					+ " of " + this);
			WaitingProcess waiting_process = new WaitingProcess(process, num);
			fromRunningToWaiting(waiting_process, !isFifo);
			process.getSchedulableProcess().passivate();
			return false;
		}
	}

	private void grantAccess(int num, ProcessWithPriority process) {
		LoggingWrapper.log("Process " + process + " acquires " + num + " of "
				+ this);
		punish(process);
		boostPriority(process);
		available -= num;
		observee.fireAquire(process.getSchedulableProcess(), num);
		assert available >= 0 : "More resource than available have been acquired!";
	}

	public void release(ISchedulableProcess sched_process, int num) {

		// AM: Copied from AbstractActiveResource: If simulation is stopped,
		// allow all processes to finish
		if (!getModel().getSimulationControl().isRunning()) {
			// Do nothing, but allows calling process to complete
			return;
		}

		LoggingWrapper.log("Process " + sched_process + " releases " + num
				+ " of " + this);
		available += num;
		observee.fireRelease(sched_process, num);
		notifyNextWaitingProcess();
	}

	private void notifyNextWaitingProcess() {
		WaitingProcess waiting_process = (WaitingProcess)waiting_queue.peek();
		if (waiting_process != null) {
			IActiveProcess process = waiting_process.getActiveProcess();
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
		if (waitingProcess.getNumRequested() <= available) {
			grantAccess(waitingProcess.getNumRequested(),
					(ProcessWithPriority) waitingProcess.getActiveProcess());
			if (available > 0)
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
				waiting_process.getActiveProcess().getSchedulableProcess().activate();
				return true;
			}
		}
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
