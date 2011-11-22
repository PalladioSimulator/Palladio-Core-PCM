package de.uka.ipd.sdq.simulation;

import de.uka.ipd.sdq.simucomframework.simucomstatus.SimuComStatus;

/**
 * Control interface for simulation frameworks. It defines methods, which are responsible for
 * starting and stopping the simulation.
 * 
 * When SimuCom is used, the code generated for each SimuCom instance contains the class
 * main.SimuComControl that extends {@link AbstractMain} and provides the missing information.
 * 
 * @author Roman Andrej
 * @author Steffen Becker
 */
public interface ISimulationControl {
	
	/** Prepare a simulation run
     * @param config The configuration object which sets many simulation parameters like stop conditions, storage location, etc.
     * @param statusObserver An observer which gets notifications on the simulation progress
     * @param useOwnSensorstorage If true, the simulation uses an own, temporary result store instead of the sensorfactory
     * storage passed in the simulation parameter object. Use this for remote simulation docks which do not have access to the
     * local sensor factory storages
     * 
     */
    public void prepareSimulation(AbstractSimulationConfig config, IStatusObserver statusObserver, boolean useOwnSensorstorage);

    /** Start a simulation run
     * @param config The configuration object which sets many simulation parameters like stop conditions, storage location, etc.
     * @param statusObserver An observer which gets notifications on the simulation progress
     * @param useOwnSensorstorage If true, the simulation uses an own, temporary result store instead of the sensorfactory
     * storage passed in the simulation parameter object. Use this for remote simulation docks which do not have access to the
     * local sensor factory storages
     * @return The result of the simulation run
     */
    public SimulationResult startSimulation(AbstractSimulationConfig config, IStatusObserver statusObserver, boolean useOwnSensorstorage);
    
    /**
     * Cancels a running simulation by disallowing the generation of new simulation events
     */
    public void stopSimulation();
    
    /**
     * Returns an exception which caused the simulation to terminate in case of simulation errors as
     * indicated by the {@link SimuComResult} returned by the startSimulation method
     * @return The exception which caused the simulation to terminate
     */
    public Throwable getErrorThrowable();

    /** Retrieve an object containing the status of this simulation. 
     * @return A {@link SimuComStatus} object containing the simulation status
     */
    public SimuComStatus getStatus();
    
}
