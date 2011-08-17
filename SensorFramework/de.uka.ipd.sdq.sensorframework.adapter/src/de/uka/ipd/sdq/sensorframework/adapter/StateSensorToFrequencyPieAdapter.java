package de.uka.ipd.sdq.sensorframework.adapter;

import java.util.HashMap;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.FrequencyPie;
import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.AbstractPie;
import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.entities.State;
import de.uka.ipd.sdq.sensorframework.entities.StateMeasurement;
import de.uka.ipd.sdq.sensorframework.entities.StateSensor;

/**
 * This adapter provides a frequency-based calculation of the individual pie
 * fractions.
 * 
 * Used for execution result visualization (reliability-related).
 * 
 * @author brosch
 * 
 */
public class StateSensorToFrequencyPieAdapter extends StateSensorToPieAdapter {

	/**
	 * Initializes the adapter with the given StateSensor measurements.
	 * 
	 * @param samInformation
	 *            Information about the StateSensor and the measurements
	 */
	public StateSensorToFrequencyPieAdapter(
			final SensorAndMeasurements samInformation) {
		super(samInformation);
	}

	/*
	 * (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorframework.adapter.StateSensorToPieAdapter#calculateFractions(java.util.HashMap)
	 */
	protected double calculateFractions(final HashMap<String, Double> fractions) {
		for (State state : ((StateSensor) samInformation.getSensor())
				.getSensorStates()) {
			fractions.put(state.getStateLiteral(), 0.0);
		}
		for (Measurement m : samInformation.getMeasurements()) {
			StateMeasurement sm = (StateMeasurement) m;
			double oldValue = fractions.get(sm.getSensorState().getStateLiteral());
			double newValue = oldValue + 1.0;
			fractions.put(sm.getSensorState().getStateLiteral(), newValue);
		}
		return samInformation.getMeasurements().size();
	}

	/*
	 * (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorframework.adapter.StateSensorToPieAdapter#instantiatePie(java.lang.String)
	 */
	protected AbstractPie instantiatePie(String sensorName) {
		return new FrequencyPie(sensorName);
	}
}
