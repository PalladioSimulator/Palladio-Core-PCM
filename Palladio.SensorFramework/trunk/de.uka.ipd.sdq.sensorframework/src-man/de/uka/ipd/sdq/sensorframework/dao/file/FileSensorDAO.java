/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.dao.file;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import de.uka.ipd.sdq.sensorframework.dao.db4o.IDGenerator;
import de.uka.ipd.sdq.sensorframework.dao.file.entities.StateSensorImpl;
import de.uka.ipd.sdq.sensorframework.dao.file.entities.TimeSpanSensorImpl;
import de.uka.ipd.sdq.sensorframework.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.entities.State;
import de.uka.ipd.sdq.sensorframework.entities.StateSensor;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor;
import de.uka.ipd.sdq.sensorframework.entities.dao.ISensorDAO;

/**
 * @author ihssane
 * 
 */
public class FileSensorDAO implements ISensorDAO {

	private FileDAOFactory factory;
	private IDGenerator idGen;

	public FileSensorDAO(FileDAOFactory factory, IDGenerator idGen) {
		this.factory = (FileDAOFactory) factory;
		this.idGen = idGen;
	}

	public StateSensor addStateSensor(State p_initialstate, String p_sensorname) {
		StateSensor stsen = new StateSensorImpl(factory);
		stsen.setInitialState(p_initialstate);
		stsen.setSensorName(p_sensorname);
		stsen.setSensorID(idGen.getNextSensorID());

		factory.serializeToFile("sensor" + stsen.getSensorID(), stsen);

		return stsen;
	}

	public TimeSpanSensor addTimeSpanSensor(String p_sensorname) {
		TimeSpanSensor result = new TimeSpanSensorImpl(factory);
		result.setSensorID(idGen.getNextSensorID());
		result.setSensorName(p_sensorname);

		factory.serializeToFile("sensor" + result.getSensorID(), result);
		return result;
	}

	public Collection<Sensor> findBySensorName(String searchKey) {
		Collection<Sensor> result = new ArrayList<Sensor>();
		File[] files = factory.listFiles("sensor");
		for (File file : files) {
			Sensor state = (Sensor) factory.deserializeFromFile(file);
			if (state.getSensorName().equals(searchKey))
				result.add(state);
		}
		return Collections.unmodifiableCollection(result);
	}

	public Sensor get(long id) {
		File[] files = factory.listFiles("sensor" + id);
		Sensor sensor = null;
		if (files.length == 0)
			return null;
		else {
			for (File file : files)
				sensor = (Sensor) factory.deserializeFromFile(file);

		}
		return sensor;
	}

	public Collection<Sensor> getSensors() {
		return null;
	}

	public void removeSensor(Sensor sensor, boolean doCascade) {
		if (sensor == null)
			return;

		if (doCascade == true) {
			if (sensor instanceof StateSensor) {
				// remove the states
				for (State state : ((StateSensor) sensor).getSensorStates()) {
					factory.createStateDAO().removeState(state, true);
				}
			}
		}
		factory.removeFile("sensor" + sensor.getSensorID());
	}

	public void store(Sensor s) {
		factory.serializeToFile("sensor" + s.getSensorID(), s);
	}

}
