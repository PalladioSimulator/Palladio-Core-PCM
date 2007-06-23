package de.uka.ipd.sdq.sensorfactory.entities;

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

	de.uka.ipd.sdq.sensorfactory.entities.StateMeasurement addStateMeasurement(

	de.uka.ipd.sdq.sensorfactory.entities.StateSensor p_sensor,

	de.uka.ipd.sdq.sensorfactory.entities.State p_sensorstate

	,

	double p_eventtime);

	de.uka.ipd.sdq.sensorfactory.entities.TimeSpanMeasurement addTimeSpanMeasurement(

	de.uka.ipd.sdq.sensorfactory.entities.TimeSpanSensor p_sensor

	,

	double p_eventtime,

	double p_timespan);

	void addMeasurement(de.uka.ipd.sdq.sensorfactory.entities.Measurement value);

	java.util.Collection<de.uka.ipd.sdq.sensorfactory.entities.Measurement> getMeasurements();

	/* Abstract Operations */

	de.uka.ipd.sdq.sensorfactory.entities.SensorAndMeasurements

	getMeasurementsOfSensor(

	de.uka.ipd.sdq.sensorfactory.entities.Sensor sensor

	);

}
