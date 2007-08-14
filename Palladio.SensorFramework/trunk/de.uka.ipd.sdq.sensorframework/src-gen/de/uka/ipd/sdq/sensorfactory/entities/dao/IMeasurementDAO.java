package de.uka.ipd.sdq.sensorfactory.entities.dao;

public interface IMeasurementDAO {

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

	/* Finder methods to search for Measurements */
	;

	de.uka.ipd.sdq.sensorfactory.entities.Measurement get(long id);

	java.util.Collection<de.uka.ipd.sdq.sensorfactory.entities.Measurement> getMeasurements();
	
	void removeMeasurement(de.uka.ipd.sdq.sensorfactory.entities.Measurement measurement, boolean doCascade);
}
