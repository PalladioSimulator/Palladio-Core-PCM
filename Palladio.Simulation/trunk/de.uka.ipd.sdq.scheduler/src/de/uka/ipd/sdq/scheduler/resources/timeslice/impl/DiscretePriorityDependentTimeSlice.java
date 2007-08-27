package de.uka.ipd.sdq.scheduler.resources.timeslice.impl;

import de.uka.ipd.sdq.probfunction.math.util.MathTools;
import de.uka.ipd.sdq.scheduler.priority.IPriority;
import de.uka.ipd.sdq.scheduler.processes.ProcessWithPriority;

public class DiscretePriorityDependentTimeSlice extends
		AbstractDiscreteTimeSlice {

	private double timeslice_part;
	
	private double remaining_part;

	/**
	 * Computes the timeslice length of a process in dependency of its STATIC
	 * priority.
	 * 
	 * @param timePerTick
	 * @param process
	 *            Process this timeslice is associated to.
	 */
	public DiscretePriorityDependentTimeSlice(double timePerTick, double granularity_divisor,
			int basicTimeslice, int minTimeSlice, ProcessWithPriority process) {
		super(timePerTick);
		int computedTimeSlice = computeTicksFromPriority(process
				.getStaticPriority(), basicTimeslice);
		this.timeslice = Math.max(computedTimeSlice, minTimeSlice);
		this.timeslice_part = this.timeslice / granularity_divisor;

		// Computation from the Linux Scheduler. 5 is the result of ((MAX_BONUS
		// - CURRENT_BONUS(p)) ? : 1) if the current bonus is 5 (which is the
		// average) and MAX_BONUS is 10 (which is the default value)
		// int granularity = (int) Math.max(hertz / 100.0, 1.0);
		// timesliceGranularity = (granularity * ((1 << 5) - 1));
		// remainingPart = 0;
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
		IPriority max_prio = prio.getManager().getHighestPriority();
		int distance = max_prio.distance(prio);
		return basic * distance / max_prio.absoluteValue() / 2;
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
	public double getTimeUntilNextInterruption() {
		return remaining_part * tick_time;
	}

	@Override
	public boolean completelyFinished() {
		return MathTools.equalsDouble(remaining_ticks, 0);
	}

	@Override
	public boolean partFinished() {
		return MathTools.equalsDouble(remaining_part, 0);
	}

	@Override
	public void substractTime(double time) {
		remaining_part -= time / tick_time;
		remaining_ticks -= time / tick_time;
		assert MathTools.lessOrEqual(0, remaining_ticks) : "Part exeeded!";
		assert MathTools.lessOrEqual(0, remaining_ticks) : "Timeslice exeeded!";
}

	@Override
	public void reset() {
		remaining_part = timeslice_part;
		if ( MathTools.equalsDouble( remaining_ticks, 0.0) )
			remaining_ticks = timeslice;
	}

}
