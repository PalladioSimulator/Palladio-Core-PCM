package de.uka.ipd.sdq.codegen.rvisualisation.reportitems;

public interface IReportRenderingVisitor {

	void visitStaticItem(StaticReportItem staticReportItem);

	void visitStatisticsItem(StatisticsReportItem statisticsReportItem);

	void visitPlotItem(PlotReportItem plotReportItem);

}
