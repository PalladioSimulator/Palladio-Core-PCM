package de.uka.ipd.sdq.simucomframework.resources;

/**
 * 
 * @author Philipp Merkle
 * 
 */
public interface IStateListener {

	/**
	 * 
	 * @param queueLength
	 *            the length of the resource's queue
	 * @param instanceId
	 *            an identifier for the resource instance. A resource instance
	 *            could be a CPU core. If the resource has only one instance,
	 *            the instanceId should be 0 for this instance.
	 */
	public void stateChanged(int queueLength, int instanceId);

}
