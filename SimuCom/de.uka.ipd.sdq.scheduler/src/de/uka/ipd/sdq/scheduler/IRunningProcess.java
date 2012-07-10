package de.uka.ipd.sdq.scheduler;

import de.uka.ipd.sdq.scheduler.sensors.IProcessStateSensor;
import de.uka.ipd.sdq.simulation.abstractsimengine.IEntity;


/**
 * In oder to be scheduled properly, processes need some additional
 * runtime information. Runnable processes provide exactly this necessary
 * information. All processes that implement the ISchedulableProcess can be
 * wrapped by this class.
 * 
 * @author jens
 * 
 */
public interface IRunningProcess extends IEntity {

	/**
	 * @return Returns the process wrapped by this instance.
	 */
	public abstract ISchedulableProcess getSchedulableProcess();

	/**
	 * @return Returns the name of this process.
	 */
	public abstract String getName();
	
	/**
	 * @return Returns the unique identifier of the process.
	 */
	public abstract String getId();

	/**
	 * Observer pattern. Adds a new state sensor to the process.
	 * 
	 * @param sensor
	 */
	public abstract void addStateSensor(IProcessStateSensor sensor);

	/**
	 * Observer pattern. Removes a state sensor from the process.
	 * 
	 * @param sensor
	 */
	public abstract void removeStateSensor(IProcessStateSensor sensor);
}