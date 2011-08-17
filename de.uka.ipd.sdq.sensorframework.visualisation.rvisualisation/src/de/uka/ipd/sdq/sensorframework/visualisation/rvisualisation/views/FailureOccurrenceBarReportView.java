package de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.views;

import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reports.FailureOccurrenceBarReport;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reports.RReport;

public class FailureOccurrenceBarReportView extends AbstractHtmlRReportView {

	private RReport report = new FailureOccurrenceBarReport();

	@Override
	public RReport getReport() {
		return report;
	}
}
