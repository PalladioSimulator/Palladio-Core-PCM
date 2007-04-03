package de.uka.ipd.sdq.codegen.simudatavisualization.jfreechart;

import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.PaintEvent;
import java.awt.geom.Rectangle2D;
import java.util.Collection;

import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.DefaultTableXYDataset;
import org.jfree.data.xy.XYSeries;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.Histogram;
import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.HistogramEntity;
import de.uka.ipd.sdq.sensorframework.adapter.IAdapter;

public class JFreeChartHistogramViewer extends Canvas {

	DefaultTableXYDataset densityDataset=new DefaultTableXYDataset();
	JFreeChart myChart = null;
	
	public JFreeChartHistogramViewer(Composite parent, int style) {
		super(parent, style);
		final Graphics2DRenderer renderer = new Graphics2DRenderer();
		
		//TODO: densityDataset.setIntervalWidth(TimeSpanSensorToDatasetAdapterFactory.HISTOGRAM_CLASS_WIDTH);
	    
		initChart();
		
		addPaintListener(new PaintListener() {

			@Override
			public void paintControl(org.eclipse.swt.events.PaintEvent e) {
			    Point controlSize = ((Control) e.getSource()).getSize();

			    GC gc = e.gc; // gets the SWT graphics context from the event

			    renderer.prepareRendering(gc); // prepares the Graphics2D renderer

			    // gets the Graphics2D context and switch on the antialiasing
			    Graphics2D g2d = renderer.getGraphics2D();
			    
				myChart.draw(g2d, new Rectangle(0,0,controlSize.x,controlSize.y));
				
			    // now that we are done with Java 2D, renders Graphics2D operation
			    // on the SWT graphics context
			    renderer.render(gc);
			  }
		});
	}

	private void initChart() {
		myChart = ChartFactory.createHistogram("Histogram","Time [s]","Probability", densityDataset,PlotOrientation.VERTICAL,true,true,true);

		XYPlot plot = (XYPlot)myChart.getPlot();
		plot.getRangeAxis().setAutoRange(true);
		plot.setForegroundAlpha(0.8f); // for transparency
	}

	public void setHistograms(Collection<IAdapter> data){
		densityDataset.removeAllSeries();
		
		for (IAdapter histAdapter : data) {
			Histogram hist = (Histogram) histAdapter.getAdaptedObject();
			XYSeries density = new XYSeries(hist.getLabel(),true,false);
			for (HistogramEntity e : hist.getEntityList())
				density.add(e.getValue(), e.getProbability());
			densityDataset.addSeries(density);
		}
		initChart();
		this.redraw();
	}
}
