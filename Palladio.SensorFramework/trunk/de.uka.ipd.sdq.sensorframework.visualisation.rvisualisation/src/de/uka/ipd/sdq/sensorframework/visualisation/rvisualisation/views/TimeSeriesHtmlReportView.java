package de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.views;

import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reports.RReport;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reports.TimeSeriesReport;

/**View for TimeSeriesReport in HTML format.
 * @author groenda
 */
public class TimeSeriesHtmlReportView extends AbstractHtmlReportView {

	/** Identifier to allow the use of the time series view. */
	public static final String RREPORTVIEW_ID = 
		"de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.views.TimeSeriesHtmlView";

	/** The report associated with this view. */
	private RReport report = new TimeSeriesReport();
	
	/** {@inheritDoc}
	 */
	@Override
	public RReport getReport() {
		return report;
	}
}
