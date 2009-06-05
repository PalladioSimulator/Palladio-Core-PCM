package de.uka.ipd.sdq.capra.simulator.builder;

import java.util.Collection;
import java.util.Hashtable;
import java.util.List;

import de.uka.ipd.sdq.capra.simulator.measurement.sensors.SimSensor;
import de.uka.ipd.sdq.capra.simulator.measurement.sensors.SimTimeSpanSensor;

public class SensorManager {

	private Hashtable<String, SimSensor> sensorTable = new Hashtable<String, SimSensor>();
	
	public void init() {
		
	}
	
	public SimSensor getSensor(String name){
		return sensorTable.get(name);
	}

	public SimTimeSpanSensor getTimeSpanSensor(String name) {
		return (SimTimeSpanSensor) getSensor(name);
	}
	
	public void addSensor(SimSensor sensor){
		sensorTable.put(sensor.getName(), sensor);
	}

	public Collection<SimSensor> getSensors() {
		return sensorTable.values();

	}
}
