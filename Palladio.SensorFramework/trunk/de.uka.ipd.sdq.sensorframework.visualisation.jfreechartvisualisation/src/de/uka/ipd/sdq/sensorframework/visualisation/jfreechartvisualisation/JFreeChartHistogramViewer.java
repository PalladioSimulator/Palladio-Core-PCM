package de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.widgets.Composite;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.Histogram;
import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.HistogramEntity;


public class JFreeChartHistogramViewer extends AbstractJFreeChartWidthViewer 
	implements IHistogramAccepter, ISeriesExporter {

	public JFreeChartHistogramViewer(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	protected void initializeContextMenu(MenuManager menu_manager) {
		super.initializeContextMenu(menu_manager);
	    menu_manager.add(new LoadCSVHistogram(this));
	    menu_manager.add(new ExportCSV(this));
	}

	public void addHistogram(Histogram histogram) {
		XYSeries density = new XYSeries(histogram.getLabel(),true,false);
		for (HistogramEntity e : histogram.getEntityList())
			density.add(e.getValue(), e.getProbability());
		densityDataset.addSeries(density);
		densityDataset.setAutoWidth(true);
		initChart();
		this.redraw();
	}

	protected void initChart() {
		JFreeChart chart = ChartFactory.createHistogram("Histogram","Time [s]","Probability", densityDataset,PlotOrientation.VERTICAL,true,true,true);

		XYPlot plot = (XYPlot)chart.getPlot();
		plot.getRangeAxis().setAutoRange(true);
		plot.setForegroundAlpha(0.8f); // for transparency
		this.setChart(chart);
		if (densityDataset != null)
			densityDataset.setAutoWidth(true);
	}
	
	protected XYSeries computeDensities(Histogram hist) {
		XYSeries density;
		density = new XYSeries(hist.getLabel(),true,false);
		for (HistogramEntity e : hist.getEntityList()) {
			density.add(e.getValue(), e.getProbability());
		}
		return density;
	}

	public XYSeries getSeries() {
		return densityDataset.getSeries(0);
	}

}
