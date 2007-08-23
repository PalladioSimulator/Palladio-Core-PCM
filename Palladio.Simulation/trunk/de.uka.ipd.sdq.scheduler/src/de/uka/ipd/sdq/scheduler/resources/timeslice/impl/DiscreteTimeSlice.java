package de.uka.ipd.sdq.scheduler.resources.timeslice.impl;


public class DiscreteTimeSlice extends AbstractDiscreteTimeSlice {
	
	public DiscreteTimeSlice(double timePerTick, int ticksPerTimeslice) {
		super(timePerTick);
		this.timeslice = ticksPerTimeslice;
	}

	@Override
	public double getGranularity() {
		return this.timeslice * this.timePerTick;
	}
}
