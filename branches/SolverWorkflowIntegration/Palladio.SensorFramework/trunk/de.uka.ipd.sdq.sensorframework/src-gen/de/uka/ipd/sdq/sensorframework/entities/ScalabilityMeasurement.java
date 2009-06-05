package de.uka.ipd.sdq.sensorframework.entities;

public interface ScalabilityMeasurement

extends de.uka.ipd.sdq.sensorframework.entities.Measurement {
	/* Getter and Setter for Properties with cardinality 0..1 or 1 which are not a composition */

	Double[] getParameters();
	
	//String[] getParameterNames();

	void setParameters(Double[] value);
	
	//void setParameterNames(String[] value);

	de.uka.ipd.sdq.sensorframework.entities.ScalabilitySensor getSensor();

	void setSensor(de.uka.ipd.sdq.sensorframework.entities.ScalabilitySensor value);

	/* Getter and Setter for Properties with cardinality 0..1 or 1 which are a composition */

	/* Getter and Setter for Properties with cardinality 0..* which are not a composition */

	/* Getter and Setter for Properties with cardinality 0..* which are a composition */

	/* Abstract Operations */

}
