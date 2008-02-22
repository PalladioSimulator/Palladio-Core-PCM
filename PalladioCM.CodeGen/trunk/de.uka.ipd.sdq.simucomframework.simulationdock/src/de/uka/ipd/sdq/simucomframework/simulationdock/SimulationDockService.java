package de.uka.ipd.sdq.simucomframework.simulationdock;

import de.uka.ipd.sdq.simucomframework.SimuComConfig;

public interface SimulationDockService {
	
	/**
	 * Takes a byte array containing a bundle jar which contains the code for a single simulation. Installs, starts, and runs the contained
	 * simulation.
	 * @param simulationBundle The jar file of the bundle containing the simulation
	 */
	void simulate(SimuComConfig config, byte[] simulationBundle);

	String getDockId();
}
