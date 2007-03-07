package de.uka.ipd.sdq.probfunction.math;

import de.uka.ipd.sdq.probfunction.math.exception.ConfigurationNotSetException;

public class PDFConfiguration {

	private static PDFConfiguration currentConfiguration = null;

	private int numSamplingPoints;
	
	private double distance;
	
	private IUnit unit;
	
	private static Object lock = new Object();
	
	private PDFConfiguration(int numSamplingPoints, double distance, IUnit unit) {
		super();
		this.numSamplingPoints = numSamplingPoints;
		this.distance = distance;
		this.unit = unit;
	}

	public double getDistance() {
		return distance;
	}

	public int getNumSamplingPoints() {
		return numSamplingPoints;
	}

	public IUnit getUnit() {
		return unit;
	}
	
	public static PDFConfiguration getCurrentConfiguration() throws ConfigurationNotSetException{
		synchronized (lock) {
			if (currentConfiguration == null)
				throw new ConfigurationNotSetException();
			return currentConfiguration;
		}
	}
	
	public static void setCurrentConfiguration(int numSamplingPoints, double distance, IUnit unit){
		synchronized (lock) {
			currentConfiguration = new PDFConfiguration(numSamplingPoints,distance,unit);
		}
	}
}
