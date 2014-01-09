package org.palladiosimulator.protocom.framework.usage;

import java.util.concurrent.atomic.AtomicLong;

import org.palladiosimulator.protocom.framework.IStopable;
import org.palladiosimulator.protocom.framework.experiment.ExperimentManager;
import org.palladiosimulator.protocom.framework.utils.RunProperties;

import de.uka.ipd.sdq.sensorframework.entities.Experiment;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor;

/**
 * Abstract class for running both closed and open workload users. 
 * 
 * For closed workloads, this class represents a single user. 
 * For open workloads, only one instance of this class represents the usage scenario and spawns 
 * a new thread each time the interarrival time has passed.  
 * 
 * @author Steffen, martens
 *
 */
public abstract class AbstractScenarioThread extends Thread implements IStopable {
	protected org.apache.log4j.Logger logger = org.apache.log4j.Logger
		.getLogger(AbstractScenarioThread.class);
	
	private static AtomicLong measurementTotalCount = null;
	protected long maxMeasurementCount = -1;
	
	ExperimentRun experimentRun = null;
	protected boolean shouldContinue = true;

	protected String scenarioName;
	
	private TimeSpanSensor timeSpanSensor;
	
	static {
		/** 
		 * Total measurement count of all active usage scenarios (thus static).
		 * Is reset to 0 in the constructor by all scenarios, so that the counting 
		 * starts after the construction of all threads.  */ 
		measurementTotalCount = new AtomicLong(0);
	}
	
	/** 
	 * Initialise thread and perform warmup runs. Number of warmup runs can be configured 
	 * with -u option, or is 1000 as the default. 
	 * 
	 * @param expRun
	 * @param timeSpanSensor
	 * @param runProps
	 */
	public AbstractScenarioThread (
			Experiment exp,
			ExperimentRun expRun,
			String scenarioName,
			RunProperties runProps) 
	{
		this.experimentRun = expRun;
		this.scenarioName = scenarioName;
		this.timeSpanSensor = ExperimentManager.createOrReuseTimeSpanSensor(scenarioName);

		
		if (runProps.hasOption("m"))
		{
			maxMeasurementCount = Integer.parseInt(runProps.getOptionValue('m'));
		}
		
		int warmupRuns = 1000;
		if (runProps.hasOption("u"))
		{
			warmupRuns = Integer.parseInt(runProps.getOptionValue('u'));
		}
		logger.info("Warmup - Cyles: "+warmupRuns);
		for (int i=0; i<warmupRuns; i++)
		{
			logger.info("Warmup started, cycle: "+i);
			getScenarioRunner(runProps).run();
		}
		logger.info("Warmup finished");
		
		// reset number of measurements to 0
		measurementTotalCount = new AtomicLong(0);

	}

	public void run() {
		while (shouldContinue) {
			logger.debug("Starting my scenario");

			try {
				runAndMeasureUsageScenarioIteration();
			} catch (Exception ex) {
				ex.printStackTrace();
				shouldContinue = false;
				break;
			}
		}
	}
	
	protected abstract void runAndMeasureUsageScenarioIteration();
	
	/**
	 * FIXME: duplicate, see ExperimentManager!
	 * 
	 * @param start
	 */
	protected void takeScenarioMeasurement(long start) {
		long now = System.nanoTime();
		double measuredTimeSpan = (now - start) / Math.pow(10, 9);
		
		experimentRun.addTimeSpanMeasurement(timeSpanSensor, 
				now / Math.pow(10, 9), measuredTimeSpan);
		logger.debug("Finished my scenario");
		
		long value = measurementTotalCount.incrementAndGet();
		logger.debug("Execution of scenario iteration no "+value+" took: " + measuredTimeSpan
				+ " seconds");
		
		if (maxMeasurementCount > 0 && value >= maxMeasurementCount && shouldContinue) {
			logger.info("Reached maximum measurement count");
			shouldContinue = false;
			
		}
		

	}

	public void requestStop() {
		shouldContinue = false;
	}

	/**
	 * Return a new instance of the usage scenario to be executed.  
	 * @param runProps
	 * @return
	 */
	protected abstract Runnable getScenarioRunner(RunProperties runProps);
}
