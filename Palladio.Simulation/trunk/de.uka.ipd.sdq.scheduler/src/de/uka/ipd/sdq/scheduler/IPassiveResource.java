package de.uka.ipd.sdq.scheduler;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;

public interface IPassiveResource {

	/**
	 * Acquires num instances of the passive resource for the given process.
	 */
	public abstract void acquire(ISchedulableProcess process, int num);

	/**
	 * Releases num instances of the passive resource from the given process.
	 */
	public abstract void release(ISchedulableProcess process, int num);

}
