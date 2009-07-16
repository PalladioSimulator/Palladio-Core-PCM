package de.uka.ipd.sdq.sensorframework.dao.memory;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.ScalabilityMeasurement;
import de.uka.ipd.sdq.sensorframework.entities.ScalabilitySensor;
import de.uka.ipd.sdq.sensorframework.entities.State;
import de.uka.ipd.sdq.sensorframework.entities.StateMeasurement;
import de.uka.ipd.sdq.sensorframework.entities.StateSensor;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanMeasurement;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;
import de.uka.ipd.sdq.sensorframework.entities.dao.IMeasurementDAO;
import de.uka.ipd.sdq.sensorframework.entities.impl.ScalabilityMeasurementImpl;
import de.uka.ipd.sdq.sensorframework.entities.impl.StateMeasurementImpl;
import de.uka.ipd.sdq.sensorframework.entities.impl.TimeSpanMeasurementImpl;

/**
 * TODO
 *
 */
public class MemoryMeasurementDAO implements IMeasurementDAO {

	private long nextID = 0;
	private IDAOFactory myFactory;
	private HashMap<Long, Measurement> index = new HashMap<Long, Measurement>();
	
	public MemoryMeasurementDAO(IDAOFactory myFactory){
		this.myFactory = myFactory;
	}
	
	public synchronized StateMeasurement addStateMeasurement(StateSensor p_sensor,
			State p_sensorstate, double p_eventtime) {
		StateMeasurement result = new StateMeasurementImpl(myFactory);
		result.setMeasurementID(nextID++);
		result.setEventTime(p_eventtime);
		result.setSensor(p_sensor);
		result.setSensorState(p_sensorstate);
		
		index.put(result.getMeasurementID(), result);
		return result;
	}

	public synchronized TimeSpanMeasurement addTimeSpanMeasurement(TimeSpanSensor p_sensor,
			double p_eventtime, double p_timespan) {
		TimeSpanMeasurement result = new TimeSpanMeasurementImpl(myFactory);
		result.setMeasurementID(nextID++);
		result.setEventTime(p_eventtime);
		result.setSensor(p_sensor);
		result.setTimeSpan(p_timespan);

		index.put(result.getMeasurementID(), result);
		return result;
	}
	
	public synchronized ScalabilityMeasurement addScalabilityMeasurement(ScalabilitySensor p_sensor,
			Double[] p_params, double p_result ) {
		ScalabilityMeasurement result = new ScalabilityMeasurementImpl(myFactory);
		result.setMeasurementID(nextID++);
		result.setEventTime(p_result);
		result.setSensor(p_sensor);
		result.setParameters(p_params);

		index.put(result.getMeasurementID(), result);
		return result;
	}

	public synchronized Measurement get(long id) {
		return index.get(id);
	}

	public synchronized Collection<Measurement> getMeasurements() {
		return Collections.unmodifiableCollection(index.values());
	}

	public synchronized void removeMeasurement(Measurement measurement, boolean doCascade) {
		if (measurement == null) {
			return;
		}
				
		index.remove(measurement.getMeasurementID());		
	}
}
