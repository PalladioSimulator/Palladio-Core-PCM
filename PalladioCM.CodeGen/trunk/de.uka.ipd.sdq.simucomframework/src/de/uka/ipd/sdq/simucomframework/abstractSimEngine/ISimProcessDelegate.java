package de.uka.ipd.sdq.simucomframework.abstractSimEngine;

public interface ISimProcessDelegate {

	// Strategy dependent methods
	public abstract void passivate();

	public abstract void scheduleAt(double d);

	public abstract void hold(double d);

	public abstract boolean isTerminated();

}