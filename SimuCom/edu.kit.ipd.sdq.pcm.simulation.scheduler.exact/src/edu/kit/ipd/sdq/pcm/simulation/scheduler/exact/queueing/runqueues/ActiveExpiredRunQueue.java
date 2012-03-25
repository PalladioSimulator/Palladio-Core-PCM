package edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.queueing.runqueues;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.scheduler.SchedulerModel;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.IResourceInstance;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.processes.IActiveProcess;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.processes.impl.PreemptiveProcess;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.queueing.IProcessQueue;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.queueing.IRunQueue;

public class ActiveExpiredRunQueue extends AbstractRunQueue {

    private SchedulerModel model;
	private IProcessQueue activePriorityArray;
	private IProcessQueue expiredPriorityArray;
	private double expired_timestamp = -1;

	public ActiveExpiredRunQueue(SchedulerModel model, IProcessQueue queue_prototype) {
	    this.model = model;
		this.activePriorityArray = queue_prototype.createNewInstance();
		this.expiredPriorityArray = queue_prototype.createNewInstance();
	}

	/**
	 * Adds a new process to the end of the expired priority array.
	 */
	@Override
	public void addProcessToRunQueue(IActiveProcess process, boolean inFront) {

		if (((PreemptiveProcess) process).getTimeslice().isFinished()) {
			updateStarvationTime();
		}
		if (process instanceof PreemptiveProcess) {
			PreemptiveProcess preemptiveProcess = (PreemptiveProcess) process;
			if (preemptiveProcess.getTimeslice().isFinished()) {
				expiredPriorityArray.add(process, inFront);
			} else {
				activePriorityArray.add(process, inFront);
			}
		} else {
			expiredPriorityArray.add(process, inFront);
		}
	}

	@Override
	protected int numWaitingProcesses() {
		return activePriorityArray.size() + expiredPriorityArray.size();
	}

	@Override
	public IActiveProcess getNextRunnableProcess(IResourceInstance instance) {
		if (activeQueueEmpty())
			switchActiveAndExpired();
		if (activePriorityArray.isEmpty()) // no process to be scheduled.
			return null;
		return activePriorityArray.getNextRunnableProcess(instance);
	}

	public IActiveProcess getNextRunnableProcess() {
		if (activeQueueEmpty())
			switchActiveAndExpired();
		if (activePriorityArray.isEmpty()) // no process to be scheduled.
			return null;
		return activePriorityArray.getNextRunnableProcess();
	}

	private void switchActiveAndExpired() {
		IProcessQueue temp = activePriorityArray;
		activePriorityArray = expiredPriorityArray;
		expiredPriorityArray = temp;
		resetStarvationInfo();
	}

	@Override
	public boolean removePendingProcess(IActiveProcess process) {
		return activePriorityArray.remove(process)
				|| expiredPriorityArray.remove(process);
	}

	/**
	 * Determines whether the current active queue is empty including the
	 * running and standby processes.
	 */
	protected boolean activeQueueEmpty() {
		return running_on_table.isEmpty() && activePriorityArray.isEmpty();
	}

	public IRunQueue createNewInstance() {
		return new ActiveExpiredRunQueue(model, activePriorityArray);
	}

	public List<IActiveProcess> identifyMovableProcesses(
			IResourceInstance targetInstance, boolean prio_increasing,
			boolean queue_ascending, int processes_needed) {
		List<IActiveProcess> process_list = new ArrayList<IActiveProcess>();
		expiredPriorityArray.identifyMovableProcesses(targetInstance,
				prio_increasing, queue_ascending, processes_needed,
				process_list);
		activePriorityArray.identifyMovableProcesses(targetInstance,
				prio_increasing, queue_ascending, processes_needed,
				process_list);
		return process_list;
	}

	public IProcessQueue getBestRunnableQueue(IResourceInstance instance) {
		IProcessQueue result = activePriorityArray
				.getBestRunnableQueue(instance);
		if (result == null) {
			result = expiredPriorityArray.getBestRunnableQueue(instance);
		}
		return result;
	}

	@Override
	public boolean containsPending(IActiveProcess process) {
		return activePriorityArray.contains(process)
				|| expiredPriorityArray.contains(process);
	}

	public boolean processStarving(double threshold) {
		if (expired_timestamp >= 0) {
		    double simTime = model.getSimulationControl().getCurrentSimulationTime();
			return simTime - expired_timestamp > threshold;
		} else {
			return false;
		}
	}

	public List<IActiveProcess> getStarvingProcesses(double starvationLimit) {
		List<IActiveProcess> result = expiredPriorityArray
				.getStarvingProcesses(starvationLimit);
		result
				.addAll(activePriorityArray
						.getStarvingProcesses(starvationLimit));
		return result;
	}

	public void setWaitingTime(IActiveProcess process, double waiting) {
		if (expiredPriorityArray.contains(process)) {
			expiredPriorityArray.setWaitingTime(process, waiting);
		} else {
			activePriorityArray.setWaitingTime(process, waiting);
		}
	}

	public double getWaitingTime(IActiveProcess process) {
		if (expiredPriorityArray.contains(process)) {
			return expiredPriorityArray.getWaitingTime(process);
		} else {
			return activePriorityArray.getWaitingTime(process);
		}
	}

	public void resetStarvationInfo() {
		expired_timestamp = -1;
	}

	private void updateStarvationTime() {
	    double simTime = model.getSimulationControl().getCurrentSimulationTime();
		updateStarvationTime(simTime);
	}

	private void updateStarvationTime(double waiting) {
		if (expired_timestamp < 0) {
			expired_timestamp = waiting;
		}
	}

}
