package de.uka.ipd.sdq.capra.simulator.measurement.recorders;

import de.uka.ipd.sdq.capra.simulator.measurement.sensors.SimSensor;
import de.uka.ipd.sdq.capra.simulator.tools.CapraExperimentManager;

public interface SimRecorder extends Cloneable {

	void storeData(CapraExperimentManager expManager);
	
	SimRecorder clone();

	void start();

	void setSensor(SimSensor sensor);

}
