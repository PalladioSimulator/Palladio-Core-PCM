package de.uka.ipd.sdq.sensorframework.entities;

public interface StateMeasurement

extends de.uka.ipd.sdq.sensorframework.entities.Measurement

{
	/* Getter and Setter for Properties with cardinality 0..1 or 1 which are not a composition */

	de.uka.ipd.sdq.sensorframework.entities.State getSensorState();

	void setSensorState(de.uka.ipd.sdq.sensorframework.entities.State value);;

	de.uka.ipd.sdq.sensorframework.entities.StateSensor getSensor();

	void setSensor(de.uka.ipd.sdq.sensorframework.entities.StateSensor value);

	/* Getter and Setter for Properties with cardinality 0..1 or 1 which are a composition */

	/* Getter and Setter for Properties with cardinality 0..* which are not a composition */

	/* Getter and Setter for Properties with cardinality 0..* which are a composition */

	/* Abstract Operations */

}
