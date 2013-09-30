package de.uka.ipd.sdq.scheduler;

import de.uka.ipd.sdq.simulation.abstractsimengine.IEntity;

/**
 * Process that can be scheduled for execution on an active resource or can
 * acquire and release passive resources.
 * 
 * @author jens
 * 
 */
public interface ISchedulableProcess extends IEntity {

	/**
	 * Notifies the process to resume its execution. Is only called if the
	 * process has been passivated before.
	 */
	public abstract void activate();

	/**
	 * Notifies the process to suspend its execution.
	 */
	public abstract void passivate();

	/**
	 * Unique identifier of the process.
	 * 
	 * @return A unique ID identifying this process
	 */
	public abstract String getId();

	/**
	 * Returns the root process that spawned this processes (directly or
	 * indirectly). The root process is used to create this process' scheduling
	 * meta-data. The root process has to point to itself.
	 * 
	 * @return ISchedulableProcess which is the root process
	 * */
	public abstract ISchedulableProcess getRootProcess();

	/**
	 * Return whether this process is finished
	 * 
	 * @return true if the process has finished its execution
	 */
	public abstract boolean isFinished();

	public abstract void fireTerminated();

	public abstract void addTerminatedObserver(IActiveResource o);

	public abstract void removeTerminatedObserver(IActiveResource o);
	
	public abstract int getPriority();
	
	public abstract void setPriority(int prio);

	/**
	 * Forces a suspended process to run into a timeout failure.
	 * 
	 * Used for passive resource timeouts
	 * 
	 * @param timeoutFailureName
	 *            the name of the triggered timeout failure
	 */
	public abstract void timeout(String timeoutFailureName);
}
