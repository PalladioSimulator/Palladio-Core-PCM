package de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reports;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.entities.StateMeasurement;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reportitems.BarPlotReportItem;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reportitems.HTMLTable;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reportitems.IReportItem;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reportitems.StaticTextReportItem;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.utils.FailureExtractor;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.utils.RConnection;

public class FailureOccurrenceBarReport extends RReport {

	/**
	 * This method extracts all failures with the {@link FailureExtractor} 
	 * and plots them with a BarChart.
	 * Extra information is printed within a {@link HTMLTable} beyond.
	 */
	@Override
	public ArrayList<IReportItem> prepareReportItems(
			Collection<SensorAndMeasurements> measurements,
			RConnection rConnection) {
		ArrayList<IReportItem> items = new ArrayList<IReportItem>();
		Iterator<SensorAndMeasurements> it = measurements.iterator();
		ArrayList<StateMeasurement> Failures = FailureExtractor
				.extractFailures(it);
		HashMap<String, Integer> counts = FailureExtractor
				.countFailures(Failures.iterator());
		BarPlotReportItem barPlot = new BarPlotReportItem("Failure BarPlot");
		//TODO: The first parameter is forced, but never used, why?
		barPlot.addData("1", "AnzeigeName", "barPlot");
		barPlot.setValues(counts);
		HTMLTable table = new HTMLTable();
		table.setRuns(measurements.iterator().next().getMeasurements().size());
		table.setFaults(Failures.size());
		if (Failures.size()>0){
			items.add(barPlot);	
			Object[] keys = counts.keySet().toArray();
			for (int i =0; i<counts.size(); i++){
				table.addRow((i+1), keys[i].toString(), counts.get(keys[i].toString()));
			}
		} else {
			items.add(new StaticTextReportItem("No Failure happened", false));
		}
		
		
		items.add(table);
		return items;
	}

}
