package de.uka.ipd.sdq.sensorframework.entities.base;

@javax.persistence.Entity
@javax.persistence.Table(name = "EXPERIMENT")
public abstract class AbstractExperiment

implements de.uka.ipd.sdq.sensorframework.entities.Experiment

{

	protected transient de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory myDAOFactory = null;

	public AbstractExperiment(
			de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory myFactory) {
		this.myDAOFactory = myFactory;
	}

	/* Getter and Setter for Properties with cardinality 0..1 or 1 which are not a composition */

	@javax.persistence.Id
	@javax.persistence.Column(name = "EXPERIMENTID")
	@javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	private long m_experimentID;

	public long getExperimentID() {
		return m_experimentID;
	}

	public void setExperimentID(long value) {
		this.m_experimentID = value;
	};

	@javax.persistence.Column(name = "EXPERIMENTNAME")
	private String m_experimentName;

	public String getExperimentName() {
		return m_experimentName;
	}

	public void setExperimentName(String value) {
		this.m_experimentName = value;
	}

	/* Getter and Setter for Properties with cardinality 0..1 or 1 which are a composition */

	/* Getter and Setter for Properties with cardinality 0..* which are not a composition */

	/* Getter and Setter for Properties with cardinality 0..* which are a composition */

	@javax.persistence.OneToMany(cascade = javax.persistence.CascadeType.ALL)
	@javax.persistence.JoinTable(name = "Experiment_sensors", joinColumns = { @javax.persistence.JoinColumn(name = "EXPERIMENT_ID") }, inverseJoinColumns = { @javax.persistence.JoinColumn(name = "SENSOR_ID") })
	private java.util.Collection<de.uka.ipd.sdq.sensorframework.entities.Sensor> m_sensors = new java.util.ArrayList<de.uka.ipd.sdq.sensorframework.entities.Sensor>();

	public de.uka.ipd.sdq.sensorframework.entities.StateSensor addStateSensor(

	de.uka.ipd.sdq.sensorframework.entities.State p_initialstate

	,

	String p_sensorname) {

		de.uka.ipd.sdq.sensorframework.entities.StateSensor result = myDAOFactory
				.createSensorDAO().addStateSensor(

				p_initialstate

				,

				p_sensorname);

		m_sensors.add(result);
		return result;
	}

	public de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor addTimeSpanSensor(

	String p_sensorname) {

		de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor result = myDAOFactory
				.createSensorDAO().addTimeSpanSensor(

				p_sensorname);

		m_sensors.add(result);
		return result;
	}
	
	public de.uka.ipd.sdq.sensorframework.entities.ScalabilitySensor addScalabilitySensor(

			String p_sensorname) {

				de.uka.ipd.sdq.sensorframework.entities.ScalabilitySensor result = myDAOFactory
						.createSensorDAO().addScalabilitySensor(

						p_sensorname);

				m_sensors.add(result);
				return result;
			}

	public void addSensor(de.uka.ipd.sdq.sensorframework.entities.Sensor value) {
		this.m_sensors.add(value);
	}

	public java.util.Collection<de.uka.ipd.sdq.sensorframework.entities.Sensor> getSensors() {
		return this.m_sensors;
	};

	@javax.persistence.OneToMany(cascade = javax.persistence.CascadeType.ALL)
	@javax.persistence.JoinTable(name = "Experiment_experimentRuns", joinColumns = { @javax.persistence.JoinColumn(name = "EXPERIMENT_ID") }, inverseJoinColumns = { @javax.persistence.JoinColumn(name = "EXPERIMENTRUN_ID") })
	private java.util.Collection<de.uka.ipd.sdq.sensorframework.entities.ExperimentRun> m_experimentRuns = new java.util.ArrayList<de.uka.ipd.sdq.sensorframework.entities.ExperimentRun>();

	public de.uka.ipd.sdq.sensorframework.entities.ExperimentRun addExperimentRun(

	String p_experimentdatetime) {

		de.uka.ipd.sdq.sensorframework.entities.ExperimentRun result = myDAOFactory
				.createExperimentRunDAO().addExperimentRun(

				p_experimentdatetime);

		m_experimentRuns.add(result);
		return result;
	}
	
	public de.uka.ipd.sdq.sensorframework.entities.ExperimentRun addScalabilityExperimentRun(

			String p_experimentdatetime) {

				de.uka.ipd.sdq.sensorframework.entities.ExperimentRun result = myDAOFactory
						.createExperimentRunDAO().addScalabilityExperimentRun(

						p_experimentdatetime);

				m_experimentRuns.add(result);
				return result;
			}

	public void addExperimentRun(
			de.uka.ipd.sdq.sensorframework.entities.ExperimentRun value) {
		this.m_experimentRuns.add(value);
	}

	public java.util.Collection<de.uka.ipd.sdq.sensorframework.entities.ExperimentRun> getExperimentRuns() {
		return this.m_experimentRuns;
	}

	/* Abstract Operations */

}
