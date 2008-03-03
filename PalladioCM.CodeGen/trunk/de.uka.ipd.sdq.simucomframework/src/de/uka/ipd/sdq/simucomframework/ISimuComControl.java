package de.uka.ipd.sdq.simucomframework;



/**
 * Control interface for the SimuCom Framework. It defines methods, which are responsible
 * for starting and stopping the simulation.
 * 
 * @author Roman Andrej
 * 		   Steffen Becker
 */
public interface ISimuComControl {

	/** Start a simulation run
	 * @param config The configuration object which sets many simulation parameters like stop conditions, storage location, etc.
	 * @param statusObserver An observer which gets notifications on the simulation progress
	 * @param useOwnSensorstorage If true, the simulation uses an own, temporary result store instead of the sensorfactory
	 * storage passed in the simulation parameter object. Use this for remote simulation docks which do not have access to the
	 * local sensor factory storages
	 * @return The result of the simulation run
	 */
	public SimuComStatus startSimulation(SimuComConfig config, IStatusObserver statusObserver, boolean useOwnSensorstorage);
	
	/**
	 * Cancels a running simulation 
	 */
	public void stopSimulation();
	
	/**
	 * Returns an exception which caused the simulation to terminate in case of simulation errors
	 * @return The exception which caused the simulation to terminate
	 */
	public Throwable getErrorThrowable();
}
