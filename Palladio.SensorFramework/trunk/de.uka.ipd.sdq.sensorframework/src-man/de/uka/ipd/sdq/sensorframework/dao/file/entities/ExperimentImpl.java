/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.dao.file.entities;

import java.util.ArrayList;
import java.util.Collection;

import de.uka.ipd.sdq.sensorframework.dao.file.FileDAOFactory;
import de.uka.ipd.sdq.sensorframework.entities.Experiment;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.entities.State;
import de.uka.ipd.sdq.sensorframework.entities.StateSensor;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;

/**
 * @author ihssane
 * 
 */
public class ExperimentImpl implements Experiment, NamedSerializable {

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
		for (ExperimentRun er : experimentRuns)
			((ExperimentRunImpl) er).setFactory(factory);
	}

	public IDAOFactory getFactory() {
		return factory;
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
		StateSensor stsen = factory.createSensorDAO().addStateSensor(
				p_initialstate, p_sensorname);
		sensors.add(stsen);
		return stsen;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ExperimentImpl))
			return false;
		ExperimentImpl exp = (ExperimentImpl) obj;

		if (!(experimentID == exp.getExperimentID() && experimentName
				.equals(exp.getExperimentName())))
			return false;

		if (!(experimentRuns.equals(exp.getExperimentRuns())))
			return false;

		if (!(sensors.equals(exp.getSensors())))
			return false;

		return true;
	}

	public String getFileName() {
		return FileDAOFactory.EXP_FILE_NAME_PREFIX + getExperimentID();
	}

}
