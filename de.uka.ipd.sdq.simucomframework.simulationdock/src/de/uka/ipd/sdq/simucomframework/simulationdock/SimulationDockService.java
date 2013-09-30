package de.uka.ipd.sdq.simucomframework.simulationdock;

import de.uka.ipd.sdq.simucomframework.simucomstatus.SimuComStatus;
import de.uka.ipd.sdq.simulation.AbstractSimulationConfig;

public interface SimulationDockService {
	
	/**
	 * Takes a byte array containing a bundle jar which contains the code for a single simulation. Installs, and prepares the simulation.
	 * @param config The simulation configuration object describing simulation parameters
	 * @param simulationBundle The jar file of the bundle containing the simulation
	 * @param isRemoteRun True of the simulation should run remotely and has no access to the local sensorframework
	 */
	void load(AbstractSimulationConfig config, byte[] simulationBundle, boolean isRemoteRun);
	
	/**
	 * Takes a byte array containing a bundle jar which contains the code for a single simulation. Installs, starts, and runs the contained
	 * simulation.
	 * @param config The simulation configuration object describing simulation parameters
	 * @param simulationBundle The jar file of the bundle containing the simulation
	 * @param isRemoteRun True of the simulation should run remotely and has no access to the local sensorframework
	 */
	void simulate(AbstractSimulationConfig config, byte[] simulationBundle, boolean isRemoteRun);

	/** Returns the ID of this simulation dock
	 * @return The ID of the simulation dock
	 */
	String getDockId();
	
	/**
	 * Cancels the running simulation 
	 */
	void stopSimulation();
	
	void suspend();
	
	void resume();

	void step();
	
	SimuComStatus getSimuComStatus();
}
