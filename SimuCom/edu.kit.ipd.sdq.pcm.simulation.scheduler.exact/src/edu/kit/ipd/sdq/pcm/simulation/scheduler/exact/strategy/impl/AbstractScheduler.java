package edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.strategy.impl;

import java.util.Deque;

import scheduler.configuration.StarvationBoost;
import de.uka.ipd.sdq.scheduler.LoggingWrapper;
import de.uka.ipd.sdq.scheduler.processes.IWaitingProcess;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.IResourceInstance;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.SimActiveResource;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.processes.IActiveProcess;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.processes.impl.PreemptiveProcess;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.queueing.IQueueingStrategy;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.resources.passive.WaitingProcess;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.strategy.IScheduler;

public abstract class AbstractScheduler implements IScheduler {
	protected SimActiveResource resource;

	protected IQueueingStrategy queueing_strategy;

	private boolean in_front_after_waiting;

	protected double scheduling_interval;
	
	protected StarvationBoost starvationBoost;

	public AbstractScheduler(SimActiveResource resource,
			IQueueingStrategy queueingStrategy, boolean in_front_after_waiting, StarvationBoost starvationBoost) {
		super();
		this.resource = resource;
		this.queueing_strategy = queueingStrategy;
		this.in_front_after_waiting = in_front_after_waiting;
		this.starvationBoost = starvationBoost;
	}

	
	public void forkNewProcess(IActiveProcess process, IResourceInstance current) {
		queueing_strategy.forkProcess(process, current, false);
	}
	
	public void registerProcess(IActiveProcess p, IResourceInstance instance) {
		queueing_strategy.registerProcess(p,instance);
	}
	
	public void terminateProcess(IActiveProcess process, IResourceInstance current){
		if (process.isRunning()){
			fromRunningToReady(process, current, true);
			queueing_strategy.terminateProcess(process);
			process.getLastInstance().schedulingInterrupt(0);
		} else {
			queueing_strategy.terminateProcess(process);
		}
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
	protected void fromRunningToReady(IActiveProcess process, IResourceInstance current, boolean inFront) {
		LoggingWrapper.log(" From RUNNING to READY Process " + process);
		assert process.isRunning() : "Process must be in running state to return to pending queue!";
		assert queueing_strategy.runningOn(process).equals(
				process.getLastInstance()) : "Inconstistant State of the last instance of the process.";
		assert process.getLastInstance().getRunningProcess().equals(process) : "Inconsistent running state!";
		queueing_strategy.removeRunning(process);
		stopProcess(process);
		process.setReady();
		queueing_strategy.addProcess(process, current, inFront);
	}

	
	public void fromRunningToWaiting(WaitingProcess waiting_process,
			Deque<IWaitingProcess> waiting_queue, boolean in_front) {
		LoggingWrapper.log(" From RUNNING to WAITING Process "
				+ waiting_process.getProcess());
		IActiveProcess process = waiting_process.getActiveProcess();
		assert process.isRunning() : "Process must be in running state.";

		queueing_strategy.fromRunningToWaiting(process);
		stopProcess(process);
		process.setWaiting();
		
		if (in_front) {
			waiting_queue.addFirst(waiting_process);
		} else {
			waiting_queue.addLast(waiting_process);
		}
		
		process.getLastInstance().schedulingInterrupt(0);

		queueing_strategy.onSleep(process.getLastInstance());
		
	}

	private void stopProcess(IActiveProcess process) {
		process.getLastInstance().release();
		process.cancelProceedEvent();
	}

	
	public void fromWaitingToReady(WaitingProcess waiting_process,
			Deque<IWaitingProcess> waitingQueue, IResourceInstance current) {
		LoggingWrapper.log("From WAITING to READY Process "
				+ waiting_process.getProcess());
		IActiveProcess process = waiting_process.getActiveProcess();
		assert process.isWaiting() : "Process must be in waiting state";

		waitingQueue.remove(waiting_process);
		process.setReady();
		
		((PreemptiveProcess)process).getTimeslice().updateTimeForScheduling();
		
		queueing_strategy.fromWaitingToReady(process, current, in_front_after_waiting);
		process.toNow();
		process.update();
		process.getLastInstance().schedulingInterrupt(0);
	}
}
