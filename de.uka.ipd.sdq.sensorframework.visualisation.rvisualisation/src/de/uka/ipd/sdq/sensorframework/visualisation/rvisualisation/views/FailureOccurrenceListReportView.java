package de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.views;

import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reports.RReport;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reports.FailureOccurenceListReport;

public class FailureOccurrenceListReportView extends AbstractHtmlRReportView {

	/** Identifier to allow the use of the time series view. */
	public static final String RREPORTVIEW_ID = 
		"de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.views.FailureOccurrenceListView";
	
	/** The report associated with this view. */
	private RReport report = new FailureOccurenceListReport();
	
	
	@Override
	public RReport getReport() {
		return report;
	}

}
