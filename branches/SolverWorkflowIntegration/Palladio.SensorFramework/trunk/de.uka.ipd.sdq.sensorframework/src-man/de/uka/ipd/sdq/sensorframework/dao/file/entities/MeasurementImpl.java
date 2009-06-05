/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.dao.file.entities;

import de.uka.ipd.sdq.sensorframework.entities.Measurement;

/**
 * @author Ihssane El-Oudghiri 
 */
public class MeasurementImpl implements Measurement {

	protected long measurementID;
	protected double eventTime;

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
