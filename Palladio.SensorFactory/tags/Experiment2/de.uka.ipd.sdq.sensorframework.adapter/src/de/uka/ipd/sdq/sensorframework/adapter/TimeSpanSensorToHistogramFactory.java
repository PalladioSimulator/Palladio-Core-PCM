package de.uka.ipd.sdq.sensorframework.adapter;

import java.util.Collection;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.Histogram;
import de.uka.ipd.sdq.sensorfactory.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorfactory.entities.StateSensor;
import de.uka.ipd.sdq.sensorfactory.entities.TimeSpanMeasurement;
import de.uka.ipd.sdq.sensorfactory.entities.TimeSpanSensor;

public class TimeSpanSensorToHistogramFactory implements IAdapterFactory {

	public boolean canAdapt(Object adaptee, Class targetClass) {
		if (adaptee instanceof SensorAndMeasurements){
			SensorAndMeasurements sam = (SensorAndMeasurements) adaptee;
			if (sam.getSensor() instanceof TimeSpanSensor && Histogram.class == targetClass)
				return true;
		}
		return false;
	}
	
	public IAdapter getAdapter(Object adaptee) {
		return new TimeSpanToHistogramAdapter((SensorAndMeasurements) adaptee);
	}

}
