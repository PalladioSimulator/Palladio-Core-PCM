package de.uka.ipd.sdq.sensorframework.dao.db4o;

import java.util.Collection;

import com.db4o.ObjectContainer;

import de.uka.ipd.sdq.sensorframework.dao.db4o.entities.StateMeasurementImpl;
import de.uka.ipd.sdq.sensorframework.dao.db4o.entities.TimeSpanMeasurementImpl;
import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.entities.State;
import de.uka.ipd.sdq.sensorframework.entities.StateMeasurement;
import de.uka.ipd.sdq.sensorframework.entities.StateSensor;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanMeasurement;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;
import de.uka.ipd.sdq.sensorframework.entities.dao.IMeasurementDAO;

public class DB4OMeasurementDAO implements IMeasurementDAO {

	private IDAOFactory factory;
	private ObjectContainer db;
	private IDGenerator idGen;

	public DB4OMeasurementDAO(IDAOFactory factory, ObjectContainer db, IDGenerator idGen) {
		this.factory = factory;
		this.db = db;
		this.idGen = idGen;
	}

	public synchronized StateMeasurement addStateMeasurement(StateSensor p_sensor,
			State p_sensorstate, double p_eventtime) {
		StateMeasurement result = new StateMeasurementImpl(factory);
		result.setMeasurementID(idGen.getNextMeasurementID());
		result.setEventTime(p_eventtime);
		result.setSensor(p_sensor);
		result.setSensorState(p_sensorstate);
				
		return result;
	}

	public synchronized TimeSpanMeasurement addTimeSpanMeasurement(TimeSpanSensor p_sensor,
			double p_eventtime, double p_timespan) {
		TimeSpanMeasurement result = new TimeSpanMeasurementImpl(factory);
		result.setMeasurementID(idGen.getNextMeasurementID());
		result.setEventTime(p_eventtime);
		result.setSensor(p_sensor);
		result.setTimeSpan(p_timespan);

		return result;
	}

	public Measurement get(long id) {
		return null;
	}

	public Collection<Measurement> getMeasurements() {
		return null;
	}

	public synchronized void removeMeasurement(Measurement measurement, boolean doCascade) {
		if (measurement == null) {
			return;
		}
		
		if ( doCascade == true ) {
			if (measurement instanceof StateMeasurement) {
				//remove the state
				State state = ((StateMeasurement)measurement).getSensorState();
				factory.createStateDAO().removeState(state, true);
				
				//remove the sensor
				Sensor sensor = ((StateMeasurement)measurement).getSensor();
				factory.createSensorDAO().removeSensor(sensor, true);
			}
			if (measurement instanceof TimeSpanMeasurement) {
				//remove the sensor
				Sensor sensor = ((TimeSpanMeasurement)measurement).getSensor();
				factory.createSensorDAO().removeSensor(sensor, true);
			}
		}
		
		db.delete(measurement);
		db.commit();
	}

}
