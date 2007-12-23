package de.uka.ipd.sdq.scheduler.queueing.strategies;

import de.uka.ipd.sdq.scheduler.loaddistribution.IInstanceSelector;
import de.uka.ipd.sdq.scheduler.loaddistribution.IProcessSelector;
import de.uka.ipd.sdq.scheduler.processes.IActiveProcess;
import de.uka.ipd.sdq.scheduler.queueing.IQueueingStrategy;
import de.uka.ipd.sdq.scheduler.queueing.IRunQueue;
import de.uka.ipd.sdq.scheduler.resources.IResourceInstance;

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

	@Override
	public IActiveProcess getNextProcessFor(IResourceInstance instance) {
		return processSelector.select(runQueue, instance);
	}

	
	public void addProcess(IActiveProcess process, boolean inFront) {
		IResourceInstance instance = process.getLastInstance();
		if (instance == null) {
			instance = idealInstanceSelector.selectInstanceFor(process);
			process.setLastInstance(instance);
		}
		runQueue.addProcess(process, inFront);
	}

	
	public void balance(IResourceInstance instance) {
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

}
