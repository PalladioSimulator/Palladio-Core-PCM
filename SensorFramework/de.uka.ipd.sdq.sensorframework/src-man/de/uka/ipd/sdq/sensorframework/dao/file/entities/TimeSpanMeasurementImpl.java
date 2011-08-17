/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.dao.file.entities;

import de.uka.ipd.sdq.sensorframework.entities.TimeSpanMeasurement;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor;

/**
 * @author Ihssane El-Oudghiri 
 * 
 * TODO Kommentare TODO Warum wird hier nicht TimeSpanSensorAndMeasurement
 * referenziert??
 * TODO add toString method...
 */
public class TimeSpanMeasurementImpl 
extends MeasurementImpl 
implements TimeSpanMeasurement {

	private double timeSpan;

	public TimeSpanMeasurementImpl(long id, double eventTime, double timeSpan) {
		super(id, eventTime);
		this.timeSpan = timeSpan;
	}

	public TimeSpanSensor getSensor() {
		throw new UnsupportedOperationException();
	}

	public double getTimeSpan() {
		return timeSpan;
	}

	public void setSensor(TimeSpanSensor value) {
		throw new UnsupportedOperationException();
	}

	public void setTimeSpan(double value) {
		this.timeSpan = value;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return 	"TimeSpanMeasurementImpl: ID="+this.getMeasurementID()+", " +
				"eventTime="+this.eventTime+", "+
				"timeSpan="+this.timeSpan;
	}
}
