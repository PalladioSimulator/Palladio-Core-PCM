package de.uka.ipd.sdq.scheduler;

public interface ISchedulableProcess {

	/**
	 * Notifies the process to continue its execution.
	 * Is only called if the process has been passivated before.
	 */
	public abstract void activate();

	/**
	 * Notifies the process to stop its execution.
	 */
	public abstract void passivate();
	
}
