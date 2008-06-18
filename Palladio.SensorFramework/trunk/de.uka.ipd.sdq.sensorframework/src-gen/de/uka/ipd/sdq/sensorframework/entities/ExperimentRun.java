package de.uka.ipd.sdq.sensorframework.entities;

public interface ExperimentRun

{
	/* Getter and Setter for Properties with cardinality 0..1 or 1 which are not a composition */

	String getExperimentDateTime();

	void setExperimentDateTime(String value);;

	long getExperimentRunID();

	void setExperimentRunID(long value);

	/* Getter and Setter for Properties with cardinality 0..1 or 1 which are a composition */

	/* Getter and Setter for Properties with cardinality 0..* which are not a composition */

	/* Getter and Setter for Properties with cardinality 0..* which are a composition */

	de.uka.ipd.sdq.sensorframework.entities.StateMeasurement addStateMeasurement(

	de.uka.ipd.sdq.sensorframework.entities.StateSensor p_sensor,

	de.uka.ipd.sdq.sensorframework.entities.State p_sensorstate

	,

	double p_eventtime);
	
	de.uka.ipd.sdq.sensorframework.entities.ScalabilityMeasurement addScalabilityMeasurement(

			de.uka.ipd.sdq.sensorframework.entities.ScalabilitySensor p_sensor,

			Double[] p_parameters,
			double p_result

			);

	de.uka.ipd.sdq.sensorframework.entities.TimeSpanMeasurement addTimeSpanMeasurement(

	de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor p_sensor

	,

	double p_eventtime,

	double p_timespan);

	void addMeasurement(de.uka.ipd.sdq.sensorframework.entities.Measurement value);

	java.util.Collection<de.uka.ipd.sdq.sensorframework.entities.Measurement> getMeasurements();

	/* Abstract Operations */

	de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements

	getMeasurementsOfSensor(

	de.uka.ipd.sdq.sensorframework.entities.Sensor sensor

	);

}
