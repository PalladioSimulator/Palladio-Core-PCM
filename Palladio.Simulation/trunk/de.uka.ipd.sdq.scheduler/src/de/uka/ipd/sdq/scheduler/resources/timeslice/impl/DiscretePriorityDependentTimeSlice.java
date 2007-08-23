package de.uka.ipd.sdq.scheduler.resources.timeslice.impl;

import de.uka.ipd.sdq.scheduler.priority.IPriority;
import de.uka.ipd.sdq.scheduler.processes.ProcessWithPriority;

public class DiscretePriorityDependentTimeSlice extends
		AbstractDiscreteTimeSlice {

	private int timesliceGranularity;

	/**
	 * Computes the timeslice length of a process in dependency of its STATIC
	 * priority.
	 * 
	 * @param timePerTick
	 * @param process
	 *            Process this timeslice is associated to.
	 */
	public DiscretePriorityDependentTimeSlice(double timePerTick,
			int basicTimeslice, int minTimeSlice, ProcessWithPriority process) {
		super(timePerTick);
		int computedTimeSlice = computeTicksFromPriority(process
				.getStaticPriority(), basicTimeslice);
		this.timeslice = Math.max(computedTimeSlice, minTimeSlice);

		// Computation from the Linux Scheduler. 5 is the result of ((MAX_BONUS
		// - CURRENT_BONUS(p)) ? : 1) if the current bonus is 5 (which is the
		// average) and MAX_BONUS is 10 (which is the default value)
		int granularity = (int) Math.max((10 * 1 / timePerTick) / 1000.0, 1.0);
		timesliceGranularity = (granularity * ((1 << 5) - 1));
	}

	/**
	 * Computes the length of the current time slice according to the Linux
	 * 2.6.18 Scheduler.
	 * 
	 * @param process
	 * @return
	 */
	private int computeTicksFromPriority(IPriority prio, int basicTimeslice) {
		int basic = getBasicTimeSlice(prio, basicTimeslice);
		IPriority max_prio = prio.getManager().getMaxPriority();
		int difference = max_prio.minus(prio);
		return basic * difference / max_prio.absoluteValue() / 2;
	}

	/**
	 * Processes with a static priority above default are prefered.
	 * 
	 * @param static_prio
	 * @return
	 */
	private int getBasicTimeSlice(IPriority static_prio, int basicTimeslice) {
		IPriority default_prio = static_prio.getManager().getDefaultPriority();
		if (static_prio.greaterThan(default_prio)) {
			return basicTimeslice * 4;
		} else {
			return basicTimeslice;
		}
	}

	@Override
	public double getGranularity() {
		return this.timesliceGranularity * this.timePerTick;
	}
}
