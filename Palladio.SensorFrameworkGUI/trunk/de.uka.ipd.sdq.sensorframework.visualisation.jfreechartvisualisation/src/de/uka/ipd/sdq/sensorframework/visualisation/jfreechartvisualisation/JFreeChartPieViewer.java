package de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation;

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
import org.jfree.data.category.CategoryToPieDataset;
import org.jfree.data.general.DefaultKeyedValueDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.xy.DefaultTableXYDataset;
import org.jfree.data.xy.XYSeries;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.Histogram;
import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.HistogramEntity;
import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.Pie;
import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.PieEntity;
import de.uka.ipd.sdq.sensorframework.adapter.IAdapter;

public class JFreeChartPieViewer extends AbstractJFreeChartChart {

	DefaultPieDataset pieDataset=null;
	
	public JFreeChartPieViewer(Composite parent, int style) {
		super(parent, style);
	}

	protected void initChart() {
		if(pieDataset != null)
			chart = ChartFactory.createPieChart3D("Pie", pieDataset, true, true, true);
		else
			chart = ChartFactory.createPieChart3D("Pie", new DefaultPieDataset(), true, true, true);
	}

	public void setPie(Pie data){
		pieDataset = new DefaultPieDataset();
		for (PieEntity pe : data.getEntities()){
			pieDataset.setValue(pe.getLabel(), pe.getValue());
		}
		initChart();
		chart.setTitle(data.getLabel());
		this.forceRedraw();
	}
}
