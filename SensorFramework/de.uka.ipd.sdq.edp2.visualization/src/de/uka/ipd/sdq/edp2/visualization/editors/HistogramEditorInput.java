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
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.general.AbstractSeriesDataset;
import org.jfree.data.statistics.HistogramDataset;

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
	private final static String NUMBER_BINS_KEY = "numberOfBins";
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
	 * The handle, which manages this input.
	 */
	private JFreeChartEditorInputHandle handle;

	/**
	 * Empty constructor.
	 */
	public HistogramEditorInput() {
		super();
	}

	/**
	 * Constructor, with reference on the source. Automatically initiates an
	 * update of the {@link #dataset}.
	 * 
	 * @param source
	 */
	public HistogramEditorInput(AbstractDataSource source) {
		super(source);
		dataset = new BasicDataset<HistogramDataset>(new HistogramDataset());
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

		// set the textual information of the chart
		if (getInputName() == null)
			setInputName(getDefaultName());

		defaultDataset.addSeries(getInputName(), data, getNumberOfBins());
		if (dataset == null) {
			dataset = new BasicDataset<HistogramDataset>(getDataTypeInstance());
			dataset.addDataSeries(this);
			//don't overwrite persisted color settings
			if (getColor() == null) setColor(NO_COLOR);
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
		if (properties.get(NUMBER_BINS_KEY) != null
				&& newProperties.get(NUMBER_BINS_KEY) != null)
			setNumberOfBins(Integer.parseInt(newProperties.get(NUMBER_BINS_KEY)
					.toString()));
		else
			setNumberOfBins(DEFAULT_NUMBER_BINS);
		if (properties.get(COLOR_KEY) != null
				&& newProperties.get(COLOR_KEY) != null)
			setColor(newProperties.get(COLOR_KEY).toString());
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

	public JFreeChart getChart() {
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
		renderer = new XYBarRenderer();
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
	public double[] getData() {
		return data;
	}

	@Override
	public HistogramEditorInput createCopyForSource(AbstractDataSource source) {
		HistogramEditorInput copy = new HistogramEditorInput(source);
		return copy;
	}

	@Override
	public BasicDataset<HistogramDataset> getBasicDataset() {
		return dataset;
	}

	@Override
	public HistogramDataset getDataTypeInstance() {
		return new HistogramDataset();
	}

	@Override
	public String getName() {
		return ELEMENT_NAME;
	}

	@Override
	public String getDefaultTitle() {
		return "Histogram";
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
		return "Frequency (Absolute)";
	}

}
