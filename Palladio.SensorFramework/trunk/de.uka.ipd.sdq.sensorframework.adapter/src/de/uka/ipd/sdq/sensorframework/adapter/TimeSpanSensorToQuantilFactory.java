package de.uka.ipd.sdq.sensorframework.adapter;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.TimeSeries;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor;

public class TimeSpanSensorToQuantilFactory implements IAdapterFactory {

	public boolean canAdapt(Object adaptee, Class<?> targetClass) {
		if (adaptee instanceof SensorAndMeasurements){
			SensorAndMeasurements sam = (SensorAndMeasurements) adaptee;
			if (sam.getSensor() instanceof TimeSpanSensor && TimeSeries.class == targetClass)
				return true;
		}
		return false;
	}

	public DataAdapter getAdapter(Object adaptee) {
		return new TimeSpanToQuantilAdapter((SensorAndMeasurements) adaptee);
	}

	public String getMetricLabel() {
		return "Quantil";
	}

	public String getAdapterFactoryID() {
		return "TimeSpanSensorToQuantilFactory";
	}
	
	public boolean createsAdaptersFor(Class<?> targetClass) {
		return targetClass.isAssignableFrom(TimeSeries.class);
	}
}
