package de.uka.ipd.sdq.capra.simulator.expressions;

import java.util.Hashtable;

import de.uka.ipd.sdq.capra.simulator.measurement.sensors.SimSensorInstance;

public interface SimCapraExpression extends Cloneable {
		
	SimCapraExpression clone();

	void useSensorInstances(Hashtable<String,SimSensorInstance> sensorInstanceTable);

	SimCapraExpression getNext();

	boolean isAction();

	void reset();

}
