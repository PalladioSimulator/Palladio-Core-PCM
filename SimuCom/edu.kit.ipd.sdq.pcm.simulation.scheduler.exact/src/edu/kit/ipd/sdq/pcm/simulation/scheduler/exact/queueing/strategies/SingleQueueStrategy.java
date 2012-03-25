package edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.queueing.strategies;

import java.util.List;

import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.IResourceInstance;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.loaddistribution.IInstanceSelector;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.loaddistribution.IProcessSelector;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.processes.IActiveProcess;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.queueing.IQueueingStrategy;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.queueing.IRunQueue;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.resources.active.SimResourceInstance;

public class SingleQueueStrategy implements IQueueingStrategy {

	private IRunQueue runQueue;
	private IProcessSelector processSelector;
	private IInstanceSelector idealInstanceSelector;
	public SingleQueueStrategy(IRunQueue runQueue,
			IProcessSelector processSelector,
			IInstanceSelector idealInstanceSelector) {
		super();
		this.runQueue = runQueue;
		this.processSelector = processSelector;
		this.idealInstanceSelector = idealInstanceSelector;
	}

	public IActiveProcess getNextProcessFor(IResourceInstance instance) {
		return processSelector.select(runQueue, instance);
	}

	public void registerProcess(IActiveProcess process, IResourceInstance current) {
		IResourceInstance instance = process.getLastInstance();
		if (instance == null) {
			instance = idealInstanceSelector.selectInstanceFor(process, current);
			process.setLastInstance(instance);
		}
	}
	
	public void addProcess(IActiveProcess process, IResourceInstance current, boolean inFront) {
		registerProcess(process, current);
		runQueue.addProcess(process, inFront);
	}

	
	public void activelyBalance(IResourceInstance instance) {
		// nothing to do.
	}

	
	public boolean removePendingProcess(IActiveProcess process) {
		return runQueue.removePendingProcess(process);
	}

	
	public boolean containsPending(IActiveProcess process) {
		return runQueue.containsPending(process);
	}

	
	public void removeRunning(IActiveProcess process) {
		runQueue.removeRunning(process);
	}

	
	public IResourceInstance runningOn(IActiveProcess process) {
		return runQueue.runningOn(process);
	}

	
	public void setRunningOn(IActiveProcess process, IResourceInstance instance) {
		runQueue.setRunningOn(process, instance);
	}

	
	public boolean isIdle(IResourceInstance instance) {
		return runQueue.isIdle(instance);
	}

	public void forkProcess(IActiveProcess process, IResourceInstance current,
			boolean inFront) {
		addProcess(process, current, inFront);
	}

	public void fromRunningToWaiting(IActiveProcess process) {
		removeRunning(process);
	}

	public void fromWaitingToReady(IActiveProcess process,
			IResourceInstance current, boolean in_front_after_waiting) {
		addProcess(process, current, in_front_after_waiting);
	}

	public void terminateProcess(IActiveProcess process) {
		removePendingProcess(process);
	}

	public void onSleep(IResourceInstance lastInstance) {
		// nothing to do
	}

	public List<IActiveProcess> getStarvingProcesses(
			IResourceInstance instance, double starvationLimit) {
		return runQueue.getStarvingProcesses(starvationLimit);
	}
	
	public void resetStarvationInfo() {
		runQueue.resetStarvationInfo();
	}

	public int getQueueLengthFor(SimResourceInstance simResourceInstance) {
		return this.runQueue.getCurrentLoad();
	}

}
