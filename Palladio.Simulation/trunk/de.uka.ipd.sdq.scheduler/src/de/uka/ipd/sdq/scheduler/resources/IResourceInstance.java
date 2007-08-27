package de.uka.ipd.sdq.scheduler.resources;

import de.uka.ipd.sdq.scheduler.IRunningProcess;

/**
 * This class represents an instance of an active resources. It got a unique ID
 * and knows the process it is currently executing.
 * 
 * @author jens
 * 
 */
public interface IResourceInstance {

	/**
	 * Unique name of the resource instance.
	 * 
	 * @return The unique name of the resource instance.
	 */
	public abstract String getName();

	/**
	 * @return Returns the process currently executing on the resource.
	 */
	public abstract IRunningProcess getRunningProcess();

	/**
	 * @return True, if there is process executing on this resource instance,
	 *         false otherwise.
	 */
	public abstract boolean processAssigned();

	/**
	 * Assigns a new process to this instance. Note that the resource has to be
	 * idle to do so.
	 * 
	 * @param process
	 *            Process to execute on the resource instance.
	 */
	public abstract void assign(IRunningProcess process);

	/**
	 * Releases the current resource instance.
	 */
	public abstract void release();

	/**
	 * Schedules the next SchedulingEvent for the instance at the specified
	 * time.
	 * 
	 * @param time
	 *            Time the event shall occur.
	 */
	public abstract void scheduleSchedulingEvent(double time);

	/**
	 * Removes a pending SchedulingEvent.
	 */
	public abstract void cancelSchedulingEvent();

}