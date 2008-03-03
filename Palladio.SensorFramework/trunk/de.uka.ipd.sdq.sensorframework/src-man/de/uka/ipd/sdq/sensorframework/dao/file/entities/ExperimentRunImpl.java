/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.dao.file.entities;

import java.io.IOException;
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
	
	/**
	 * Contains the measurements and event times for each sensor in this experiment run.
	 * Hashes sensor ID on the sensor's measurements 
	 */
	private transient HashMap<Long, AbstractSensorAndMeasurements> measurementsForSensor;
	
	/**
	 * IDs of the sensors defineded for this experiment run 
	 */
	public List<Long> sensorIDs;

	public ExperimentRunImpl(){
		measurementsForSensor = new HashMap<Long, AbstractSensorAndMeasurements>();
	}
	
	public ExperimentRunImpl(FileDAOFactory factory) {
		this.factory = factory;
		measurementsForSensor = new HashMap<Long, AbstractSensorAndMeasurements>();
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

	public Collection<AbstractSensorAndMeasurements> getCachedSensorAndMeasurements() {
		if (measurementsForSensor == null){
			measurementsForSensor = new HashMap<Long, AbstractSensorAndMeasurements>();
		}
		return measurementsForSensor.values();
	}

	public Collection<AbstractSensorAndMeasurements> getSensorAndMeasurements() {
		Collection<AbstractSensorAndMeasurements> result = new ArrayList<AbstractSensorAndMeasurements>();
		if (measurementsForSensor == null)
			measurementsForSensor = new HashMap<Long, AbstractSensorAndMeasurements>();

		for (long l : sensorIDs) {
			AbstractSensorAndMeasurements sam = measurementsForSensor.get(l);
			if (sam == null)
				sam = createMeasurementStorage(factory.createSensorDAO().get(l), sam);
				//sam = factory.getFileManager().loadMeasurementForSensor(
				//		getExperimentRunID(), l);
			result.add(sam);
		}
		return result;
	}

	public StateMeasurement addStateMeasurement(StateSensor p_sensor,
			State p_sensorstate, double p_eventtime) {
		AbstractSensorAndMeasurements sam = null;

		if (measurementsForSensor == null)
			measurementsForSensor = new HashMap<Long, AbstractSensorAndMeasurements>();

		if (!sensorIDs.contains(p_sensor.getSensorID())) {
			try {
				sam = new StateSensorAndMeasurement(((FileDAOFactory)factory).getFileManager(),this, p_sensor);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			sensorIDs.add(p_sensor.getSensorID());
			measurementsForSensor.put(p_sensor.getSensorID(), sam);
		}

		sam = measurementsForSensor.get(p_sensor.getSensorID());
		if (sam == null) {
			sam = createMeasurementStorage(p_sensor, sam);		}
		((StateSensorAndMeasurement) sam).addState(p_eventtime, p_sensorstate);

		return factory.createMeasurementDAO().addStateMeasurement(p_sensor,
				p_sensorstate, p_eventtime);
	}

	public TimeSpanMeasurement addTimeSpanMeasurement(TimeSpanSensor p_sensor,
			double p_eventtime, double p_timespan) {
		AbstractSensorAndMeasurements sam = null;
		if (measurementsForSensor == null)
			measurementsForSensor = new HashMap<Long, AbstractSensorAndMeasurements>();

		if (!sensorIDs.contains(p_sensor.getSensorID())) {
			
			try {
				sam = new TimeSpanSensorAndMeasurement(((FileDAOFactory)factory).getFileManager(),this, p_sensor);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			sensorIDs.add(p_sensor.getSensorID());
			measurementsForSensor.put(p_sensor.getSensorID(), sam);
		}

		sam = measurementsForSensor.get(p_sensor.getSensorID());
		if (sam == null) {
			sam = createMeasurementStorage(p_sensor, sam);		}
		((TimeSpanSensorAndMeasurement) sam).addTimeSpan(p_eventtime, p_timespan);

		return factory.createMeasurementDAO().addTimeSpanMeasurement(p_sensor,
				p_eventtime, p_timespan);
	}

	public Collection<Measurement> getMeasurements() {
		ArrayList<Measurement> m = new ArrayList<Measurement>();

		for (AbstractSensorAndMeasurements sam : getSensorAndMeasurements()) {
			m.addAll(sam.getMeasurements());
		}
		return m;
	}

	public SensorAndMeasurements getMeasurementsOfSensor(Sensor sensor) {
		if (!sensorIDs.contains(sensor.getSensorID())) {
			throw new IllegalArgumentException("Error: No Measuremts for Sensor: "
					+ sensor.getSensorName() + " found");
		}
		if (measurementsForSensor == null)
			measurementsForSensor = new HashMap<Long, AbstractSensorAndMeasurements>();

		AbstractSensorAndMeasurements sam = measurementsForSensor.get(sensor
				.getSensorID());
		if (sam == null) {
			sam = createMeasurementStorage(sensor, sam);
		}
		return new SensorAndMeasurements(sensor, sam.getMeasurements());
	}

	private AbstractSensorAndMeasurements createMeasurementStorage(
			Sensor sensor, AbstractSensorAndMeasurements sam) {
		try{
//			sam = factory.getFileManager().loadMeasurementForSensor(
//					getExperimentRunID(), sensor.getSensorID());
			if (sensor instanceof TimeSpanSensor)
				sam = new TimeSpanSensorAndMeasurement(((FileDAOFactory)factory).getFileManager(),this,sensor);
			else if (sensor instanceof StateSensor)
				sam = new StateSensorAndMeasurement(((FileDAOFactory)factory).getFileManager(),this,sensor);
			else
				throw new RuntimeException("Invalid sensor found, fix implementation!");
		}catch(IOException e){
			throw new RuntimeException(e);
		}
		measurementsForSensor.put(sensor.getSensorID(), sam);
		return sam;
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
