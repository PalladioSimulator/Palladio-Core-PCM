package de.uka.ipd.sdq.simucomframework.resources;

import de.uka.ipd.sdq.simucomframework.abstractSimEngine.SimProcess;

public interface IPassiveStateListener {

	/**
	 * A simulated thread has requested the resource
	 * 
	 * @param thread
	 *            the requesting thread
	 */
	public void request(SimProcess thread);

	/**
	 * A simulated thread has acquired the resource
	 * 
	 * @param thread
	 *            the acquiring thread
	 */
	public void acquired(SimProcess thread);

	/**
	 * A simulated thread has released the resource
	 */
	public void release();

}
