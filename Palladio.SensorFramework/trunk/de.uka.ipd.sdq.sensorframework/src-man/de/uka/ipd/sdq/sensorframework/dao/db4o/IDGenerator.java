package de.uka.ipd.sdq.sensorframework.dao.db4o;

import java.io.Serializable;

public class IDGenerator implements Serializable {

	private static final long serialVersionUID = -4845947012172760482L;

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

}
