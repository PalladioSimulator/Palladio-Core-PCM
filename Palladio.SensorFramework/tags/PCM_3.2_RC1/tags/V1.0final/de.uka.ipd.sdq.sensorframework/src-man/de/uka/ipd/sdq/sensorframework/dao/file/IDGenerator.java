package de.uka.ipd.sdq.sensorframework.dao.file;

import java.io.Serializable;

/** TODO document me
 * @author Ihssane El-Oudghiri 
 * @author Steffen Becker

 */
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
