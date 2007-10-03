/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.dao.file.entities;

import java.util.ArrayList;
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
public abstract class AbstractSensorAndMeasurements implements NamedSerializable {

	protected ExperimentRun experimentRun;
	protected Sensor sensor;
	protected DoubleArrayList eventTimes;

	public AbstractSensorAndMeasurements(ExperimentRun exprun, Sensor sensor) {
		this.sensor = sensor;
		this.experimentRun = exprun;
		eventTimes = new DoubleArrayList();
	}

	public Sensor getSensor() {
		return sensor;
	}

	public void setSensor(SensorImpl sensor) {
		this.sensor = sensor;
	}

	public abstract List<Measurement> getMeasurements();

	public String getFileName() {
		return FileDAOFactory.EXPRUN_FILE_NAME_PREFIX
				+ experimentRun.getExperimentRunID() + "_"
				+ sensor.getSensorID();
	}
}