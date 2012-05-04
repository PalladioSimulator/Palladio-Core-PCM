package de.uka.ipd.sdq.edp2.transformation.adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.measure.Measure;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IMemento;

import de.uka.ipd.sdq.edp2.OrdinalMeasurementsDao;
import de.uka.ipd.sdq.edp2.impl.Measurement;
import de.uka.ipd.sdq.edp2.impl.MeasurementsUtility;
import de.uka.ipd.sdq.edp2.impl.MetricDescriptionUtility;
import de.uka.ipd.sdq.edp2.models.ExperimentData.DataSeries;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Edp2Measure;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Measurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MetricDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.RawMeasurements;
import de.uka.ipd.sdq.edp2.visualization.AbstractAdapter;
import de.uka.ipd.sdq.edp2.visualization.AbstractDataSource;
import de.uka.ipd.sdq.edp2.visualization.IDataSink;
import de.uka.ipd.sdq.edp2.visualization.util.RepositoryUtility;

/**
 * Implementation of an {@link AbstractAdapter}, which transforms the source
 * data into one, single-dimension series of data to be displayed in a
 * histogram.
 * 
 * @author Dominik Ernst
 * 
 */
public class HistogramFrequencyAdapter extends AbstractAdapter {

	/**
	 * Name constant, which is used to identify this class in properties.
	 */
	private final static String ELEMENT_NAME = "HistogramFrequencyAdapter";

	/**
	 * Keys for persistence of properties
	 */
	private final static String DATA_SERIES_KEY = "dataSeriesIndex";

	/**
	 * Default value for <dataSeriesIndex>.
	 */
	private final static int DEFAULT_VALUE_DATA_SERIES_INDEX = 0;

	/**
	 * Logger for this class.
	 */
	private final static Logger logger = Logger
			.getLogger(HistogramFrequencyAdapter.class.getCanonicalName());

	/**
	 * The index of the {@link DataSeries}, which is selected by this adapter.
	 */
	private int dataSeriesIndex;

	/**
	 * Empty constructor
	 */
	public HistogramFrequencyAdapter() {
	}

	/**
	 * Constructor, which sets default values for the
	 * {@link HistogramFrequencyAdapter}'s variables.
	 * 
	 * @param source
	 *            the attached {@link AbstractDataSource}
	 */
	public HistogramFrequencyAdapter(AbstractDataSource source) {
		super(source);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.uka.ipd.sdq.edp2.visualization.AbstractTransformation#transformData()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void transformData() {
		logger.log(Level.INFO, "transformation BEGIN");
		// get the MetricDescription of the data series, which will be displayed
		// in the histogram - data series will have one dimension
		MetricDescription metricDescription = RepositoryUtility
				.copyMetricDescriptionSilent(MetricDescriptionUtility
						.toBaseMetricDescriptions(source.getMeasurementsRange()
								.getMeasurements().getMeasure().getMetric())[dataSeriesIndex]);
		Edp2Measure edp2measure = RepositoryUtility.createEdp2Measure(source
				.getMeasurementsRange().getMeasurements().getMeasure(),
				metricDescription);
		// create a new Measurements object
		Measurements measurements = RepositoryUtility
				.createMeasurements(edp2measure);
		// copy measurementsRange from source using the new measurements
		measurementsRange = RepositoryUtility.copyMeasurementsRange(source
				.getOriginalMeasurementsRange(), measurements);

		// create new RawMeasurements, connected to the new measurements via the
		// measurementsRange
		RawMeasurements rawMeasurements = RepositoryUtility
				.createRawMeasurements(measurementsRange);

		// create dao for the selected data series - data becomes
		// one-dimensional
		OrdinalMeasurementsDao<Measure> daoForSelectedSeries = MeasurementsUtility
				.getOrdinalMeasurementsDao(source.getOutput().get(
						dataSeriesIndex));
		List<Measure> listOfMeasures = daoForSelectedSeries.getMeasurements();
		// TODO sort data in ascending order
		// Collections.sort(listOfMeasures);

		// copy all values of the selected data series to the local measurements
		MeasurementsUtility.createDAOsForRawMeasurements(rawMeasurements);
		for (int j = 0; j < listOfMeasures.size(); j++) {
			Measurement measurement = new Measurement(metricDescription);
			Measure m = listOfMeasures.get(j);
			measurement.setMeasuredValue(0, m);
			MeasurementsUtility.storeMeasurement(measurements, measurement);
		}

		// important: set the reference of the dataSeries
		this.dataSeries = rawMeasurements.getDataSeries();

		setChanged();
		notifyObservers();

		logger.log(Level.INFO, "transformation END");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IPersistableElement#getFactoryId()
	 */
	@Override
	public String getFactoryId() {
		return HistogramFrequencyAdapterFactory.getFactoryId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IPersistable#saveState(org.eclipse.ui.IMemento)
	 */
	@Override
	public void saveState(IMemento memento) {
		HistogramFrequencyAdapterFactory.saveState(memento, this);
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
	 * @see
	 * de.uka.ipd.sdq.edp2.visualization.IDataSink#canAccept(de.uka.ipd.sdq.
	 * edp2.visualization.IDataSource)
	 */
	@Override
	public boolean canAccept(AbstractDataSource source) {
		// TODO when is a histogram frequency adapter actually usable?
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.edp2.visualization.IDataSink#getMetricRoles()
	 */
	@Override
	public ArrayList<MetricDescription> getMetricRoles() {
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
		logger.log(Level.INFO, "update invoked");
		transformData();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IEditorInput#getName()
	 */
	@Override
	public String getName() {
		return "Histogram Frequency Adapter";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.edp2.visualization.IDataFlow#getProperties()
	 */
	@Override
	public HashMap<String, Object> getProperties() {
		properties.put(ELEMENT_KEY, ELEMENT_NAME);
		properties.put(DATA_SERIES_KEY, getDataSeriesIndex());
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
		if (validProperties(newProperties, DATA_SERIES_KEY))
			setDataSeriesIndex(Integer.parseInt(newProperties.get(
					DATA_SERIES_KEY).toString()));
		else
			setDataSeriesIndex(DEFAULT_VALUE_DATA_SERIES_INDEX);

	}

	/**
	 * @return the dataSeriesIndex
	 */
	public int getDataSeriesIndex() {
		return dataSeriesIndex;
	}

	/**
	 * @param dataSeriesIndex
	 *            the dataSeriesIndex to set
	 */
	public void setDataSeriesIndex(int dataSeriesIndex) {
		this.dataSeriesIndex = dataSeriesIndex;
	}
	/*
	 * (non-Javadoc)
	 * @see de.uka.ipd.sdq.edp2.visualization.IDataSink#createCopyForSource(de.uka.ipd.sdq.edp2.visualization.AbstractDataSource)
	 */
	public IDataSink createCopyForSource(AbstractDataSource source) {
		HistogramFrequencyAdapter copy = new HistogramFrequencyAdapter();
		copy.setSource(source);
		copy.setDataSeriesIndex(getDataSeriesIndex());
		return copy;
	}
}
