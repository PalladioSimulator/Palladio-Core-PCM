package de.uka.ipd.sdq.capra.simulator.measurement.recorders;

import de.uka.ipd.sdq.sensorframework.util.ExperimentManager;

public interface SimRecorder extends Cloneable {

	void storeData(ExperimentManager expManager);
	
	SimRecorder clone();

}
