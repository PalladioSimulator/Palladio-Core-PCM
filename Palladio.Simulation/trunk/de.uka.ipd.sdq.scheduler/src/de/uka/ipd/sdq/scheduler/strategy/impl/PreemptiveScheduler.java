package de.uka.ipd.sdq.scheduler.strategy.impl;

import de.uka.ipd.sdq.scheduler.priority.IPriority;
import de.uka.ipd.sdq.scheduler.processes.ProcessWithPriority;
import de.uka.ipd.sdq.scheduler.queueing.IQueueingStrategy;
import de.uka.ipd.sdq.scheduler.resources.SimActiveResource;
import de.uka.ipd.sdq.scheduler.resources.SimResourceInstance;

public class PreemptiveScheduler extends AbstractScheduler {

	private double scheduling_interval;

	public PreemptiveScheduler(SimActiveResource resource,
			IQueueingStrategy queueingStrategy, boolean in_front_after_waiting,
			double scheduling_interval) {
		super(resource, queueingStrategy, in_front_after_waiting);
		this.scheduling_interval = scheduling_interval;
	}

	@Override
	public void schedule(SimResourceInstance instance) {
		// Cancel possibly pending scheduling events for the instance. The new
		// events are determined in the process of this method.
		instance.cancelSchedulingEvent();

		// Balance the runqueue of this instance with the runqueues of other
		// instances. This might change the state of the instance's runqueue.
		// So, the next runnable process can only be determined after the
		// balancing was finished.
		queueing_strategy.balance(instance);

		ProcessWithPriority running_process = (ProcessWithPriority) instance
				.getRunningProcess();
		ProcessWithPriority next_process = (ProcessWithPriority) queueing_strategy
				.getNextProcessFor(instance);

		// Update the timing variables and priority of the process. Possibly
		// pending events of the process are canceled.
		updateProcessState(running_process);

		boolean next_has_higher_priority = hasHigherPriority(next_process,
				running_process);

		if ( reschedulingNeeded(running_process, next_process)
				|| next_has_higher_priority) {
			unschedule(running_process, next_has_higher_priority);
			next_process.toNow();
			fromReadyToRunningOn(next_process, instance);
		}
		scheduleNextEvent(instance);
	}

	private void updateProcessState(ProcessWithPriority process) {
		if (process != null) {
			process.toNow();
			process.cancelProceedEvent();
			if (process.timeSliceCompletelyFinished()) {
				process.updatePriority();
			}
		}
	}

	private void unschedule(ProcessWithPriority running_process,
			boolean next_has_higher_priority) {
		if (running_process != null) {
			fromRunningToReady(running_process, next_has_higher_priority
					&& !running_process.timeSlicePartFinished());
			if (running_process.timeSlicePartFinished()) {
				running_process.resetTimeSlice();
			}
		}
	}

	private boolean reschedulingNeeded(ProcessWithPriority running_process,
			ProcessWithPriority next_process) {

		if (running_process == null)
			return next_process != null;

		if (next_process == null)
			return running_process.timeSlicePartFinished();

		return running_process.timeSlicePartFinished();
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

	public void scheduleNextEvent(SimResourceInstance instance) {
		ProcessWithPriority running = (ProcessWithPriority) instance
				.getRunningProcess();
		if (running != null) {
			if (running.getCurrentDemand() < running
					.getTimeUntilNextInterruption())
				running.scheduleProceedEvent();
			else
				instance.scheduleSchedulingEvent(running
						.getTimeUntilNextInterruption());
		} else {
			instance.scheduleSchedulingEvent(scheduling_interval);
		}
	}
}
