package de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation;

import java.awt.BasicStroke;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.PaintEvent;
import java.awt.geom.Rectangle2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

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
import de.uka.ipd.sdq.sensorfactory.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorfactory.entities.Measurement;
import de.uka.ipd.sdq.sensorfactory.entities.TimeSpanMeasurement;
import de.uka.ipd.sdq.sensorframework.adapter.IAdapter;


public class JFreeChartCDFViewer extends AbstractJFreeChartChart implements IHistogramAccepter {
	

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

	DefaultTableXYDataset densityDataset=new DefaultTableXYDataset();

	protected void initChart() {
		this.chart = ChartFactory.createXYLineChart("CDF", "Time", "Probability", densityDataset, PlotOrientation.VERTICAL, true, true, true);

		XYPlot plot = (XYPlot)chart.getPlot();
		plot.getRangeAxis().setAutoRange(true);
		plot.getRenderer().setStroke(new BasicStroke(3));
	}

	public void setCDFs(Collection data){
		densityDataset.removeAllSeries();
		
		for (Object o : data) {
			XYSeries density = null;
			if (o instanceof IAdapter) {
				IAdapter histAdapter = (IAdapter) o;
				double sum = 0;
				Histogram hist = (Histogram) histAdapter.getAdaptedObject();
				density = new XYSeries(hist.getLabel(),true,false);
				for (HistogramEntity e : hist.getEntityList()) {
					sum += e.getProbability();
					density.add(e.getValue(), sum);
				} 
			} else if (o instanceof SensorAndMeasurements) {
				SensorAndMeasurements sam = (SensorAndMeasurements) o;
				double sum = 0;
				density = new XYSeries(sam.getSensor().getSensorName(),true,false);
				double[] values = new double[sam.getMeasurements().size()]; int i = 0;
				for (Measurement m : sam.getMeasurements()) {
					TimeSpanMeasurement tsm = (TimeSpanMeasurement) m;
					values[i] = tsm.getTimeSpan();
					i++;
				} 
				Arrays.sort(values);
				for (i=0; i<values.length;)	{
					int j = i+1;
					while (j < values.length && values[i]==values[j])
						j++;
					density.add(values[i], ((double)j) / values.length);
					i=j;
				}
			}
			densityDataset.addSeries(density);
		}
		initChart();
		this.forceRedraw();
	}
}
