/**
 * 
 */
package de.uka.ipd.sdq.edp2.visualization.inputs;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.measure.Measure;
import javax.measure.quantity.Quantity;

import org.eclipse.ui.IMemento;
import org.jfree.chart.ChartColor;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.DefaultXYItemRenderer;
import org.jfree.data.xy.DefaultXYDataset;

import de.uka.ipd.sdq.edp2.OrdinalMeasurementsDao;
import de.uka.ipd.sdq.edp2.impl.MeasurementsUtility;
import de.uka.ipd.sdq.edp2.impl.MetricDescriptionUtility;
import de.uka.ipd.sdq.edp2.models.ExperimentData.BaseMetricDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.CaptureType;
import de.uka.ipd.sdq.edp2.models.ExperimentData.DataSeries;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MetricDescription;
import de.uka.ipd.sdq.edp2.visualization.AbstractDataSource;
import de.uka.ipd.sdq.edp2.visualization.IDataSink;
import de.uka.ipd.sdq.edp2.visualization.datasource.ElementFactory;
import de.uka.ipd.sdq.edp2.visualization.editors.JFreeChartEditorInput;
import de.uka.ipd.sdq.edp2.visualization.util.DefaultUnitSwitch;

/**
 * Input for {@link ScatterPlotEditor} .
 * 
 * @author Dominik Ernst, Roland Richter
 */
public class ScatterPlotInput extends JFreeChartEditorInput<DefaultXYDataset> {

	/**
	 * Name constant, which is used to identify this class in properties.
	 */
	private static final String ELEMENT_NAME = "ScatterPlotInput";
	public static final String DOMAIN_AXIS_LABEL_KEY = "domainAxisLabel";
	public static final String RANGE_AXIS_LABEL_KEY = "rangeAxisLabel";
	public static final String SHOW_RANGE_AXIS_LABEL_KEY = "showRangeAxisLabel";
	public static final String SHOW_DOMAIN_AXIS_LABEL_KEY = "showDomainAxisLabel";

	/**
	 * Logger for this class.
	 */
	private final static Logger logger = Logger
			.getLogger(ScatterPlotInput.class.getCanonicalName());

	/**
	 * The data provided by this {@link JFreeChartEditorInput}
	 */
	private double[][] rawData;

	private JFreeChart chart;

	/**
	 * Label for the number axis (= horizontal axis)
	 */
	private String domainAxisLabel;

	/**
	 * Label for the range axis (= vertical axis)
	 */
	private String rangeAxisLabel;

	/**
	 * Show different labels?
	 */
	private boolean showRangeAxisLabel;
	private boolean showDomainAxisLabel;

	private DefaultXYItemRenderer renderer;

	public ScatterPlotInput() {
		this(null);
	}

	public ScatterPlotInput(AbstractDataSource source) {
		setShowDomainAxisLabel(true);
		setShowRangeAxisLabel(true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.uka.ipd.sdq.edp2.models.ExperimentData.presentation.IDataSink#canAccept
	 * (de.uka.ipd.sdq.edp2.models.ExperimentData.presentation.IDataSource)
	 */
	@Override
	public boolean canAccept(AbstractDataSource source) {
		BaseMetricDescription[] mds = MetricDescriptionUtility
				.toBaseMetricDescriptions(source.getOutput().get(0)
						.getRawMeasurements().getMeasurementsRange()
						.getMeasurements().getMeasure().getMetric());
		boolean allDataNumeric = true;
		for (BaseMetricDescription md : mds) {
			if (!(md.getCaptureType().equals(CaptureType.INTEGER_NUMBER) || md
					.getCaptureType().equals(CaptureType.REAL_NUMBER))) {
				allDataNumeric = false;
			}
		}
		return allDataNumeric && source.getOutput().size() == 2;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seede.uka.ipd.sdq.edp2.models.ExperimentData.presentation.IDataSink#
	 * getMetricRoles()
	 */
	@Override
	public ArrayList<MetricDescription> getMetricRoles() {
		throw new RuntimeException("Not implemented!");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IPersistableElement#getFactoryId()
	 */
	@Override
	public String getFactoryId() {
		return ScatterPlotInputFactory.getFactoryId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IPersistable#saveState(org.eclipse.ui.IMemento)
	 */
	@Override
	public void saveState(IMemento memento) {
		ScatterPlotInputFactory.saveState(memento, this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.edp2.visualization.IDataFlow#getProperties()
	 */
	@Override
	public HashMap<String, Object> getProperties() {
		properties.put(ElementFactory.ELEMENT_KEY, ELEMENT_NAME);
		properties.put(RANGE_AXIS_LABEL_KEY, getRangeAxisLabel());
		properties.put(DOMAIN_AXIS_LABEL_KEY, getDomainAxisLabel());
		properties.put(SHOW_DOMAIN_AXIS_LABEL_KEY,
				String.valueOf(isShowDomainAxisLabel()));
		properties.put(SHOW_RANGE_AXIS_LABEL_KEY,
				String.valueOf(isShowRangeAxisLabel()));
		properties.put(COLOR_KEY, getColor());
		return properties;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.uka.ipd.sdq.edp2.visualization.IDataFlow#setProperties(java.util.HashMap
	 * )
	 */
	@Override
	public void setProperties(HashMap<String, Object> newProperties) {
		if (newProperties.get(COLOR_KEY) != null)
			setColor(newProperties.get(COLOR_KEY).toString());
		if (newProperties.get(RANGE_AXIS_LABEL_KEY) != null) {
			setRangeAxisLabel(newProperties.get(RANGE_AXIS_LABEL_KEY)
					.toString());
		}
		if (newProperties.get(DOMAIN_AXIS_LABEL_KEY) != null) {
			setDomainAxisLabel(newProperties.get(DOMAIN_AXIS_LABEL_KEY)
					.toString());
		}
		if (newProperties.get(SHOW_DOMAIN_AXIS_LABEL_KEY) != null) {
			setShowDomainAxisLabel(Boolean.parseBoolean(newProperties.get(
					SHOW_DOMAIN_AXIS_LABEL_KEY).toString()));
		}
		if (newProperties.get(SHOW_RANGE_AXIS_LABEL_KEY) != null) {
			setShowRangeAxisLabel(Boolean.parseBoolean(newProperties.get(
					SHOW_RANGE_AXIS_LABEL_KEY).toString()));
		}
	}

	@Override
	public JFreeChart getChart() {
		NumberAxis domainAxis = new NumberAxis(
				isShowDomainAxisLabel() ? getDomainAxisLabel() : null);
		NumberAxis rangeAxis = new NumberAxis(
				isShowRangeAxisLabel() ? getRangeAxisLabel() : null);

		dataset = new DefaultXYDataset();
		// add all inputs anew
		// assume that if the getChart()-Method of this input is called, the
		// remaining inputs have the same type of data
		for (int i = 0; i < getHandle().getInputsSize(); i++) {
			dataset.addSeries(getHandle().getInputs().get(i).getInputName(),
					(double[][]) getHandle().getInputs().get(i).getData());
		}
		XYPlot plot = new XYPlot();
		plot.setDataset(getDataset());

		// the renderer for the chart
		renderer = new DefaultXYItemRenderer();
		plot.setRenderer(renderer);
		plot.setRangeAxis(rangeAxis);
		plot.setDomainAxis(domainAxis);

		// modifiy the colors of the data series, if there are persisted color
		// properties
		for (int i = 0; i < getHandle().getInputsSize(); i++) {
			float alpha = Float.parseFloat(getHandle().getInputProperties()[i]
					.get(JFreeChartEditorInput.ALPHA_KEY).toString());
			if ((getHandle().getInputProperties()[i]
					.get(JFreeChartEditorInput.COLOR_KEY) != null)
					&& !getHandle().getInputProperties()[i]
							.get(JFreeChartEditorInput.COLOR_KEY).toString()
							.equals(NO_COLOR)) {
				Color opaque = Color.decode(getHandle().getInputProperties()[i]
						.get(JFreeChartEditorInput.COLOR_KEY).toString());

				float[] comp = opaque.getRGBColorComponents(null);
				Color col = new Color(comp[0], comp[1], comp[2], alpha);
				renderer.setSeriesPaint(i, col);
			} else {
				Color defaultColor = (Color) ChartColor
						.createDefaultPaintArray()[i];
				float[] comp = defaultColor.getRGBColorComponents(null);
				Color col = new Color(comp[0], comp[1], comp[2], alpha);
				renderer.setSeriesPaint(i, col);
			}
		}
		renderer.setDrawSeriesLineAsPath(false);

		// finally, create the chart using the plot
		JFreeChart chart = new JFreeChart(
				getHandle().isShowTitle() ? getHandle().getTitle() : null,
				JFreeChart.DEFAULT_TITLE_FONT, plot, getHandle().isShowLegend());

		return chart;
	}

	@Override
	public double[][] getData() {
		return rawData;
	}

	@Override
	public IDataSink createCopyForSource(AbstractDataSource source) {
		ScatterPlotInput copy = new ScatterPlotInput();
		copy.setProperties(this.getProperties());
		copy.setSource(source);
		return copy;
	}

	@Override
	public void updateInputData() {
		DefaultXYDataset defaultDataset = new DefaultXYDataset();

		logger.log(Level.INFO, "Editor input updateDataSet begin");
		ArrayList<OrdinalMeasurementsDao<?,? extends Quantity>> list = new ArrayList<OrdinalMeasurementsDao<?,? extends Quantity>>();
		for (DataSeries data : getSource().getOutput()) {
			list.add(MeasurementsUtility.getOrdinalMeasurementsDao(data));
		}
		OrdinalMeasurementsDao<?,? extends Quantity> omdSeries1 = MeasurementsUtility
				.getOrdinalMeasurementsDao(getSource().getOutput().get(0));
		OrdinalMeasurementsDao<?,? extends Quantity> omdSeries2 = MeasurementsUtility
				.getOrdinalMeasurementsDao(getSource().getOutput().get(1));
		List<?> list1 = omdSeries1.getMeasurements();

		List<?> list2 = omdSeries2.getMeasurements();

		rawData = new double[2][list1.size()];

		for (int i = 0; i < list1.size(); i++) {
			Measure x = (Measure) list1.get(i);
			Measure y = (Measure) list2.get(i);
			rawData[0][i] = x.doubleValue(x.getUnit());
			rawData[1][i] = y.doubleValue(y.getUnit());
		}

		defaultDataset.addSeries(getInputName(), rawData);

		setChanged();
		notifyObservers();
		logger.log(Level.INFO, "Editor input updateDataSet end");

	}

	@Override
	public String getName() {
		return ELEMENT_NAME;
	}

	@Override
	public String getDefaultTitle() {
		return "Scatterplot";
	}

	public String getDefaultDomainAxisLabel() {
		BaseMetricDescription metric = MetricDescriptionUtility
				.toBaseMetricDescriptions(getSource().getMeasurementsRange()
						.getMeasurements().getMeasure().getMetric())[0];
		return metric.getName() + " ["
				+ new DefaultUnitSwitch(metric).doSwitch(metric) + "]";
	}

	public String getDefaultRangeAxisLabel() {
		BaseMetricDescription metric = MetricDescriptionUtility
				.toBaseMetricDescriptions(getSource().getMeasurementsRange()
						.getMeasurements().getMeasure().getMetric())[1];
		return metric.getName() + " ["
				+ new DefaultUnitSwitch(metric).doSwitch(metric) + "]";
	}

	@Override
	public boolean supportsMultipleInputs() {
		return true;
	}

	public String getDomainAxisLabel() {
		if (domainAxisLabel == null) {
			return getDefaultDomainAxisLabel();
		}
		return domainAxisLabel;
	}

	public void setDomainAxisLabel(String domainAxisLabel) {
		this.domainAxisLabel = domainAxisLabel;
	}

	public void setRangeAxisLabel(String rangeAxisLabel) {
		this.rangeAxisLabel = rangeAxisLabel;
	}

	public String getRangeAxisLabel() {
		if (rangeAxisLabel == null) {
			return getDefaultRangeAxisLabel();
		}
		return rangeAxisLabel;
	}

	public boolean isShowRangeAxisLabel() {
		return showRangeAxisLabel;
	}

	public void setShowRangeAxisLabel(boolean showRangeAxisLabel) {
		this.showRangeAxisLabel = showRangeAxisLabel;
	}

	public boolean isShowDomainAxisLabel() {
		return showDomainAxisLabel;
	}

	public void setShowDomainAxisLabel(boolean showDomainAxisLabel) {
		this.showDomainAxisLabel = showDomainAxisLabel;
	}
}
