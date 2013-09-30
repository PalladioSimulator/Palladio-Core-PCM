package de.uka.ipd.sdq.scheduler.sensors;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;



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
	
	/**
	 * Notifies the sensor about a process whose demand has been completed by the resource.
	 * 
	 * @param simProcess the process whose demand has been completed by the resource.
	 * @param typeID the id of the resource
	 */
	public abstract void demandCompleted(ISchedulableProcess simProcess);

}
