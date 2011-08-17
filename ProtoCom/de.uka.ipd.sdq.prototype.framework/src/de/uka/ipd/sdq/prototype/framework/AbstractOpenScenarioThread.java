package de.uka.ipd.sdq.prototype.framework;

import org.apache.commons.cli.CommandLine;

import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;

public abstract class AbstractOpenScenarioThread extends AbstractScenarioThread {

	private CommandLine cmdLine;
	private String interarrivalTime;

	public AbstractOpenScenarioThread(ExperimentRun expRun,
			TimeSpanSensor overallTimeSpanSensor, CommandLine cmdLine, 
			String interarrivalTimeInSec) {
		super(expRun, overallTimeSpanSensor, cmdLine);
		this.cmdLine = cmdLine;
		this.interarrivalTime = interarrivalTimeInSec;

	}

	@Override
	protected void runAndMeasureUsageScenarioIteration() {

		Thread thread = new Thread(new java.lang.Runnable() {
			public void run() {

				Runnable us = getScenarioRunner(cmdLine);
				logger.info("Starting my scenario");
				long start = System.nanoTime();
				new Thread(us).run();
				takeScenarioMeasurement(start);
				logger.info("Finished my scenario");

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

