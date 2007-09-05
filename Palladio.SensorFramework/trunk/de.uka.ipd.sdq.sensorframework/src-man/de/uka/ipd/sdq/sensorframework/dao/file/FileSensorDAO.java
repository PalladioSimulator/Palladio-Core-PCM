/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.dao.file;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import de.uka.ipd.sdq.sensorframework.dao.db4o.IDGenerator;
import de.uka.ipd.sdq.sensorframework.dao.file.entities.Serializable;
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
 * Data Access Object (DAO) for persistence of Sensor Objects.
 * 
 */
public class FileSensorDAO implements ISensorDAO {

    private HashMap<Long, Sensor> sensors;
    private FileDAOFactory factory;
    private IDGenerator idGen;

    public FileSensorDAO(FileDAOFactory factory, IDGenerator idGen) {
	this.factory = (FileDAOFactory) factory;
	this.idGen = idGen;
	sensors = new HashMap<Long, Sensor>();
	loadSensors();
    }

    private void loadSensors() {
	File[] files = factory.getFileManager().listFiles(
		FileDAOFactory.SENSO_FILE_NAME_PREFIX);
	for (File file : files) {
	    Sensor sen = factory.getFileManager().getSensor(file);
	    sensors.put(sen.getSensorID(), sen);
	}
    }

    public StateSensor addStateSensor(State p_initialstate, String p_sensorname) {
	StateSensor stsen = new StateSensorImpl(factory);
	stsen.setInitialState(p_initialstate);
	stsen.setSensorName(p_sensorname);
	stsen.setSensorID(idGen.getNextSensorID());

	// factory.serializeToFile(stsen);
	sensors.put(stsen.getSensorID(), stsen);
	return stsen;
    }

    public TimeSpanSensor addTimeSpanSensor(String p_sensorname) {
	TimeSpanSensor result = new TimeSpanSensorImpl(factory);
	result.setSensorID(idGen.getNextSensorID());
	result.setSensorName(p_sensorname);

	// factory.serializeToFile(result);
	sensors.put(result.getSensorID(), result);
	return result;
    }

    public Collection<Sensor> findBySensorName(String searchKey) {
	Collection<Sensor> result = new ArrayList<Sensor>();
	for (Sensor sen : sensors.values())
	    if (sen.getSensorName().equals(searchKey))
		result.add(sen);

	return Collections.unmodifiableCollection(result);
    }

    public Sensor get(long id) {
	return sensors.get(id);
    }

    public Collection<Sensor> getSensors() {
	return Collections.unmodifiableCollection(sensors.values());
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
	sensors.remove(sensor.getSensorID());
	// factory.removeFile("sensor" + sensor.getSensorID());
    }

    public void store(Sensor s) {
	factory.getFileManager().serializeToFile((Serializable) s);
    }

}
