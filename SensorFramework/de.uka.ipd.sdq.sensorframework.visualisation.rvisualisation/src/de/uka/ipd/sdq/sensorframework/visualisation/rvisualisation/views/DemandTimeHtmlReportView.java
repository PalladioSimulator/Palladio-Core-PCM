package de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.views;

import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reports.DemandTimeReport;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reports.RReport;

/**View for DemandTimeReport in HTML format.
 * @author groenda
 */
public class DemandTimeHtmlReportView extends AbstractHtmlRReportView {
	/** Identifier to allow the use of the demand time report. */
	public static final String RREPORTVIEW_ID = 
		"de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.views.DemandTimeHtmlView";

	/** The report associated with this view. */
	private RReport report = new DemandTimeReport();
	
	/** {@inheritDoc}
	 */
	@Override
	public RReport getReport() {
		return report;
	}
}
