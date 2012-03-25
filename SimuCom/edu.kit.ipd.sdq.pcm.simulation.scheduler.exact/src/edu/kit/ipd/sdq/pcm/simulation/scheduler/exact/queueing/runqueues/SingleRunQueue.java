package edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.queueing.runqueues;

import java.util.ArrayList;
import java.util.List;

import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.IResourceInstance;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.processes.IActiveProcess;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.queueing.IProcessQueue;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.queueing.IRunQueue;


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
	
	public IActiveProcess getNextRunnableProcess() {
		return process_queue.getNextRunnableProcess();
	}

	@Override
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

	@Override
	public boolean containsPending(IActiveProcess process) {
		return process_queue.contains(process);
	}

	@Override
	protected void addProcessToRunQueue(IActiveProcess process, boolean inFront) {
		process_queue.add(process, inFront);
	}
	
	public boolean processStarving(double threshold) {
		return process_queue.processStarving(threshold);
	}
	
	public void setWaitingTime(IActiveProcess process, double waiting) {
		process_queue.setWaitingTime(process, waiting);
	}
	
	public double getWaitingTime(IActiveProcess process) {
		return process_queue.getWaitingTime(process);
	}

	public List<IActiveProcess> getStarvingProcesses(double starvationLimit) {
		return process_queue.getStarvingProcesses(starvationLimit);
	}
	
	public void resetStarvationInfo() {
	}
}
