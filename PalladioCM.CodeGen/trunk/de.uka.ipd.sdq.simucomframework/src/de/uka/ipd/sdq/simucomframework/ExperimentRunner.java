package de.uka.ipd.sdq.simucomframework;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

/**
 * Helper class to actually perform a simulation run using desmo-j
 * @author Steffen Becker
 *
 */
public class ExperimentRunner {
	private static Logger logger = 
		Logger.getLogger(ExperimentRunner.class.getName());
	
	/**
	 * Run the given simulation model until the given simulation time
	 * is reached
	 * @param model Simulation model to execute
	 * @param simTime Maximum simulation time to run the simulation for
	 */
	public static void run(SimuComModel model, long simTime) {
		
		if (model.getConfig().getMaxMeasurementsCount() <= 0 && simTime <= 0)
			model.getSimulationControl().setMaxSimTime(0); 
		else
			if (simTime > 0)
				model.getSimulationControl().setMaxSimTime(simTime); // set end of simulation at 1500 time
																	// units

		model.getSimulationControl().addStopCondition(new MaxMeasurementsStopCondition(model));
		
		// measure elapsed time for the simulation
		double startTime = System.nanoTime();
		
		model.getSimulationControl().start();
		
		// log elapsed time
		double elapsedTime = System.nanoTime() - startTime;
		logger.warn("Simulation completed in " + (elapsedTime/1000000.0) + "ms.");
		
		model.getResourceRegistry().deactivateAllActiveResources();
		model.getResourceRegistry().deactivateAllPassiveResources();

		model.getDAOFactory().store();
	}
}
