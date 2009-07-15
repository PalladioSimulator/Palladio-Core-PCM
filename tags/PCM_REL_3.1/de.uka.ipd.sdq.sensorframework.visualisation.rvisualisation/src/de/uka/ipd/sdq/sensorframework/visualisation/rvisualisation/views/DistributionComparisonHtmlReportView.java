package de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.views;

import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reports.DistributionComparisonReport;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reports.RReport;

/**View for DistributionComparisonReport in HTML format.
 * @author groenda
 */
public class DistributionComparisonHtmlReportView extends
		AbstractHtmlReportView {
	/** Identifier to allow the use of the distribution comparison view. */
	public static final String RREPORTVIEW_ID = 
		"de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.views.DistributionComparisonHtmlView";

	/** The report associated with this view. */
	private RReport report = new DistributionComparisonReport();
	
	/** {@inheritDoc}
	 */
	@Override
	public RReport getReport() {
		return report;
	}
}
