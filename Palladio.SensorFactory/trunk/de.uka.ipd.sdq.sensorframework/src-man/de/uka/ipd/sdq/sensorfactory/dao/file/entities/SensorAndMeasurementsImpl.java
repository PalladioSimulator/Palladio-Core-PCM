/**
 * 
 */
package de.uka.ipd.sdq.sensorfactory.dao.file.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.sensorfactory.entities.Measurement;
import de.uka.ipd.sdq.sensorfactory.entities.Sensor;

/**
 * @author ihssane
 * 
 */
public abstract class SensorAndMeasurementsImpl implements Serializable {

	protected long sensorAndMeasurementsID;

	protected Sensor sensor;

	protected List<Double> eventTimes;

	public SensorAndMeasurementsImpl(Sensor sensor) {
		this.sensor = sensor;
		eventTimes = new ArrayList<Double>();
	}

	public List<Double> getEventTimes() {
		return eventTimes;
	}

	public long getSensorAndMeasurementsID() {
		return sensorAndMeasurementsID;
	}

	public void setSensorAndMeasurementsID(long sensorAndMeasurementsID) {
		this.sensorAndMeasurementsID = sensorAndMeasurementsID;
	}

	public Sensor getSensor() {
		return sensor;
	}

	public void setSensor(SensorImpl sensor) {
		this.sensor = sensor;
	}

	public void addEventTime(double et) {
		eventTimes.add(et);
	}

	public abstract List<Measurement> getMeasurements();

}
