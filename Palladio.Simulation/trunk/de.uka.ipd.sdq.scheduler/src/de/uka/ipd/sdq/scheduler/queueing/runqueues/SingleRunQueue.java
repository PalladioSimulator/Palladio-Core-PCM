package de.uka.ipd.sdq.scheduler.queueing.runqueues;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.scheduler.processes.IActiveProcess;
import de.uka.ipd.sdq.scheduler.queueing.IProcessQueue;
import de.uka.ipd.sdq.scheduler.queueing.IRunQueue;
import de.uka.ipd.sdq.scheduler.resources.IResourceInstance;


public class SingleRunQueue extends AbstractRunQueue  {
	
	private IProcessQueue process_queue;

	public SingleRunQueue(IProcessQueue queue_prototype) {
		this.process_queue = queue_prototype.createNewInstance();
	}

	protected int numWaitingProcesses() {
		return process_queue.size();
	}

	public IActiveProcess getNextRunnableProcess(IResourceInstance instance) {
		return process_queue.getNextRunnableProcess(instance);
	}
	
	public IActiveProcess getNextRunnableProcess() {
		return process_queue.getNextRunnableProcess();
	}

	public boolean removePendingProcess(IActiveProcess process) {
		return process_queue.remove(process);
	}

	public IRunQueue createNewInstance() {
		return new SingleRunQueue(process_queue);
	}

	public List<IActiveProcess> identifyMovableProcesses(
			IResourceInstance targetInstance, boolean prio_increasing, boolean queue_ascending, int processes_needed) {
		List<IActiveProcess> process_list = new ArrayList<IActiveProcess>();
		process_queue.identifyMovableProcesses(targetInstance,prio_increasing,queue_ascending,processes_needed, process_list);
		return process_list;
	}

	public IProcessQueue getBestRunnableQueue(
			IResourceInstance instance) {
		return this.process_queue.getBestRunnableQueue(instance);
	}

	public boolean containsPending(IActiveProcess process) {
		return process_queue.contains(process);
	}

	protected void addProcessToRunQueue(IActiveProcess process, boolean inFront) {
		process_queue.add(process, inFront);
	}
}
