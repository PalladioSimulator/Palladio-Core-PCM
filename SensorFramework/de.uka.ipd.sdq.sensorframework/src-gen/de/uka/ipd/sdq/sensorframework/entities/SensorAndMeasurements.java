package de.uka.ipd.sdq.sensorframework.entities;

import java.util.Collection;

/**
 * Container class which stores a tuple of a sensor and its measuremnts collection
 * @author Steffen Becker
 *
 */
public class SensorAndMeasurements {
	private final Sensor mySensor;
	private final Collection<Measurement> myMeasurements;

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
