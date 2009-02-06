package de.uka.ipd.sdq.sensorframework.entities;

import java.util.Collection;

public class SensorAndMeasurements {
	private Sensor mySensor;
	private Collection<Measurement> myMeasurements;

	public SensorAndMeasurements(Sensor s, Collection<Measurement> m){
		this.mySensor = s;
		this.myMeasurements = m;
	}

	public Sensor getSensor() {
		return mySensor;
	}

	public Collection<Measurement> getMeasurements() {
		return myMeasurements;
	}
}
