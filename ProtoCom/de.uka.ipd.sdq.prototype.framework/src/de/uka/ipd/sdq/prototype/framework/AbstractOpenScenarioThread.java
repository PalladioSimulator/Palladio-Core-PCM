package de.uka.ipd.sdq.prototype.framework;

import de.uka.ipd.sdq.prototype.framework.utils.RunProperties;
import de.uka.ipd.sdq.sensorframework.entities.Experiment;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;

public abstract class AbstractOpenScenarioThread extends AbstractScenarioThread {

	private RunProperties runProps;
	private String interarrivalTime;

	public AbstractOpenScenarioThread(Experiment exp,
			ExperimentRun expRun,
			String scenarioName, RunProperties runProps, 
			String interarrivalTimeInSec) {
		super(exp, expRun, scenarioName, runProps);
		this.runProps = runProps;
		this.interarrivalTime = interarrivalTimeInSec;

	}

	@Override
	protected void runAndMeasureUsageScenarioIteration() {

		new Thread() {
			public void run() {
				if (logger.isDebugEnabled()) {
					logger.debug("New Thread: Open Scenario (" + scenarioName + "), interarrival time: " + interarrivalTime);
				}
				
				logger.debug("Starting my scenario");
				long start = System.nanoTime();
				logger.debug("New Thread: Open Scenario (" + scenarioName + "), inner thread");

				getScenarioRunner(runProps).run();
				
				takeScenarioMeasurement(start);
				logger.debug("Finished my scenario");

			}
		}.start();

		try {
			
			Double interarrivalTime = StackContext.evaluateStatic(this.interarrivalTime, Double.class) * 1000.0;
			Thread.sleep(interarrivalTime.longValue());
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}

