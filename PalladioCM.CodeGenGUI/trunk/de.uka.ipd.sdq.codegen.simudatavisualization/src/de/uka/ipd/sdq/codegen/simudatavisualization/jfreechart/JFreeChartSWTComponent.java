package de.uka.ipd.sdq.codegen.simudatavisualization.jfreechart;

import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.PaintEvent;
import java.awt.geom.Rectangle2D;

import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.DefaultTableXYDataset;
import org.jfree.data.xy.XYSeries;

import de.uka.ipd.sdq.sensorframework.adapter.TimeSpanSensorToDatasetAdapterFactory;

public class JFreeChartSWTComponent extends Canvas {

	public JFreeChartSWTComponent(Composite parent, int style) {
		super(parent, style);
		final Graphics2DRenderer renderer = new Graphics2DRenderer();

		XYSeries density = new XYSeries("Series1",true,false);
		density.add(1, 1);
		density.add(2,3);

		DefaultTableXYDataset densityDataset=new DefaultTableXYDataset();
		densityDataset.addSeries(density);
		densityDataset.setIntervalWidth(TimeSpanSensorToDatasetAdapterFactory.HISTOGRAM_CLASS_WIDTH);
	    
		final JFreeChart myChart = ChartFactory.createHistogram("Histogram","Time [s]","Probability", densityDataset,PlotOrientation.VERTICAL,true,true,true);

		XYPlot plot = (XYPlot)myChart.getPlot();
		plot.getRangeAxis().setAutoRange(true);
		plot.setForegroundAlpha(0.8f); // for transparency
		
		
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

}
