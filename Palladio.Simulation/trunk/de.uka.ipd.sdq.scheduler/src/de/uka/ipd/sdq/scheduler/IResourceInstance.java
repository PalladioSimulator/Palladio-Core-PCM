package de.uka.ipd.sdq.scheduler;

import de.uka.ipd.sdq.scheduler.processes.impl.ActiveProcess;

public interface IResourceInstance {

	public abstract ActiveProcess getRunningProcess();

	public abstract void release();

	/**
	 * True, if there is no process executing on this resource instance, false
	 * otherwise.
	 */
	public abstract boolean noProcessAssigned();

	/**
	 * Assigns a new process to this instance. Note that the resource has to be
	 * idle to do so.
	 * 
	 * @param process
	 */
	public abstract void assign(ActiveProcess process);

	public abstract String getName();

	public abstract void scheduleSchedulingEvent(double time);

	public abstract void cancelSchedulingEvent();

}