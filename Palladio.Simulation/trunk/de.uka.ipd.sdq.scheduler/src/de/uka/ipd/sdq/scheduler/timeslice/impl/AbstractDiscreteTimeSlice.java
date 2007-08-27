package de.uka.ipd.sdq.scheduler.timeslice.impl;

import de.uka.ipd.sdq.scheduler.timeslice.ITimeSlice;

public abstract class AbstractDiscreteTimeSlice implements ITimeSlice {

	protected double remaining_ticks;

	protected double tick_time;
	
	protected int timeslice;
	
	public AbstractDiscreteTimeSlice(double timePerTick) {
		super();
		this.remaining_ticks = 0;
		this.tick_time = timePerTick;
	}

	public abstract double getTimeUntilNextInterruption();

	public int getRemainingTicks() {
		return (int)remaining_ticks;
	}

	public void setRemainingTicks(int remainingTicks) {
		this.remaining_ticks = remainingTicks;
	}
}
