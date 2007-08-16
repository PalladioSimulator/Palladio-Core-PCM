package de.uka.ipd.sdq.scheduler.resources.timeslice;

public interface ITimeSlice {

	/**
	 * Returns the total remaining time of the timeslice.
	 */
	public abstract double getRemainingTime();
	
	
	/**
	 * @return Time until the timeslice is interrupted.
	 */
	public abstract double getGranularity();

	/**
	 * Resets the timeslice to full. The value can depend on the current status
	 * of the process.
	 */
	public abstract void reset();

	/**
	 * Subtracts the specified amount of time from the timeslice.
	 */
	public abstract void substractTime(double time);

	/**
	 * Returns true if the timeslice is finished, false otherwise.
	 */
	public abstract boolean isFinished();

}
