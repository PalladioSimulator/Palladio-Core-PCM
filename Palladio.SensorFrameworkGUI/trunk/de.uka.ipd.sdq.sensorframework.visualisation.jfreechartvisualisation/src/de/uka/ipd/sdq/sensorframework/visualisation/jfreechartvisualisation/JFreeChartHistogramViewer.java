package de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation;

import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.PaintEvent;
import java.awt.geom.Rectangle2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collection;
import java.util.Properties;
import java.util.Vector;

import org.eclipse.jface.action.AbstractAction;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.PlatformUI;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.DefaultTableXYDataset;
import org.jfree.data.xy.XYSeries;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.Histogram;
import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.HistogramEntity;
import de.uka.ipd.sdq.sensorframework.adapter.IAdapter;


public class JFreeChartHistogramViewer extends AbstractJFreeChartChart 
	implements IHistogramAccepter {
	

	public JFreeChartHistogramViewer(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	protected void initializeContextMenu(MenuManager menu_manager) {
		super.initializeContextMenu(menu_manager);
	    menu_manager.add(new LoadCSVHistogram(this));
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

	DefaultTableXYDataset densityDataset=new DefaultTableXYDataset();
	private double histogramWidth;
	private Collection<IAdapter> lastData = new Vector<IAdapter>();

	protected void initChart() {
		JFreeChart chart = ChartFactory.createHistogram("Histogram","Time [s]","Probability", densityDataset,PlotOrientation.VERTICAL,true,true,true);

		XYPlot plot = (XYPlot)chart.getPlot();
		plot.getRangeAxis().setAutoRange(true);
		plot.setForegroundAlpha(0.8f); // for transparency
		this.setChart(chart);
	}

	public static final String HISTOGRAM_WIDTH = "HISTOGRAM_WIDTH";

	public void setHistograms(Collection<IAdapter> data){
		densityDataset.removeAllSeries();
		
		for (IAdapter histAdapter : data) {
			Properties p = new Properties();
			p.put(HISTOGRAM_WIDTH, histogramWidth);
			histAdapter.setProperties(p);
			Histogram hist = (Histogram) histAdapter.getAdaptedObject();
			XYSeries density = new XYSeries(hist.getLabel(),true,false);
			for (HistogramEntity e : hist.getEntityList())
				density.add(e.getValue(), e.getProbability());
			densityDataset.addSeries(density);
		}
		densityDataset.setAutoWidth(true);
		initChart();
		this.forceRedraw();
		lastData  = data;
	}

	public void setHistogramWidth(double width) {
		this.histogramWidth = width;
		setHistograms(lastData);
	}
}
