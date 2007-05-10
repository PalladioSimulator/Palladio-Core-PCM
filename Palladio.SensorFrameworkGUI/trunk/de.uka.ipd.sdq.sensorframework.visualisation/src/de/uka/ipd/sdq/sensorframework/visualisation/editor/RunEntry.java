package de.uka.ipd.sdq.sensorframework.visualisation.editor;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.sensorfactory.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorfactory.entities.Sensor;

public class RunEntry {
	private List<Sensor> sensors;
	private ExperimentRun experimentRun;

	public RunEntry(ExperimentRun experimentRun) {
		this.experimentRun = experimentRun;
		this.sensors = new ArrayList<Sensor>();
	}

	public List<Sensor> getSensors() {
		return sensors;
	}

	public void setSensorChecked(Sensor sensor) {
		sensors.add(sensor);
	}

	public void setSensorUnchecked(Sensor sensor) {
		sensors.remove(sensor);
	}

	/**
	 * TODO
	 * 
	 * @param sensor
	 * @return
	 */
	public boolean isSensorChecked(Sensor sensor) {
		if (sensors != null) {
			return sensors.contains(sensor);
		}
		return false;
	}

	public ExperimentRun getExperimentRun() {
		return experimentRun;
	}
}
