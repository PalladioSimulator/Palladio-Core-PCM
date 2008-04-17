package de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reports;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import org.eclipse.core.runtime.IStatus;
import org.rosuda.JRI.REXP;

import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.RVisualisationPlugin;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reportitems.CdfReportItem;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reportitems.HistogramReportItem;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reportitems.IReportItem;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reportitems.PdfReportItem;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reportitems.RCommandRReportItem;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reportitems.StaticTextReportItem;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reportitems.SummaryReportItem;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.utils.RConnection;

/**View for a set of time series.
 * Displays a Histogram, CDF, PDF, number of measurements, mean,
 * and the standard deviation for the series.
 * @author groenda
 */
public class TimeSeriesReport extends RReport {

	/** {@inheritDoc}
	 */
	@Override
	public ArrayList<IReportItem> prepareReportItems(
			final Collection<SensorAndMeasurements> c, final RConnection t) {
		ArrayList<IReportItem> items = new ArrayList<IReportItem>();
		items.add(new StaticTextReportItem("Time Series Report", true));

		Iterator<SensorAndMeasurements> it = c.iterator();
		
		HistogramReportItem hrt = new HistogramReportItem(
				"Histogram", "Time");
		//hrt.setColumns(20);
		items.add(hrt);
		
		CdfReportItem cdf = new CdfReportItem(
				"Cumulative Distribution Function", "Time");
		items.add(cdf);
		//cdf.setLegendPos(LegendPosition.right);
		
		PdfReportItem pdf = new PdfReportItem(
				"Probability Density Function", "Time");
		items.add(pdf);
		//pdf.setLegendPos(LegendPosition.right);
		
		for (int i = 0; i < c.size(); i++) {
			SensorAndMeasurements sm = it.next();
			
			String rCommand = storeMeasurementsInRVector(sm, i) + "\n";
			Vector<REXP> result = t.execute(rCommand);
			// Comment in if file transfer is used for the measurements
//			if (!t.getLastConsoleMessage().equalsIgnoreCase("Read " 
//					+ sm.getMeasurements().size() + " items\n")) {
				String rResults = "Executing command: '" + rCommand + "' with ";
				for (REXP currentResult : result) {
					rResults += "String: " + currentResult.asString() 
						+ ", SymbolName: " + currentResult.asSymbolName() 
						+ ", Type: " + currentResult.getType() + "\n";
				}
				RVisualisationPlugin.log(IStatus.INFO,
					"Storing Measurements in R via file is most likely wrong. Last message "
					+ "on the console was: " + t.getLastConsoleMessage()
					+ "R returned:\n" + rResults);
//			}
			
			items.add(new SummaryReportItem("sensor" + i, 
				sm.getSensor().getSensorName()));
			hrt.addData("s" + i, sm.getSensor().getSensorName(), "sensor" + i);
			cdf.addData("s" + i, sm.getSensor().getSensorName(), "sensor" + i);
			pdf.addData("s" + i, sm.getSensor().getSensorName(), "sensor" + i);
			
			rCommand = "length(sensor" + i + ")\n";
			items.add(new RCommandRReportItem(rCommand, 
				"Number of observations of Sensor " 
					+ sm.getSensor().getSensorName()));
			rCommand = "mean(sensor" + i + ")\n";
			items.add(new RCommandRReportItem(rCommand, 
				"Mean of Sensor " + sm.getSensor().getSensorName()));
			rCommand = "sd(sensor" + i + ")\n";
			items.add(new RCommandRReportItem(rCommand, 
					"Standard-Deviation of Sensor " 
					+ sm.getSensor().getSensorName()));
		}
		
		return items;
	}

}
