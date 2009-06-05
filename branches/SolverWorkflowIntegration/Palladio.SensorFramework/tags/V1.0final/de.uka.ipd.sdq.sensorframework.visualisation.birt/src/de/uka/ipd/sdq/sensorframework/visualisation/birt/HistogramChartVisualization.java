/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.visualisation.birt;

import java.util.Collection;

import org.eclipse.birt.chart.device.IDeviceRenderer;
import org.eclipse.birt.chart.exception.ChartException;
//import org.eclipse.birt.chart.internal.log.DefaultLoggerImpl;
import org.eclipse.birt.chart.model.ChartWithAxes;
import org.eclipse.birt.chart.model.attribute.AxisType;
import org.eclipse.birt.chart.model.attribute.ChartDimension;
import org.eclipse.birt.chart.model.attribute.HorizontalAlignment;
import org.eclipse.birt.chart.model.attribute.IntersectionType;
import org.eclipse.birt.chart.model.attribute.LegendItemType;
import org.eclipse.birt.chart.model.attribute.NumberFormatSpecifier;
import org.eclipse.birt.chart.model.attribute.Position;
import org.eclipse.birt.chart.model.attribute.TextAlignment;
import org.eclipse.birt.chart.model.attribute.TickStyle;
import org.eclipse.birt.chart.model.attribute.VerticalAlignment;
import org.eclipse.birt.chart.model.attribute.impl.ColorDefinitionImpl;
import org.eclipse.birt.chart.model.attribute.impl.NumberFormatSpecifierImpl;
import org.eclipse.birt.chart.model.attribute.impl.TextAlignmentImpl;
import org.eclipse.birt.chart.model.component.Axis;
import org.eclipse.birt.chart.model.component.Series;
import org.eclipse.birt.chart.model.component.impl.SeriesImpl;
import org.eclipse.birt.chart.model.data.DataElement;
import org.eclipse.birt.chart.model.data.NumberDataSet;
import org.eclipse.birt.chart.model.data.SeriesDefinition;
import org.eclipse.birt.chart.model.data.impl.NumberDataElementImpl;
import org.eclipse.birt.chart.model.data.impl.NumberDataSetImpl;
import org.eclipse.birt.chart.model.data.impl.QueryImpl;
import org.eclipse.birt.chart.model.data.impl.SeriesDefinitionImpl;
import org.eclipse.birt.chart.model.impl.ChartWithAxesImpl;
import org.eclipse.birt.chart.model.layout.Legend;
import org.eclipse.birt.chart.model.type.impl.BarSeriesImpl;
import org.eclipse.birt.chart.util.PluginSettings;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.Histogram;
import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.HistogramBucketInformation;
import de.uka.ipd.sdq.sensorframework.adapter.IAdapter;
import de.uka.ipd.sdq.sensorframework.visualisation.actions.ConfigureBirtViewerAction;
import de.uka.ipd.sdq.sensorframework.visualisation.actions.ExportAsPNGAction;
import de.uka.ipd.sdq.sensorframework.visualisation.actions.ExportAsSVGAction;
import de.uka.ipd.sdq.sensorframework.visualisation.actions.IHistogramAccepter;
import de.uka.ipd.sdq.sensorframework.visualisation.actions.LoadCSVHistogram;

/**
 * @author admin
 * 
 */
public class HistogramChartVisualization implements IHistogramAccepter {

	private ChartWithAxes cwa;
	private Axis xAxisPrimary;
	private Axis yAxisPrimary;
	private ChartSwtViewer viewer;

	/**
	 * @param reportConf
	 */
	public HistogramChartVisualization(Composite parent) {
		IDeviceRenderer idr = null;
		final PluginSettings ps = PluginSettings.instance();

		createEmptyChart();
		addHistogram(new double[]{1,2,3,4}, new double[]{0.2,0.4,0.3999,0.11}, "Test");
		addHistogram(new double[]{1,2,3,4}, new double[]{0.1,0.3,0.5,0.11}, "Test");
	
		try {
			idr = ps.getDevice("dv.SWT");
			viewer = new ChartSwtViewer(parent, 0, idr, getChart());

			MenuManager menuManager = new MenuManager();
			Menu menu = menuManager.createContextMenu(viewer);
			menuManager.add(new ConfigureBirtViewerAction(getChart()));
			menuManager.add(new ExportAsSVGAction(cwa));
			menuManager.add(new ExportAsPNGAction(cwa));
			menuManager.add(new LoadCSVHistogram(this));
			viewer.setMenu(menu);

		} catch (ChartException pex) {
//			DefaultLoggerImpl.instance().log(pex);
			throw new RuntimeException(pex.getLocalizedMessage());
		}
	}

	public ChartWithAxes createEmptyChart() {
		createChart();
		initialisePlot();
		cwa.getTitle().getLabel().getCaption().setValue("Response Time Histogram");
		
		configureLegend();
		configureXAxis();
		configureYAxis();

		return cwa;
	}

	private void configureYAxis() {
		yAxisPrimary = cwa.getPrimaryOrthogonalAxis(xAxisPrimary);
		yAxisPrimary.getMajorGrid().setTickStyle(TickStyle.LEFT_LITERAL);
		yAxisPrimary.setType(AxisType.LINEAR_LITERAL);
		NumberFormatSpecifier nfs = NumberFormatSpecifierImpl.create();
		nfs.setFractionDigits(2);
		yAxisPrimary.setFormatSpecifier(nfs);
		
		DataElement de = NumberDataElementImpl.create(0);
		yAxisPrimary.getScale().setMin(de);
		yAxisPrimary.getTitle().getCaption().getFont().setSize(9);
		
		TextAlignment ta = TextAlignmentImpl.create();
		ta.setHorizontalAlignment(HorizontalAlignment.CENTER_LITERAL);
		ta.setVerticalAlignment(VerticalAlignment.CENTER_LITERAL);
		yAxisPrimary.getTitle().getCaption().getFont().setAlignment(ta);
		yAxisPrimary.getTitle().setVisible(true);
		yAxisPrimary.getTitle().getCaption().setValue("Probability");
	}

	private void configureXAxis() {
		xAxisPrimary = cwa.getPrimaryBaseAxes()[0];
		xAxisPrimary.setType(AxisType.LINEAR_LITERAL);
		xAxisPrimary.getMajorGrid().setTickStyle(TickStyle.BELOW_LITERAL);
		xAxisPrimary.getOrigin().setType(IntersectionType.VALUE_LITERAL);
		xAxisPrimary.getTitle().setVisible(false);

		NumberFormatSpecifier nfs = NumberFormatSpecifierImpl.create();
		nfs.setFractionDigits(0);
		xAxisPrimary.setFormatSpecifier(nfs);
	}

	private void configureLegend() {
		Legend lg = cwa.getLegend();
		lg.getText().getFont().setSize(12);
		lg.setItemType(LegendItemType.SERIES_LITERAL);
		lg.setPosition(Position.BELOW_LITERAL);
		lg.setVisible(true);
	}

	private void initialisePlot() {
		cwa.getBlock().setBackground(ColorDefinitionImpl.WHITE());
		cwa.getBlock().getOutline().setVisible(true);
		cwa.getPlot().getClientArea().setBackground(ColorDefinitionImpl.WHITE());
		cwa.getPlot().getOutline().setVisible(false);
		cwa.getPlot().setHorizontalSpacing(0);
		cwa.getPlot().setVerticalSpacing(0);
	}

	private void createChart() {
		cwa = ChartWithAxesImpl.create();
		cwa.setType("Bar Chart");
		cwa.setSubType("Stacked");
		cwa.setUnits("s");
		cwa.setDimension(ChartDimension.TWO_DIMENSIONAL_WITH_DEPTH_LITERAL);
		// cwa.setUnitSpacing(0.0);
	}

	public void initChart(Collection<IAdapter> adapters) {
		xAxisPrimary.getSeriesDefinitions().clear();
		yAxisPrimary.getSeriesDefinitions().clear();
		
		for (IAdapter histAdapter : adapters) {
			Histogram hist = (Histogram) histAdapter.getAdaptedObject();
			double[] values = new double[hist.getBucketInformation().size()];
			double[] probabilities = new double[hist.getBucketInformation().size()];
			int i = 0;
			for (HistogramBucketInformation e : hist.getBucketInformation()) {
				values[i] = e.getValue();
				probabilities[i] = e.getProbability();
				i++;
			}
			addHistogram(values, probabilities, hist.getTitle());
		}
		viewer.redraw();
	}

	@SuppressWarnings("unchecked")
	private SeriesDefinition createYSeries(double[] values, String label) {
		NumberDataSet orthovalues = NumberDataSetImpl.create(values);

		Series series = BarSeriesImpl.create();
		series.setDataSet(orthovalues);
		series.setSeriesIdentifier(label);
		series.getDataDefinition().add(QueryImpl.create(""));
		series.getLabel().getCaption().setValue(label);
		series.getLabel().setVisible(false);
		series.setStacked(true);
		
		SeriesDefinition sdY = SeriesDefinitionImpl.create();
		sdY.getSeriesPalette().update(ColorDefinitionImpl.BLUE());
		sdY.setQuery(QueryImpl.create(""));
		sdY.getSeries().add(series);
		
		return sdY;
	}

	@SuppressWarnings("unchecked")
	private SeriesDefinition createXSeries(double[] seriesData) {
		NumberDataSet categoryValues = NumberDataSetImpl.create(seriesData);
		
		Series seCategory = SeriesImpl.create();
		seCategory.setDataSet(categoryValues);
		seCategory.getDataDefinition().add(QueryImpl.create(""));
		
		SeriesDefinition sdX = SeriesDefinitionImpl.create();
		sdX.getSeriesPalette().update(0);
		sdX.getSeries().add(seCategory);
		sdX.setQuery(QueryImpl.create(""));

		return sdX;
	}

	@SuppressWarnings("unchecked")
	private void addHistogram(double[] values, double[] probabilities, String label) {
		SeriesDefinition sdX = createXSeries(values);
		xAxisPrimary.getSeriesDefinitions().add(sdX);

		SeriesDefinition sdY = createYSeries(probabilities,label);
		yAxisPrimary.getSeriesDefinitions().add(sdY);
	}
	
	/**
	 * @return the cwa
	 */
	public ChartWithAxes getChart() {
		return cwa;
	}

	@Override
	public void addHistogram(Histogram histogram) {
		double[] values = new double[histogram.getBucketInformation().size()];
		double[] probabilities = new double[histogram.getBucketInformation().size()];
		int i = 0;
		for (HistogramBucketInformation e : histogram.getBucketInformation()) {
			values[i] = e.getValue();
			probabilities[i] = e.getProbability();
			i++;
		}
		addHistogram(values, probabilities, histogram.getTitle());
		viewer.redraw();
	}
}
