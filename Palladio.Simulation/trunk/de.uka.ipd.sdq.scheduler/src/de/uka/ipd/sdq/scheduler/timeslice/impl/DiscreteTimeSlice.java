package de.uka.ipd.sdq.scheduler.resources.timeslice.impl;

import de.uka.ipd.sdq.probfunction.math.util.MathTools;

public class DiscreteTimeSlice extends AbstractDiscreteTimeSlice {

	public DiscreteTimeSlice(double timePerTick, int ticksPerTimeslice) {
		super(timePerTick);
		this.timeslice = ticksPerTimeslice;
	}

	@Override
	public double getTimeUntilNextInterruption() {
		return remaining_ticks * tick_time;
	}
	

	@Override
	public boolean completelyFinished() {
		return MathTools.equalsDouble(remaining_ticks, 0);
	}
	
	@Override
	public boolean partFinished() {
		return completelyFinished();
	}
	
	/**
	 * Subtracts the rounded (lower end) number of ticks passed during the given
	 * time.
	 */
	public void substractTime(double time) {
		remaining_ticks -= time / tick_time;
		assert MathTools.lessOrEqual(0, remaining_ticks) : "Timeslice exeeded!";
	}
	
	@Override
	public void reset() {
		remaining_ticks = timeslice;
	}

}
