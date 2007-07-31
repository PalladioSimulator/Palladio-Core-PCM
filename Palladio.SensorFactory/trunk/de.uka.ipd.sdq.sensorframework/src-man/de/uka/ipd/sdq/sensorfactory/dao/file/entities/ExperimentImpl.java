/**
 * 
 */
package de.uka.ipd.sdq.sensorfactory.dao.file.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import de.uka.ipd.sdq.sensorfactory.dao.file.FileDAOFactory;
import de.uka.ipd.sdq.sensorfactory.entities.Experiment;
import de.uka.ipd.sdq.sensorfactory.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorfactory.entities.Sensor;
import de.uka.ipd.sdq.sensorfactory.entities.State;
import de.uka.ipd.sdq.sensorfactory.entities.StateSensor;
import de.uka.ipd.sdq.sensorfactory.entities.TimeSpanSensor;
import de.uka.ipd.sdq.sensorfactory.entities.dao.IDAOFactory;

/**
 * @author ihssane
 * 
 */
public class ExperimentImpl implements Experiment, Serializable {

	private static final long serialVersionUID = 1L;

	protected transient IDAOFactory factory;

	private long experimentID;

	private String experimentName;

	private Collection<Sensor> sensors;

	private Collection<ExperimentRun> experimentRuns;

	public ExperimentImpl(IDAOFactory factory) {
		this.factory = factory;
		sensors = new ArrayList<Sensor>();
		experimentRuns = new ArrayList<ExperimentRun>();
	}

	public long getExperimentID() {
		return experimentID;
	}

	public void setExperimentID(long experimentID) {
		this.experimentID = experimentID;
	}

	public String getExperimentName() {
		return experimentName;
	}

	public void setExperimentName(String experimentName) {
		this.experimentName = experimentName;
	}

	public Collection<Sensor> getSensors() {
		return sensors;
	}

	public void setSensors(Collection<Sensor> sensors) {
		this.sensors = sensors;
	}

	public void setFactory(FileDAOFactory factory) {
		this.factory = factory;
	}

	public Collection<ExperimentRun> getExperimentRuns() {
		return experimentRuns;
	}

	public void setExperimentRuns(Collection<ExperimentRun> experimentRuns) {
		this.experimentRuns = experimentRuns;
	}

	public TimeSpanSensor addTimeSpanSensor(String sensorName) {
		TimeSpanSensor tss = factory.createSensorDAO().addTimeSpanSensor(
				sensorName);
		sensors.add(tss);
		return tss;
	}

	public ExperimentRun addExperimentRun(String experimentdatetime) {
		ExperimentRun expRun = factory.createExperimentRunDAO()
				.addExperimentRun(experimentdatetime);
		experimentRuns.add(expRun);
		return expRun;
	}

	public void addExperimentRun(ExperimentRun experimentRun) {
		experimentRuns.add(experimentRun);
	}

	public void addSensor(Sensor value) {
		sensors.add(value);
	}

	public StateSensor addStateSensor(State p_initialstate, String p_sensorname) {
		// TODO Auto-generated method stub
		return null;
	}

}
