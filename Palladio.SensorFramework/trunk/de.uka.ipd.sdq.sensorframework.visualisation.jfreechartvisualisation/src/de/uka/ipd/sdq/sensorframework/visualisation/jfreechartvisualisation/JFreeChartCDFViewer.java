package de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation;

import java.awt.BasicStroke;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.widgets.Composite;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.Histogram;
import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.HistogramBucketInformation;


public class JFreeChartCDFViewer extends AbstractJFreeChartWidthViewer implements IHistogramAccepter, ISeriesExporter {

	public XYSeries getSeries() {
		return densityDataset.getSeries(0);
	}

	public JFreeChartCDFViewer(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	protected void initializeContextMenu(MenuManager menu_manager) {
		super.initializeContextMenu(menu_manager);
	    menu_manager.add(new LoadCSVHistogram(this));
	    menu_manager.add(new ExportCSV(this));
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation.IHistogramAccepter#addHistogram(de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.Histogram)
	 */
	public void addHistogram(Histogram histogram) {
		XYSeries density = new XYSeries(histogram.getTitle(),true,false);
		double sum = 0;
		for (HistogramBucketInformation e : histogram.getBucketInformation()) {
			sum += e.getProbability();
			density.add(e.getValue(), sum);
		}
		densityDataset.addSeries(density);
		initChart();
		this.redraw();
	}


	@SuppressWarnings("deprecation")
	protected void initChart() {
		chart = ChartFactory.createXYLineChart("Cumulative Distribution Function", "Time", "Probability", densityDataset, PlotOrientation.VERTICAL, true, true, true);
		XYPlot plot = (XYPlot)chart.getPlot();
		
		plot.getRangeAxis().setAutoRange(true);
		plot.getRenderer().setStroke(new BasicStroke(3));
	}
	
	protected XYSeries computeDensities(Histogram hist) {
		double sum = 0;
		XYSeries density;
		density = new XYSeries(hist.getTitle(),true,false);
		for (HistogramBucketInformation bucketInformation : hist.getBucketInformation()) {
			if (sum == 0) // is only executed the first time in the loop.
				density.add(bucketInformation.getValue(), sum);
			sum += bucketInformation.getProbability();
			if (sum != 0)
				density.add(bucketInformation.getValue() + hist.getBucketWidth(), sum);
//			if (sum == 1)
//				density.add(bucketInformation.getValue() + hist.getBucketWidth(), sum);
		}
		return density;
	}

}
