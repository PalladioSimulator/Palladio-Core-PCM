package de.uka.ipd.sdq.sensorframework.dao.db4o;

import de.uka.ipd.sdq.sensorframework.dao.file.entities.NamedSerializable;

public class IDGenerator implements NamedSerializable {

	private static final long serialVersionUID = -4845947012172760482L;
	public static final String FILE_NAME = "id_generator";

	private long nextExperimentID = 0;
	private long nextExperimentRunID = 0;
	private long nextMeasurementID = 0;
	private long nextSensorID = 0;
	private long nextStateID = 0;

	public long getNextExperimentID() {
		return nextExperimentID++;
	}

	public long getNextExperimentRunID() {
		return nextExperimentRunID++;
	}

	public long getNextMeasurementID() {
		return nextMeasurementID++;
	}

	public long getNextSensorID() {
		return nextSensorID++;
	}

	public long getNextStateID() {
		return nextStateID++;
	}

	public String getFileName() {
		return FILE_NAME;
	}
}
