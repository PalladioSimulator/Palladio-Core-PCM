package de.uka.ipd.sdq.simucomframework;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.variables.cache.StoExCache;
import desmoj.core.simulator.Experiment;
import desmoj.core.simulator.SimTime;

/**
 * Helper class to actually perform a simulation run using desmo-j
 * @author Steffen Becker
 *
 */
public class ExperimentRunner {
	
	/**
	 * Run the given simulation model until the given simulation time
	 * is reached
	 * @param model Simulation model to execute
	 * @param simTime Maximum simulation time to run the simulation for
	 */
	public static void run(SimuComModel model, long simTime) {
		Experiment exp = model.getExperiment();
		// set experiment parameters
		exp.setShowProgressBar(false); // display a progress bar (or not)
		
		if (model.getConfig().getMaxMeasurementsCount() <= 0 && simTime <= 0)
			exp.stop(new SimTime(0)); 
		else
			if (simTime > 0)
				exp.stop(new SimTime(simTime)); // set end of simulation at 1500 time
												// units

		exp.stop(new MaxMeasurementsStopCondition(model,"MaxMeasurementsStopCondtion",true));
		
		exp.start();

		// generate the report (and other output files)
		exp.report();
		
		// stop all threads still alive and close all output files
		exp.finish();
		model.getResourceRegistry().deactivateAllActiveResources();

		model.getDAOFactory().createExperimentDAO().store(model.getExperimentDatastore());
	}
}
