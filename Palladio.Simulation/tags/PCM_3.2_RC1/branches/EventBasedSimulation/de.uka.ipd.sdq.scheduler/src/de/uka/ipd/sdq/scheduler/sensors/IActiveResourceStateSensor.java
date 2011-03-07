package de.uka.ipd.sdq.scheduler.sensors;



/**
 * Observer of a resource's state.
 */
public interface IActiveResourceStateSensor {

	/**
	 * Notifies the sensor about a state change of the resource.
	 * 
	 * @param state the changed state
	 * @param instanceId id of the instance whose state changed
	 */
	public abstract void update(int state, int instanceId);

}
