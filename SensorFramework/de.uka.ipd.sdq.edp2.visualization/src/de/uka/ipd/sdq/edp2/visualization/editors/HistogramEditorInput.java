/**
 * 
 */
package de.uka.ipd.sdq.edp2.visualization.editors;

import java.awt.Color;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.measure.Measure;
import javax.measure.unit.UnitFormat;

import org.eclipse.ui.IMemento;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.general.AbstractSeriesDataset;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.statistics.HistogramType;
import org.jfree.ui.TextAnchor;

import de.uka.ipd.sdq.edp2.OrdinalMeasurementsDao;
import de.uka.ipd.sdq.edp2.impl.MeasurementsUtility;
import de.uka.ipd.sdq.edp2.impl.MetricDescriptionUtility;
import de.uka.ipd.sdq.edp2.models.ExperimentData.DataSeries;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MetricDescription;
import de.uka.ipd.sdq.edp2.visualization.AbstractDataSource;
import de.uka.ipd.sdq.edp2.visualization.datasource.ElementFactory;
import de.uka.ipd.sdq.edp2.visualization.properties.IProperty;

/**
 * @author Dominik Ernst
 * 
 */
public class HistogramEditorInput extends JFreeChartEditorInput {

	/**
	 * Name constant, which is used to identify this class in properties and
	 * persistence.
	 */
	private static final String ELEMENT_NAME = "HistogramEditorInput";
	/**
	 * Keys for persistence of properties
	 */
	public final static String NUMBER_BINS_KEY = "numberOfBins";
	public final static String SHOW_ITEM_VALUES_KEY = "showItemValues";
	public final static String BAR_MARGIN_KEY = "barMargin";
	public final static String ABSOLUTE_FREQUENCY_KEY = "absoluteFrequency";
	public final static String MANUAL_BIN_WIDTHS = "manualBinWidths";
	/**
	 * Default value for <code>numberOfBins</code>
	 */
	private final static int DEFAULT_NUMBER_BINS = 5;

	/**
	 * The number of bins, i.e. the number of intervals of equal length in which
	 * the measurements are counted.
	 */
	private int numberOfBins;
	/**
	 * Option to show the value for each bar in the histogram, i.e. the absolute
	 * or relative number of items contained in each bin.
	 */
	private boolean showItemValues;

	/**
	 * Wheter to use absolute frequency or relative frequency for the chart.
	 * NOTE: this does affect other input items as well, but is specific for
	 * histograms, thus it is located here.
	 */
	private boolean absoluteFrequency;

	/**
	 * The width of the whitespace between the bars in percentage of each bar's
	 * width.
	 */
	private double barMargin;

	/**
	 * The lower bounds for the width of each bin, when manual settings are
	 * used.
	 */
	private double[] binLowerBounds;

	/**
	 * Upper bounds for bin sizes.
	 */
	private double[] binUpperBounds;
	/**
	 * The specific type of data provided by this {@link JFreeChartEditorInput}.
	 */
	private double[] data;
	/**
	 * Logger for this class
	 */
	private final static Logger logger = Logger
			.getLogger(HistogramEditorInput.class.getCanonicalName());

	/**
	 * Renderer for 2D-Bar-Charts.
	 */
	private XYBarRenderer renderer;
	/**
	 * The plot, containing the data.
	 */
	private XYPlot plot;
	/**
	 * The chart, in which the plot is rendered.
	 */
	private JFreeChart chart;
	/**
	 * The dataset required by this input, as a typed instance of
	 * {@link BasicDataset}
	 */
	private BasicDataset<HistogramDataset> dataset;

	/**
	 * Empty constructor.
	 */
	public HistogramEditorInput() {
		super();
		new HistogramEditorInput(null);
	}

	/**
	 * Constructor, with reference on the source. Automatically initiates an
	 * update of the {@link #dataset}.
	 * 
	 * @param source
	 */
	public HistogramEditorInput(AbstractDataSource source) {
		if (source != null) {
			setSource(source);
			dataset = new BasicDataset<HistogramDataset>(getDataTypeInstance());
		}
		setAbsoluteFrequency(true);
		setBarMargin(0.0);
		setNumberOfBins(DEFAULT_NUMBER_BINS);
		setShowItemValues(false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.uka.ipd.sdq.edp2.visualization.IVisualizationInput#updateInputData()
	 */
	@SuppressWarnings("unchecked")
	public void updateInputData() {
		logger.log(Level.INFO, "Transformation : BEGIN");
		HistogramDataset defaultDataset = new HistogramDataset();

		ArrayList<OrdinalMeasurementsDao<Measure>> listOfDaos = new ArrayList<OrdinalMeasurementsDao<Measure>>();
		ArrayList<List<Measure>> listOfMeasures = new ArrayList<List<Measure>>();
		for (DataSeries series : getSource().getOutput()) {
			listOfDaos.add(MeasurementsUtility
					.getOrdinalMeasurementsDao(series));
		}
		for (OrdinalMeasurementsDao<Measure> dao : listOfDaos) {
			listOfMeasures.add(dao.getMeasurements());
		}

		MetricDescription[] metrics = MetricDescriptionUtility
				.toBaseMetricDescriptions(getSource().getMeasurementsRange()
						.getMeasurements().getMeasure().getMetric());

		// TODO sorting seems to have no effect
		// Collections.sort(listOfMeasures.get(0));
		data = new double[listOfMeasures.get(0).size()];

		for (int i = 0; i < listOfMeasures.get(0).size(); i++) {
			data[i] = listOfMeasures.get(0).get(i)
					.doubleValue(listOfMeasures.get(0).get(i).getUnit());

		}

		defaultDataset.addSeries(getInputName(), data, getNumberOfBins());
		if (dataset == null) {
			dataset = new BasicDataset<HistogramDataset>(getDataTypeInstance());
			dataset.addDataSeries(this);
		}
		setChanged();
		notifyObservers();
		logger.log(Level.INFO, "Transformation : END");
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
		return source.getOutput().size() >= 1;
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
		return HistogramEditorInputFactory.getFactoryId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IPersistable#saveState(org.eclipse.ui.IMemento)
	 */
	@Override
	public void saveState(IMemento memento) {
		HistogramEditorInputFactory.saveState(memento, this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.edp2.visualization.IDataFlow#getProperties()
	 */
	public HashMap<String, Object> getProperties() {
		properties.put(ElementFactory.ELEMENT_KEY, ELEMENT_NAME);
		properties.put(NUMBER_BINS_KEY, getNumberOfBins());
		properties.put(COLOR_KEY, getColor());
		properties.put(INPUT_NAME_KEY, getInputName());
		properties.put(SHOW_ITEM_VALUES_KEY, isShowItemValues());
		properties.put(BAR_MARGIN_KEY, getBarMargin());
		properties.put(ABSOLUTE_FREQUENCY_KEY, isAbsoluteFrequency());
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
		if (newProperties.get(NUMBER_BINS_KEY) != null)
			setNumberOfBins(Integer.parseInt(newProperties.get(NUMBER_BINS_KEY)
					.toString()));
		if (newProperties.get(COLOR_KEY) != null)
			setColor(newProperties.get(COLOR_KEY).toString());
		if (newProperties.get(SHOW_ITEM_VALUES_KEY) != null)
			setShowItemValues(Boolean.parseBoolean(newProperties.get(
					SHOW_ITEM_VALUES_KEY).toString()));
		if (newProperties.get(BAR_MARGIN_KEY) != null) {
			setBarMargin(Double.parseDouble(newProperties.get(BAR_MARGIN_KEY)
					.toString()));
		}
		if (newProperties.get(ABSOLUTE_FREQUENCY_KEY) != null) {
			setAbsoluteFrequency(Boolean.parseBoolean(newProperties.get(
					ABSOLUTE_FREQUENCY_KEY).toString()));
		}
		if (newProperties.get(INPUT_NAME_KEY) != null) {
			setInputName(newProperties.get(INPUT_NAME_KEY).toString());
		}
	}

	private int getNumberOfBins() {
		if (numberOfBins != 0) {
			return numberOfBins;
		}
		return DEFAULT_NUMBER_BINS;
	}

	private void setNumberOfBins(int numberOfBins) {
		this.numberOfBins = numberOfBins;
	}

	/*
	 * (non-Javadoc)
	 * @see de.uka.ipd.sdq.edp2.visualization.editors.JFreeChartEditorInput#getChart()
	 */
	public JFreeChart getChart() {
		//create the axes for the chart; if an axis is not to be displayed, it must be null
		NumberAxis domainAxis = new NumberAxis(getBasicDataset().getHandle()
				.isShowDomainAxisLabel() ? getBasicDataset().getHandle()
				.getDomainAxisLabel() : null);
		domainAxis.setAutoRangeIncludesZero(getBasicDataset().getHandle()
				.isIncludeZero());
		NumberAxis rangeAxis = new NumberAxis(getBasicDataset().getHandle()
				.isShowRangeAxisLabel() ? getBasicDataset().getHandle()
				.getRangeAxisLabel() : null);

		plot = new XYPlot();
		plot.setDataset(getBasicDataset().getDataset());

		//the renderer for the chart
		renderer = new XYBarRenderer();
		plot.setRenderer(renderer);
		plot.setRangeAxis(rangeAxis);
		plot.setDomainAxis(domainAxis);
		
		//modifiy the colors of the data series, if there are persisted color properties
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

		//absolute or relative frequency
		getBasicDataset().getDataset().setType(
				isAbsoluteFrequency() ? HistogramType.FREQUENCY
						: HistogramType.RELATIVE_FREQUENCY);
		//margin is the relative space of each bar, which remains uncolored
		//NOTE: this prevents a clear visibility of the bins' upper / lower bounds
		renderer.setMargin(getBarMargin() / 100);

		//show values on each bar in the histogram if the property is set
		renderer.setBaseItemLabelGenerator(new StandardXYItemLabelGenerator());
		renderer.setBaseItemLabelPaint(Color.BLACK);
		renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition());
		renderer.setBaseNegativeItemLabelPosition(new ItemLabelPosition(
				ItemLabelAnchor.OUTSIDE12, TextAnchor.TOP_CENTER));
		renderer.setBaseItemLabelsVisible(isShowItemValues());

		//finally, create the chart using the plot
		chart = new JFreeChart(
				getBasicDataset().getHandle().isShowTitle() ? getBasicDataset()
						.getHandle().getTitle() : null,
				JFreeChart.DEFAULT_TITLE_FONT, plot, getBasicDataset()
						.getHandle().isShowLegend());
		return chart;
	}

	/*
	 * (non-Javadoc)
	 * @see de.uka.ipd.sdq.edp2.visualization.IVisualizationInput#getData()
	 */
	@Override
	public double[] getData() {
		return data;
	}

	/*
	 * (non-Javadoc)
	 * @see de.uka.ipd.sdq.edp2.visualization.IDataSink#createCopyForSource(de.uka.ipd.sdq.edp2.visualization.AbstractDataSource)
	 */
	@Override
	public HistogramEditorInput createCopyForSource(AbstractDataSource source) {
		HistogramEditorInput copy = new HistogramEditorInput(source);
		return copy;
	}

	/*
	 * (non-Javadoc)
	 * @see de.uka.ipd.sdq.edp2.visualization.editors.JFreeChartEditorInput#getBasicDataset()
	 */
	@Override
	public BasicDataset<HistogramDataset> getBasicDataset() {
		return dataset;
	}

	/*
	 * (non-Javadoc)
	 * @see de.uka.ipd.sdq.edp2.visualization.IVisualizationInput#getDataTypeInstance()
	 */
	@Override
	public HistogramDataset getDataTypeInstance() {
		return new HistogramDataset();
	}
	
	/*
	 * (non-Javadoc)
	 * @see de.uka.ipd.sdq.edp2.visualization.IDataFlow#getName()
	 */
	@Override
	public String getName() {
		return ELEMENT_NAME;
	}

	/*
	 * (non-Javadoc)
	 * @see de.uka.ipd.sdq.edp2.visualization.editors.JFreeChartEditorInput#getDefaultTitle()
	 */
	@Override
	public String getDefaultTitle() {
		return "Histogram";
	}

	/*
	 * (non-Javadoc)
	 * @see de.uka.ipd.sdq.edp2.visualization.editors.JFreeChartEditorInput#getDefaultDomainAxisLabel()
	 */
	@Override
	public String getDefaultDomainAxisLabel() {
		return MetricDescriptionUtility.toBaseMetricDescriptions(getSource()
				.getMeasurementsRange().getMeasurements().getMeasure()
				.getMetric())[0].getName()
				+ " [" + getDefaultUnits()[0].toString() + "]";
	}

	/*
	 * (non-Javadoc)
	 * @see de.uka.ipd.sdq.edp2.visualization.editors.JFreeChartEditorInput#getDefaultRangeAxisLabel()
	 */
	@Override
	public String getDefaultRangeAxisLabel() {
		return "Frequency (Absolute)";
	}

	private boolean isAbsoluteFrequency() {
		return absoluteFrequency;
	}

	private double getBarMargin() {
		return barMargin;
	}

	private boolean isShowItemValues() {
		return showItemValues;
	}

	private void setAbsoluteFrequency(boolean value) {
		absoluteFrequency = value;
	}

	private void setBarMargin(double percentage) {
		if (percentage < 0)
			barMargin = 0.0;
		else if (percentage > 100)
			barMargin = 100.0;
		else
			barMargin = percentage;
	}

	private void setShowItemValues(boolean value) {
		showItemValues = value;
	}

}
