package de.uka.ipd.sdq.scheduler.resources.timeslice.impl;

import de.uka.ipd.sdq.scheduler.resources.timeslice.ITimeSlice;

public abstract class AbstractDiscreteTimeSlice implements ITimeSlice {

	protected int remainingTicks;

	protected double timePerTick;
	
	protected int timeslice;
	
	public AbstractDiscreteTimeSlice(double timePerTick) {
		super();
		this.remainingTicks = 0;
		this.timePerTick = timePerTick;
	}

	public double getRemainingTime(){
		return remainingTicks * timePerTick;
	}

	public boolean isFinished() {
		return remainingTicks == 0;
	}
	
	@Override
	public void reset() {
		remainingTicks = timeslice;
	}

	/**
	 * Subtracts the rounded (lower end) number of ticks passed during the given
	 * time.
	 */
	public void substractTime(double time) {
		int ticks = (int) (time / timePerTick);
		remainingTicks -= ticks;
		assert remainingTicks >= 0 : "Timeslice exeeded!";
	}

	public int getRemainingTicks() {
		return remainingTicks;
	}

	public void setRemainingTicks(int remainingTicks) {
		this.remainingTicks = remainingTicks;
	}
}
