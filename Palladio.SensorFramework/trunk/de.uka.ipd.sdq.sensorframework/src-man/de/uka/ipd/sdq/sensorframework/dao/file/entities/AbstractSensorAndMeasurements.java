/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.dao.file.entities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cern.colt.list.DoubleArrayList;

import de.uka.ipd.sdq.sensorframework.dao.file.FileDAOFactory;
import de.uka.ipd.sdq.sensorframework.dao.file.FileManager;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.storage.lists.BackgroundMemoryList;
import de.uka.ipd.sdq.sensorframework.storage.lists.DoubleSerialiser;

/**
 * @author Ihssane El-Oudghiri 
 * @author Steffen Becker
 * 
 */
public abstract class AbstractSensorAndMeasurements extends AbstractFileEntity implements SerializableEntity {

	protected static final String EVENT_TIME_SUFFIX = "ET";
	protected static final String MEASUREMENTS_SUFFIX = "MEAS";
	
	protected ExperimentRun experimentRun;
	protected Sensor sensor;
	protected BackgroundMemoryList<Double> eventTimes;
	private FileManager fm;

	public AbstractSensorAndMeasurements(FileManager fm, ExperimentRun exprun, Sensor sensor) throws IOException {
		super(fm.getDAOFactory());
		this.sensor = sensor;
		this.experimentRun = exprun;
		this.fm = fm;
		eventTimes = new BackgroundMemoryList<Double>(getEventTimeFileName(), new DoubleSerialiser());
		fm.addOpenList(eventTimes);
	}

	protected String getEventTimeFileName() {
		return fm.getRootDirectory() + File.separator +
		FileDAOFactory.EXPRUN_FILE_NAME_PREFIX
		+ experimentRun.getExperimentRunID() + "_"
		+ sensor.getSensorID() + "_" +
		EVENT_TIME_SUFFIX + ".ser";
	}

	protected String getMeasurementsFileName() {
		return fm.getRootDirectory() + File.separator + FileDAOFactory.EXPRUN_FILE_NAME_PREFIX
		+ experimentRun.getExperimentRunID() + "_"
		+ sensor.getSensorID() + "_" +
		MEASUREMENTS_SUFFIX + ".ser";
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

	public void store() {
		try {
			eventTimes.flush();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public long getID() {
		throw new UnsupportedOperationException();
	}
}