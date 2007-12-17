package de.uka.ipd.sdq.codegen.rvisualisation.views;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import de.uka.ipd.sdq.codegen.rvisualisation.actions.RInterface;
import de.uka.ipd.sdq.codegen.rvisualisation.reportitems.IReportItem;
import de.uka.ipd.sdq.codegen.rvisualisation.reportitems.StaticReportItem;
import de.uka.ipd.sdq.codegen.rvisualisation.reportitems.StatisticsReportItem;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;

public class RDemandTimeReportView extends AbstractRReportView {

	public static final String RDEMANDTIMEREPORTVIEW_ID = "de.uka.ipd.sdq.codegen.rvisualization.views.DemandTimeView";


	/**
	 * Creates a list of summed up resource demands for each registered sensor
	 */
	protected ArrayList<IReportItem> prepareReportItems(Collection<SensorAndMeasurements> c, RInterface t) {
		ArrayList<IReportItem> items = new ArrayList<IReportItem>();
		items.add(new StaticReportItem("R-Report about total resource demands", true));

		Iterator<SensorAndMeasurements> it = c.iterator();
		for(int i=0; i<c.size();i++){
			SensorAndMeasurements sm = it.next();
			
			String rCommand = getRVector(sm,i) + "\n";
			t.execute(rCommand);
			
			rCommand = "sum(sensor"+i+")\n";
			items.add(new StatisticsReportItem(rCommand, " is the total resource demand of "+sm.getSensor().getSensorName()));
		} 
		return items;
	}




}
