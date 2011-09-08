package de.uka.ipd.sdq.edp2.visualization.filter;

import java.util.ArrayList;
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
import de.uka.ipd.sdq.edp2.impl.DataNotAccessibleException;
import de.uka.ipd.sdq.edp2.impl.Measurement;
import de.uka.ipd.sdq.edp2.impl.MeasurementsUtility;
import de.uka.ipd.sdq.edp2.impl.RepositoryManager;
import de.uka.ipd.sdq.edp2.models.ExperimentData.DataSeries;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Edp2Measure;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Measurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MeasurementsRange;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MetricDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.RawMeasurements;
import de.uka.ipd.sdq.edp2.models.Repository.Repository;
import de.uka.ipd.sdq.edp2.visualization.IDataSource;
import de.uka.ipd.sdq.edp2.visualization.IFilter;
import de.uka.ipd.sdq.edp2.visualization.util.RepositoryUtility;

/**
 * A WarmupFilter cuts off the first n values of the {@link DataSeries} from
 * {@link IDataSource}. Metrics and other metadata remain untouched. TODO At the
 * moment works with a local copy in local directory.
 * 
 * @author Dominik Ernst, Roland Richter
 * 
 */
public class WarmupFilter extends IFilter {

	private final static String ELEMENT_NAME = "WarmupFilter";
	private final static String DROPPED_VALUES_ABS_KEY = "droppedValuesAbsolute";
	private final static String DROPPED_VALUES_REL_KEY = "droppedValuesRelative";
	/**
	 * Logger for this class
	 */
	private final static Logger logger = Logger.getLogger(WarmupFilter.class
			.getCanonicalName());

	/**
	 * The number of values dropped by this {@link WarmupFilter} (as an absolute
	 * number). TODO change to long and adapt using classes to work with long
	 * values,too.
	 */
	private int droppedValues = 0;
	/**
	 * The number of values dropped by this {@link WarmupFilter} (in
	 * percentage). TODO maybe change to double for easier compatibility and no
	 * typecasting?
	 */
	private float droppedValuesPercentage = 0.0f;

	public int getDroppedValues() {
		return droppedValues;
	}

	public void setDroppedValues(int droppedValues) {
		this.droppedValues = droppedValues;
		this.droppedValuesPercentage = 0.0f;
	}

	public float getDroppedValuesPercentage() {
		return droppedValuesPercentage;
	}

	public void setDroppedValuesPercentage(float droppedValuesPercentage) {
		this.droppedValuesPercentage = droppedValuesPercentage;
		this.droppedValues = 0;
	}

	public WarmupFilter() {
	};

	public WarmupFilter(IDataSource source) {
		super(source);
		transformData();
	}

	/**
	 * Constructor for restoring of a {@link WarmupFilter} by the a Factory
	 * (used for persistence).
	 * 
	 * @param source
	 *            the attached {@link IDataSource}
	 * @param droppedValues
	 *            number of values dropped as an absolute value
	 * @param droppedValuesPercentage
	 *            number of values dropped in percentage
	 */
	public WarmupFilter(IDataSource source, int droppedValues,
			float droppedValuesPercentage) {
		super(source);
		setDroppedValues(droppedValues);
		setDroppedValuesPercentage(droppedValuesPercentage);
		transformData();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IPersistableElement#getFactoryId()
	 */
	@Override
	public String getFactoryId() {
		return WarmupFilterFactory.getFactoryId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IPersistable#saveState(org.eclipse.ui.IMemento)
	 */
	@Override
	public void saveState(IMemento memento) {
		WarmupFilterFactory.saveState(memento, this);
		logger.log(Level.INFO, "saveState()");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.uka.ipd.sdq.edp2.visualization.IDataSink#canAccept(de.uka.ipd.sdq.
	 * edp2.visualization.IDataSource)
	 */
	@Override
	public boolean canAccept(IDataSource source) {
		// TODO Auto-generated method stub
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
	 * @see
	 * de.uka.ipd.sdq.edp2.visualization.AbstractTransformation#transformData()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void transformData() {
		logger.log(Level.INFO, "warmup filter transform begin");

		// metrics remain untouched
		MetricDescription metricDescription = RepositoryUtility
				.copyMetricDescriptionSilent(source.getMeasurementsRange()
						.getMeasurements().getMeasure().getMetric());
		// create RawMeasurements and finish copying/setting of required
		// references
		Edp2Measure edp2measure = RepositoryUtility.createEdp2Measure(source
				.getMeasurementsRange().getMeasurements().getMeasure(),
				metricDescription);
		// create a new Measurements object
		Measurements measurements = RepositoryUtility
				.createMeasurements(edp2measure);
		// copy measurementsRange from source using the new measurements
		measurementsRange = RepositoryUtility.copyMeasurementsRange(source
				.getMeasurementsRange(), measurements);

		// create new RawMeasurements, connected to the new measurements via the
		// measurementsRange
		RawMeasurements rawMeasurements = RepositoryUtility
				.createRawMeasurements(measurementsRange);

		// copy only relevant measurements
		ArrayList<OrdinalMeasurementsDao<Measure>> listOfDaos = new ArrayList<OrdinalMeasurementsDao<Measure>>();
		ArrayList<List<Measure>> listOfMeasures = new ArrayList<List<Measure>>();
		for (DataSeries series : source.getOutput()) {
			listOfDaos.add(MeasurementsUtility
					.getOrdinalMeasurementsDao(series));
		}
		for (OrdinalMeasurementsDao<Measure> dao : listOfDaos) {
			listOfMeasures.add(dao.getMeasurements());
		}
		/**
		 * filter droppedValues: if @code{droppedValues} = 0 don't throw values;
		 */
		int droppedValuesTemp = 0;
		if (droppedValuesPercentage > 0) {
			droppedValuesTemp = (int) (droppedValuesPercentage
					* listOfMeasures.get(0).size() / 100);
		} else if (droppedValues > 0) {
			droppedValuesTemp = droppedValues;
			// droppedValuesPercentage = (float) (Math.floor(10000*
			// droppedValues / listOfMeasures.get(0).size()) / 100);
		}
		MeasurementsUtility.createDAOsForRawMeasurements(rawMeasurements);
		for (int i = droppedValuesTemp; i < listOfMeasures.get(0).size(); i++) {
			Measurement measurement = new Measurement(metricDescription);
			for (int dimension = 0; dimension < listOfMeasures.size(); dimension++) {
				Measure m = listOfMeasures.get(dimension).get(i);
				measurement.setMeasuredValue(dimension, m);
			}
			MeasurementsUtility.storeMeasurement(measurements, measurement);
		}

		dataSeries = rawMeasurements.getDataSeries();

		setChanged();
		notifyObservers();

		logger.log(Level.INFO, "warmup filter transform end");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IEditorInput#getName()
	 */
	@Override
	public String getName() {
		return "WarmupFilter";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.uka.ipd.sdq.edp2.visualization.IDataTransformation#getProperties()
	 */
	@Override
	public HashMap<String, Object> getProperties() {
		properties.put(ELEMENT_KEY, ELEMENT_NAME);
		properties.put(DROPPED_VALUES_ABS_KEY, getDroppedValues());
		properties.put(DROPPED_VALUES_REL_KEY, getDroppedValuesPercentage());
		return properties;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.uka.ipd.sdq.edp2.visualization.IDataTransformation#getProperties()
	 */
	public void setProperties(HashMap<String, Object> map) {
		setDroppedValues(Integer.parseInt(map.get(DROPPED_VALUES_ABS_KEY)
				.toString()));
		setDroppedValuesPercentage(Float.parseFloat(map.get(
				DROPPED_VALUES_REL_KEY).toString()));
		properties.put(DROPPED_VALUES_ABS_KEY, getDroppedValues());
		properties.put(DROPPED_VALUES_REL_KEY, getDroppedValuesPercentage());
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

	/**
	 * Update this filter, if the observed {@link Observable} changed and notify
	 * observers in case there are any registered ones.
	 */
	@Override
	public void update(Observable o, Object arg) {
		transformData();
		setChanged();
		notifyObservers();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.runtime.IExecutableExtension#setInitializationData(org
	 * .eclipse.core.runtime.IConfigurationElement, java.lang.String,
	 * java.lang.Object)
	 */
	@Override
	public void setInitializationData(IConfigurationElement config,
			String propertyName, Object data) throws CoreException {
		// TODO Auto-generated method stub

	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		// TODO Auto-generated method stub
		return null;
	}
}
