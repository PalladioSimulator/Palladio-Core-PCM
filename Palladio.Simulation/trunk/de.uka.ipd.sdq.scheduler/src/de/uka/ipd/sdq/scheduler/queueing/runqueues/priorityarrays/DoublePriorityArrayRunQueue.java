package de.uka.ipd.sdq.scheduler.queueing.runqueues.priorityarrays;

import java.util.List;

import de.uka.ipd.sdq.scheduler.priority.IPriorityManager;
import de.uka.ipd.sdq.scheduler.processes.ActiveProcess;
import de.uka.ipd.sdq.scheduler.processes.PreemptiveProcess;
import de.uka.ipd.sdq.scheduler.queueing.IRunQueue;
import de.uka.ipd.sdq.scheduler.queueing.runqueues.ProcessQueue;
import de.uka.ipd.sdq.scheduler.resources.active.SimResourceInstance;

public class DoublePriorityArrayRunQueue extends AbstractPriorityArrayRunQueue {

	private PriorityArray activePriorityArray;
	private PriorityArray expiredPriorityArray;

	public DoublePriorityArrayRunQueue(IPriorityManager priorityManager) {
		super(priorityManager);
		this.activePriorityArray = new PriorityArray(priorityManager);
		this.expiredPriorityArray = new PriorityArray(priorityManager);
	}

	/**
	 * Adds a new process to the end of the expired priority array.
	 */
	@Override
	public void addProcessToRunQueue(ActiveProcess process, boolean inFront) {
		if (process instanceof PreemptiveProcess) {
			PreemptiveProcess preemptiveProcess = (PreemptiveProcess) process;
			if (preemptiveProcess.timeSliceCompletelyFinished()) {
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
		return activePriorityArray.getNumberOfProcesses()
				+ expiredPriorityArray.getNumberOfProcesses();
	}

	@Override
	public ActiveProcess getNextRunnableProcess(SimResourceInstance instance) {
		if (activeQueueEmpty())
			switchActiveAndExpired();
		if (activePriorityArray.isEmpty()) // no process to be scheduled.
			return null;
		return activePriorityArray.getNextRunnableProcess(instance);
	}

	@Override
	public ActiveProcess getNextRunnableProcess() {
		if (activeQueueEmpty())
			switchActiveAndExpired();
		if (activePriorityArray.isEmpty()) // no process to be scheduled.
			return null;
		return activePriorityArray.getNextRunnableProcess();
	}

	private void switchActiveAndExpired() {
		PriorityArray temp = activePriorityArray;
		activePriorityArray = expiredPriorityArray;
		expiredPriorityArray = temp;
	}

	@Override
	public boolean removePendingProcess(ActiveProcess process) {
		return activePriorityArray.removeProcess(process) ||
			   expiredPriorityArray.removeProcess(process);
	}

	/**
	 * Determines whether the current active queue is empty including the
	 * running and standby processes.
	 */
	protected boolean activeQueueEmpty() {
		return runningOnTable.isEmpty() && activePriorityArray.isEmpty();
	}

	@Override
	public IRunQueue createNewInstance() {
		return new DoublePriorityArrayRunQueue(priorityManager);
	}

	/**
	 * TODO: allow different strategies for process selection.
	 */
	@Override
	public List<ActiveProcess> identifyMovableProcesses(
			SimResourceInstance targetInstance, boolean prio_increasing, boolean queue_ascending, int processes_needed) {
		List<ActiveProcess> processList = expiredPriorityArray.identifyMovableProcesses(targetInstance, prio_increasing, queue_ascending, processes_needed) ;
		processList.addAll( activePriorityArray.identifyMovableProcesses(targetInstance, prio_increasing, queue_ascending, processes_needed) );
		return processList;
	}

	@Override
	public ProcessQueue<ActiveProcess> getBestRunnableQueue(
			SimResourceInstance instance) {
		ProcessQueue<ActiveProcess> result = activePriorityArray
				.getBestRunnableQueue(instance);
		if (result == null) {
			result = expiredPriorityArray.getBestRunnableQueue(instance);
		}
		return result;
	}

	@Override
	public boolean containsPending(ActiveProcess process) {
		return activePriorityArray.contains(process) || expiredPriorityArray.contains(process);
	}
}
