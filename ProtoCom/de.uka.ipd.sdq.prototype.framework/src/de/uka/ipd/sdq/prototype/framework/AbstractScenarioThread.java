package de.uka.ipd.sdq.prototype.framework;

import java.util.concurrent.atomic.AtomicLong;

import org.apache.commons.cli.CommandLine;

import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;

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
	protected Runnable usageScenario;

	private TimeSpanSensor overallTimeSpanSensor;
	
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
	 * @param overallTimeSpanSensor
	 * @param cmdLine
	 */
	public AbstractScenarioThread (
			ExperimentRun expRun,
			TimeSpanSensor overallTimeSpanSensor, CommandLine cmdLine) {
		this.usageScenario = getScenarioRunner(cmdLine);
		this.experimentRun = expRun;
		this.overallTimeSpanSensor = overallTimeSpanSensor;
		
		if (cmdLine.hasOption("m")){
			maxMeasurementCount = Integer.parseInt(cmdLine.getOptionValue('m'));
		}
		
		int warmupRuns = 1000;
		if (cmdLine.hasOption("u")){
			warmupRuns = Integer.parseInt(cmdLine.getOptionValue('u'));
		}
		logger.info("Warmup - Cyles: "+warmupRuns);
		for (int i=0; i<warmupRuns; i++){
			logger.info("Warmup started, cycle: "+i);
			usageScenario.run();
		}
		logger.info("Warmup finished");
		
		// reset number of measurements to 0
		measurementTotalCount = new AtomicLong(0);

	}

	public void run() {
		while (shouldContinue) {
			logger.debug("Starting my scenario");
			//System.gc(); 
			//try {
				//Thread.sleep(100);
			//} catch (InterruptedException e) {
				// TODO Auto-generated catch block
			//	e.printStackTrace();
			//}
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
	
	protected void takeScenarioMeasurement(long start) {
		long now = System.nanoTime();
		double measuredTimeSpan = (now - start) / Math.pow(10, 9);
		
		experimentRun.addTimeSpanMeasurement(overallTimeSpanSensor, 
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
	 * @param cmdLine
	 * @return
	 */
	protected abstract Runnable getScenarioRunner(CommandLine cmdLine);
}
