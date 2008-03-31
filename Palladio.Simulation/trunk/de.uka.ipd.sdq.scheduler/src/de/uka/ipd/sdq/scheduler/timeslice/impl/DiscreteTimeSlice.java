package de.uka.ipd.sdq.scheduler.timeslice.impl;

import de.uka.ipd.sdq.scheduler.timeslice.ITimeSlice;

public class DiscreteTimeSlice implements ITimeSlice {

	int per_quantum = 3;
	int quanta = 2;
	int value = per_quantum * quanta;

	int current_value;

	public DiscreteTimeSlice() {
		super();
		fullReset();
	}

	
	public double getTimeUntilNextInterruption() {
		return getRemainingTime();
	}

	
	public double getRemainingTime() {
		// Process.toString
		return current_value;
	}

	
	public boolean completelyFinished() {
		return (current_value <= 0);
	}

	
	public boolean partFinished() {
		// PreemptiveScheduler.schedule
		// PreemptiveScheduler.unschedule
		return completelyFinished();
	}

	
	public void fullReset() {
		// Boost.boost
		// PreemptiveScheduler.initialiseProcess
		this.current_value = value;
	}

	
	public void reset() {
		// PreemptiveScheduler.unschedule (Preemt.uptdate)
		fullReset();
	}

	
	public void punish(int penalty) {
		current_value -= penalty;
	}

	
	public void setExpired() {
		current_value = 0;
	}

	
	public void quantumFinished() {
		current_value -= per_quantum;
	}

	public void substractTime(double time) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public DiscreteTimeSlice clone() {
		return null;
	}

	public void halfReset() {
		current_value = value / 2;
	}

	public void enoughTime() {
		// TODO Auto-generated method stub
		
	}
}

