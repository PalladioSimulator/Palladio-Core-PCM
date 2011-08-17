package de.uka.ipd.sdq.sensorfactory.entities;

public interface StateMeasurement

extends de.uka.ipd.sdq.sensorfactory.entities.Measurement

{
	/* Getter and Setter for Properties with cardinality 0..1 or 1 which are not a composition */

	de.uka.ipd.sdq.sensorfactory.entities.State getSensorState();

	void setSensorState(de.uka.ipd.sdq.sensorfactory.entities.State value);;

	de.uka.ipd.sdq.sensorfactory.entities.StateSensor getSensor();

	void setSensor(de.uka.ipd.sdq.sensorfactory.entities.StateSensor value);

	/* Getter and Setter for Properties with cardinality 0..1 or 1 which are a composition */

	/* Getter and Setter for Properties with cardinality 0..* which are not a composition */

	/* Getter and Setter for Properties with cardinality 0..* which are a composition */

	/* Abstract Operations */

}
