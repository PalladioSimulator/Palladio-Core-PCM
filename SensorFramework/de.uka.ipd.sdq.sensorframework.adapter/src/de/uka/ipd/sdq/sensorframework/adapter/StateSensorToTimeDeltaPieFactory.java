package de.uka.ipd.sdq.sensorframework.adapter;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.AbstractPie;
import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.TimeDeltaPie;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.entities.StateSensor;

public class StateSensorToTimeDeltaPieFactory implements IAdapterFactory {

	public boolean canAdapt(Object adaptee, Class<?> targetClass) {
		if (adaptee instanceof SensorAndMeasurements) {
			SensorAndMeasurements sam = (SensorAndMeasurements) adaptee;
			if (sam.getSensor() instanceof StateSensor) {
				if (TimeDeltaPie.class == targetClass) {
					return true;
				}
			}
		}
		return false;
	}

	public DataAdapter getAdapter(Object adaptee) {
		return new StateSensorToTimeDeltaPieAdapter(
				(SensorAndMeasurements) adaptee);
	}

	public String getMetricLabel() {
		return "Utilisation";
	}

	public String getAdapterFactoryID() {
		return "StateSensorToTimeDeltaPieFactory";
	}

	public boolean createsAdaptersFor(Class<?> targetClass) {
		return targetClass.isAssignableFrom(TimeDeltaPie.class);
	}

}
