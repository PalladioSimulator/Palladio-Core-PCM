package de.uka.ipd.sdq.sensorframework.adapter;

import java.util.Collection;

import de.uka.ipd.sdq.sensorfactory.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorfactory.entities.StateMeasurement;
import de.uka.ipd.sdq.sensorfactory.entities.TimeSpanMeasurement;

public class StateSensorToPieFactory implements IAdapterFactory {

	public boolean canAdapt(Object adaptee, Class targetClass) {
		if (adaptee instanceof SensorAndMeasurements){
			SensorAndMeasurements sam = (SensorAndMeasurements) adaptee;
			Object[] values = sam.getMeasurements().toArray(); 
			if (values.length > 0 && values[0] instanceof StateMeasurement)
				return true;
		}
		return false;
	}
	
	public IAdapter getAdapter(Object adaptee) {
		return new StateToPieAdapter((SensorAndMeasurements) adaptee);
	}

}
