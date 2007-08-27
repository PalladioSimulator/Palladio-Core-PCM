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
	public double getTimeUntilNextInterruption() {
		return remainingTimeslice;
	}

	@Override
	public boolean completelyFinished() {
		return MathTools.equalsDouble(remainingTimeslice, 0.0);
	}
	
	@Override
	public boolean partFinished() {
		return completelyFinished();
	}

	@Override
	public void substractTime(double time) {
		remainingTimeslice -= time;
		assert !MathTools.less(remainingTimeslice, 0.0) : "Timeslice exceeded!";
	}

	@Override
	public void reset() {
		remainingTimeslice = timeslice;
	}
}
