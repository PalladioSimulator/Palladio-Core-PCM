package de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation;

import java.text.DecimalFormat;
import java.util.Collection;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.widgets.Composite;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.TickUnits;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.DefaultTableXYDataset;
import org.jfree.data.xy.XYSeries;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.TimeSeries;
import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.TimeSeriesEntity;

public class JFreeChartTimeSeriesViewer extends
		AbstractJFreeChartChart<TimeSeries> implements ISeriesExporter {

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
		chart = ChartFactory.createScatterPlot(
				"Time Series",
				"Number of Measurement", 
				"Time", 
				dataset,
				PlotOrientation.VERTICAL, 
				true, 
				true, 
				true);
		NumberAxis yAxis = (NumberAxis) chart.getXYPlot().getRangeAxis();
		yAxis.setAutoRangeIncludesZero(false);
		// adjusted to work with values with an accuracy of tick units (y-Axis
		// labels) of up to 1e-16.
		yAxis.setAutoRangeMinimumSize(1e-16);
		yAxis.setStandardTickUnits(createAdvancedTickUnits());
	}

	/**
	 * Creates an advanced version of tick units. Works with up to 16 digits.
	 * Necessary to enable ticks by the auto range feature for values like 1/3.
	 * 
	 * @return
	 */
	private static final TickUnitSource createAdvancedTickUnits() {
		TickUnits tu = (TickUnits) NumberAxis.createStandardTickUnits();
		DecimalFormat df16 = new DecimalFormat("0.0000000000000000");
		DecimalFormat df15 = new DecimalFormat("0.000000000000000");
		DecimalFormat df14 = new DecimalFormat("0.00000000000000");
		DecimalFormat df13 = new DecimalFormat("0.0000000000000");
		DecimalFormat df12 = new DecimalFormat("0.000000000000");
		DecimalFormat df11 = new DecimalFormat("0.00000000000");
		DecimalFormat df10 = new DecimalFormat("0.0000000000");
		DecimalFormat df9 = new DecimalFormat("0.000000000");
		DecimalFormat df8 = new DecimalFormat("0.00000000");

		tu.add(new NumberTickUnit(0.0000000000000001, df16));
		tu.add(new NumberTickUnit(0.000000000000001, df15));
		tu.add(new NumberTickUnit(0.00000000000001, df14));
		tu.add(new NumberTickUnit(0.0000000000001, df13));
		tu.add(new NumberTickUnit(0.000000000001, df12));
		tu.add(new NumberTickUnit(0.00000000001, df11));
		tu.add(new NumberTickUnit(0.0000000001, df10));
		tu.add(new NumberTickUnit(0.000000001, df9));
		tu.add(new NumberTickUnit(0.00000001, df8));

		tu.add(new NumberTickUnit(0.0000000000000005, df16));
		tu.add(new NumberTickUnit(0.000000000000005, df15));
		tu.add(new NumberTickUnit(0.00000000000005, df14));
		tu.add(new NumberTickUnit(0.0000000000005, df13));
		tu.add(new NumberTickUnit(0.000000000005, df12));
		tu.add(new NumberTickUnit(0.00000000005, df11));
		tu.add(new NumberTickUnit(0.0000000005, df10));
		tu.add(new NumberTickUnit(0.000000005, df9));
		tu.add(new NumberTickUnit(0.00000005, df8));

		tu.add(new NumberTickUnit(0.0000000000000025, df16));
		tu.add(new NumberTickUnit(0.000000000000025, df15));
		tu.add(new NumberTickUnit(0.00000000000025, df14));
		tu.add(new NumberTickUnit(0.0000000000025, df13));
		tu.add(new NumberTickUnit(0.000000000025, df12));
		tu.add(new NumberTickUnit(0.00000000025, df11));
		tu.add(new NumberTickUnit(0.0000000025, df10));
		tu.add(new NumberTickUnit(0.000000025, df9));

		return tu;
	}

	public void setData(Collection<TimeSeries> data){
		dataset.removeAllSeries();
		
		for (TimeSeries timeSeries : data){
			if(timeSeries==null){
				System.err.println("JFreeChartTimeSeries: found null TimeSeries in data supplied to setData");
			}else{
				dataset.addSeries(getSeries(timeSeries));
			}
		}
		initChart();
		this.setChart(chart);
		this.forceRedraw();
	}

	private XYSeries getSeries(TimeSeries ts) {
		String label;
		if(ts.getLabel()==null){
			label = "Time Series Label";//TODO
		}else{
			label = ts.getLabel();
		}
		XYSeries series = new XYSeries(label,true, false);
		// patched to show ascending number of measurements, starting by 1
		long number = 1;
		for (TimeSeriesEntity te : ts.getValues()) {
			if(te==null){
				System.err.println("JFreeChartTimeSeries: found null TimeSeriesEntity in TimeSeries supplied to getSeries");
			}else{
				//series.add(te.getXValue(), te.getYValue());
				series.add(number++/*instead of x-value which would be the real time*/, te.getYValue());
			}
		}
		return series;
	}

	public XYSeries getSeries() {
		return dataset.getSeries(0);
	}

}
