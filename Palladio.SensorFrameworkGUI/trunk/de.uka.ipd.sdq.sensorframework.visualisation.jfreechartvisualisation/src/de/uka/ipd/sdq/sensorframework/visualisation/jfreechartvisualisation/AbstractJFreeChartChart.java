package de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

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
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.Histogram;

class SaveImageAsAction extends Action {


	private AbstractJFreeChartChart chartViewer;

	public SaveImageAsAction(AbstractJFreeChartChart abstractJFreeChartChart) {
		super();
		setText("Save Chart as PNG...");
		this.chartViewer = abstractJFreeChartChart;
	}
	
	@Override
	public void run() {
		FileDialog dialog = new FileDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
		dialog.setFilterExtensions(new String[]{"*.png"});
		dialog.setText("Enter the image file name");
		dialog.open();
		if (dialog.getFileName() != null){
			String filename = dialog.getFilterPath()+File.separator+dialog.getFileName();
			File f = new File(filename);
			JFreeChart chart = chartViewer.getChart();
			try {
				ChartUtilities.saveChartAsPNG(f, chart, chartViewer.getBounds().width, chartViewer.getBounds().height);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public abstract class AbstractJFreeChartChart extends Canvas {
	JFreeChart myChart = null;
	
	public AbstractJFreeChartChart(Composite parent, int style) {
		super(parent, style);
		final Graphics2DRenderer renderer = new Graphics2DRenderer();
		initChart();

		MenuManager menu_manager = new MenuManager();
	    this.setMenu(menu_manager.createContextMenu(this));

	    initializeContextMenu(menu_manager);
	    
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
	
	public JFreeChart getChart() {
		return myChart;
	}

	protected void initializeContextMenu(MenuManager menu_manager) {
		menu_manager.add(new SaveImageAsAction(this));
	}

	protected abstract void initChart();
}
