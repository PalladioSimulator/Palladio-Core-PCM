package de.uka.ipd.sdq.codegen.rvisualisation.views;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import de.uka.ipd.sdq.codegen.rvisualisation.actions.RConnection;
import de.uka.ipd.sdq.codegen.rvisualisation.reportitems.IReportItem;
import de.uka.ipd.sdq.codegen.rvisualisation.reportitems.DensityPlotReportItem;
import de.uka.ipd.sdq.codegen.rvisualisation.reportitems.StaticTextReportItem;
import de.uka.ipd.sdq.codegen.rvisualisation.reportitems.StatisticsReportItem;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;

public class RDistributionComparisonView extends AbstractRReportView {

	public static final String RREPORTVIEW_ID = "de.uka.ipd.sdq.codegen.rvisualization.views.RDistributionComparison";

	@Override
	protected ArrayList<IReportItem> prepareReportItems(
			Collection<SensorAndMeasurements> c, RConnection t) {
		ArrayList<IReportItem> items = new ArrayList<IReportItem>();
		items.add(new StaticTextReportItem("R-Report for comparing distributions.",
				true));

		/**
		 * This report needs at least two sensors to be compared.
		 */
		if (c.size() != 2) {
			items.add(new StaticTextReportItem(
					"You need to add two sensors to this report. You added "
							+ c.size() + (c.size()==1 ? " sensor." : " sensors.")
							+ " Use the property sheet to add or delete sensors.", false));
			return items;
		} else {
			// c.size = 2
			ArrayList<String> data = new ArrayList<String>();
			Iterator<SensorAndMeasurements> it = c.iterator();
			SensorAndMeasurements[] sm = new SensorAndMeasurements[2];
			for (int i = 0; i < 2; i++) {
				sm[i] = it.next();
				String rCommand = storeMeasurementsInRVector(sm[i], i) + "\n";
				
				t.execute(rCommand);
				data.add("density(sensor" + i + ")");

				items.add(new DensityPlotReportItem(new String[] { "density(sensor"
						+ i + ")" }, sm[i].getSensor().getSensorName(), "Response Time"));

				rCommand = "length(sensor" + i + ")\n";
				items.add(new StatisticsReportItem(rCommand,
						"Number of observations of Sensor "
								+ sm[i].getSensor().getSensorName()));
				rCommand = "mean(sensor" + i + ")\n";
				items.add(new StatisticsReportItem(rCommand, "Mean of Sensor "
						+ sm[i].getSensor().getSensorName()));
				rCommand = "sd(sensor" + i + ")\n";
				items.add(new StatisticsReportItem(rCommand,
						"Standard-Deviation of Sensor "
								+ sm[i].getSensor().getSensorName()));
			}
			items.add(1, new DensityPlotReportItem(data.toArray(new String[0]),
					"Combined Plot", "Response Time"));
			
			int pos = 1;
			items.add(pos++, new StaticTextReportItem("Comparing sensors "
					+ sm[0].getSensor().getSensorName() + " and "
					+ sm[1].getSensor().getSensorName(), false));
			
			items.add(pos++, new StaticTextReportItem("KS test.", true));
			//t.execute("ks <- ks.test(sensor0,sensor1)\n ");
						
			items.add(pos++, new StatisticsReportItem("ks.test(sensor0,sensor1)$method", "The applied test for the sensors"));
			items.add(pos++, new StatisticsReportItem("ks.test(sensor0,sensor1)$statistic", "The value of the test statistics"));
			items.add(pos++, new StatisticsReportItem("ks.test(sensor0,sensor1)$p.value", "The p-value of the test"));
			
			items.add(pos++, new StaticTextReportItem("Chi^2 test.", true));
			//t.execute("chisq <- chisq.test(sensor0,sensor1)\n ");

			/*
			 * The vectors must have the same length for the chi square test, so use
			 * the shorter vector's length. 
			 * Additionally, Chi square test cannot handle lots of data. Thus, only compare the first 2500
			 * values or less if the sensor contains less data.
			 */
			int max = (sm[0].getMeasurements().size() < sm[1].getMeasurements()
					.size() ? sm[0].getMeasurements().size() : sm[1]
					.getMeasurements().size());
			max = max > 2500 ? 2500 : max; 
			
			
			items.add(pos++, new StatisticsReportItem("chisq.test(sensor0[1:"+max+"],sensor1[1:"+max+"])$method", "The applied test for the sensors"));
			items.add(pos++, new StatisticsReportItem("chisq.test(sensor0[1:"+max+"],sensor1[1:"+max+"])$statistic", "The value of the test statistics"));
			items.add(pos++, new StatisticsReportItem("chisq.test(sensor0[1:"+max+"],sensor1[1:"+max+"])$p.value", "The p-value of the test"));

			return items;
		}
	}

}
