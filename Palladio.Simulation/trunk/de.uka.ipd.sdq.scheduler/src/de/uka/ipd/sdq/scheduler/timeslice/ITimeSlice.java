package de.uka.ipd.sdq.scheduler.timeslice;

public interface ITimeSlice {

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
	 * Sets the remaining timeslice to given value. Once expired, the original
	 * value will be used again.
	 */
	public abstract void setTo(double time);

	/**
	 * Subtracts the specified amount of time from the timeslice. The remaining
	 * timeslice MUST be greater or equal than zero.
	 */
	public abstract void substractTime(double time);

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

	/**
	 * 
	 * @return Returns the remaining time of the timeslice.
	 */
	public abstract double getRemainingTime();

}
