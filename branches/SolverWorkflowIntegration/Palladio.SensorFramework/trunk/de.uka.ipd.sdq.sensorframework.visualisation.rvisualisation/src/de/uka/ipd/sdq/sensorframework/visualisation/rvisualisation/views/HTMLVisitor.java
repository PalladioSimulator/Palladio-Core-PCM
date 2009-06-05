package de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.views;

import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reportitems.AbstractPlotReportItem;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reportitems.IReportRenderingVisitor;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reportitems.RCommandRReportItem;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reportitems.StaticTextReportItem;

/**Visitor that generates HTML code for the report items of a report.
 * @author groenda
 */
public class HTMLVisitor implements IReportRenderingVisitor {

	/** The content of the HTML body. */
	private String content = "";
	
	/**Returns the generated HTML code for a report.
	 * @return a valid HTML page.
	 */
	public String getHTML() {
		return "<html><body>" + content + "</body></html>";
	}
	
	/** {@inheritDoc}
	 */
	public void visitStaticTextReportItem(
			final StaticTextReportItem staticReportItem) {
		if (staticReportItem.isHeading()) {
			content += "<h2>";
		}
		content += staticReportItem.getText();
		if (staticReportItem.isHeading()) {
			content += "</h2>";
		}
	}

	/** {@inheritDoc}
	 */
	public void visitGeneratedTextReportItem(
			final RCommandRReportItem rCommandReportItem) {
		content += "<b>" + rCommandReportItem.getDescription() + ":</b> ";
		content += rCommandReportItem.getText() + "<br/>";
	}

	/** {@inheritDoc}
	 */
	public void visitGraphicReportItem(
			final AbstractPlotReportItem plotReportItem) {
		// include generated graphics
		if (plotReportItem.getTemporaryRasterGraphicFilename() != null) {
			content += "<a href=\"file:///" 
				+ plotReportItem.getTemporaryVectorGraphicFilename() + "\">"
				+ "<img src=\"file:///" 
				+ plotReportItem.getTemporaryRasterGraphicFilename() + "\"/>"
				+ "</a><br/>";
		}
	}

}
