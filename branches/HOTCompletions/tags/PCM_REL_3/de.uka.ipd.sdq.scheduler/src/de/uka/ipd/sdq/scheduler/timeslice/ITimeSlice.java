package de.uka.ipd.sdq.scheduler.timeslice;

public interface ITimeSlice extends Cloneable {

	/**
	 * Returns Time until the timeslice is interrupted.
	 */
	public abstract double getTimeUntilNextInterruption();

	/**
	 * Resets the part of the timeslice. In case the timeslice is expired as
	 * well it is reset to.
	 */
	public abstract void reset();

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
	public abstract boolean completelyFinished();

	/**
	 * Some schedulers divide the timeslice in multiple parts. The process is
	 * interrupted between the parts. Only when all parts are used up the
	 * timeslice is reset.
	 * 
	 * @return
	 */
	public abstract boolean partFinished();

	public abstract double getRemainingTime();

	public abstract void punish(int penalty);

	public abstract void setExpired();

	public abstract void quantumFinished();

	public abstract ITimeSlice clone();

	public abstract void halfReset();

	public abstract void enoughTime();

}
