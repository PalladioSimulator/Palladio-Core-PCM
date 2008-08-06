package de.uka.ipd.sdq.sensorframework.entities.dao;


public interface ISensorDAO {

	de.uka.ipd.sdq.sensorframework.entities.StateSensor addStateSensor(

	de.uka.ipd.sdq.sensorframework.entities.State p_initialstate

	,

	String p_sensorname);

	de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor addTimeSpanSensor(

	String p_sensorname);
	
	de.uka.ipd.sdq.sensorframework.entities.ScalabilitySensor addScalabilitySensor(

			String p_sensorname);

	/* Finder methods to search for Sensors */

	java.util.Collection<de.uka.ipd.sdq.sensorframework.entities.Sensor> findBySensorName(
			String searchKey);;

	de.uka.ipd.sdq.sensorframework.entities.Sensor get(long id);

	java.util.Collection<de.uka.ipd.sdq.sensorframework.entities.Sensor> getSensors();
	
	void removeSensor(de.uka.ipd.sdq.sensorframework.entities.Sensor sensor, boolean doCascade);

	void storeAll();
}
