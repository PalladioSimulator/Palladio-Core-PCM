package de.uka.ipd.sdq.scheduler.strategy.impl;

import de.uka.ipd.sdq.scheduler.IRunningProcess;
import de.uka.ipd.sdq.scheduler.priority.IPriority;
import de.uka.ipd.sdq.scheduler.processes.IActiveProcess;
import de.uka.ipd.sdq.scheduler.processes.impl.PreemptiveProcess;
import de.uka.ipd.sdq.scheduler.processes.impl.ProcessWithPriority;
import de.uka.ipd.sdq.scheduler.queueing.IQueueingStrategy;
import de.uka.ipd.sdq.scheduler.resources.IResourceInstance;
import de.uka.ipd.sdq.scheduler.resources.active.SimActiveResource;

public class PreemptiveScheduler extends AbstractScheduler {

	private double scheduling_interval;
	
	public PreemptiveScheduler(SimActiveResource resource,
			IQueueingStrategy queueingStrategy, boolean in_front_after_waiting,
			double scheduling_interval) {
		super(resource, queueingStrategy, in_front_after_waiting);
		this.scheduling_interval = scheduling_interval;
	}

	@Override
	public void schedule(IResourceInstance instance) {
		// Balance the runqueue of this instance with the runqueues of other
		// instances. This might change the state of the instance's runqueue.
		// So, the next runnable process can only be determined after the
		// balancing was finished.
		queueing_strategy.balance(instance);

		// get the currently scheduled process for the instance.
		ProcessWithPriority running_process = (ProcessWithPriority) instance
				.getRunningProcess();

		// Update the timing variables and priority of the process. Possibly
		// pending events of the process are canceled.
		toNow(running_process);
		
		if (running_process == null){
			scheduleNextProcess(instance);
		} else if ( running_process.timeSliceCompletelyFinished()) {
			unschedule(running_process, false);
			scheduleNextProcess(instance);
		} else if ( running_process.timeSlicePartFinished()) {
			unschedule(running_process, false);
			scheduleNextProcess(instance);
		} else {
			ProcessWithPriority next_process = (ProcessWithPriority) queueing_strategy.getNextProcessFor(instance);
			
			if ( hasHigherPriority(next_process,running_process) ) {
				unschedule(running_process, true);
				scheduleNextProcess(next_process, instance);
			}
		}
		
		scheduleNextEvent(instance);
	}

	private void scheduleNextProcess(ProcessWithPriority next_process, IResourceInstance instance) {
		if (next_process != null) {
			next_process.toNow();
			fromReadyToRunningOn(next_process, instance);
		}
	}

	private void scheduleNextProcess(IResourceInstance instance) {
		ProcessWithPriority next_process = (ProcessWithPriority) queueing_strategy.getNextProcessFor(instance);
		scheduleNextProcess(next_process, instance);
	}

	private void toNow(ProcessWithPriority process) {
		if (process != null) {
			process.toNow();
		}
	}

	private void unschedule(ProcessWithPriority running_process,
			boolean next_has_higher_priority) {
		if (running_process != null) {
			fromRunningToReady(running_process, next_has_higher_priority
					&& !running_process.timeSlicePartFinished());
			running_process.update();
		}
	}

	/**
	 * pOne > pTwo ?
	 * 
	 * @param pTwo
	 * @return
	 */
	private boolean hasHigherPriority(ProcessWithPriority pOne,
			ProcessWithPriority pTwo) {
		if (pOne == null)
			return false;
		if (pTwo == null)
			return true;
		IPriority prio_one = pOne.getDynamicPriority();
		IPriority prio_two = pTwo.getDynamicPriority();
		return prio_one.greaterThan(prio_two);
	}

	public void scheduleNextEvent(IResourceInstance instance) {
		ProcessWithPriority running = (ProcessWithPriority) instance
				.getRunningProcess();
		if (running != null) {
			if (running.getCurrentDemand() < running
					.getTimeUntilNextInterruption()) {
				instance.cancelSchedulingEvent();
				running.scheduleProceedEvent();
			} else {
				running.cancelProceedEvent();
				instance.scheduleSchedulingEvent(running
						.getTimeUntilNextInterruption());
			}
		} else {
			if (!instance.schedulingEventScheduled()){
				instance.scheduleSchedulingEvent(scheduling_interval);
			}
		}
	}

	@Override
	public boolean isIdle(IResourceInstance instance) {
		return queueing_strategy.isIdle(instance);
	}

	@Override
	protected void initialiseProcess(IActiveProcess process) {
		PreemptiveProcess preemptiveProcess = (PreemptiveProcess) process;
		preemptiveProcess.resetTimeSlice();
	}

}
