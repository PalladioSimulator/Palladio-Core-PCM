package de.uka.ipd.sdq.scheduler.sensors;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;

/**
 * Observer of a passive resource.
 * 
 * @author Philipp Merkle
 * 
 */
public interface IPassiveResourceSensor {

	/**
	 * The given process has requested num instances of the passive resource but
	 * not yet acquired them.
	 */
	public void request(ISchedulableProcess process, long num);
	
	/**
	 * The given process has successfully acquired num instances of the passive
	 * resource.
	 */
	public void acquire(ISchedulableProcess process, long num);

	/**
	 * The given process has released num instances of the passive resource.
	 */
	public void release(ISchedulableProcess process, long num);

}
