package de.uka.ipd.sdq.sensorframework.adapter;


import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.Pie;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.entities.StateSensor;

public class StateSensorToPieFactory implements IAdapterFactory {

	public boolean canAdapt(Object adaptee, Class<?> targetClass) {
		if (adaptee instanceof SensorAndMeasurements){
			SensorAndMeasurements sam = (SensorAndMeasurements) adaptee;
			if (sam.getSensor() instanceof StateSensor && Pie.class == targetClass)
				return true;
		}
		return false;
	}
	
	public DataAdapter getAdapter(Object adaptee) {
		return new StateSensorToPieAdapter((SensorAndMeasurements) adaptee);
	}

	public String getMetricLabel() {
		return "Utilisation";
	}

	public String getAdapterFactoryID() {
		return "StateSensorToPieFactory";
	}

	public boolean createsAdaptersFor(Class<?> targetClass) {
		return targetClass.isAssignableFrom(Pie.class);
	}

}
