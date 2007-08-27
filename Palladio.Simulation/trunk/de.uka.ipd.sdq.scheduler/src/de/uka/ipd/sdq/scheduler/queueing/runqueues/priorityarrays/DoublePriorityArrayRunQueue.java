package de.uka.ipd.sdq.scheduler.queueing.runqueues.priorityarrays;

import java.util.List;

import de.uka.ipd.sdq.scheduler.priority.IPriorityManager;
import de.uka.ipd.sdq.scheduler.processes.IActiveProcess;
import de.uka.ipd.sdq.scheduler.processes.impl.PreemptiveProcess;
import de.uka.ipd.sdq.scheduler.queueing.IRunQueue;
import de.uka.ipd.sdq.scheduler.queueing.runqueues.ProcessQueue;
import de.uka.ipd.sdq.scheduler.resources.IResourceInstance;

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
	public void addProcessToRunQueue(IActiveProcess process, boolean inFront) {
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
	public IActiveProcess getNextRunnableProcess(IResourceInstance instance) {
		if (activeQueueEmpty())
			switchActiveAndExpired();
		if (activePriorityArray.isEmpty()) // no process to be scheduled.
			return null;
		return activePriorityArray.getNextRunnableProcess(instance);
	}

	@Override
	public IActiveProcess getNextRunnableProcess() {
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
	public boolean removePendingProcess(IActiveProcess process) {
		return activePriorityArray.removeProcess(process) ||
			   expiredPriorityArray.removeProcess(process);
	}

	/**
	 * Determines whether the current active queue is empty including the
	 * running and standby processes.
	 */
	protected boolean activeQueueEmpty() {
		return running_on_table.isEmpty() && activePriorityArray.isEmpty();
	}

	@Override
	public IRunQueue createNewInstance() {
		return new DoublePriorityArrayRunQueue(priorityManager);
	}

	/**
	 */
	@Override
	public List<IActiveProcess> identifyMovableProcesses(
			IResourceInstance targetInstance, boolean prio_increasing, boolean queue_ascending, int processes_needed) {
		List<IActiveProcess> processList = expiredPriorityArray.identifyMovableProcesses(targetInstance, prio_increasing, queue_ascending, processes_needed) ;
		processList.addAll( activePriorityArray.identifyMovableProcesses(targetInstance, prio_increasing, queue_ascending, processes_needed) );
		return processList;
	}

	@Override
	public ProcessQueue<IActiveProcess> getBestRunnableQueue(
			IResourceInstance instance) {
		ProcessQueue<IActiveProcess> result = activePriorityArray
				.getBestRunnableQueue(instance);
		if (result == null) {
			result = expiredPriorityArray.getBestRunnableQueue(instance);
		}
		return result;
	}

	@Override
	public boolean containsPending(IActiveProcess process) {
		return activePriorityArray.contains(process) || expiredPriorityArray.contains(process);
	}
}
