package de.uka.ipd.sdq.sensorframework.entities.base;

@javax.persistence.Entity
@javax.persistence.Table(name = "EXPERIMENTRUN")
public abstract class AbstractExperimentRun

implements de.uka.ipd.sdq.sensorframework.entities.ExperimentRun

{

	protected transient de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory myDAOFactory = null;

	public AbstractExperimentRun(
			de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory myFactory) {
		this.myDAOFactory = myFactory;
	}

	/*
	 * Getter and Setter for Properties with cardinality 0..1 or 1 which are not
	 * a composition
	 */

	@javax.persistence.Column(name = "EXPERIMENTDATETIME")
	private String m_experimentDateTime;

	public String getExperimentDateTime() {
		return m_experimentDateTime;
	}

	public void setExperimentDateTime(String value) {
		this.m_experimentDateTime = value;
	};

	@javax.persistence.Id
	@javax.persistence.Column(name = "EXPERIMENTRUNID")
	@javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	private long m_experimentRunID;

	public long getExperimentRunID() {
		return m_experimentRunID;
	}

	public void setExperimentRunID(long value) {
		this.m_experimentRunID = value;
	}

	/*
	 * Getter and Setter for Properties with cardinality 0..1 or 1 which are a
	 * composition
	 */

	/*
	 * Getter and Setter for Properties with cardinality 0..* which are not a
	 * composition
	 */

	/*
	 * Getter and Setter for Properties with cardinality 0..* which are a
	 * composition
	 */

	@javax.persistence.OneToMany(cascade = javax.persistence.CascadeType.ALL)
	@javax.persistence.JoinTable(name = "ExperimentRun_measurements", joinColumns = { @javax.persistence.JoinColumn(name = "EXPERIMENTRUN_ID") }, inverseJoinColumns = { @javax.persistence.JoinColumn(name = "MEASUREMENT_ID") })
	private java.util.Collection<de.uka.ipd.sdq.sensorframework.entities.Measurement> m_measurements = new java.util.ArrayList<de.uka.ipd.sdq.sensorframework.entities.Measurement>();

	public de.uka.ipd.sdq.sensorframework.entities.StateMeasurement addStateMeasurement(

	de.uka.ipd.sdq.sensorframework.entities.StateSensor p_sensor,

	de.uka.ipd.sdq.sensorframework.entities.State p_sensorstate

	,

	double p_eventtime) {

		de.uka.ipd.sdq.sensorframework.entities.StateMeasurement result = myDAOFactory
				.createMeasurementDAO().addStateMeasurement(

				p_sensor, p_sensorstate

				,

				p_eventtime);

		m_measurements.add(result);
		return result;
	}

	public de.uka.ipd.sdq.sensorframework.entities.TimeSpanMeasurement addTimeSpanMeasurement(

	de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor p_sensor

	,

	double p_eventtime,

	double p_timespan) {

		de.uka.ipd.sdq.sensorframework.entities.TimeSpanMeasurement result = myDAOFactory
				.createMeasurementDAO().addTimeSpanMeasurement(

				p_sensor

				,

				p_eventtime, p_timespan);

		m_measurements.add(result);
		return result;
	}
	
	public de.uka.ipd.sdq.sensorframework.entities.ScalabilityMeasurement addScalabilityMeasurement(

			de.uka.ipd.sdq.sensorframework.entities.ScalabilitySensor p_sensor

			,
			Double[] p_parameters,
			
			double p_result

			) {

				de.uka.ipd.sdq.sensorframework.entities.ScalabilityMeasurement result = myDAOFactory
						.createMeasurementDAO().addScalabilityMeasurement(

						p_sensor

						,

						p_parameters, p_result);

				m_measurements.add(result);
				return result;
			}

	public void addMeasurement(
			de.uka.ipd.sdq.sensorframework.entities.Measurement value) {
		this.m_measurements.add(value);
	}

	public java.util.Collection<de.uka.ipd.sdq.sensorframework.entities.Measurement> getMeasurements() {
		return this.m_measurements;
	}

	/* Abstract Operations */

	public abstract de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements

	getMeasurementsOfSensor(

	de.uka.ipd.sdq.sensorframework.entities.Sensor sensor

	);

}
