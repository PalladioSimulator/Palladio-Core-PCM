/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.dao.file.entities;

import de.uka.ipd.sdq.sensorframework.entities.Measurement;

/**
 * @author ihssane
 * 
 */
public class MeasurementImpl implements Measurement {

	private long measurementID;
	private double eventTime;

	public MeasurementImpl(long id, double eventTime) {
		this.eventTime = eventTime;
		this.measurementID = id;
	}

	public double getEventTime() {
		return eventTime;
	}

	public long getMeasurementID() {
		return measurementID;
	}

	public void setEventTime(double value) {
		this.eventTime = value;
	}

	public void setMeasurementID(long value) {
		this.measurementID = value;
	}

}
