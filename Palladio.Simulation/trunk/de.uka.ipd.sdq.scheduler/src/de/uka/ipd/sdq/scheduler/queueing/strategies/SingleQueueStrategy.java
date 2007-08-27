package de.uka.ipd.sdq.scheduler.queueing.strategies;

import de.uka.ipd.sdq.scheduler.balancing.IProcessSelector;
import de.uka.ipd.sdq.scheduler.processes.ActiveProcess;
import de.uka.ipd.sdq.scheduler.queueing.IQueueingStrategy;
import de.uka.ipd.sdq.scheduler.queueing.IRunQueue;
import de.uka.ipd.sdq.scheduler.resources.active.SimResourceInstance;

public class SingleQueueStrategy implements IQueueingStrategy {

	private IRunQueue runQueue;
	private IProcessSelector processSelector;

	public SingleQueueStrategy(IRunQueue runQueue,
			IProcessSelector processSelector) {
		super();
		this.runQueue = runQueue;
		this.processSelector = processSelector;
	}

	@Override
	public ActiveProcess getNextProcessFor(SimResourceInstance instance) {
		return processSelector.select(runQueue, instance);
	}

	@Override
	public void addProcess(ActiveProcess process, boolean inFront) {
		runQueue.addProcess(process, inFront);
	}

	@Override
	public void balance(SimResourceInstance instance) {
		// nothing to do.
	}

	@Override
	public boolean removePendingProcess(ActiveProcess process) {
		return runQueue.removePendingProcess(process);
	}

	@Override
	public boolean containsPending(ActiveProcess process) {
		return runQueue.containsPending(process);
	}

	@Override
	public void removeRunning(ActiveProcess process) {
		runQueue.removeRunning(process);
	}

	@Override
	public SimResourceInstance runningOn(ActiveProcess process) {
		return runQueue.runningOn(process);
	}

	@Override
	public void setRunningOn(ActiveProcess process, SimResourceInstance instance) {
		runQueue.setRunningOn(process, instance);
	}

}
