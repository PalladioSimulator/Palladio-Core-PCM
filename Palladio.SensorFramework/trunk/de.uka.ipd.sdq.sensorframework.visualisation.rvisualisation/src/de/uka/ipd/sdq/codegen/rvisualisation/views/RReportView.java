package de.uka.ipd.sdq.codegen.rvisualisation.views;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.core.runtime.IStatus;

import de.uka.ipd.sdq.codegen.rvisualisation.RVisualisationPlugin;
import de.uka.ipd.sdq.codegen.rvisualisation.actions.RConnection;
import de.uka.ipd.sdq.codegen.rvisualisation.reportitems.IReportItem;
import de.uka.ipd.sdq.codegen.rvisualisation.reportitems.DensityPlotReportItem;
import de.uka.ipd.sdq.codegen.rvisualisation.reportitems.StaticTextReportItem;
import de.uka.ipd.sdq.codegen.rvisualisation.reportitems.StatisticsReportItem;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;

public class RReportView extends AbstractRReportView {

	public static final String RREPORTVIEW_ID = "de.uka.ipd.sdq.codegen.rvisualization.views.ReportView";


	/**
	 * Creates a density plot and statistics (length, mean, standard deviation)
	 * for each given sensor/measurement as well a a plot that combines the densities of 
	 * all sensors/measurements. 
	 */
	protected ArrayList<IReportItem> prepareReportItems(Collection<SensorAndMeasurements> c, RConnection t) {
		ArrayList<IReportItem> items = new ArrayList<IReportItem>();
		items.add(new StaticTextReportItem("R-Report", true));

		ArrayList<String> data = new ArrayList<String>();
		Iterator<SensorAndMeasurements> it = c.iterator();
		for(int i=0; i<c.size();i++){
			SensorAndMeasurements sm = it.next();
			
			String rCommand = storeMeasurementsInRVector(sm,i) + "\n";
			t.execute(rCommand);
			if (!t.getLastConsoleMessage().equalsIgnoreCase("Read " + sm.getMeasurements().size() + " items\n"))
				RVisualisationPlugin.log(IStatus.WARNING,
						"Storing Measurments in R might be wrong. Last message on the console is: " + t.getLastConsoleMessage());
			
			data.add("density(sensor"+i+")");
			items.add(new DensityPlotReportItem(new String[]{"density(sensor"+i+")"}, sm.getSensor().getSensorName(), "Response Time"));

			rCommand = "length(sensor"+i+")\n";
			items.add(new StatisticsReportItem(rCommand, "Number of observations of Sensor "+sm.getSensor().getSensorName()));
			rCommand = "mean(sensor"+i+")\n";
			items.add(new StatisticsReportItem(rCommand, "Mean of Sensor "+sm.getSensor().getSensorName()));
			rCommand = "sd(sensor"+i+")\n";
			items.add(new StatisticsReportItem(rCommand, "Standard-Deviation of Sensor "+sm.getSensor().getSensorName()));
		} 
		if (data.size() > 0)
			items.add(1, new DensityPlotReportItem(data.toArray(new String[0]), "Combined Plot", "Response Time"));
		return items;
	}




}
