package de.uka.ipd.sdq.sensorfactory.entities;

public interface Sensor

{
	/* Getter and Setter for Properties with cardinality 0..1 or 1 which are not a composition */

	String getSensorName();

	void setSensorName(String value);;

	long getSensorID();

	void setSensorID(long value);

	/* Getter and Setter for Properties with cardinality 0..1 or 1 which are a composition */

	/* Getter and Setter for Properties with cardinality 0..* which are not a composition */

	/* Getter and Setter for Properties with cardinality 0..* which are a composition */

	/* Abstract Operations */

}
