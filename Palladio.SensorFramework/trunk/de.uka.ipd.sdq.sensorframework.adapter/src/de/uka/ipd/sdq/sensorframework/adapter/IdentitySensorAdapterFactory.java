package de.uka.ipd.sdq.sensorframework.adapter;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.Histogram;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor;

public class IdentitySensorAdapterFactory implements IAdapterFactory {

	public boolean canAdapt(Object adaptee, Class targetClass) {
		if (adaptee instanceof SensorAndMeasurements){
			SensorAndMeasurements sam = (SensorAndMeasurements) adaptee;
			if (targetClass.isInstance(sam.getSensor()))
				return true;
		}
		return false;
	}
	
	public IAdapter getAdapter(Object adaptee) {
		return new IdentitySensorAdapter(adaptee);
	}

	public String getMetricLabel() {
		return "";
	}

	public String getAdapterFactoryID() {
		return "IdentityAdapterFactory";
	}

	public boolean createsAdaptersFor(Class<?> targetClass) {
		return true;
	}

}
