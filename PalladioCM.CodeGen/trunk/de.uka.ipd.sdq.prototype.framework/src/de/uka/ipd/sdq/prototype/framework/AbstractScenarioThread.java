package de.uka.ipd.sdq.prototype.framework;

import org.apache.commons.cli.CommandLine;
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
	protected Runnable usageScenario;

	private TimeSpanSensor overallTimeSpanSensor;
	
	public AbstractScenarioThread (
			ExperimentRun expRun,
			TimeSpanSensor overallTimeSpanSensor, CommandLine cmdLine) {
		this.usageScenario = getScenarioRunner(cmdLine);
		this.experimentRun = expRun;
		this.overallTimeSpanSensor = overallTimeSpanSensor;

		logger.debug("Warmup once");
		usageScenario.run();
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
			long start = System.nanoTime();
			try {
				usageScenario.run();
			} catch (Exception ex) {
				ex.printStackTrace();
				shouldContinue = false;
				break;
			}
			double measuredTimeSpan = (System.nanoTime() - start)
					/ Math.pow(10, 9);
			experimentRun.addTimeSpanMeasurement(overallTimeSpanSensor, System.nanoTime() / Math.pow(10, 9),
					measuredTimeSpan);
			logger.debug("Finished my scenario");
			logger.debug("Execution of scenario took: " + measuredTimeSpan
					+ " seconds");
		}
	}
	
	public void requestStop() {
		shouldContinue = false;
	}

	protected abstract Runnable getScenarioRunner(CommandLine cmdLine);
}
