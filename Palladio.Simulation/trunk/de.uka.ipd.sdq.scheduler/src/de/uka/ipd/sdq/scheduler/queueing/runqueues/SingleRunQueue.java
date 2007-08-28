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

	@Override
	protected int numWaitingProcesses() {
		return process_queue.size();
	}

	@Override
	public IActiveProcess getNextRunnableProcess(IResourceInstance instance) {
		return process_queue.getNextRunnableProcess(instance);
	}
	
	@Override
	public IActiveProcess getNextRunnableProcess() {
		return process_queue.getNextRunnableProcess();
	}

	@Override
	public boolean removePendingProcess(IActiveProcess process) {
		return process_queue.remove(process);
	}

	@Override
	public IRunQueue createNewInstance() {
		return new SingleRunQueue(process_queue);
	}

	@Override
	public List<IActiveProcess> identifyMovableProcesses(
			IResourceInstance targetInstance, boolean prio_increasing, boolean queue_ascending, int processes_needed) {
		List<IActiveProcess> process_list = new ArrayList<IActiveProcess>();
		process_queue.identifyMovableProcesses(targetInstance,prio_increasing,queue_ascending,processes_needed, process_list);
		return process_list;
	}

	@Override
	public IProcessQueue getBestRunnableQueue(
			IResourceInstance instance) {
		return this.process_queue.getBestRunnableQueue(instance);
	}

	@Override
	public boolean containsPending(IActiveProcess process) {
		return process_queue.contains(process);
	}

	@Override
	protected void addProcessToRunQueue(IActiveProcess process, boolean inFront) {
		process_queue.add(process, inFront);
	}
}
