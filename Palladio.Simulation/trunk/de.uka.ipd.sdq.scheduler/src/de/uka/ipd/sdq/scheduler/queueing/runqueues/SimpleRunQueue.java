package de.uka.ipd.sdq.scheduler.queueing.runqueues;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.scheduler.processes.IActiveProcess;
import de.uka.ipd.sdq.scheduler.queueing.IRunQueue;
import de.uka.ipd.sdq.scheduler.resources.IResourceInstance;

public class SimpleRunQueue extends AbstractRunQueue {

	private ProcessQueue<IActiveProcess> queue;

	public SimpleRunQueue() {
		this.queue = new ProcessQueue<IActiveProcess>();
	}

	/**
	 * Adds a process at the end of the run queue.
	 */
	@Override
	public void addProcessToRunQueue(IActiveProcess process, boolean inFront) {
		queue.add(process, inFront);
	}

	@Override
	protected int numWaitingProcesses() {
		return queue.size();
	}

	@Override
	public boolean removePendingProcess(IActiveProcess process) {
		return queue.remove(process);
	}

	@Override
	public IRunQueue createNewInstance() {
		return new SimpleRunQueue();
	}

	@Override
	public List<IActiveProcess> identifyMovableProcesses(
			IResourceInstance targetInstance, boolean prio_increasing, boolean queue_ascending, int processes_needed) {
		List<IActiveProcess> processList = new ArrayList<IActiveProcess>();
		Iterable<IActiveProcess> queue_direction = queue_ascending ? this.queue.ascending() : this.queue.descending();
		for (IActiveProcess process : queue_direction) {
			if (process.checkAffinity(targetInstance)) {
				processList.add(process);
				if (processList.size() >= processes_needed)
					break;
			}
		}
		return processList;
	}

	@Override
	public ProcessQueue<IActiveProcess> getBestRunnableQueue(
			IResourceInstance instance) {
		if (this.queue.containsRunnableFor(instance))
			return this.queue;
		return null;
	}

	@Override
	public IActiveProcess getNextRunnableProcess(IResourceInstance instance) {
		for (IActiveProcess process : queue.ascending()) {
			if (process.checkAffinity(instance))
				return process;
		}
		return null;
	}

	@Override
	public IActiveProcess getNextRunnableProcess() {
		return queue.peek();
	}

	@Override
	public boolean containsPending(IActiveProcess process) {
		return queue.contains(process);
	}

}
