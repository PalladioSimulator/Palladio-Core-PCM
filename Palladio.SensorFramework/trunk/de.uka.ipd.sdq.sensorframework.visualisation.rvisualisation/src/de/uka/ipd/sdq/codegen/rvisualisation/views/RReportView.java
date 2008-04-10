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
import de.uka.ipd.sdq.codegen.rvisualisation.reportitems.StaticTextReportItem;
import de.uka.ipd.sdq.codegen.rvisualisation.reportitems.StatisticsReportItem;
import de.uka.ipd.sdq.codegen.rvisualisation.reportitems.SummaryReportItem;
import de.uka.ipd.sdq.codegen.rvisualisation.reportitems.AbstractPlotReportItem.LegendPosition;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;

public class RReportView extends AbstractRReportView {

	public static final String RREPORTVIEW_ID = "de.uka.ipd.sdq.codegen.rvisualization.views.ReportView";
	
	public static final boolean GEN_PDF = false;


	/**
	 * Creates a density plot and statistics (length, mean, standard deviation)
	 * for each given sensor/measurement as well a a plot that combines the densities of 
	 * all sensors/measurements. 
	 */
	@Override
	protected ArrayList<IReportItem> prepareReportItems(Collection<SensorAndMeasurements> c, RConnection t) {
		ArrayList<IReportItem> items = new ArrayList<IReportItem>();
		items.add(new StaticTextReportItem("R-Report", true));

		Iterator<SensorAndMeasurements> it = c.iterator();
		
		HistogramReportItem hrt = new HistogramReportItem(GEN_PDF,"Histogram");
		hrt.setColumns(20);
		items.add(hrt);
		
		CdfReportItem cdf = new CdfReportItem(GEN_PDF,"Cumulative Distribution Function");
		items.add(cdf);
		cdf.setLegendPos(LegendPosition.right);
		
		PdfReportItem pdf = new PdfReportItem(GEN_PDF,true, "Probability Density Function");
		items.add(pdf);
		
		for(int i=0; i<c.size();i++){
			SensorAndMeasurements sm = it.next();
			
			String rCommand = storeMeasurementsInRVector(sm,i) + "\n";
			t.execute(rCommand);
			if (!t.getLastConsoleMessage().equalsIgnoreCase("Read " + sm.getMeasurements().size() + " items\n"))
				RVisualisationPlugin.log(IStatus.WARNING,
						"Storing Measurments in R might be wrong. Last message on the console is: " + t.getLastConsoleMessage());
			
			items.add(new SummaryReportItem("sensor"+i, sm.getSensor()));
			hrt.addData("s"+i, sm.getSensor().getSensorName(), "sensor"+i);
			cdf.addData("s"+i, sm.getSensor().getSensorName(), "sensor"+i);
			pdf.addData("s"+i, sm.getSensor().getSensorName(), "sensor"+i);
			rCommand = "length(sensor"+i+")\n";
			items.add(new StatisticsReportItem(rCommand, "Number of observations of Sensor "+sm.getSensor().getSensorName()));
			rCommand = "mean(sensor"+i+")\n";
			items.add(new StatisticsReportItem(rCommand, "Mean of Sensor "+sm.getSensor().getSensorName()));
			rCommand = "sd(sensor"+i+")\n";
			items.add(new StatisticsReportItem(rCommand, "Standard-Deviation of Sensor "+sm.getSensor().getSensorName()));
		}
		
		return items;
	}

}
