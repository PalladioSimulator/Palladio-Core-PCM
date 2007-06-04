package de.uka.ipd.sdq.sensorframework.visualisation.editor;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import de.uka.ipd.sdq.sensorfactory.entities.Experiment;
import de.uka.ipd.sdq.sensorfactory.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorfactory.entities.Sensor;

public class ConfigEntry extends Observable {
	private List<Sensor> sensors;
	private ExperimentRun experimentRun;
	private Experiment experiment;

	public ConfigEntry(ExperimentRun experimentRun, Experiment experiment,
			Sensor sensor) {
		this.experimentRun = experimentRun;
		this.experiment = experiment;
		this.sensors = new ArrayList<Sensor>();
		if (sensor != null)
			this.sensors.add(sensor);
	}
	
	public List<Sensor> getSensors() {
		return sensors;
	}

	public void setSensorChecked(Sensor sensor) {
		if (!isSensorChecked(sensor)){
			sensors.add(sensor);
			this.setChanged();
		}
		notifyObservers();
	}

	public void setSensorUnchecked(Sensor sensor) {
		sensors.remove(sensor);
		this.setChanged();
		notifyObservers();
	}

	/**
	 * @return - status of sensor (checked/unchecked)
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

	public Experiment getExperiment() {
		return experiment;
	}

	public void setExperiment(Experiment experiment) {
		this.experiment = experiment;
	}
}
