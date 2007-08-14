package de.uka.ipd.sdq.sensorframework.entities;

public interface State

{
	/* Getter and Setter for Properties with cardinality 0..1 or 1 which are not a composition */

	long getStateID();

	void setStateID(long value);;

	String getStateLiteral();

	void setStateLiteral(String value);

	/* Getter and Setter for Properties with cardinality 0..1 or 1 which are a composition */

	/* Getter and Setter for Properties with cardinality 0..* which are not a composition */

	/* Getter and Setter for Properties with cardinality 0..* which are a composition */

	/* Abstract Operations */

}
