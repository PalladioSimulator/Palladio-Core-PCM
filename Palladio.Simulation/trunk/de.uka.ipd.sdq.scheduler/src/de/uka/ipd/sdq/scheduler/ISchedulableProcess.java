package de.uka.ipd.sdq.scheduler;

import de.uka.ipd.sdq.scheduler.resources.active.SimActiveResource;

/**
 * Process that can be scheduled for execution on an active resource or can
 * acquire and release passive resources.
 * 
 * @author jens
 * 
 */
public interface ISchedulableProcess {

	/**
	 * Notifies the process to continue its execution. Is only called if the
	 * process has been passivated before.
	 */
	public abstract void activate();

	/**
	 * Notifies the process to stop its execution.
	 */
	public abstract void passivate();
	
	/**
	 * Unique identifier of the resource.
	 * 
	 * @return
	 */
	public abstract String getId();

	/**
	 * Name of the resource.
	 * 
	 * @return
	 */
	public abstract String getName();

	/**
	 * @return Returns the original process that 
	 * spawned many other processes including this one.
	 * Its IRunningProcess serves as a prototype for the newly 
	 * spawned processes. The original Ancestor has to point 
	 * to itself.  
	 */
	public abstract ISchedulableProcess getAncestor();

	public abstract boolean isFinished();
}
