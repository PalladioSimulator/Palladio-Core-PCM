/**
 * 
 */
package de.uka.ipd.sdq.sensorfactory.dao.file.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import de.uka.ipd.sdq.sensorfactory.dao.file.FileDAOFactory;
import de.uka.ipd.sdq.sensorfactory.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorfactory.entities.Measurement;
import de.uka.ipd.sdq.sensorfactory.entities.Sensor;
import de.uka.ipd.sdq.sensorfactory.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorfactory.entities.State;
import de.uka.ipd.sdq.sensorfactory.entities.StateMeasurement;
import de.uka.ipd.sdq.sensorfactory.entities.StateSensor;
import de.uka.ipd.sdq.sensorfactory.entities.TimeSpanMeasurement;
import de.uka.ipd.sdq.sensorfactory.entities.TimeSpanSensor;
import de.uka.ipd.sdq.sensorfactory.entities.dao.IDAOFactory;

/**
 * @author ihssane
 * 
 */
public class ExperimentRunImpl implements ExperimentRun, Serializable {

	private static final long serialVersionUID = 1L;

	private transient IDAOFactory factory;

	private long experimentRunID;

	private String experimetDateTime;

	private Collection<SensorAndMeasurementsImpl> sensorAndMeasurements;

	private HashMap<Sensor, SensorAndMeasurementsImpl> sensorToMeasurements;

	public ExperimentRunImpl(FileDAOFactory factory) {
		this.factory = factory;
		sensorToMeasurements = new HashMap<Sensor, SensorAndMeasurementsImpl>();
		sensorAndMeasurements = new ArrayList<SensorAndMeasurementsImpl>();
	}

	public long getExperimentRunID() {
		return experimentRunID;
	}

	public void setExperimentRunID(long experimentRunID) {
		this.experimentRunID = experimentRunID;
	}

	public String getExperimentDateTime() {
		return experimetDateTime;
	}

	public void setExperimentDateTime(String experimetDateTime) {
		this.experimetDateTime = experimetDateTime;
	}

	public Collection<SensorAndMeasurementsImpl> getSensorAndMeasurements() {
		return sensorAndMeasurements;
	}

	public void setSensorAndMeasurements(
			Collection<SensorAndMeasurementsImpl> sensorAndMeasurements) {
		this.sensorAndMeasurements = sensorAndMeasurements;
	}

	public void addMeasurement(Measurement value) {
		// TODO Auto-generated method stub

	}

	public StateMeasurement addStateMeasurement(StateSensor p_sensor,
			State p_sensorstate, double p_eventtime) {
		// TODO Auto-generated method stub
		return null;
	}

	public TimeSpanMeasurement addTimeSpanMeasurement(TimeSpanSensor p_sensor,
			double p_eventtime, double p_timespan) {
		SensorAndMeasurementsImpl sam = sensorToMeasurements.get(p_sensor);
		if (sam == null) {
			sam = new TimeSpanSensorAndMeasurement(p_sensor);
			sensorAndMeasurements.add(sam);
			sensorToMeasurements.put(p_sensor, sam);
		}
		sam.addEventTime(p_eventtime);
		((TimeSpanSensorAndMeasurement) sam).addTimeSpan(p_timespan);

		return null;
	}

	public Collection<Measurement> getMeasurements() {
		// TODO Auto-generated method stub
		return null;
	}

	public SensorAndMeasurements getMeasurementsOfSensor(Sensor sensor) {
		// TODO Auto-generated method stub
		return null;
	}

}
