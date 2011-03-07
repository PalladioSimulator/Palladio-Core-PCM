package de.uka.ipd.sdq.capra.simulator.builder;

import de.uka.ipd.sdq.capra.simulator.measurement.recorders.SimFullTimeSpanRecorder;
import de.uka.ipd.sdq.capra.simulator.measurement.sensors.SimTimeSpanSensor;

public class SensorFactory {

	public SimFullTimeSpanRecorder createFullTimeSpanRecorder(String name) {
		return new SimFullTimeSpanRecorder(name);
	}

	public SimTimeSpanSensor createTimeSpanSensor(String name) {
		return new SimTimeSpanSensor(name);
	}
}
