package de.uka.ipd.sdq.sensorframework.entities.dao;

public interface IMeasurementDAO {

	de.uka.ipd.sdq.sensorframework.entities.StateMeasurement addStateMeasurement(

	de.uka.ipd.sdq.sensorframework.entities.StateSensor p_sensor,

	de.uka.ipd.sdq.sensorframework.entities.State p_sensorstate

	,

	double p_eventtime);

	de.uka.ipd.sdq.sensorframework.entities.TimeSpanMeasurement addTimeSpanMeasurement(

	de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor p_sensor

	,

	double p_eventtime,

	double p_timespan);

	/* Finder methods to search for Measurements */
	;

	de.uka.ipd.sdq.sensorframework.entities.Measurement get(long id);

	java.util.Collection<de.uka.ipd.sdq.sensorframework.entities.Measurement> getMeasurements();
	
	void removeMeasurement(de.uka.ipd.sdq.sensorframework.entities.Measurement measurement, boolean doCascade);
}
