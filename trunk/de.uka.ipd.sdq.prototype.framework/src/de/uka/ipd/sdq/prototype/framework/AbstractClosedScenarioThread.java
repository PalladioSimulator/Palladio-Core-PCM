package de.uka.ipd.sdq.prototype.framework;

import org.apache.commons.cli.CommandLine;

import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;

public abstract class AbstractClosedScenarioThread extends AbstractScenarioThread {

	public AbstractClosedScenarioThread(ExperimentRun expRun,
			TimeSpanSensor overallTimeSpanSensor, CommandLine cmdLine) {
		super(expRun, overallTimeSpanSensor, cmdLine);
		
	}

	@Override
	protected void runAndMeasureUsageScenarioIteration() {
		long start = System.nanoTime();
		usageScenario.run();
		takeScenarioMeasurement(start);
	}
	
	
	


}
