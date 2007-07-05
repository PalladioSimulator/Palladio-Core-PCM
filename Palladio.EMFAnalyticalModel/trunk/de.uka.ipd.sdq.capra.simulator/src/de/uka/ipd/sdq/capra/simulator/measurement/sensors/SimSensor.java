package de.uka.ipd.sdq.capra.simulator.measurement.sensors;

import de.uka.ipd.sdq.sensorframework.util.ExperimentManager;

public interface SimSensor {
	
	void storeData(ExperimentManager expManager);
	
	String getName();

	SimSensorInstance createInstance();
}
