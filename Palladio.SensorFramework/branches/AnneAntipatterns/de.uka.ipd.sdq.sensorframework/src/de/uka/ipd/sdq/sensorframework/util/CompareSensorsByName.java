package de.uka.ipd.sdq.sensorframework.util;

import java.util.Comparator;

import de.uka.ipd.sdq.sensorframework.entities.Sensor;

public class CompareSensorsByName implements Comparator<Sensor> {

	@Override
	public int compare(Sensor arg0, Sensor arg1) {
		
		if (arg0 == arg1 ){
			return 0;
		}
		
		return arg0.getSensorName().compareTo(arg1.getSensorName());
	}

}
