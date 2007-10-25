package de.uka.ipd.sdq.prototype.framework;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.PatternLayout;

import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor;


public abstract class AbstractScenarioThread extends Thread implements IStopable {
	protected org.apache.log4j.Logger logger = org.apache.log4j.Logger
		.getLogger(AbstractScenarioThread.class);
	
	ExperimentRun experimentRun = null;
	protected boolean shouldContinue = true;
	private Runnable usageScenario;

	private TimeSpanSensor overallTimeSpanSensor;
	
	public AbstractScenarioThread (
			ExperimentRun expRun,
			TimeSpanSensor overallTimeSpanSensor) {

		PatternLayout layout = new PatternLayout( "%d{ISO8601} %-5p [%t] %c: %m%n" );
		logger.addAppender( new ConsoleAppender(layout) );
		logger.setLevel( Level.INFO );
	      
		this.usageScenario = getScenarioRunner();
		this.experimentRun = expRun;
		this.overallTimeSpanSensor = overallTimeSpanSensor;

		logger.debug("Warmup once");
		usageScenario.run();
	}

	public void run() {
		while (shouldContinue) {
			logger.debug("Starting my scenario");
			long start = System.nanoTime();
			usageScenario.run();
			double measuredTimeSpan = (System.nanoTime() - start)
					/ Math.pow(10, 9);
			experimentRun.addTimeSpanMeasurement(overallTimeSpanSensor, System.nanoTime() / Math.pow(10, 9),
					measuredTimeSpan);
			logger.debug("Finished my scenario");
			logger.info("Execution of scenario took: " + measuredTimeSpan
					+ " seconds");
		}
	}
	
	public void requestStop() {
		shouldContinue = false;
	}

	protected abstract Runnable getScenarioRunner();
}
