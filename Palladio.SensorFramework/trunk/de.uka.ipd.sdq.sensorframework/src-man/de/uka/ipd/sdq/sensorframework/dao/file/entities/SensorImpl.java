package de.uka.ipd.sdq.sensorframework.dao.file.entities;

import de.uka.ipd.sdq.sensorframework.dao.file.FileDAOFactory;
import de.uka.ipd.sdq.sensorframework.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;

/**
 * @author ihssane
 * 
 */
public abstract class SensorImpl extends AbstractFileEntity implements Sensor, NamedSerializable {

	protected long sensorID;
	protected String sensorName;

	public SensorImpl(IDAOFactory factory) {
		super(factory);
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

	public String getFileName() {
		return FileDAOFactory.SENSOR_FILE_NAME_PREFIX + getSensorID();
	}

	public long getID() {
		return this.sensorID;
	}
}
