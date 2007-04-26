package de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.jfree.chart.JFreeChart;

public abstract class AbstractJFreeChartChart extends Canvas {
	JFreeChart myChart = null;
	
	public AbstractJFreeChartChart(Composite parent, int style) {
		super(parent, style);
		final Graphics2DRenderer renderer = new Graphics2DRenderer();
		initChart();
		
		addPaintListener(new PaintListener() {

			public void paintControl(org.eclipse.swt.events.PaintEvent e) {
			    Point controlSize = ((Control) e.getSource()).getSize();

			    GC gc = e.gc; // gets the SWT graphics context from the event

			    renderer.prepareRendering(gc); // prepares the Graphics2D renderer

			    // gets the Graphics2D context and switch on the antialiasing
			    Graphics2D g2d = renderer.getGraphics2D();
			    
				if(myChart != null)
					myChart.draw(g2d, new Rectangle(0,0,controlSize.x,controlSize.y));
				else
					g2d.drawString("No data yet", 5, 20);
			    // now that we are done with Java 2D, renders Graphics2D operation
			    // on the SWT graphics context
			    renderer.render(gc);
			    
			  }
		});
	}
	
	protected abstract void initChart();
}
