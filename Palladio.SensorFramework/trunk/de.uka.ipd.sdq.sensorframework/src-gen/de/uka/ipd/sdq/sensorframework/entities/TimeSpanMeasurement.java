package de.uka.ipd.sdq.sensorframework.entities;

public interface TimeSpanMeasurement

extends de.uka.ipd.sdq.sensorframework.entities.Measurement

{
	/* Getter and Setter for Properties with cardinality 0..1 or 1 which are not a composition */

	double getTimeSpan();

	void setTimeSpan(double value);;

	de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor getSensor();

	void setSensor(de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor value);

	/* Getter and Setter for Properties with cardinality 0..1 or 1 which are a composition */

	/* Getter and Setter for Properties with cardinality 0..* which are not a composition */

	/* Getter and Setter for Properties with cardinality 0..* which are a composition */

	/* Abstract Operations */

}
