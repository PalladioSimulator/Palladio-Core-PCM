package de.uka.ipd.sdq.scheduler.sensors;

import de.uka.ipd.sdq.sensorframework.util.ExperimentManager;

public interface IDataRecorder {
	
	void storeData(ExperimentManager expManager);
	
}
