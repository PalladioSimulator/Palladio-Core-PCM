/**
 * 
 */
package de.uka.ipd.sdq.edp2.visualization.editors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.measure.Measure;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPersistableElement;
import org.eclipse.ui.part.EditorPart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.general.Dataset;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.xy.IntervalXYDataset;

import de.uka.ipd.sdq.edp2.OrdinalMeasurementsDao;
import de.uka.ipd.sdq.edp2.impl.DataNotAccessibleException;
import de.uka.ipd.sdq.edp2.impl.MeasurementsUtility;
import de.uka.ipd.sdq.edp2.models.ExperimentData.DataSeries;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MetricDescription;
import de.uka.ipd.sdq.edp2.models.Repository.Repository;
import de.uka.ipd.sdq.edp2.visualization.IDataSink;
import de.uka.ipd.sdq.edp2.visualization.IDataSource;
import de.uka.ipd.sdq.edp2.visualization.util.PersistenceTag;

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

	private final static int DEFAULT_NUMBER_BINS = 5;
	/**
	 * The number of bins, i.e. the number of intervals of equal length in which
	 * the measurements are counted.
	 */
	private int numberOfBins;
	/**
	 * The specific type of {@link Dataset}.
	 */
	private HistogramDataset dataset;
	/**
	 * Logger for this class
	 */
	private final static Logger logger = Logger
			.getLogger(HistogramEditorInput.class.getCanonicalName());

	/**
	 * 
	 * @return the dataset
	 */
	public HistogramDataset getDataset() {
		return dataset;
	}

	/**
	 * Changes the dataset to the specified one.
	 * 
	 * @param dataset
	 *            the new {@link HistogramDataset}
	 */
	public void setDataset(HistogramDataset dataset) {
		this.dataset = dataset;
	}

	/**
	 * 
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
	public HistogramEditorInput(IDataSource source) {
		super(source);
		updateDataset();
	}

	/**
	 * Parses the data within the current source and updates the
	 * {@link #dataset} in accordance.
	 */
	@SuppressWarnings("unchecked")
	public void updateDataset() {
		dataset = new HistogramDataset();

		ArrayList<OrdinalMeasurementsDao<Measure>> listOfDaos = new ArrayList<OrdinalMeasurementsDao<Measure>>();
		ArrayList<List<Measure>> listOfMeasures = new ArrayList<List<Measure>>();
		for (DataSeries series : getSource().getOutput()) {
			listOfDaos.add(MeasurementsUtility
					.getOrdinalMeasurementsDao(series));
		}
		for (OrdinalMeasurementsDao<Measure> dao : listOfDaos) {
			listOfMeasures.add(dao.getMeasurements());
		}
		// TODO sorting seems to have no effect
		// Collections.sort(listOfMeasures.get(0));
		double[] values = new double[listOfMeasures.get(0).size()];
		for (int i = 0; i < listOfMeasures.get(0).size(); i++) {
			values[i] = listOfMeasures.get(0).get(i).doubleValue(
					listOfMeasures.get(0).get(i).getUnit());
		}

		// source must be a HistogramAdapter
		// TODO change so that the adapter doesn't have to be the direct
		// predecessor
		// FIXME shouldn't use PersistenceTag, but must get the number of bins
		dataset.addSeries(getSource().getMeasurementsRange().getMeasurements()
				.getMeasure().getMetric().getName(), values, getNumberOfBins());
		// set the title of the chart to the name of the input data series
		setTitle(getSource().getMeasurementsRange().getMeasurements()
				.getMeasure().getMetric().getName());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.uka.ipd.sdq.edp2.models.ExperimentData.presentation.IDataSink#canAccept
	 * (de.uka.ipd.sdq.edp2.models.ExperimentData.presentation.IDataSource)
	 */
	@Override
	public boolean canAccept(IDataSource source) {
		return source.getOutput().size() == 1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seede.uka.ipd.sdq.edp2.models.ExperimentData.presentation.IDataSink#
	 * getMetricRoles()
	 */
	@Override
	public ArrayList<MetricDescription> getMetricRoles() {
		// TODO Auto-generated method stub
		return null;
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
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 */
	@Override
	public Object getAdapter(Class adapter) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		updateDataset();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.ISelection#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.edp2.visualization.IDataFlow#getProperties()
	 */
	public HashMap<String, Object> getProperties() {
		properties.put(ELEMENT_KEY, ELEMENT_NAME);
		properties.put(NUMBER_BINS_KEY, getNumberOfBins());
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
		setNumberOfBins(Integer.parseInt(newProperties.get(NUMBER_BINS_KEY)
				.toString()));
		properties.put(NUMBER_BINS_KEY, getNumberOfBins());
	}

	@Override
	public JFreeChart createChart() {
		updateDataset();
		JFreeChart chart = ChartFactory.createHistogram("Histogram",
				getToolTipText(), "Frequency", getDataset(),
				PlotOrientation.VERTICAL, true, true, false);
		setChart(chart);
		return chart;
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

}
