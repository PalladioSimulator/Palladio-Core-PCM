package de.uka.ipd.sdq.codegen.rvisualisation.views;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import de.uka.ipd.sdq.codegen.rvisualisation.actions.RConnection;
import de.uka.ipd.sdq.codegen.rvisualisation.reportitems.IReportItem;
import de.uka.ipd.sdq.codegen.rvisualisation.reportitems.RCommandRReportItem;
import de.uka.ipd.sdq.codegen.rvisualisation.reportitems.StaticTextReportItem;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;

/**Report that displays the total resource demands for sensors.
 * @author groenda
 */
public class RDemandTimeReportView extends AbstractRReportView {

	/** Identifier to allow the use of this View. */
	public static final String RREPORTVIEW_ID = 
		"de.uka.ipd.sdq.codegen.rvisualization.views.DemandTimeReportView";


	/**Creates a list of summed up resource demands for each registered sensor.
	 * @param c The measurements to sum up.
	 * @param t The connection to the R-Engine.
	 * @return List of items with statistical information.
	 */
	@Override
	protected ArrayList<IReportItem> prepareReportItems(
			final Collection<SensorAndMeasurements> c, final RConnection t) {
		ArrayList<IReportItem> items = new ArrayList<IReportItem>();
		items.add(new StaticTextReportItem(
				"R-Report about total resource demands", true));

		Iterator<SensorAndMeasurements> it = c.iterator();
		for (int i = 0; i < c.size(); i++) {
			SensorAndMeasurements sm = it.next();
			
			String rCommand = storeMeasurementsInRVector(sm, i) + "\n";
			t.execute(rCommand);
			
			rCommand = "sum(sensor" + i + ")\n";
			items.add(new RCommandRReportItem(rCommand, 
					"Resource demand of " + sm.getSensor().getSensorName()));
		} 
		return items;
	}
}
