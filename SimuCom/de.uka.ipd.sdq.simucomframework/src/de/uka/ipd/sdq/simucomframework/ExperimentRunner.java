package de.uka.ipd.sdq.simucomframework;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.statistics.PhiMixingBatchAlgorithm;
import de.uka.ipd.sdq.statistics.estimation.SampleMeanEstimator;

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
	public static double run(SimuComModel model, long simTime) {
		logger.debug("Setting up experiment runner");
		setupStopConditions(model, simTime);
		
		// measure elapsed time for the simulation
		double startTime = System.nanoTime();
		
		model.getSimulationControl().start();
		
		return System.nanoTime() - startTime;
	}

	/**
	 * @param model
	 * @param simTime
	 */
	private static void setupStopConditions(SimuComModel model, long simTime) {
		if (model.getConfig().getMaxMeasurementsCount() <= 0 && simTime <= 0) {
			logger.debug("Deactivating maximum simulation time stop condition per user request");
			model.getSimulationControl().setMaxSimTime(0); 
		} else {
			logger.debug("Enabling simulation stop condition at maximum simulation time of "+simTime);
			if (simTime > 0)
				model.getSimulationControl().setMaxSimTime(simTime); // set end of simulation at 1500 time
																	// units
		}
		
		model.getSimulationControl().addStopCondition(new MaxMeasurementsStopCondition(model));
		
		// Add confidence stop condition if configured
		if (model.getConfig().isUseConfidence()) {
			double level = model.getConfig().getConfidenceLevel() / 100.0;
			double halfWidth = model.getConfig().getConfidenceHalfWidth() / 100.0;
			model.getSimulationControl().addStopCondition(
					new ConfidenceStopCondition(model, new PhiMixingBatchAlgorithm(),
							new SampleMeanEstimator(), level, halfWidth));
	}
}
}
