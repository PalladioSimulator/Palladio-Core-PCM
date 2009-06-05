package de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation;

import java.util.Collection;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.widgets.Composite;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.DefaultTableXYDataset;
import org.jfree.data.xy.XYSeries;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.TimeSeries;
import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.TimeSeriesEntity;

public class JFreeChartTimeSeriesViewer extends AbstractJFreeChartChart<TimeSeries> implements ISeriesExporter {

	DefaultTableXYDataset dataset = new DefaultTableXYDataset();
	
	public JFreeChartTimeSeriesViewer(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	protected void initializeContextMenu(MenuManager menu_manager) {
		super.initializeContextMenu(menu_manager);
	    menu_manager.add(new ExportCSV(this));
		menu_manager.add(new CopyClipboardAsR(this));
	}
	
	protected void initChart() {
		chart = ChartFactory.createScatterPlot("Time Series", "Number of Measurement", "Time", dataset, PlotOrientation.VERTICAL, true, true, true);
	}

	public void setData(Collection<TimeSeries> data){
		dataset.removeAllSeries();
		
		for (TimeSeries timeSeries : data)
			dataset.addSeries(getSeries(timeSeries));
		initChart();
		this.setChart(chart);
		this.forceRedraw();
	}

	private XYSeries getSeries(TimeSeries ts) {
		XYSeries series = new XYSeries(ts.getLabel(),true, false);
		// patched to show ascending number of measurements, starting by 1
		long number = 1;
		for (TimeSeriesEntity te : ts.getValues()) {
			//series.add(te.getXValue(), te.getYValue());
			series.add(number++, te.getYValue());
		}
		return series;
	}
	
	public XYSeries getSeries() {
		return dataset.getSeries(0);
	}
	
}
