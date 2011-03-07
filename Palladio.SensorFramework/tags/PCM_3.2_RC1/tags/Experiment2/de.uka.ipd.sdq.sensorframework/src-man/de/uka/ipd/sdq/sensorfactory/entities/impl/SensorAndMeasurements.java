package de.uka.ipd.sdq.sensorfactory.entities.impl;

import java.util.Collection;

import de.uka.ipd.sdq.sensorfactory.entities.Measurement;
import de.uka.ipd.sdq.sensorfactory.entities.Sensor;

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
