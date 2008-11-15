package de.uka.ipd.sdq.scheduler.sensors;

import de.uka.ipd.sdq.scheduler.processes.PROCESS_STATE;

/**
 * Observer of the process' states.
 */
public interface IProcessStateSensor {

	/**
	 * Notifies the sensor about a state change of the process.
	 */
	public abstract void update(PROCESS_STATE newState);

}
