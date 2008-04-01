package de.uka.ipd.sdq.capra.simulator.builder;

import de.uka.ipd.sdq.capra.simulator.measurement.recorders.SimFullTimeSpanRecorder;
import de.uka.ipd.sdq.capra.simulator.measurement.sensors.SimGlobalTimeSpanSensor;
import de.uka.ipd.sdq.capra.simulator.measurement.sensors.SimHptSensor;
import de.uka.ipd.sdq.capra.simulator.measurement.sensors.SimLocalTimeSpanSensor;
import de.uka.ipd.sdq.capra.simulator.measurement.sensors.SimTimeSpanSensor;
import de.uka.ipd.sdq.scheduler.IActiveResource;
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
}
