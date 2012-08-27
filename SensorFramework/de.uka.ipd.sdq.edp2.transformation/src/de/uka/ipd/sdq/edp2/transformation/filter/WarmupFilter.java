package de.uka.ipd.sdq.edp2.transformation.filter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.measure.Measure;
import javax.measure.quantity.Quantity;

import org.eclipse.ui.IMemento;

import de.uka.ipd.sdq.edp2.OrdinalMeasurementsDao;
import de.uka.ipd.sdq.edp2.impl.DataNotAccessibleException;
import de.uka.ipd.sdq.edp2.impl.Measurement;
import de.uka.ipd.sdq.edp2.impl.MeasurementsUtility;
import de.uka.ipd.sdq.edp2.models.ExperimentData.DataSeries;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Edp2Measure;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataFactory;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Measurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MetricDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.RawMeasurements;
import de.uka.ipd.sdq.edp2.visualization.AbstractDataSource;
import de.uka.ipd.sdq.edp2.visualization.AbstractFilter;
import de.uka.ipd.sdq.edp2.visualization.IDataSink;
import de.uka.ipd.sdq.edp2.visualization.util.RepositoryUtility;

/**
 * A WarmupFilter cuts off the first n values of the {@link DataSeries} from
 * {@link AbstractDataSource}. Metrics and other metadata remain untouched. TODO
 * At the moment works with a local copy in local directory.
 * 
 * @author Dominik Ernst, Roland Richter
 * 
 */
public class WarmupFilter extends AbstractFilter {

	/**
	 * This elements Name as used in extension points and for persistence.
	 */
	public final static String ELEMENT_NAME = "WarmupFilter";
	/**
	 * Property key for persistence of <droppedValues>.
	 */
	public final static String DROPPED_VALUES_ABS_KEY = "droppedValuesAbsolute";
	/**
	 * Property key for persistence of <droppedValuesPercentage>.
	 */
	public final static String DROPPED_VALUES_REL_KEY = "droppedValuesRelative";

	/**
	 * Default value for <droppedValuesPercentage>.
	 */
	public final static int DEFAULT_VALUE_DROPPED_VALUES_REL = 10;
	/**
	 * Default value for <droppedValues>.
	 */
	public final static int DEFAULT_VALUE_DROPPED_VALUES_ABS = 100;

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

	/**
	 * 
	 * @return the current value in <droppedValues>
	 */
	public int getDroppedValues() {
		return droppedValues;
	}

	/**
	 * 
	 * @param droppedValues
	 *            the number of dropped values to set (as an absolute value)
	 */
	public void setDroppedValues(int droppedValues) {
		this.droppedValues = droppedValues;
		this.droppedValuesPercentage = 0.0f;
	}

	/**
	 * 
	 * @return the current <droppedValuesPercentage>
	 */
	public float getDroppedValuesPercentage() {
		return droppedValuesPercentage;
	}

	/**
	 * 
	 * @param droppedValuesPercentage
	 *            the number of dropped values to set (as an absolute value)
	 */
	public void setDroppedValuesPercentage(float droppedValuesPercentage) {
		this.droppedValuesPercentage = droppedValuesPercentage;
		this.droppedValues = 0;
	}

	/**
	 * Empty constructor.
	 */
	public WarmupFilter() {
		this(null);
	};

	/**
	 * Default constructor
	 * 
	 * @param source
	 */
	public WarmupFilter(AbstractDataSource source) {
		super(source);
		setDroppedValues(DEFAULT_VALUE_DROPPED_VALUES_ABS);
		setDroppedValuesPercentage(DEFAULT_VALUE_DROPPED_VALUES_REL);
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
	public boolean canAccept(AbstractDataSource source){
		throw new RuntimeException("Currently not working");
		/*
		final MetricDescription sourceMetric = source.getMeasurementsRange()
				.getMeasurements().getMeasure().getMetric();
		// Maximum of 3 dimensions for measurements
		BaseMetricDescription[] sourceMetrics = new BaseMetricDescription[3];
		if (!(sourceMetric instanceof BaseMetricDescription)) {
			sourceMetrics = MetricDescriptionUtility
					.toBaseMetricDescriptions(sourceMetric);
		} else {
			sourceMetrics[0] = (BaseMetricDescription) sourceMetric;
		}
		if (sourceMetrics[0].getCaptureType()
				.equals(CaptureType.INTEGER_NUMBER)
				|| sourceMetrics[0].getCaptureType().equals(
						CaptureType.REAL_NUMBER))
			return true;
		return false; */
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.edp2.visualization.IDataSink#getMetricRoles()
	 */
	@Override
	public ArrayList<MetricDescription> getMetricRoles() {
		ArrayList<MetricDescription> roles = new ArrayList<MetricDescription>();
		MetricDescription nonTextual = ExperimentDataFactory.eINSTANCE
				.createNumericalBaseMetricDescription();
		roles.add(nonTextual);

		return roles;
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
		measurementsRange = RepositoryUtility.copyMeasurementsRange(
				source.getMeasurementsRange(), measurements);

		// create new RawMeasurements, connected to the new measurements via the
		// measurementsRange
		RawMeasurements rawMeasurements = RepositoryUtility
				.createRawMeasurements(measurementsRange);

		// copy only relevant measurements
		ArrayList<OrdinalMeasurementsDao<?,? extends Quantity>> listOfDaos = new ArrayList<OrdinalMeasurementsDao<?,? extends Quantity>>();
		ArrayList<List<?>> listOfMeasures = new ArrayList<List<?>>();
		for (DataSeries series : source.getOutput()) {
			listOfDaos.add(MeasurementsUtility
					.getOrdinalMeasurementsDao(series));
		}
		for (OrdinalMeasurementsDao<?,? extends Quantity> dao : listOfDaos) {
			if (!dao.isOpen()) {
				try {
					dao.open();
				} catch (DataNotAccessibleException e) {
					logger.log(Level.SEVERE, e.getMessage());
				}
			}
			listOfMeasures.add(dao.getMeasurements());
		}
		/**
		 * filter droppedValues: if @code{droppedValues} = 0 don't remove any
		 * values;
		 */
		int droppedValuesTemp = 0;
		if (droppedValuesPercentage > 0) {
			droppedValuesTemp = (int) (droppedValuesPercentage * listOfMeasures.get(0).size() / 100);
		} else if (droppedValues > 0) {
			droppedValuesTemp = Math.min(droppedValues, listOfMeasures.get(0).size());
			setDroppedValues(droppedValuesTemp);
		}
		// FIXME: This should not write on disk, transformation should work in memory.... Why use disk here, this is 
		// too slow....
		// FIXME: Copy of measurments uses the metric description to get its dimension, but other adapters may have 
		// converted the source, e.g., to one dimension only... Then this fails...
		MeasurementsUtility.createDAOsForRawMeasurements(rawMeasurements);
		for (int i = droppedValuesTemp; i >= 0 && i < listOfMeasures.get(0).size(); i++) {
			Measurement measurement = new Measurement(metricDescription);
			for (int dimension = 0; dimension < listOfMeasures.size(); dimension++) {
				Measure<?,? extends Quantity> m = (Measure<?, ? extends Quantity>) listOfMeasures.get(dimension).get(i);
				logger.log(Level.INFO,m.toString());
				if (m == null) {
				    throw new RuntimeException("Null value read from DAO. This should not happen");
				}
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
	 * de.uka.ipd.sdq.edp2.visualization.IDataFlow#setProperties(java.util.HashMap
	 * )
	 */
	public void setProperties(HashMap<String, Object> newProperties) {
		int droppedAbsTemp = 0;
		if (validProperties(newProperties, DROPPED_VALUES_ABS_KEY)) {
			droppedAbsTemp = Integer.parseInt(newProperties.get(
					DROPPED_VALUES_ABS_KEY).toString());
			if (droppedAbsTemp > 0) {
			setDroppedValues(Integer.parseInt(newProperties.get(
					DROPPED_VALUES_ABS_KEY).toString()));
			}
		}
		if (validProperties(newProperties, DROPPED_VALUES_REL_KEY)) {
			float droppedRelTemp = Float.parseFloat(newProperties.get(
					DROPPED_VALUES_REL_KEY).toString());
			if (droppedRelTemp > 0 && droppedAbsTemp < 1) {
				setDroppedValuesPercentage(droppedRelTemp);
				}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 */
	@SuppressWarnings("rawtypes")
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
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.uka.ipd.sdq.edp2.visualization.IDataSink#createCopyForSource(de.uka
	 * .ipd.sdq.edp2.visualization.AbstractDataSource)
	 */
	public IDataSink createCopyForSource(AbstractDataSource source) {
		WarmupFilter copy = new WarmupFilter();
		copy.setSource(source);
		copy.setDroppedValuesPercentage(getDroppedValuesPercentage());
		copy.setDroppedValues(getDroppedValues());
		return copy;
	}
}
