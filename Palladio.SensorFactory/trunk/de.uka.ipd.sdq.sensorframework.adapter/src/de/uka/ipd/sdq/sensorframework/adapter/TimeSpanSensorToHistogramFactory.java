package de.uka.ipd.sdq.sensorframework.adapter;

import java.util.Collection;

import de.uka.ipd.sdq.sensorfactory.entities.TimeSpanMeasurement;
import de.uka.ipd.sdq.sensorfactory.entities.impl.SensorAndMeasurements;

public class TimeSpanSensorToHistogramFactory implements IAdapterFactory {

	@Override
	public boolean canAdapt(Object adaptee, Class targetClass) {
		if (adaptee instanceof SensorAndMeasurements){
			SensorAndMeasurements sam = (SensorAndMeasurements) adaptee;
			Object[] values = sam.getMeasurements().toArray(); 
			if (values.length > 0 && values[0] instanceof TimeSpanMeasurement)
				return true;
		}
		return false;
	}
	
	@Override
	public IAdapter getAdapter(Object adaptee) {
		return new TimeSpanToHistogramAdapter((SensorAndMeasurements) adaptee);
	}

}
