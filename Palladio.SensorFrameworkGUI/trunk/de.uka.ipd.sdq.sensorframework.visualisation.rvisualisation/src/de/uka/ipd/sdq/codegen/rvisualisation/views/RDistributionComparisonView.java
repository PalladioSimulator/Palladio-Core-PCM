package de.uka.ipd.sdq.codegen.rvisualisation.views;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import de.uka.ipd.sdq.codegen.rvisualisation.actions.RInterface;
import de.uka.ipd.sdq.codegen.rvisualisation.reportitems.IReportItem;
import de.uka.ipd.sdq.codegen.rvisualisation.reportitems.PlotReportItem;
import de.uka.ipd.sdq.codegen.rvisualisation.reportitems.StaticReportItem;
import de.uka.ipd.sdq.codegen.rvisualisation.reportitems.StatisticsReportItem;
import de.uka.ipd.sdq.sensorfactory.entities.SensorAndMeasurements;

public class RDistributionComparisonView extends AbstractRReportView {

	public static final String RREPORTVIEW_ID = "de.uka.ipd.sdq.codegen.rvisualization.views.RDistributionComparison";

	protected ArrayList<IReportItem> prepareReportItems(
			Collection<SensorAndMeasurements> c, RInterface t) {
		ArrayList<IReportItem> items = new ArrayList<IReportItem>();
		items.add(new StaticReportItem("R-Report for comparing distributions.",
				true));

		/**
		 * This report needs at least two sensors to be compared.
		 */
		if (c.size() != 2) {
			items.add(new StaticReportItem(
					"You need to add two sensors to this report. You added "
							+ c.size() + (c.size()==1 ? " sensor." : " sensors.")
							+ "Use the property sheet to add or delete sensors.", false));
			return items;
		} else {
			// c.size = 2
			ArrayList<String> data = new ArrayList<String>();
			Iterator<SensorAndMeasurements> it = c.iterator();
			SensorAndMeasurements[] sm = new SensorAndMeasurements[2];
			for (int i = 0; i < 2; i++) {
				sm[i] = it.next();
				String rCommand = getRVector(sm[i], i) + "\n";
				t.execute(rCommand);
				data.add("density(sensor" + i + ")");

				items.add(new PlotReportItem(new String[] { "density(sensor"
						+ i + ")" }, sm[i].getSensor().getSensorName()));

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
			items.add(1, new PlotReportItem(data.toArray(new String[0]),
					"Combined Plot"));

			int pos = 1;
			items.add(pos++, new StaticReportItem("Comparing sensors "
					+ sm[0].getSensor().getSensorName() + " and "
					+ sm[1].getSensor().getSensorName(), false));
			
			items.add(pos++, new StaticReportItem("KS test.", true));
			t.execute("ks <- ks.test(sensor0,sensor1)\n ");
						
			items.add(pos++, new StatisticsReportItem("ks$method", "The applied test for the sensors"));
			items.add(pos++, new StatisticsReportItem("ks$statistic", "The value of the test statistics"));
			items.add(pos++, new StatisticsReportItem("ks$p.value", "The p-value of the test"));
			
			items.add(pos++, new StaticReportItem("Chi^2 test.", true));
			t.execute("chisq <- chisq.test(sensor0,sensor1)\n ");

			//TODO: The RDistributionComparisonView behaves strangely if this is removed.
			//The values for the chi square test are all set to the last KS test value.
			//Maybe the results are not properly stored?
			//System.out.println("Last result for StatItem with description was "+getResult());
			
			items.add(pos++, new StatisticsReportItem("chisq$method", "The applied test for the sensors"));
			items.add(pos++, new StatisticsReportItem("chisq$statistic", "The value of the test statistics"));
			items.add(pos++, new StatisticsReportItem("chisq$p.value", "The p-value of the test"));

			return items;
		}
	}

}
