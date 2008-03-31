package de.uka.ipd.sdq.capra.simulator.builder;

import de.uka.ipd.sdq.capra.simulator.measurement.recorders.SimFullTimeSpanRecorder;
import de.uka.ipd.sdq.capra.simulator.measurement.sensors.SimGlobalTimeSpanSensor;
import de.uka.ipd.sdq.capra.simulator.measurement.sensors.SimLocalTimeSpanSensor;
import de.uka.ipd.sdq.capra.simulator.measurement.sensors.SimTimeSpanSensor;

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
}
