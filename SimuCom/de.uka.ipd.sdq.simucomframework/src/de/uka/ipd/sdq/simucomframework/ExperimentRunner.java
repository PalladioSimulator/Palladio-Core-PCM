package de.uka.ipd.sdq.simucomframework;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.statistics.IBatchAlgorithm;
import de.uka.ipd.sdq.statistics.PhiMixingBatchAlgorithm;
import de.uka.ipd.sdq.statistics.StaticBatchAlgorithm;
import de.uka.ipd.sdq.statistics.estimation.SampleMeanEstimator;

/**
 * Helper class to actually perform a simulation run using desmo-j
 * @author Steffen Becker
 *
 */
public class ExperimentRunner {
	
    private static final double ONE_HUNDERT_PERCENT = 100.0;
    
	private static final long UNLIMITED_SIMULATION_TIME = Long.MAX_VALUE - 1;
    
    private final static Logger logger = 
		Logger.getLogger(ExperimentRunner.class.getName());
	
	/**
	 * Run the given simulation model until the given simulation time
	 * is reached
	 * @param model Simulation model to execute
	 * @param simTime Maximum simulation time to run the simulation for
	 * @deprecated Use run(SimuComModel) instead as time is already stored in SimuComModel
	 */
	public static double run(SimuComModel model, long simTime) {
	    if (logger.isDebugEnabled()) {
	        logger.debug("Setting up experiment runner");
	    }
		setupStopConditions(model);
		
		// measure elapsed time for the simulation
		double startTime = System.nanoTime();
		
		model.getSimulationControl().start();
		
		return System.nanoTime() - startTime;
	}

	/**
	 * Run the given simulation model until the given simulation time
	 * is reached
	 * @param model Simulation model to execute
	 */
	public static double run(SimuComModel model) {
		return run(model,model.getConfiguration().getSimuTime());
	}
	
	/**
	 * @param model
	 */
	private static void setupStopConditions(SimuComModel model) {
	    boolean hasStopCondition = false;
	    
		// 1. Setup maximal simulation time stop cond.
	    hasStopCondition |= setupMaximumSimulationTimeStopCondition(model);
		
	    // 2. Setup maximal measurements count stop condition
	    hasStopCondition |= setupMaximumMeasurementsStopCondition(model);
		
		// 3. Setup stop condition based on confidence intervals
		// Add confidence stop condition if configured
        hasStopCondition |= setupConfidenceIntervalStopCondition(model);
        
        if (!hasStopCondition) {
            throw new RuntimeException("No stop condition configured. No simulation is executed");
        }
	}

    private static boolean setupConfidenceIntervalStopCondition(SimuComModel model) {
        if (isConfidenceIntervalStopConditionEnabled(model)) {
            if (logger.isDebugEnabled()) { 
                logger.debug("Enabling simulation stop condition for confidence intervals");
            }
            double level = model.getConfiguration().getConfidenceLevel() / ONE_HUNDERT_PERCENT;
            double halfWidth = model.getConfiguration().getConfidenceHalfWidth() / ONE_HUNDERT_PERCENT;
            
            IBatchAlgorithm batchAlgorithm = null;
            if (model.getConfiguration().isAutomaticBatches() ){
                batchAlgorithm = new PhiMixingBatchAlgorithm();
            } else {
                int batchSize = model.getConfiguration().getBatchSize();
                int minNumberOfBatches = model.getConfiguration().getMinNumberOfBatches();
                batchAlgorithm = new StaticBatchAlgorithm(batchSize, minNumberOfBatches);
            }
            
            model.getSimulationControl().addStopCondition(
                    new ConfidenceStopCondition(model, batchAlgorithm,
                            new SampleMeanEstimator(), level, halfWidth));
            return true;
        } else {
            if (logger.isDebugEnabled()) { 
                logger.debug("Deactivating confidence interval stop condition per user request");
            }
            return false;
        }   
    }

    private static boolean isConfidenceIntervalStopConditionEnabled(SimuComModel model) {
        return model.getConfiguration().isUseConfidence();
    }

    private static boolean setupMaximumMeasurementsStopCondition(SimuComModel model) {
        if (isMaximumMeasurementsStopConditionEnabled(model)) {
            long maxMeasurementsCount = model.getConfiguration().getMaxMeasurementsCount();
            if (logger.isDebugEnabled()) { 
                logger.debug("Enabling simulation stop condition at maximum measurements count of " + maxMeasurementsCount);
            }
            model.getSimulationControl().addStopCondition(new MaxMeasurementsStopCondition(model));
            return true;
        } else {
            if (logger.isDebugEnabled()) { 
                logger.debug("Deactivating maximum measurements count stop condition per user request");
            }
            return false;
        }
    }

    private static boolean isMaximumMeasurementsStopConditionEnabled(SimuComModel model) {
        return model.getConfiguration().getMaxMeasurementsCount() > 0;
    }

    /**
     * @param model
     */
    private static boolean setupMaximumSimulationTimeStopCondition(SimuComModel model) {
        if (isMaximumSimulationTimeStopConditionEnabled(model)) {
            long simTime = model.getConfiguration().getSimuTime();
            if (logger.isDebugEnabled()) { 
                logger.debug("Enabling simulation stop condition at maximum simulation time of "+simTime);
            }
            model.getSimulationControl().setMaxSimTime(simTime);
            return true;
		} else {
            if (logger.isDebugEnabled()) { 
                logger.debug("Deactivating maximum simulation time stop condition per user request");
            }
            // model.getSimulationControl().setMaxSimTime(UNLIMITED_SIMULATION_TIME); 
            return false;
		}
    }

    /**
     * @param model
     * @return
     */
    private static boolean isMaximumSimulationTimeStopConditionEnabled(SimuComModel model) {
        return model.getConfiguration().getSimuTime() > 0;
    }
}
