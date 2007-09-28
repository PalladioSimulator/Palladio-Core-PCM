/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.dao.file.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import de.uka.ipd.sdq.sensorframework.dao.file.FileDAOFactory;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.entities.State;
import de.uka.ipd.sdq.sensorframework.entities.StateMeasurement;
import de.uka.ipd.sdq.sensorframework.entities.StateSensor;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanMeasurement;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor;

/**
 * @author ihssane
 * 
 */
public class ExperimentRunImpl implements ExperimentRun, Serializable {

	private static final long serialVersionUID = 6496657460961660218L;
	private transient FileDAOFactory factory;
	private long experimentRunID;
	private String experimentDateTime;
	private transient HashMap<Long, SensorAndMeasurementsImpl> measurementsForSensor;
	public List<Long> sensorIDs;

	public ExperimentRunImpl(){
		measurementsForSensor = new HashMap<Long, SensorAndMeasurementsImpl>();
	}
	
	public ExperimentRunImpl(FileDAOFactory factory) {
		this.factory = factory;
		measurementsForSensor = new HashMap<Long, SensorAndMeasurementsImpl>();
		sensorIDs = new ArrayList<Long>();
	}

	public void setFactory(FileDAOFactory factory) {
		this.factory = factory;
	}

	public long getExperimentRunID() {
		return experimentRunID;
	}

	public void setExperimentRunID(long experimentRunID) {
		this.experimentRunID = experimentRunID;
	}

	public String getExperimentDateTime() {
		return experimentDateTime;
	}

	public void setExperimentDateTime(String experimetDateTime) {
		this.experimentDateTime = experimetDateTime;
	}

	public void addMeasurement(Measurement value) {
		return;
	}

	public Collection<SensorAndMeasurementsImpl> getCachedSensorAndMeasurements() {
		if (measurementsForSensor == null){
			measurementsForSensor = new HashMap<Long, SensorAndMeasurementsImpl>();
		}
		return measurementsForSensor.values();
	}

	public Collection<SensorAndMeasurementsImpl> getSensorAndMeasurements() {
		Collection<SensorAndMeasurementsImpl> result = new ArrayList<SensorAndMeasurementsImpl>();
		if (measurementsForSensor == null)
			measurementsForSensor = new HashMap<Long, SensorAndMeasurementsImpl>();

		for (long l : sensorIDs) {
			SensorAndMeasurementsImpl sam = measurementsForSensor.get(l);
			if (sam == null)
				sam = factory.getFileManager().loadMeasurementForSensor(
						getExperimentRunID(), l);
			result.add(sam);
		}
		return result;
	}

	public StateMeasurement addStateMeasurement(StateSensor p_sensor,
			State p_sensorstate, double p_eventtime) {
		SensorAndMeasurementsImpl sam = null;

		if (measurementsForSensor == null)
			measurementsForSensor = new HashMap<Long, SensorAndMeasurementsImpl>();

		if (!sensorIDs.contains(p_sensor.getSensorID())) {
			sam = new StateSensorAndMeasurement(this, p_sensor);
			sensorIDs.add(p_sensor.getSensorID());
			measurementsForSensor.put(p_sensor.getSensorID(), sam);
		}

		sam = measurementsForSensor.get(p_sensor.getSensorID());
		if (sam == null) {
			sam = factory.getFileManager().loadMeasurementForSensor(
					getExperimentRunID(), p_sensor.getSensorID());
		}
		sam.addEventTime(p_eventtime);
		((StateSensorAndMeasurement) sam).addState(p_sensorstate);

		return factory.createMeasurementDAO().addStateMeasurement(p_sensor,
				p_sensorstate, p_eventtime);
	}

	public TimeSpanMeasurement addTimeSpanMeasurement(TimeSpanSensor p_sensor,
			double p_eventtime, double p_timespan) {
		SensorAndMeasurementsImpl sam = null;
		if (measurementsForSensor == null)
			measurementsForSensor = new HashMap<Long, SensorAndMeasurementsImpl>();

		if (!sensorIDs.contains(p_sensor.getSensorID())) {
			sam = new TimeSpanSensorAndMeasurement(this, p_sensor);
			sensorIDs.add(p_sensor.getSensorID());
			measurementsForSensor.put(p_sensor.getSensorID(), sam);
		}

		sam = measurementsForSensor.get(p_sensor.getSensorID());
		if (sam == null) {
			sam = factory.getFileManager().loadMeasurementForSensor(
					getExperimentRunID(), p_sensor.getSensorID());
		}
		sam.addEventTime(p_eventtime);
		((TimeSpanSensorAndMeasurement) sam).addTimeSpan(p_timespan);

		return factory.createMeasurementDAO().addTimeSpanMeasurement(p_sensor,
				p_eventtime, p_timespan);
	}

	public Collection<Measurement> getMeasurements() {
		ArrayList<Measurement> m = new ArrayList<Measurement>();

		for (SensorAndMeasurementsImpl sam : getSensorAndMeasurements()) {
			m.addAll(sam.getMeasurements());
		}
		return m;
	}

	public SensorAndMeasurements getMeasurementsOfSensor(Sensor sensor) {
		if (!sensorIDs.contains(sensor.getSensorID())) {
			System.err.println("Error: No Measuremts for Sensor: "
					+ sensor.getSensorName() + " found");
			return null;
		}
		if (measurementsForSensor == null)
			measurementsForSensor = new HashMap<Long, SensorAndMeasurementsImpl>();

		SensorAndMeasurementsImpl sam = measurementsForSensor.get(sensor
				.getSensorID());
		if (sam == null) {
			sam = factory.getFileManager().loadMeasurementForSensor(
					getExperimentRunID(), sensor.getSensorID());
		}

		return new SensorAndMeasurements(sensor, sam.getMeasurements());
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ExperimentRunImpl))
			return false;
		ExperimentRunImpl er = (ExperimentRunImpl) obj;

		if (!(experimentRunID == er.getExperimentRunID() && experimentDateTime
				.equals(er.getExperimentDateTime())))
			return false;
		if (!(sensorIDs.equals(er.sensorIDs)))
			return false;

		if (!(getSensorAndMeasurements().equals(er.getSensorAndMeasurements())))
			return false;
		return true;
	}
}
