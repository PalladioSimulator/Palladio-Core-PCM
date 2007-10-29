package de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation;

import java.awt.BasicStroke;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.widgets.Composite;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.Histogram;
import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.HistogramEntity;


public class JFreeChartCDFViewer extends AbstractJFreeChartWidthViewer implements IHistogramAccepter {
	

	public JFreeChartCDFViewer(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	protected void initializeContextMenu(MenuManager menu_manager) {
		super.initializeContextMenu(menu_manager);
	    menu_manager.add(new LoadCSVHistogram(this));
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation.IHistogramAccepter#addHistogram(de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.Histogram)
	 */
	public void addHistogram(Histogram histogram) {
		XYSeries density = new XYSeries(histogram.getLabel(),true,false);
		double sum = 0;
		for (HistogramEntity e : histogram.getEntityList()) {
			sum += e.getProbability();
			density.add(e.getValue(), sum);
		}
		densityDataset.addSeries(density);
		initChart();
		this.redraw();
	}


	@SuppressWarnings("deprecation")
	protected void initChart() {
		this.chart = ChartFactory.createXYLineChart("CDF", "Time", "Probability", densityDataset, PlotOrientation.VERTICAL, true, true, true);

		XYPlot plot = (XYPlot)chart.getPlot();
		plot.getRangeAxis().setAutoRange(true);
		plot.getRenderer().setStroke(new BasicStroke(3));
	}
	
	protected XYSeries computeDensities(Histogram hist) {
		double sum = 0;
		XYSeries density;
		density = new XYSeries(hist.getLabel(),true,false);
		for (HistogramEntity e : hist.getEntityList()) {
			sum += e.getProbability();
			density.add(e.getValue(), sum);
		}
		return density;
	}

}
