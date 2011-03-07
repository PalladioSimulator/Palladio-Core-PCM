package de.uka.ipd.sdq.simuservice.types;

import java.util.HashMap;

/**
 * Stores aggregated results from a simulation sensor.
 * 
 * @author brosch
 * 
 */
public class SimulationResult {

	private String sensorName = null;
	private HashMap<Double, Double> percentiles = new HashMap<Double, Double>();
	private boolean frozen = false;

	public String getSensorName() {
		return sensorName;
	}

	public void setSensorName(String sensorName) {
		if (!frozen) {
			this.sensorName = sensorName;
		}
	}

	public HashMap<Double, Double> getPercentiles() {
		return percentiles;
	}

	public void setPercentiles(HashMap<Double, Double> percentiles) {
		if (!frozen) {
			this.percentiles = percentiles;
		}
	}

	public void freeze() {
		frozen = true;
	}
}
