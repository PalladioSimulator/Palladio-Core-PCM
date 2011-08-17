package de.uka.ipd.sdq.sensorframework.adapter;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.FrequencyFailurePie;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.entities.StateSensor;

public class StateSensorToFrequencyFailurePieFactory implements IAdapterFactory {

	public boolean canAdapt(Object adaptee, Class<?> targetClass) {
		if (adaptee instanceof SensorAndMeasurements) {
			SensorAndMeasurements sam = (SensorAndMeasurements) adaptee;
			if (sam.getSensor() instanceof StateSensor) {
				if (FrequencyFailurePie.class == targetClass) {
					return true;
				}
			}
		}
		return false;
	}

	public DataAdapter getAdapter(Object adaptee) {
		return new StateSensorToFrequencyFailurePieAdapter(
				(SensorAndMeasurements) adaptee);
	}

	public String getMetricLabel() {
		return "Execution Result (failures only)";
	}

	public String getAdapterFactoryID() {
		return "StateSensorToFrequencyFailurePieFactory";
	}

	public boolean createsAdaptersFor(Class<?> targetClass) {
		return targetClass.isAssignableFrom(FrequencyFailurePie.class);
	}

}
