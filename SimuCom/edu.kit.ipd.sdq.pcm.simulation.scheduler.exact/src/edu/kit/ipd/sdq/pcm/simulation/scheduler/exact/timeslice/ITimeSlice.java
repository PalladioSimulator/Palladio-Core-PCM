package edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.timeslice;

public interface ITimeSlice extends Cloneable {

	/**
	 * Returns Time until the timeslice is interrupted.
	 */
	public abstract double getRemainingTime();

	/**
	 * Resets the remaining time to a full timeslice. 
	 */
	public abstract void fullReset();

	/**
	 * Subtracts the specified amount of time from the timeslice. The remaining
	 * timeslice MUST be greater or equal than zero.
	 */
	void substractTime(double time);

	/**
	 * Returns true if the timeslice is finished, false otherwise.
	 */
	public abstract boolean isFinished();

	public abstract void punish(int penalty);

	public abstract void setExpired();

	public abstract ITimeSlice clone();

	public abstract void halfReset();

	public abstract void updateTimeForBoosting();

	public abstract void updateTimeForScheduling();
}
