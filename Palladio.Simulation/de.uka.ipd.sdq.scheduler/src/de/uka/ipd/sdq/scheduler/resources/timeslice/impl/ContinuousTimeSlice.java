package de.uka.ipd.sdq.scheduler.resources.timeslice.impl;

import de.uka.ipd.sdq.probfunction.math.util.MathTools;
import de.uka.ipd.sdq.scheduler.resources.timeslice.ITimeSlice;


public class ContinuousTimeSlice implements ITimeSlice {
	
	protected double remainingTimeslice;
	protected double timeslice;
	
	public ContinuousTimeSlice(double timeslice) {
		super();
		this.timeslice = timeslice;
		this.remainingTimeslice = 0;
	}

	@Override
	public double getRemainingTime() {
		return remainingTimeslice;
	}

	@Override
	public boolean isFinished() {
		return MathTools.equalsDouble(remainingTimeslice, 0.0);
	}

	@Override
	public void substractTime(double time) {
		remainingTimeslice -= time;
		assert !MathTools.less(0.0, remainingTimeslice) : "Timeslice exceeded!";
	}

	@Override
	public void reset() {
		remainingTimeslice = timeslice;
	}

	@Override
	public double getGranularity() {
		return this.timeslice;
	}

}
