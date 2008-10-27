package de.uka.ipd.sdq.sensorframework.visualisation.editor;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import de.uka.ipd.sdq.sensorframework.SensorFrameworkDataset;
import de.uka.ipd.sdq.sensorframework.entities.Experiment;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;

/**
 * TODO: Document me! What do I do?
 * @author ?
 *
 */
public class ConfigEntry extends Observable {
	private List<Long> sensorIDs;
	private long experimentRunID;
	private long experimentID;
	private long datasourceID;

	public ConfigEntry(IDAOFactory factory, ExperimentRun experimentRun, Experiment experiment,
			Sensor sensor) {
		this.datasourceID = factory.getID();
		this.experimentRunID = experimentRun.getExperimentRunID();
		this.experimentID = experiment.getExperimentID();
		this.sensorIDs = new ArrayList<Long>();
		if (sensor != null)
			this.sensorIDs.add(sensor.getSensorID());
	}
	
	public List<Sensor> getSensors() {
		ArrayList<Sensor> result = new ArrayList<Sensor>();
		for (long sensorID : this.sensorIDs)
			result.add(getDatasource().createSensorDAO().get(sensorID));
		return result;
	}

	/** 
	 * Adds the given Sensor (or its id, respectively) to the list of
	 * sensors of this ConfigEntry. TODO: What does that mean? Are these the 
	 * sensors shown in one diagram, for example?     
	 * @param sensor
	 */
	public void setSensorChecked(Sensor sensor) {
		if (!isSensorChecked(sensor)){
			sensorIDs.add(sensor.getSensorID());
			this.setChanged();
		}
		notifyObservers();
	}

	public void setSensorUnchecked(Sensor sensor) {
		sensorIDs.remove(sensor.getSensorID());
		this.setChanged();
		notifyObservers();
	}

	/**
	 * @return - status of sensor (checked/unchecked)
	 */
	public boolean isSensorChecked(Sensor sensor) {
		if (sensorIDs != null) {
			return sensorIDs.contains(sensor.getSensorID());
		}
		return false;
	}

	public ExperimentRun getExperimentRun() {
		return getDatasource().createExperimentRunDAO().get(experimentRunID);
	}

	public Experiment getExperiment() {
		return getDatasource().createExperimentDAO().get(experimentID);
	}

	public void setExperiment(Experiment experiment) {
		this.experimentID = experiment.getExperimentID();
	}

	public IDAOFactory getDatasource() {
		return SensorFrameworkDataset.singleton().getDataSourceByID(this.datasourceID);
	}
}
