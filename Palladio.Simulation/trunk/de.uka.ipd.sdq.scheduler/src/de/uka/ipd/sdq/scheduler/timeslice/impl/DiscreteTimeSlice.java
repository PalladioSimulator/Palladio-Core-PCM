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

	@Override
	public double getTimeUntilNextInterruption() {
		return getRemainingTime();
	}

	@Override
	public double getRemainingTime() {
		// Process.toString
		return current_value;
	}

	@Override
	public boolean completelyFinished() {
		return (current_value <= 0);
	}

	@Override
	public boolean partFinished() {
		// PreemptiveScheduler.schedule
		// PreemptiveScheduler.unschedule
		return completelyFinished();
	}

	@Override
	public void fullReset() {
		// Boost.boost
		// PreemptiveScheduler.initialiseProcess
		this.current_value = value;
	}

	@Override
	public void reset() {
		// PreemptiveScheduler.unschedule (Preemt.uptdate)
		fullReset();
	}

	@Override
	public void punish(int penalty) {
		current_value -= penalty;
	}

	@Override
	public void setExpired() {
		current_value = 0;
	}

	@Override
	public void quantumFinished() {
		current_value -= per_quantum;
	}
}
