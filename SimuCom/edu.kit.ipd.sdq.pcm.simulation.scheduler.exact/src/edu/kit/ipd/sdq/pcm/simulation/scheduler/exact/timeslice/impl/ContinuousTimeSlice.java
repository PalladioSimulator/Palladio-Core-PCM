package edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.timeslice.impl;

import de.uka.ipd.sdq.probfunction.math.util.MathTools;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.timeslice.ITimeSlice;


public class ContinuousTimeSlice implements ITimeSlice {
	
	protected double remaining_time;
	protected double timeslice;
	
	public ContinuousTimeSlice(double timeslice) {
		super();
		this.timeslice = timeslice;
		this.remaining_time = 0;
	}
	
	protected ContinuousTimeSlice(){
		this.timeslice = 0;
		this.remaining_time = 0;
	}

	public boolean isFinished() {
		return MathTools.equalsDouble(remaining_time, 0.0);
	}
	
	
	public void substractTime(double time) {
		remaining_time -= time;
		assert MathTools.lessOrEqual(0.0, remaining_time) : "Timeslice exceeded: " + remaining_time;
	}

	
	public void fullReset() {
		remaining_time = timeslice;
	}

	
	public double getRemainingTime() {
		return remaining_time;
	}

	
	public void punish(int penalty) {
		double time = Math.min(penalty, remaining_time);
		substractTime(time);
	}

	
	public void setExpired() {
		this.remaining_time = 0;
		
	}
	
	@Override
	public ITimeSlice clone() {
		ContinuousTimeSlice cts = new ContinuousTimeSlice();
		cts.timeslice = this.timeslice;
		cts.remaining_time = this.remaining_time;
		return cts;
	}

	
	public void halfReset() {
	}

	public void updateTimeForBoosting() {
	}

	public void updateTimeForScheduling() {
	}
}
