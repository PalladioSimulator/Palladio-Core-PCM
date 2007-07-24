package de.uka.ipd.sdq.sensorfactory.dao.file.entities;

import java.io.Serializable;

import de.uka.ipd.sdq.sensorfactory.dao.file.FileDAOFactory;
import de.uka.ipd.sdq.sensorfactory.entities.Sensor;

/**
 * @author ihssane
 * 
 */
public abstract class SensorImpl implements Sensor, Serializable {

	protected transient FileDAOFactory factory;

	protected long sensorID;

	protected String sensorName;

	public SensorImpl(FileDAOFactory factory) {
		this.factory = factory;
	}

	public long getSensorID() {
		return sensorID;
	}

	public void setSensorID(long sensorID) {
		this.sensorID = sensorID;
	}

	public String getSensorName() {
		return sensorName;
	}

	public void setSensorName(String sensorName) {
		this.sensorName = sensorName;
	}

}
