package com.palladio_simulator.protocom.framework.visitor;

import java.util.HashMap;
import java.util.Map;

import de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;

public class SensorFrameworkVisitor implements ICallVisitor {

	private static SensorFrameworkVisitor singleton;
	
	public static SensorFrameworkVisitor getInstance() {
		if (singleton == null) {
			singleton = new SensorFrameworkVisitor();
		}
		
		return singleton;
	}
	
	private Map<String, TimeSpanSensor> sensors = new HashMap<String, TimeSpanSensor>();
	private Map<String, Long> startTimes = new HashMap<String, Long>();
	
	@Override
	public void preCallVisit(StackContext ctx, String callIdentifier) {
		if (sensors.get(callIdentifier) == null) {
			sensors.put(callIdentifier, com.palladio_simulator.protocom.framework.experiment.ExperimentManager.createOrReuseTimeSpanSensor(callIdentifier));	
		}
		startTimes.put(callIdentifier, com.palladio_simulator.protocom.framework.experiment.ExperimentManager.takeStartTimeForInnerMeasurement());
	}

	@Override
	public void postCallVisit(StackContext ctx, String callIdentifier) {
		com.palladio_simulator.protocom.framework.experiment.ExperimentManager.takeMeasurement(startTimes.get(callIdentifier), com.palladio_simulator.protocom.framework.experiment.ExperimentManager.getLatestExperimentRun(), sensors.get(callIdentifier));
	}

}
