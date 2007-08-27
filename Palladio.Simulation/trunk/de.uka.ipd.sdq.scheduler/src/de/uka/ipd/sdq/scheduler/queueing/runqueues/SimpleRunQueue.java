package de.uka.ipd.sdq.scheduler.queueing.runqueues;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.scheduler.IResourceInstance;
import de.uka.ipd.sdq.scheduler.processes.impl.ActiveProcess;
import de.uka.ipd.sdq.scheduler.queueing.IRunQueue;

public class SimpleRunQueue extends AbstractRunQueue {

	private ProcessQueue<ActiveProcess> queue;

	public SimpleRunQueue() {
		this.queue = new ProcessQueue<ActiveProcess>();
	}

	/**
	 * Adds a process at the end of the run queue.
	 */
	@Override
	public void addProcessToRunQueue(ActiveProcess process, boolean inFront) {
		queue.add(process, inFront);
	}

	@Override
	protected int numWaitingProcesses() {
		return queue.size();
	}

	@Override
	public boolean removePendingProcess(ActiveProcess process) {
		return queue.remove(process);
	}

	@Override
	public IRunQueue createNewInstance() {
		return new SimpleRunQueue();
	}

	@Override
	public List<ActiveProcess> identifyMovableProcesses(
			IResourceInstance targetInstance, boolean prio_increasing, boolean queue_ascending, int processes_needed) {
		List<ActiveProcess> processList = new ArrayList<ActiveProcess>();
		Iterable<ActiveProcess> queue_direction = queue_ascending ? this.queue.ascending() : this.queue.descending();
		for (ActiveProcess process : queue_direction) {
			if (process.checkAffinity(targetInstance)) {
				processList.add(process);
				if (processList.size() >= processes_needed)
					break;
			}
		}
		return processList;
	}

	@Override
	public ProcessQueue<ActiveProcess> getBestRunnableQueue(
			IResourceInstance instance) {
		if (this.queue.containsRunnableFor(instance))
			return this.queue;
		return null;
	}

	@Override
	public ActiveProcess getNextRunnableProcess(IResourceInstance instance) {
		for (ActiveProcess process : queue.ascending()) {
			if (process.checkAffinity(instance))
				return process;
		}
		return null;
	}

	@Override
	public ActiveProcess getNextRunnableProcess() {
		return queue.peek();
	}

	@Override
	public boolean containsPending(ActiveProcess process) {
		return queue.contains(process);
	}

}
