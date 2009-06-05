package de.uka.ipd.sdq.sensorframework.entities;

public interface Experiment

{
	/* Getter and Setter for Properties with cardinality 0..1 or 1 which are not a composition */

	long getExperimentID();

	void setExperimentID(long value);;

	String getExperimentName();

	void setExperimentName(String value);

	/* Getter and Setter for Properties with cardinality 0..1 or 1 which are a composition */

	/* Getter and Setter for Properties with cardinality 0..* which are not a composition */

	/* Getter and Setter for Properties with cardinality 0..* which are a composition */

	de.uka.ipd.sdq.sensorframework.entities.StateSensor addStateSensor(

	de.uka.ipd.sdq.sensorframework.entities.State p_initialstate

	,

	String p_sensorname);

	de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor addTimeSpanSensor(

	String p_sensorname);
	
	de.uka.ipd.sdq.sensorframework.entities.ScalabilitySensor addScalabilitySensor(

			String p_sensorname);

	void addSensor(de.uka.ipd.sdq.sensorframework.entities.Sensor value);

	java.util.Collection<de.uka.ipd.sdq.sensorframework.entities.Sensor> getSensors();;

	de.uka.ipd.sdq.sensorframework.entities.ExperimentRun addExperimentRun(

	String p_experimentdatetime);
	
	de.uka.ipd.sdq.sensorframework.entities.ExperimentRun addScalabilityExperimentRun(

			String p_experimentdatetime);

	void addExperimentRun(
			de.uka.ipd.sdq.sensorframework.entities.ExperimentRun experimentRun);

	java.util.Collection<de.uka.ipd.sdq.sensorframework.entities.ExperimentRun> getExperimentRuns();

	/* Abstract Operations */

}
