package de.uka.ipd.sdq.sensorframework.adapter;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.Histogram;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor;

public class TimeSpanSensorToHistogramFactory implements IAdapterFactory {

	public boolean canAdapt(Object adaptee, Class<?> targetClass) {
		if (adaptee instanceof SensorAndMeasurements){
			SensorAndMeasurements sam = (SensorAndMeasurements) adaptee;
			if (sam.getSensor() instanceof TimeSpanSensor && Histogram.class == targetClass)
				return true;
		}
		return false;
	}
	
	public DataAdapter getAdapter(Object adaptee) {
		return new TimeSpanToHistogramAdapter((SensorAndMeasurements) adaptee);
	}

	public String getMetricLabel() {
		return "Response Time";
	}

	public String getAdapterFactoryID() {
		return "TimeSpanToHistogramFactory";
	}
	
	public boolean createsAdaptersFor(Class<?> targetClass) {
		return targetClass.isAssignableFrom(Histogram.class);
	}	
}
