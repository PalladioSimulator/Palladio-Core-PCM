package de.uka.ipd.sdq.scheduler;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;

/**
 * A passive can be hold by a process for some time. As the number of available
 * instances is limited the process might has to wait until it gets the
 * requested number of instances.
 * 
 * @author jens
 * 
 */
public interface IPassiveResource {

	/**
	 * Acquires num instances of the passive resource for the given process. The
	 * process is blocked until it successfully receives the requested number of
	 * resource instances.
	 * 
	 * @return True, if the acquisition was successful, otherwise false.
	 */
	public abstract boolean acquire(ISchedulableProcess process, int num);

	/**
	 * Releases num instances of the passive resource from the given process.
	 */
	public abstract void release(ISchedulableProcess process, int num);
	
	/**
	 * Name of the resource.
	 * 
	 * @return
	 */
	public String getName();
	
	/**
	 * Unique identifier of the resource.
	 * 
	 * @return
	 */
	public String getId();
}
