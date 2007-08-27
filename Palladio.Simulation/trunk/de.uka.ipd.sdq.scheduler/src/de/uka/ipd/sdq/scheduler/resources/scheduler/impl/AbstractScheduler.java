package de.uka.ipd.sdq.scheduler.resources.scheduler.impl;

import de.uka.ipd.sdq.scheduler.processes.ActiveProcess;
import de.uka.ipd.sdq.scheduler.resources.SimActiveResource;
import de.uka.ipd.sdq.scheduler.resources.SimResourceInstance;
import de.uka.ipd.sdq.scheduler.resources.passive.WaitingProcess;
import de.uka.ipd.sdq.scheduler.resources.queueing.IQueueingStrategy;
import de.uka.ipd.sdq.scheduler.resources.queueing.runqueues.ProcessQueue;
import de.uka.ipd.sdq.scheduler.resources.scheduler.IScheduler;

public abstract class AbstractScheduler implements IScheduler {

	protected SimActiveResource resource;

	protected IQueueingStrategy queueing_strategy;

	private boolean in_front_after_waiting;

	public AbstractScheduler(SimActiveResource resource,
			IQueueingStrategy queueingStrategy, boolean in_front_after_waiting) {
		super();
		this.resource = resource;
		this.queueing_strategy = queueingStrategy;
		this.in_front_after_waiting = in_front_after_waiting;
	}

	public abstract void schedule(SimResourceInstance instance);

	@Override
	public void addProcess(ActiveProcess process) {
		queueing_strategy.addProcess(process, false);
	}

	/**
	 * Marks the given process as executing on the specified resource instance.
	 * 
	 * @param process
	 * @param instance
	 */
	protected void fromReadyToRunningOn(ActiveProcess process,
			SimResourceInstance instance) {
		assert process != null;
		assert process.isReady();
		assert queueing_strategy.containsPending(process);
		assert instance.noProcessAssigned();

		queueing_strategy.removePendingProcess(process);
		process.setRunning();
		queueing_strategy.setRunningOn(process, instance);

		instance.assign(process);
		process.setLastInstance(instance);
	}

	/**
	 * 
	 * @param process
	 */
	protected void fromRunningToReady(ActiveProcess process, boolean inFront) {
		assert process.isRunning() : "Process must be in running state to return to pending queue!";
		assert queueing_strategy.runningOn(process).equals(
				process.getLastInstance()) : "Inconstistant State of the last instance of the process.";
		assert process.getLastInstance().getRunningProcess().equals(process) : "Inconsistent running state!";
		process.getLastInstance().release();
		queueing_strategy.removeRunning(process);
		process.setReady();
		queueing_strategy.addProcess(process, inFront);
	}

	@Override
	public void fromWaitingToReady(WaitingProcess waiting_process, ProcessQueue<WaitingProcess> waitingQueue) {
		ActiveProcess process = waiting_process.getProcess();
		assert process.isWaiting() : "Process must be in waiting state";
		
		waitingQueue.remove(waiting_process);
		process.setReady();
		queueing_strategy.addProcess(process, in_front_after_waiting);
		process.getLastInstance().scheduleSchedulingEvent(0);
	}

	@Override
	public void fromRunningToWaiting(WaitingProcess waiting_process,
			ProcessQueue<WaitingProcess> waitingQueue, boolean inFront) {
		ActiveProcess process = waiting_process.getProcess();
		assert process.isRunning() : "Process must be in running state.";
		
		process.getRunQueue().removeRunning(process);
		process.setWaiting();
		waitingQueue.add(waiting_process,inFront);
		process.getLastInstance().scheduleSchedulingEvent(0);
	}
}
