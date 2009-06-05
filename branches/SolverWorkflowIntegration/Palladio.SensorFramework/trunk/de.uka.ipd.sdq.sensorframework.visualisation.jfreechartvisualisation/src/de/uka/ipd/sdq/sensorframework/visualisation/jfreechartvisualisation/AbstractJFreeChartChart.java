package de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation;

import java.awt.Color;
import java.awt.Paint;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Collection;

import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.PlatformUI;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.title.LegendTitle;
import org.jfree.experimental.chart.swt.ChartComposite;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

class SaveImageAsAction extends Action {


	private AbstractJFreeChartChart<?> chartViewer;

	public SaveImageAsAction(AbstractJFreeChartChart<?> abstractJFreeChartChart) {
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

class ToggleLegendAction extends Action {


	private AbstractJFreeChartChart<?> chartViewer;
	private LegendTitle chartLegend;

	public ToggleLegendAction(AbstractJFreeChartChart<?> abstractJFreeChartChart) {
		super();
		setText("Enable/Disable Legend");
		this.chartViewer = abstractJFreeChartChart;
		this.chartLegend = null;
	}
	
	@Override
	public void run() {
		if (chartLegend == null) {
			chartLegend = this.chartViewer.getChart().getLegend();
			this.chartViewer.getChart().removeLegend();
		} else {
			this.chartViewer.getChart().addLegend(chartLegend);
			chartLegend = null;
		}
		this.chartViewer.forceRedraw();
	}
}

class SaveSVGAsAction extends Action {


	private AbstractJFreeChartChart<?> chartViewer;

	public SaveSVGAsAction(AbstractJFreeChartChart<?> abstractJFreeChartChart) {
		super();
		setText("Save Chart as SVG...");
		this.chartViewer = abstractJFreeChartChart;
	}
	
	@Override
	public void run() {
		FileDialog dialog = new FileDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
		dialog.setFilterExtensions(new String[]{"*.svg"});
		dialog.setText("Enter the image file name");
		dialog.open();
		if (dialog.getFileName() != null){
			String filename = dialog.getFilterPath()+File.separator+dialog.getFileName();
			File f = new File(filename);
			JFreeChart chart = chartViewer.getChart();
			try {
				DOMImplementation domI = new GenericDOMImplementation();
				Document doc = domI.createDocument(null, "svg", null);
				SVGGraphics2D svgRenderer = new SVGGraphics2D(doc);
				Paint p = chart.getBackgroundPaint();
				chart.setBackgroundPaint(new Color(0, 0, 0, 0));
				chart.draw(svgRenderer, new Rectangle(0,0,640,480));
				chart.setBackgroundPaint(p);
				Writer out = new OutputStreamWriter(new FileOutputStream(f),"UTF-8");
				svgRenderer.stream(out,true);
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

public abstract class AbstractJFreeChartChart<T> extends ChartComposite {
	protected JFreeChart chart;
	
	@Override
	protected Menu createPopupMenu(boolean arg0, boolean arg1, boolean arg2,
			boolean arg3) {
		Menu parentMenu = super.createPopupMenu(arg0, arg1, arg2, arg3);
		MenuManager menu_manager = new MenuManager("Additional Functions");
	    initializeContextMenu(menu_manager);
	    menu_manager.fill(parentMenu,SWT.NONE);
	    return parentMenu;
	}

	public AbstractJFreeChartChart(Composite parent, int style) {
		super(parent, style);
		// final Graphics2DRenderer renderer = new Graphics2DRenderer();
		initChart();

//	    
//		addPaintListener(new PaintListener() {
//
//			public void paintControl(org.eclipse.swt.events.PaintEvent e) {
//			    Point controlSize = ((Control) e.getSource()).getSize();
//
//			    GC gc = e.gc; // gets the SWT graphics context from the event
//
//			    renderer.prepareRendering(gc); // prepares the Graphics2D renderer
//
//			    // gets the Graphics2D context and switch on the antialiasing
//			    Graphics2D g2d = renderer.getGraphics2D();
//			    
//				if(myChart != null)
//					myChart.draw(g2d, new Rectangle(0,0,controlSize.x,controlSize.y));
//				else
//					g2d.drawString("No data yet", 5, 20);
//			    // now that we are done with Java 2D, renders Graphics2D operation
//			    // on the SWT graphics context
//			    renderer.render(gc);
//			    
//			  }
//		});
	}
	
	protected void initializeContextMenu(MenuManager menu_manager) {
		menu_manager.add(new ToggleLegendAction(this));
		menu_manager.add(new SaveImageAsAction(this));
		menu_manager.add(new SaveSVGAsAction(this));
	}

	protected abstract void initChart();
	
	public abstract void setData(Collection<T> data);
	
}
