package de.uka.ipd.sdq.scheduler;

public interface ISchedulableProcess {

	/**
	 */
	public void activate();

	/**
	 */
	public abstract void passivate();

}
