/**
 * 
 */
package de.uka.ipd.sdq.edp2.visualization.editors;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.measure.Measure;

import org.eclipse.ui.IMemento;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.DefaultXYItemRenderer;
import org.jfree.data.general.AbstractSeriesDataset;
import org.jfree.data.statistics.HistogramDataset;
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

/**
 * Input for {@link ScatterPlotEditor} .
 * 
 * @author Dominik Ernst, Roland Richter
 */
public class ScatterPlotInput extends JFreeChartEditorInput {

	/**
	 * Name constant, which is used to identify this class in properties.
	 */
	private static final String ELEMENT_NAME = "ScatterPlotInput";

	/**
	 * Logger for this class.
	 */
	private final static Logger logger = Logger
			.getLogger(ScatterPlotInput.class.getCanonicalName());

	/**
	 * The data provided by this {@link JFreeChartEditorInput}
	 */
	private double[][] rawData;

	private BasicDataset<DefaultXYDataset> dataset;

	private JFreeChart chart;

	private DefaultXYItemRenderer renderer;

	public ScatterPlotInput() {
		super();
	}

	public ScatterPlotInput(AbstractDataSource source) {
		setSource(source);
		dataset = new BasicDataset<DefaultXYDataset>(getDataTypeInstance());
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
	}

	@Override
	public JFreeChart getChart() {
		NumberAxis domainAxis = new NumberAxis(getBasicDataset().getHandle()
				.isShowDomainAxisLabel() ? getBasicDataset().getHandle()
				.getDomainAxisLabel() : null);
		domainAxis.setAutoRangeIncludesZero(getBasicDataset().getHandle()
				.isIncludeZero());
		NumberAxis rangeAxis = new NumberAxis(getBasicDataset().getHandle()
				.isShowRangeAxisLabel() ? getBasicDataset().getHandle()
				.getRangeAxisLabel() : null);
		XYPlot plot = new XYPlot();
		plot.setDataset(getBasicDataset().getDataset());
		renderer = new DefaultXYItemRenderer();
		plot.setRenderer(renderer);
		plot.setRangeAxis(rangeAxis);
		plot.setDomainAxis(domainAxis);
		for (int i = 0; i < getBasicDataset().getSeriesProperties().length; i++) {
			if ((getBasicDataset().getSeriesProperties()[i]
					.get(JFreeChartEditorInput.COLOR_KEY) != null)
					&& !getBasicDataset().getSeriesProperties()[i]
							.get(JFreeChartEditorInput.COLOR_KEY).toString()
							.equals(NO_COLOR))
				renderer.setSeriesPaint(i, Color.decode(getBasicDataset()
						.getSeriesProperties()[i].get(
						JFreeChartEditorInput.COLOR_KEY).toString()));
		}

		chart = new JFreeChart(
				getBasicDataset().getHandle().isShowTitle() ? getBasicDataset()
						.getHandle().getTitle() : null,
				JFreeChart.DEFAULT_TITLE_FONT, plot, getBasicDataset()
						.getHandle().isShowLegend());
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
	public DefaultXYDataset getDataTypeInstance() {
		return new DefaultXYDataset();
	}

	@Override
	public void updateInputData() {
		DefaultXYDataset defaultDataset = new DefaultXYDataset();

		logger.log(Level.INFO, "Editor input updateDataSet begin");
		ArrayList<OrdinalMeasurementsDao<Measure>> list = new ArrayList<OrdinalMeasurementsDao<Measure>>();
		for (DataSeries data : getSource().getOutput()) {
			list.add(MeasurementsUtility.getOrdinalMeasurementsDao(data));
		}
		OrdinalMeasurementsDao<Measure> omdSeries1 = MeasurementsUtility
				.getOrdinalMeasurementsDao(getSource().getOutput().get(0));
		OrdinalMeasurementsDao<Measure> omdSeries2 = MeasurementsUtility
				.getOrdinalMeasurementsDao(getSource().getOutput().get(1));
		List<Measure> list1 = omdSeries1.getMeasurements();

		List<Measure> list2 = omdSeries2.getMeasurements();

		rawData = new double[2][list1.size()];

		for (int i = 0; i < list1.size(); i++) {
			Measure x = list1.get(i);
			Measure y = list2.get(i);
			rawData[0][i] = x.doubleValue(x.getUnit());
			rawData[1][i] = y.doubleValue(y.getUnit());
		}

		defaultDataset.addSeries(getInputName(), rawData);

		if (dataset == null) {
			dataset = new BasicDataset<DefaultXYDataset>(getDataTypeInstance());
			dataset.addDataSeries(this);
		}
		
		setChanged();
		notifyObservers();
		logger.log(Level.INFO, "Editor input updateDataSet end");

	}

	@Override
	public BasicDataset<DefaultXYDataset> getBasicDataset() {
		return dataset;
	}

	@Override
	public String getName() {
		return ELEMENT_NAME;
	}

	@Override
	public String getDefaultTitle() {
		return "Scatterplot";
	}

	@Override
	public String getDefaultDomainAxisLabel() {
		return MetricDescriptionUtility.toBaseMetricDescriptions(getSource()
				.getMeasurementsRange().getMeasurements().getMeasure()
				.getMetric())[0].getName()
				+ " [" + getDefaultUnits()[0].toString() + "]";
	}

	@Override
	public String getDefaultRangeAxisLabel() {
		return MetricDescriptionUtility.toBaseMetricDescriptions(getSource()
				.getMeasurementsRange().getMeasurements().getMeasure()
				.getMetric())[1].getName()
				+ " [" + getDefaultUnits()[1].toString() + "]";
	}
}
