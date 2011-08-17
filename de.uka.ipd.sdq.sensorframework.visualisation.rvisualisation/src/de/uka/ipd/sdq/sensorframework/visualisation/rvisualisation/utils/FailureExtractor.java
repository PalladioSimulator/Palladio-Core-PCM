package de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.entities.StateMeasurement;

/**
 * This class extracts all Failures out of the measurements.
 * 
 * @author toms
 * 
 */
public class FailureExtractor {

	/**
	 * This method extracts all failures from the incoming {@link Iterator}.
	 * 
	 * @param it {@link Iterator} that contains all measurements.
	 * @return An {@link ArrayList} that contains only the failures.
	 */
	public static ArrayList<StateMeasurement> extractFailures(
			Iterator<SensorAndMeasurements> it) {
		ArrayList<StateMeasurement> list = new ArrayList<StateMeasurement>();
		SensorAndMeasurements sm = null;
		while (it.hasNext()) {
			sm = it.next();
			Collection<Measurement> mess = sm.getMeasurements();
			StateMeasurement stateMeasurement;
			for (Measurement measurement : mess) {
				stateMeasurement = (StateMeasurement) measurement;
				if (stateMeasurement.getSensorState().getStateID() != 2) {
					list.add(stateMeasurement);
				}
			}
		}
		return list;
	}

	/**
	 * This methods counts the occurrences of the single failure types.
	 * 
	 * @param it {@link Iterator} that contains all failures.
	 * @return {@link HashMap} that cotains the occurrences per failure type.
	 */
	public static HashMap<String, Integer> countFailures(
			Iterator<StateMeasurement> it) {
		HashMap<String, Integer> counts = new HashMap<String, Integer>();
		String actualLiteral = null;
		StateMeasurement stateMeasurement = null;
		while (it.hasNext()) {
			stateMeasurement = it.next();
			actualLiteral = stateMeasurement.getSensorState().getStateLiteral();
			if (!counts.containsKey(actualLiteral)) {
				counts.put(actualLiteral, 1);
			} else {
				int temp = counts.get(actualLiteral);
				temp++;
				counts.remove(actualLiteral);
				counts.put(actualLiteral, temp);
			}
		}
		return counts;
	}
}
