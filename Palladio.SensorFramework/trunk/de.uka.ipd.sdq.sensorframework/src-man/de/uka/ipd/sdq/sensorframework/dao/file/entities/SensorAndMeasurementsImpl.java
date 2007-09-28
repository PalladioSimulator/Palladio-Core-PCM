/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.dao.file.entities;

import java.util.List;

import cern.colt.list.DoubleArrayList;
import de.uka.ipd.sdq.sensorframework.dao.file.FileDAOFactory;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.Sensor;

/**
 * @author ihssane
 * 
 */
public abstract class SensorAndMeasurementsImpl implements NamedSerializable {

    protected ExperimentRun experimentRun;
    protected long sensorAndMeasurementsID;
    protected Sensor sensor;
    protected DoubleArrayList eventTimes;

    public SensorAndMeasurementsImpl(ExperimentRun exprun, Sensor sensor) {
	this.sensor = sensor;
	this.experimentRun = exprun;
	eventTimes = new DoubleArrayList();
    }

    @SuppressWarnings("unchecked")
    public List<Double> getEventTimes() {
	return eventTimes.toList();
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

    public String getFileName() {
	return FileDAOFactory.EXPRUN_FILE_NAME_PREFIX
		+ experimentRun.getExperimentRunID() + "_"
		+ sensor.getSensorID();
    }

}