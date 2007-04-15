package de.uka.ipd.sdq.codegen.rvisualisation.visitor;

import de.uka.ipd.sdq.codegen.rvisualisation.reportitems.IReportRenderingVisitor;
import de.uka.ipd.sdq.codegen.rvisualisation.reportitems.PlotReportItem;
import de.uka.ipd.sdq.codegen.rvisualisation.reportitems.StaticReportItem;
import de.uka.ipd.sdq.codegen.rvisualisation.reportitems.StatisticsReportItem;

public class HTMLVisitor implements IReportRenderingVisitor {

	protected String htmlContent;
	private String content = "";
	
	public String getHTML(){
		return "<html><body>"+content+"</body></html>";
	}
	
	public void visitStaticItem(StaticReportItem staticReportItem) {
		String result = "";
		if (staticReportItem.isHeading())
			result += "<h2>";
		result += staticReportItem.getText();
		if (staticReportItem.isHeading())
			result += "</h2>";
		content += result;
	}

	public void visitStatisticsItem(StatisticsReportItem statisticsReportItem) {
		String result = "<b>"+statisticsReportItem.getDescription()+":</b> ";
		result += statisticsReportItem.getResult()+"<br/>";
		content += result;
	}

	@Override
	public void visitPlotItem(PlotReportItem plotReportItem) {
		if (plotReportItem.getFilename()!= null)
			content += "<img src=\"file:///"+plotReportItem.getFilename()+"\"/><br/>";
	}

}
