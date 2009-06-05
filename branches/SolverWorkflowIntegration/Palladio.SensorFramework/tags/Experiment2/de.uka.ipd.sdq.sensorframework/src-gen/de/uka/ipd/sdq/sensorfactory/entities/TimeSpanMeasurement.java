package de.uka.ipd.sdq.sensorfactory.entities;

public interface TimeSpanMeasurement

extends de.uka.ipd.sdq.sensorfactory.entities.Measurement

{
	/* Getter and Setter for Properties with cardinality 0..1 or 1 which are not a composition */

	double getTimeSpan();

	void setTimeSpan(double value);;

	de.uka.ipd.sdq.sensorfactory.entities.TimeSpanSensor getSensor();

	void setSensor(de.uka.ipd.sdq.sensorfactory.entities.TimeSpanSensor value);

	/* Getter and Setter for Properties with cardinality 0..1 or 1 which are a composition */

	/* Getter and Setter for Properties with cardinality 0..* which are not a composition */

	/* Getter and Setter for Properties with cardinality 0..* which are a composition */

	/* Abstract Operations */

}
