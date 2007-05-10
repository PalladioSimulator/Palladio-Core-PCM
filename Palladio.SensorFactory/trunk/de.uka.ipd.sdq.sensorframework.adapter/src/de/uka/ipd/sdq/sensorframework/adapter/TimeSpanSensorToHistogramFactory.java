package de.uka.ipd.sdq.sensorframework.adapter;

import java.util.Collection;

import de.uka.ipd.sdq.sensorfactory.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorfactory.entities.TimeSpanMeasurement;

public class TimeSpanSensorToHistogramFactory implements IAdapterFactory {

	public boolean canAdapt(Object adaptee, Class targetClass) {
		if (adaptee instanceof SensorAndMeasurements){
			SensorAndMeasurements sam = (SensorAndMeasurements) adaptee;
			Object[] values = sam.getMeasurements().toArray(); 
			if (values.length > 0 && values[0] instanceof TimeSpanMeasurement)
				return true;
		}
		return false;
	}
	
	public IAdapter getAdapter(Object adaptee) {
		return new TimeSpanToHistogramAdapter((SensorAndMeasurements) adaptee);
	}

}
