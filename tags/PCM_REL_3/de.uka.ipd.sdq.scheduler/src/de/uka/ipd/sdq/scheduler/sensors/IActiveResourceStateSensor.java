package de.uka.ipd.sdq.scheduler.sensors;

import de.uka.ipd.sdq.scheduler.resources.active.SimResourceInstance;


/**
 * Observer of a resource's state.
 */
public interface IActiveResourceStateSensor {

	/**
	 * Notifies the sensor about a state change of the resource.
	 * @param instance Resource instance whose state changed.
	 */
	public abstract void update(SimResourceInstance instance);

}
