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
import de.uka.ipd.sdq.sensorframework.adapter.IAdapter;

public class JFreeChartTimeSeriesViewer extends AbstractJFreeChartChart implements ISeriesExporter {

	DefaultTableXYDataset dataset = new DefaultTableXYDataset();
	
	public JFreeChartTimeSeriesViewer(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	protected void initializeContextMenu(MenuManager menu_manager) {
		super.initializeContextMenu(menu_manager);
	    menu_manager.add(new CopyClipboardAsR(this));
	}
	
	protected void initChart() {
		chart = ChartFactory.createScatterPlot("Time Series", "#measurement", "time", dataset, PlotOrientation.VERTICAL, true, true, true);
	}

	public void setData(Collection<?> data){
		dataset.removeAllSeries();
		
		for (Object o : data) {
			XYSeries series = null;
			if (o instanceof IAdapter) {
				IAdapter adapter = (IAdapter) o;
				TimeSeries ts = (TimeSeries) adapter.getAdaptedObject(); 
				series = getSeries(ts);
			}				
			dataset.addSeries(series);
		}
		initChart();
		this.forceRedraw();
	}

	private XYSeries getSeries(TimeSeries ts) {
		XYSeries series = new XYSeries(ts.getLabel(),true, false);
		for (TimeSeriesEntity te : ts.getValues()){
			series.add(te.getXValue(), te.getYValue());
		}
		return series;
	}
	
	public XYSeries getSeries() {
		return dataset.getSeries(0);
	}
	
}
