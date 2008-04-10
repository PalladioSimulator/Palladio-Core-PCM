package de.uka.ipd.sdq.codegen.rvisualisation.reportitems;

public interface IReportRenderingVisitor {

	void visitStaticItem(StaticTextReportItem staticReportItem);

	void visitStatisticsItem(StatisticsReportItem statisticsReportItem);

	void visitPlotItem(DensityPlotReportItem plotReportItem);

	void visitAbstractPlotItem(AbstractPlotReportItem histogramReportItem);

}
