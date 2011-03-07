package de.uka.ipd.sdq.sensorframework.util;

import java.util.Comparator;

import de.uka.ipd.sdq.sensorframework.entities.Sensor;

public class CompareSensorsByName implements Comparator<Sensor> {
	
	boolean firstLetterToUppercase = false;
	
	public CompareSensorsByName() {
		super();
	}

	public CompareSensorsByName(boolean firstLetterToUppercase) {
		super();
		this.firstLetterToUppercase = firstLetterToUppercase;
	}

	@Override
	public int compare(Sensor sensor1, Sensor sensor2) {
		
		if (sensor1 == sensor2 ){
			return 0;
		}
		
		String name1 = sensor1.getSensorName();
		String name2 = sensor2.getSensorName();
		
		if (firstLetterToUppercase){
			name1 = firstLetterToUppercase(name1);
			name2 = firstLetterToUppercase(name2);
		}
		
		return name1.compareTo(name2);
	}

	private String firstLetterToUppercase(String string) {
		return string.substring(0,1).toUpperCase()+string.substring(1);
	}

}
