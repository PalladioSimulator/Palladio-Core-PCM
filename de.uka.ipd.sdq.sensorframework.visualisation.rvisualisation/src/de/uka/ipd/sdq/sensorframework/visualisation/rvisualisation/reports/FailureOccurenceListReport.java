package de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reports;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.entities.StateMeasurement;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reportitems.IReportItem;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reportitems.StaticTextReportItem;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.utils.FailureExtractor;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.utils.RConnection;

public class FailureOccurenceListReport extends RReport {

	/**
	 * This method writes down in a list all occurrences per failure type.
	 */
	@Override
	public ArrayList<IReportItem> prepareReportItems(
			Collection<SensorAndMeasurements> measurements,
			RConnection rConnection) {
		// ArrayList for commands that are send to R
		ArrayList<IReportItem> items = new ArrayList<IReportItem>();

		Iterator<SensorAndMeasurements> it = measurements.iterator();
		ArrayList<StateMeasurement> Failures = FailureExtractor
				.extractFailures(it);
		HashMap<String, Integer> counts = FailureExtractor
				.countFailures(Failures.iterator());
		items.add(new StaticTextReportItem("Occurrences", true));
		Set<Entry<String, Integer>> set = counts.entrySet();
		for (Entry<String, Integer> entry : set) {
			items.add(new StaticTextReportItem(entry.getKey()+ ": " + entry.getValue().toString()+"\n",false));
			items.add(new StaticTextReportItem("", true));
		}
		return items;
	}

}
