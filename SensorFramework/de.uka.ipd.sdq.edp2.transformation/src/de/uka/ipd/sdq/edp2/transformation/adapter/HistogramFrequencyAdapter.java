package de.uka.ipd.sdq.edp2.transformation.adapter;

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
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IMemento;

import de.uka.ipd.sdq.edp2.OrdinalMeasurementsDao;
import de.uka.ipd.sdq.edp2.impl.Measurement;
import de.uka.ipd.sdq.edp2.impl.MeasurementsUtility;
import de.uka.ipd.sdq.edp2.impl.MetricDescriptionUtility;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Edp2Measure;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Measurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MetricDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.RawMeasurements;
import de.uka.ipd.sdq.edp2.visualization.IAdapter;
import de.uka.ipd.sdq.edp2.visualization.IDataSource;
import de.uka.ipd.sdq.edp2.visualization.util.PersistenceTag;
import de.uka.ipd.sdq.edp2.visualization.util.RepositoryUtility;

/**
 * Implementation of an {@link IAdapter}, which transforms the source data into
 * one single-dimension series of data to be displayed in a histogram.
 * 
 * @author Dominik Ernst
 * 
 */
public class HistogramFrequencyAdapter extends IAdapter implements IExecutableExtension {

	private final static Logger logger = Logger
			.getLogger(HistogramFrequencyAdapter.class.getCanonicalName());

	private int dataSeriesIndex;
	private int numberOfBins;
	private int intervalWidth;
	
	public HistogramFrequencyAdapter() {
	}
	
	public HistogramFrequencyAdapter(IDataSource source) {
		super(source);
		numberOfBins = 5;
		dataSeriesIndex = 0;
		transformData();
	}

	public HistogramFrequencyAdapter(IDataSource source, int dataSeriesIndex,
			int numberOfBins) {
		super(source);
		this.numberOfBins = numberOfBins;
		this.dataSeriesIndex = dataSeriesIndex;
		transformData();
	}

	@Override
	public void transformData() {
		logger.log(Level.INFO, "transformation BEGIN");
		//get the MetricDescription of the data series, which will be displayed in the histogram  - data series will have one dimension
		MetricDescription metricDescription = RepositoryUtility.copyMetricDescriptionSilent(MetricDescriptionUtility
				.toBaseMetricDescriptions(source.getMeasurementsRange().getMeasurements().getMeasure().getMetric())[dataSeriesIndex]);
		Edp2Measure edp2measure = RepositoryUtility.createEdp2Measure(source.getMeasurementsRange().getMeasurements().getMeasure(), metricDescription);
		//create a new Measurements object
		Measurements measurements = RepositoryUtility.createMeasurements(edp2measure);
		//copy measurementsRange from source using the new measurements
		measurementsRange = RepositoryUtility.copyMeasurementsRange(source
				.getOriginalMeasurementsRange(), measurements);
		
		//create new RawMeasurements, connected to the new measurements via the measurementsRange
		RawMeasurements rawMeasurements = RepositoryUtility.createRawMeasurements(measurementsRange);

		//create dao for the selected data series - data becomes one-dimensional
		OrdinalMeasurementsDao<Measure> daoForSelectedSeries = MeasurementsUtility
		.getOrdinalMeasurementsDao(source.getOutput().get(dataSeriesIndex));
		List<Measure> listOfMeasures = daoForSelectedSeries.getMeasurements();
		//sort data in ascending order
		Collections.sort(listOfMeasures);
		
		//copy all values of the selected data series to the local measurements
		MeasurementsUtility.createDAOsForRawMeasurements(rawMeasurements);
		for (int j = 0; j < listOfMeasures.size(); j++) {
			Measurement measurement = new Measurement(metricDescription);
				Measure m = listOfMeasures.get(j);
				measurement.setMeasuredValue(0, m);
				MeasurementsUtility.storeMeasurement(measurements, measurement);
			}
		
		//important: set the reference of the dataSeries
		this.dataSeries = rawMeasurements.getDataSeries();

		logger.log(Level.INFO, "transformation END");
	}

	
	@Override
	public String getFactoryId() {
		return HistogramFrequencyAdapterFactory.getFactoryId();
	}

	@Override
	public void saveState(IMemento memento) {
		HistogramFrequencyAdapterFactory.saveState(memento, this);
	}

	@Override
	public Object getAdapter(Class adapter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canAccept(IDataSource source) {
		//TODO when is a histogram frequency adapter usable?
		return true;
	}

	@Override
	public ArrayList<MetricDescription> getMetricRoles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Histogram Frequency Adapter";
	}

	/**
	 * @see IDataSource
	 * @return
	 */
	public HashMap<String,Object> getProperties() {
		properties.put(PersistenceTag.DATA_SERIES_INDEX.getID(), dataSeriesIndex);
		properties.put(PersistenceTag.NUMBER_OF_BINS.getID(), ""+numberOfBins);
		return properties;
	}

	public int getDataSeriesIndex() {
		return dataSeriesIndex;
	}

	public void setDataSeriesIndex(int dataSeriesIndex) {
		this.dataSeriesIndex = dataSeriesIndex;
	}

	public int getNumberOfBins() {
		return numberOfBins;
	}

	public void setNumberOfBins(int numberOfBins) {
		this.numberOfBins = numberOfBins;
	}

	@Override
	public void setInitializationData(IConfigurationElement config,
			String propertyName, Object data) throws CoreException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setProperties(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		// TODO Auto-generated method stub
		return null;
	}

}
