package de.uka.ipd.sdq.scheduler.timeslice.impl;

import de.uka.ipd.sdq.scheduler.priority.IPriority;
import de.uka.ipd.sdq.scheduler.processes.impl.ProcessWithPriority;

public class PriorityDependentTimeSlice extends ContinuousTimeSlice {

	public PriorityDependentTimeSlice(ProcessWithPriority process, double basic_timeslice, double min_timeslice, int granularity) {
		double computed_timeslice = computeTicksFromPriority(process
				.getStaticPriority(), basic_timeslice);
		this.timeslice = Math.max(computed_timeslice, min_timeslice);
		this.part = this.timeslice / granularity;
	}

	/**
	 * Computes the length of the current time slice according to the Linux
	 * 2.6.18 Scheduler.
	 * 
	 * @param process
	 * @return
	 */
	public static double computeTicksFromPriority(IPriority prio, double basic_timeslice) {
		double basic = getBasicTimeSlice(prio, basic_timeslice);
		IPriority max_prio = prio.getManager().getHighestPriority();
		IPriority min_prio = prio.getManager().getLowestPriority();
		int distance = min_prio.distance(prio) + 1;
		double factor = (min_prio.distance(max_prio) + 1) / 2;
		return basic * distance / factor;
	}

	/**
	 * Processes with a static priority above default are preferred.
	 * 
	 * @param static_prio
	 * @return
	 */
	public static double getBasicTimeSlice(IPriority static_prio, double basicTimeslice) {
		IPriority default_prio = static_prio.getManager().getDefaultPriority();
		if (static_prio.greaterThan(default_prio)) {
			return basicTimeslice * 4;
		} else {
			return basicTimeslice;
		}
	}
}
