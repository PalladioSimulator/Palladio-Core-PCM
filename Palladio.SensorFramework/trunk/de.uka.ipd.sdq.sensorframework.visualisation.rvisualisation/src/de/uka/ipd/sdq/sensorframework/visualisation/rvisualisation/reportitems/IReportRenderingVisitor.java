package de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reportitems;

/** Visitor for R reports.
 * @author groenda
 */
public interface IReportRenderingVisitor {

	/**Visitor for static report items.
	 * @param staticReportItem The report item to visit.
	 */
	void visitStaticTextReportItem(StaticTextReportItem staticReportItem);

	/**Visitor for static report items.
	 * @param statisticsReportItem The report item to visit.
	 */
	void visitGeneratedTextReportItem(RCommandRReportItem statisticsReportItem);

	/**Visitor for graphical report items.
	 * @param histogramReportItem The report item to visit.
	 */
	void visitGraphicReportItem(AbstractPlotReportItem histogramReportItem);

}
