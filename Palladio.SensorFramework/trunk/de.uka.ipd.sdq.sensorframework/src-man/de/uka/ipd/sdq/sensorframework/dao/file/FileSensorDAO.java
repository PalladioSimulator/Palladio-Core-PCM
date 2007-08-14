/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.dao.file;

import java.util.Collection;

import de.uka.ipd.sdq.sensorframework.dao.file.entities.TimeSpanSensorImpl;
import de.uka.ipd.sdq.sensorframework.dao.db4o.IDGenerator;
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
		// TODO Auto-generated method stub
		return null;
	}

	public TimeSpanSensor addTimeSpanSensor(String p_sensorname) {
		TimeSpanSensor result = new TimeSpanSensorImpl(factory);
		result.setSensorID(idGen.getNextSensorID());
		result.setSensorName(p_sensorname);

		return result;
	}

	public Collection<Sensor> findBySensorName(String searchKey) {
		// TODO Auto-generated method stub
		return null;
	}

	public Sensor get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.sensorfactory.entities.dao.ISensorDAO#getSensors()
	 */
	public Collection<Sensor> getSensors() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.sensorfactory.entities.dao.ISensorDAO#removeSensor(de.uka.ipd.sdq.sensorfactory.entities.Sensor,
	 *      boolean)
	 */
	public void removeSensor(Sensor sensor, boolean doCascade) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.sensorfactory.entities.dao.ISensorDAO#store(de.uka.ipd.sdq.sensorfactory.entities.Sensor)
	 */
	public void store(Sensor s) {
		// TODO Auto-generated method stub

	}

}
