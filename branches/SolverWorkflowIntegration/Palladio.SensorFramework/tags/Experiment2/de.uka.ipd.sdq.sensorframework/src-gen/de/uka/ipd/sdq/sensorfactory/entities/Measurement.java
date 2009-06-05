package de.uka.ipd.sdq.sensorfactory.entities;

public interface Measurement

{
	/* Getter and Setter for Properties with cardinality 0..1 or 1 which are not a composition */

	long getMeasurementID();

	void setMeasurementID(long value);;

	double getEventTime();

	void setEventTime(double value);

	/* Getter and Setter for Properties with cardinality 0..1 or 1 which are a composition */

	/* Getter and Setter for Properties with cardinality 0..* which are not a composition */

	/* Getter and Setter for Properties with cardinality 0..* which are a composition */

	/* Abstract Operations */

}
