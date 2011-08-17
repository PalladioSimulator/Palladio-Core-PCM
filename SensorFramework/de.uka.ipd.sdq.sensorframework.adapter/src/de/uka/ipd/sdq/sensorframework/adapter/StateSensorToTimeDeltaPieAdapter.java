package de.uka.ipd.sdq.sensorframework.adapter;

import java.util.HashMap;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.AbstractPie;
import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.TimeDeltaPie;
import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.entities.State;
import de.uka.ipd.sdq.sensorframework.entities.StateMeasurement;
import de.uka.ipd.sdq.sensorframework.entities.StateSensor;

/**
 * This adapter provides a time-delta-based calculation of the individual pie
 * fractions.
 * 
 * Used for resource utilization visualization.
 * 
 * @author brosch
 * 
 */
public class StateSensorToTimeDeltaPieAdapter extends StateSensorToPieAdapter {

	/**
	 * Initializes the adapter with the given StateSensor measurements.
	 * 
	 * @param samInformation
	 *            Information about the StateSensor and the measurements
	 */
	public StateSensorToTimeDeltaPieAdapter(
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
		double lastChangeTime = 0.0;
		State lastState = ((StateSensor) samInformation.getSensor())
				.getInitialState();
		double sum = 0;
		for (Measurement m : samInformation.getMeasurements()) {
			StateMeasurement sm = (StateMeasurement) m;
			double oldValue = fractions.get(lastState.getStateLiteral());
			double diff = sm.getEventTime() - lastChangeTime;
			double newValue = oldValue + diff;
			sum += diff;
			fractions.put(lastState.getStateLiteral(), newValue);
			lastChangeTime = sm.getEventTime();
			lastState = sm.getSensorState();
		}
		return sum;
	}

	/*
	 * (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorframework.adapter.StateSensorToPieAdapter#instantiatePie(java.lang.String)
	 */
	protected AbstractPie instantiatePie(String sensorName) {
		return new TimeDeltaPie(sensorName);
	}
}
