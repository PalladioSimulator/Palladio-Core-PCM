package de.uka.ipd.sdq.codegen.rvisualisation.views;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.core.runtime.IStatus;

import de.uka.ipd.sdq.codegen.rvisualisation.RVisualisationPlugin;
import de.uka.ipd.sdq.codegen.rvisualisation.actions.RConnection;
import de.uka.ipd.sdq.codegen.rvisualisation.reportitems.CdfReportItem;
import de.uka.ipd.sdq.codegen.rvisualisation.reportitems.HistogramReportItem;
import de.uka.ipd.sdq.codegen.rvisualisation.reportitems.IReportItem;
import de.uka.ipd.sdq.codegen.rvisualisation.reportitems.PdfReportItem;
import de.uka.ipd.sdq.codegen.rvisualisation.reportitems.RCommandRReportItem;
import de.uka.ipd.sdq.codegen.rvisualisation.reportitems.StaticTextReportItem;
import de.uka.ipd.sdq.codegen.rvisualisation.reportitems.SummaryReportItem;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;

/**View for a set of time series.
 * Displays a Histogram, CDF, PDF, number of measurements, mean,
 * and the standard deviation for the series.
 * @author groenda
 */
public class RTimeSeriesReportView extends AbstractRReportView {

	/** Identifier to allow the use of this View. */
	public static final String RREPORTVIEW_ID = 
		"de.uka.ipd.sdq.codegen.rvisualization.views.ReportView";


	/**
	 * Creates a histogram, cdf and pdf plot as well as statistics 
	 * (length, mean, standard deviation)
	 * for each given sensor/measurement as well a a plot that 
	 * combines the densities of 
	 * all sensors/measurements. 
	 * @param c The respective sensors/measurements.
	 * @param t The connection to the R engine.
	 * @return List of report items.
	 */
	@Override
	protected ArrayList<IReportItem> prepareReportItems(
			final Collection<SensorAndMeasurements> c, final RConnection t) {
		ArrayList<IReportItem> items = new ArrayList<IReportItem>();
		items.add(new StaticTextReportItem("R-Report", true));

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
			t.execute(rCommand);
			if (!t.getLastConsoleMessage().equalsIgnoreCase("Read " 
					+ sm.getMeasurements().size() + " items\n")) {
				RVisualisationPlugin.log(IStatus.WARNING,
					"Storing Measurements in R might be wrong. Last message "
					+ "on the console is: " + t.getLastConsoleMessage());
			}
			
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
