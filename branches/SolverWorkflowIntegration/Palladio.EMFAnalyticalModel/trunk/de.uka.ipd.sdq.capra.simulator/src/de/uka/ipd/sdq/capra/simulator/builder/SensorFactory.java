package de.uka.ipd.sdq.capra.simulator.builder;

import de.uka.ipd.sdq.capra.simulator.measurement.recorders.impl.SimFullTimeSpanRecorder;
import de.uka.ipd.sdq.capra.simulator.measurement.sensors.SimStateSensor;
import de.uka.ipd.sdq.capra.simulator.measurement.sensors.SimTimeSpanSensor;
import de.uka.ipd.sdq.capra.simulator.measurement.sensors.impl.SimGlobalTimeSpanSensor;
import de.uka.ipd.sdq.capra.simulator.measurement.sensors.impl.SimHptSensor;
import de.uka.ipd.sdq.capra.simulator.measurement.sensors.impl.SimLocalTimeSpanSensor;
import de.uka.ipd.sdq.capra.simulator.measurement.sensors.impl.SimProcessorShareSensor;
import de.uka.ipd.sdq.capra.simulator.measurement.sensors.impl.SimResourceUtilisationSensor;
import de.uka.ipd.sdq.scheduler.resources.active.SimActiveResource;

public class SensorFactory {

	public SimFullTimeSpanRecorder createFullTimeSpanRecorder(String name) {
		return new SimFullTimeSpanRecorder(name);
	}

	public SimTimeSpanSensor createLocalTimeSpanSensor(String name) {
		return new SimLocalTimeSpanSensor(name);
	}

	public SimTimeSpanSensor createGlobalTimeSpanSensor(String name) {
		return new SimGlobalTimeSpanSensor(name);
	}

	public SimTimeSpanSensor createInterruptionTimeSpanSensor(String name, SimActiveResource resource, double threshold) {
		return new SimHptSensor(name, resource, threshold);
	}

	public SimStateSensor createResourceUtilisationSensor(String name,
			SimActiveResource resource) {
		SimResourceUtilisationSensor sensor = new SimResourceUtilisationSensor(name);
		resource.addObserver(sensor);
		return sensor;
		
	}

	public SimStateSensor createProcessorShareSensor(String sensorName,
			String processName, SimActiveResource resource) {
		return new SimProcessorShareSensor(sensorName, processName, resource);
	}
}
