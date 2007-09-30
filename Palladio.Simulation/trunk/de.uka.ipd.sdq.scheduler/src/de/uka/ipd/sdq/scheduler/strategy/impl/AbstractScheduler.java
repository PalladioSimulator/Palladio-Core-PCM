package de.uka.ipd.sdq.scheduler.strategy.impl;

import java.util.Deque;

import de.uka.ipd.sdq.scheduler.LoggingWrapper;
import de.uka.ipd.sdq.scheduler.processes.IActiveProcess;
import de.uka.ipd.sdq.scheduler.queueing.IQueueingStrategy;
import de.uka.ipd.sdq.scheduler.resources.IResourceInstance;
import de.uka.ipd.sdq.scheduler.resources.active.SimActiveResource;
import de.uka.ipd.sdq.scheduler.resources.passive.WaitingProcess;
import de.uka.ipd.sdq.scheduler.strategy.IScheduler;

public abstract class AbstractScheduler implements IScheduler {

	protected SimActiveResource resource;

	protected IQueueingStrategy queueing_strategy;

	private boolean in_front_after_waiting;

	protected double scheduling_interval;

	public AbstractScheduler(SimActiveResource resource,
			IQueueingStrategy queueingStrategy, boolean in_front_after_waiting) {
		super();
		this.resource = resource;
		this.queueing_strategy = queueingStrategy;
		this.in_front_after_waiting = in_front_after_waiting;
	}

	/**
	 * Template Method.
	 * 
	 * @param process
	 */
	protected abstract void initialiseProcess(IActiveProcess process);

	@Override
	public void addProcess(IActiveProcess process) {
		queueing_strategy.addProcess(process, false);
		initialiseProcess(process);
	}

	/**
	 * Marks the given process as executing on the specified resource instance.
	 * 
	 * @param process
	 * @param instance
	 */
	protected void fromReadyToRunningOn(IActiveProcess process,
			IResourceInstance instance) {
		LoggingWrapper.log(" From READY to RUNNING " + process + " on "
				+ instance);
		assert process != null;
		assert process.isReady();
		assert queueing_strategy.containsPending(process);
		assert !instance.processAssigned();

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
	protected void fromRunningToReady(IActiveProcess process, boolean inFront) {
		LoggingWrapper.log(" From RUNNING to READY Process " + process);
		assert process.isRunning() : "Process must be in running state to return to pending queue!";
		assert queueing_strategy.runningOn(process).equals(
				process.getLastInstance()) : "Inconstistant State of the last instance of the process.";
		assert process.getLastInstance().getRunningProcess().equals(process) : "Inconsistent running state!";
		stopProcess(process);
		process.setReady();
		queueing_strategy.addProcess(process, inFront);
	}

	@Override
	public void fromRunningToWaiting(WaitingProcess waiting_process,
			Deque<WaitingProcess> waiting_queue, boolean in_front) {
		LoggingWrapper.log(" From RUNNING to WAITING Process "
				+ waiting_process.getProcess());
		IActiveProcess process = waiting_process.getProcess();
		assert process.isRunning() : "Process must be in running state.";

		stopProcess(process);
		process.setWaiting();
		if (in_front) {
			waiting_queue.addFirst(waiting_process);
		} else {
			waiting_queue.addLast(waiting_process);
		}
		process.getLastInstance().schedulingInterrupt(0, false);
	}

	private void stopProcess(IActiveProcess process) {
		process.getLastInstance().release();
		queueing_strategy.removeRunning(process);
		process.cancelProceedEvent();
	}

	@Override
	public void fromWaitingToReady(WaitingProcess waiting_process,
			Deque<WaitingProcess> waitingQueue) {
		LoggingWrapper.log("From WAITING to READY Process "
				+ waiting_process.getProcess());
		IActiveProcess process = waiting_process.getProcess();
		assert process.isWaiting() : "Process must be in waiting state";

		waitingQueue.remove(waiting_process);
		process.setReady();
		queueing_strategy.addProcess(process, in_front_after_waiting);
		process.getLastInstance().schedulingInterrupt(0, true);
	}
}
