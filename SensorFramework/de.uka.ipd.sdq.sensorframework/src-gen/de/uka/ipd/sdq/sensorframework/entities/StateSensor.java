package de.uka.ipd.sdq.sensorframework.entities;

public interface StateSensor

extends de.uka.ipd.sdq.sensorframework.entities.Sensor

{
	/* Getter and Setter for Properties with cardinality 0..1 or 1 which are not a composition */

	de.uka.ipd.sdq.sensorframework.entities.State getInitialState();

	void setInitialState(de.uka.ipd.sdq.sensorframework.entities.State value);

	/* Getter and Setter for Properties with cardinality 0..1 or 1 which are a composition */

	/* Getter and Setter for Properties with cardinality 0..* which are not a composition */

	/* Getter and Setter for Properties with cardinality 0..* which are a composition */

	de.uka.ipd.sdq.sensorframework.entities.State addState(

	String p_stateliteral);

	void addSensorState(de.uka.ipd.sdq.sensorframework.entities.State value);

	java.util.Collection<de.uka.ipd.sdq.sensorframework.entities.State> getSensorStates();

	/* Abstract Operations */

}
