package de.uka.ipd.sdq.sensorframework.adapter;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.FrequencyPie;
import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.AbstractPie;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.entities.StateSensor;

public class StateSensorToFrequencyPieFactory implements IAdapterFactory {

	public boolean canAdapt(Object adaptee, Class<?> targetClass) {
		if (adaptee instanceof SensorAndMeasurements) {
			SensorAndMeasurements sam = (SensorAndMeasurements) adaptee;
			if (sam.getSensor() instanceof StateSensor) {
				if (FrequencyPie.class == targetClass) {
					return true;
				}
			}
		}
		return false;
	}

	public DataAdapter getAdapter(Object adaptee) {
		return new StateSensorToFrequencyPieAdapter(
				(SensorAndMeasurements) adaptee);
	}

	public String getMetricLabel() {
		return "Execution Result";
	}

	public String getAdapterFactoryID() {
		return "StateSensorToFrequencyPieFactory";
	}

	public boolean createsAdaptersFor(Class<?> targetClass) {
		return targetClass.isAssignableFrom(FrequencyPie.class);
	}

}
