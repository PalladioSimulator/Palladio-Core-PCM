package de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.widgets.Composite;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.Histogram;
import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.HistogramBucketInformation;


public class JFreeChartHistogramViewer extends AbstractJFreeChartWidthViewer
	implements IHistogramAccepter, IHistSeriesExporter {

	public JFreeChartHistogramViewer(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	protected void initializeContextMenu(MenuManager menu_manager) {
		super.initializeContextMenu(menu_manager);
	    menu_manager.add(new LoadCSVHistogram(this));
	    menu_manager.add(new ExportCSV(this));
	    menu_manager.add(new ExportDoublePDF(this));
	}

	public void addHistogram(Histogram histogram) {
		XYSeries density = new XYSeries(histogram.getTitle(),true,false);
		for (HistogramBucketInformation e : histogram.getBucketInformation())
			density.add(e.getValue(), e.getProbability());
		densityDataset.addSeries(density);
		densityDataset.setAutoWidth(true);
		initChart();
		this.redraw();
	}

	protected void initChart() {
		chart = ChartFactory.createHistogram("Histogram","Time","Probability", densityDataset,PlotOrientation.VERTICAL,true,true,true);

		XYPlot plot = (XYPlot)chart.getPlot();
		plot.getRangeAxis().setAutoRange(true);
		plot.setForegroundAlpha(0.8f); // for transparency
		if (densityDataset != null)
			densityDataset.setAutoWidth(true);
	}
	
	protected XYSeries computeDensities(Histogram hist) {
		XYSeries density;
		density = new XYSeries(hist.getTitle(),true,false);
		for (HistogramBucketInformation bucketInformation : hist.getBucketInformation()) {
			density.add(bucketInformation.getValue() + hist.getBucketWidth() / 2, bucketInformation.getProbability());
		}
		return density;
	}

	public XYSeries getSeries() {
		return densityDataset.getSeries(0);
	}

	public double getHistogramWidth() {
		return densityDataset.getIntervalWidth();
	}

}
