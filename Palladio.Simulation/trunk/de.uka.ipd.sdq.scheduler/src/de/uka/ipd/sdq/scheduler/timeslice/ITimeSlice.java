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

//	/**
//	 * Subtracts the specified amount of time from the timeslice. The remaining
//	 * timeslice MUST be greater or equal than zero.
//	 */
//	public abstract void subTimeScheduling(double time);
//	
//	public abstract void subTimeProcessing(double time);
//	

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

//	/**
//	 * 
//	 * @return Returns the remaining time of the timeslice.
//	 */
	public abstract double getRemainingTime();
//
//	
	public abstract void punish(int penalty);

	public abstract void setExpired();

//	public abstract void setTo(double d);
//
//	public abstract void resetQuantum();
//
//	public abstract double getRemainingQuantumTime();

	public abstract void quantumFinished();

}
