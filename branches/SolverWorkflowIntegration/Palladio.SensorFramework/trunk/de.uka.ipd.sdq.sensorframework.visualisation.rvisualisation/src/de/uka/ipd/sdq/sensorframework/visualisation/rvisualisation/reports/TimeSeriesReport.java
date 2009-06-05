package de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reports;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reportitems.CdfReportItem;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reportitems.HistogramReportItem;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reportitems.IReportItem;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reportitems.PdfReportItem;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reportitems.RCommandRReportItem;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reportitems.StaticTextReportItem;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reportitems.SummaryReportItem;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.utils.RConnection;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.utils.REngineHelper;

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
			
			String sensorName = REngineHelper.storeMeasurementsInRVector(sm, i, 
					TimeseriesData.TIMESPAN, t);
			
			items.add(new SummaryReportItem(sensorName, 
				sm.getSensor().getSensorName()));
			hrt.addData("s" + i, sm.getSensor().getSensorName(), sensorName);
			cdf.addData("s" + i, sm.getSensor().getSensorName(), sensorName);
			pdf.addData("s" + i, sm.getSensor().getSensorName(), sensorName);
			
			String rCommand = "length(" + sensorName + ")\n";
			items.add(new RCommandRReportItem(rCommand, 
				"Number of observations of Sensor " 
					+ sm.getSensor().getSensorName()));
			rCommand = "mean(" + sensorName + ")\n";
			items.add(new RCommandRReportItem(rCommand, 
				"Mean of Sensor " + sm.getSensor().getSensorName()));
			rCommand = "sd(" + sensorName + ")\n";
			items.add(new RCommandRReportItem(rCommand, 
					"Standard-Deviation of Sensor " 
					+ sm.getSensor().getSensorName()));
		}
		
		return items;
	}

}
