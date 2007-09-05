/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.dao.file.entities;

import de.uka.ipd.sdq.sensorframework.entities.TimeSpanMeasurement;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor;

/**
 * @author ihssane
 * 
 * TODO Kommentare TODO Warum wird hier nicht TimeSpanSensorAndMeasurement
 * referenziert??
 * 
 */
public class TimeSpanMeasurementImpl extends MeasurementImpl implements
	TimeSpanMeasurement {

    private double timeSpan;
    private TimeSpanSensor sensor;

    // private TimeSpanSensorAndMeasurement tsam;

    public TimeSpanMeasurementImpl(long id, double eventTime, double timeSpan) {
	super(id, eventTime);
	this.timeSpan = timeSpan;
    }

    public TimeSpanSensor getSensor() {
	// return (TimeSpanSensor) tsam.getSensor();
	return sensor;
    }

    public double getTimeSpan() {
	// return tsam.getTimeSpan().get((int)measurementID);
	return timeSpan;
    }

    public void setSensor(TimeSpanSensor value) {
	this.sensor = value;
    }

    public void setTimeSpan(double value) {
	// tsam.getTimeSpan().remo
	this.timeSpan = value;
    }

}
