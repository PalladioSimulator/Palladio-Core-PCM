package de.uka.ipd.sdq.simucomframework.abstractSimEngine;

public interface IEntityDelegate {

	public abstract boolean isScheduled();

	public abstract void reschedule(double d);

}