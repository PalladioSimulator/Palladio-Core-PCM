package de.uka.ipd.sdq.scheduler.resources.timeslice;

public interface ITimeSlice {

	/**
	 * Returns Time until the timeslice is interrupted.
	 */
	public abstract double getTimeUntilNextInterruption();

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
	public abstract boolean completelyFinished();

	/**
	 * Some schedulers divide the timeslice in multiple parts. The process is
	 * interrupted between the parts. Only when all parts are used up the timeslice
	 * is reset.
	 * 
	 * @return
	 */
	public abstract boolean partFinished();

}
