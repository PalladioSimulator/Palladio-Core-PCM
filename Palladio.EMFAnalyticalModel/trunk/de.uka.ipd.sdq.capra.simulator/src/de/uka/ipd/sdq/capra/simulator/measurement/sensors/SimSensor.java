package de.uka.ipd.sdq.capra.simulator.measurement.sensors;

import de.uka.ipd.sdq.capra.simulator.measurement.recorders.SimRecorder;
import de.uka.ipd.sdq.capra.simulator.tools.CapraExperimentManager;

public interface SimSensor {
	
	void addRecorder(SimRecorder recorder);

	void storeData(CapraExperimentManager expManager);
	
	String getName();
	
	void setName(String name);

	void finishMeasurements();

	void start();

}
