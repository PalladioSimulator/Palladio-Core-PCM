package de.uka.ipd.sdq.prototype.framework;

import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;

public abstract class AbstractOpenScenarioThread extends AbstractScenarioThread {

	private RunProperties runProps;
	private String interarrivalTime;

	public AbstractOpenScenarioThread(ExperimentRun expRun,
			TimeSpanSensor overallTimeSpanSensor, RunProperties runProps, 
			String interarrivalTimeInSec) {
		super(expRun, overallTimeSpanSensor, runProps);
		this.runProps = runProps;
		this.interarrivalTime = interarrivalTimeInSec;

	}

	@Override
	protected void runAndMeasureUsageScenarioIteration() {

		// TODO Lots of threads created here. Check if this is needed. (lehrig)
		Thread thread = new Thread(new java.lang.Runnable() {
			public void run() {

				Runnable us = getScenarioRunner(runProps);
				logger.debug("Starting my scenario");
				long start = System.nanoTime();
				new Thread(us).run();
				takeScenarioMeasurement(start);
				logger.debug("Finished my scenario");

			}
		});
		thread.start();

		try {
			
			Object object = StackContext.evaluateStatic(this.interarrivalTime);
			if (object instanceof Number){
				//interarrival time in milliseconds
				Double interarrivalTime = ((Number)object).doubleValue() * 1000.0;
				// Wait for specified model time
				Thread.sleep(interarrivalTime.longValue());
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}

