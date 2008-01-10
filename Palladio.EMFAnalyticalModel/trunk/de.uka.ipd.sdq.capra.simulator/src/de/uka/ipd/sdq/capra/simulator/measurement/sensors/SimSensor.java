package de.uka.ipd.sdq.capra.simulator.measurement.sensors;

import de.uka.ipd.sdq.capra.simulator.tools.CapraExperimentManager;

public interface SimSensor {
	
	void storeData(CapraExperimentManager expManager);
	
	String getName();

	void finishMeasurements();
}
