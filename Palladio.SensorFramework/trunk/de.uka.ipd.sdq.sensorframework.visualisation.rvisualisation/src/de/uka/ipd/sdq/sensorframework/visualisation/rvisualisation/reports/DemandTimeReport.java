package de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reports;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reportitems.IReportItem;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reportitems.RCommandRReportItem;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reportitems.StaticTextReportItem;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.utils.RConnection;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.utils.REngineHelper;

/**Report that displays the total resource demands for sensors.
 * @author groenda
 */
public class DemandTimeReport extends RReport {

	/**Creates a list of summed up resource demands for each registered sensor.
	 * @param c The measurements to sum up.
	 * @param t The connection to the R-Engine.
	 * @return List of items with statistical information.
	 */
	@Override
	public ArrayList<IReportItem> prepareReportItems(
			final Collection<SensorAndMeasurements> c, final RConnection t) {
		ArrayList<IReportItem> items = new ArrayList<IReportItem>();
		items.add(new StaticTextReportItem(
				"R-Report about total resource demands", true));

		Iterator<SensorAndMeasurements> it = c.iterator();
		for (int i = 0; i < c.size(); i++) {
			SensorAndMeasurements sm = it.next();
			
			String sensorName = REngineHelper.storeMeasurementsInRVector(sm, i, 
					TimeseriesData.TIMESPAN, t);
			
			String rCommand = "sum(" + sensorName + ")\n";
			items.add(new RCommandRReportItem(rCommand, 
					"Resource demand of " + sm.getSensor().getSensorName()));
		} 
		return items;
	}
}
