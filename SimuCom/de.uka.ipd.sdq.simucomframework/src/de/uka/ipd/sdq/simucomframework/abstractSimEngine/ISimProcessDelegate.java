package de.uka.ipd.sdq.simucomframework.abstractSimEngine;

public interface ISimProcessDelegate {

	// Strategy dependent methods
	public abstract void passivate();

	/**
	 * Resumes the process after waiting <code>delay</code> simulated time
	 * units.
	 * 
	 * @param delay
	 */
	public abstract void scheduleAt(double delay);

	//public abstract void hold(double d);

	public abstract boolean isTerminated();

}