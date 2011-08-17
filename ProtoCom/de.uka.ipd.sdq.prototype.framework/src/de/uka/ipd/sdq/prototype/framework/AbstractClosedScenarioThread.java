package de.uka.ipd.sdq.prototype.framework;

import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor;

public abstract class AbstractClosedScenarioThread extends AbstractScenarioThread {

	public AbstractClosedScenarioThread(ExperimentRun expRun,
			TimeSpanSensor overallTimeSpanSensor, RunProperties runProps) {
		super(expRun, overallTimeSpanSensor, runProps);
		
	}

	@Override
	protected void runAndMeasureUsageScenarioIteration() {
		long start = System.nanoTime();
		usageScenario.run();
		takeScenarioMeasurement(start);
	}
	
	
	


}
