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
import de.uka.ipd.sdq.edp2.models.ExperimentData.DataSeries;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Edp2Measure;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Measurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MeasurementsRange;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MetricDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.RawMeasurements;
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
public class WarmupFilter extends IFilter implements IExecutableExtension{

	private final static Logger logger = Logger.getLogger(WarmupFilter.class
			.getCanonicalName());

	
	private int droppedValues = 0;
	private float droppedValuesPercentage = 0.0f;
	
	public int getDroppedValues() {
		return droppedValues;
	}

	public void setDroppedValues(int droppedValues) {
		this.droppedValues = droppedValues;
	}

	public float getDroppedValuesPercentage() {
		return droppedValuesPercentage;
	}

	public void setDroppedValuesPercentage(float droppedValuesPercentage) {
		this.droppedValuesPercentage = droppedValuesPercentage;
	}

	public WarmupFilter(){};
	
	public WarmupFilter(IDataSource source) {
		super(source);
		transformData();
	}

	public WarmupFilter(IDataSource source, int droppedValues,
			float droppedValuesPercentage) {		
		super(source);
		source.addObserver(this);
		setDroppedValues(droppedValues);
		setDroppedValuesPercentage(droppedValuesPercentage);
		transformData();
	}

	@Override
	public String getFactoryId() {
		return WarmupFilterFactory.getFactoryId();
	}

	@Override
	public void saveState(IMemento memento) {
		WarmupFilterFactory.saveState(memento, this);
		logger.log(Level.INFO, "saveState()");
	}

	@Override
	public boolean canAccept(IDataSource source) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public ArrayList<MetricDescription> getMetricRoles() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void transformData() {
		logger.log(Level.INFO, "warmup filter transform begin");

		// metrics remain untouched
		MetricDescription metricDescription = RepositoryUtility.copyMetricDescriptionSilent(source.getMeasurementsRange().getMeasurements().getMeasure().getMetric());
		// create RawMeasurements and finish copying/setting of required references
		Edp2Measure edp2measure = RepositoryUtility.createEdp2Measure(source.getMeasurementsRange().getMeasurements().getMeasure(), metricDescription);
		//create a new Measurements object
		Measurements measurements = RepositoryUtility.createMeasurements(edp2measure);
		//copy measurementsRange from source using the new measurements
		measurementsRange = RepositoryUtility.copyMeasurementsRange(source
				.getMeasurementsRange(), measurements);
		
		//create new RawMeasurements, connected to the new measurements via the measurementsRange
		RawMeasurements rawMeasurements = RepositoryUtility.createRawMeasurements(measurementsRange);

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
		int droppedValuesTemp=0;
		if (droppedValuesPercentage > 0) {
			droppedValuesTemp = (int) (droppedValuesPercentage
					* listOfMeasures.get(0).size() / 100);
		} else if (droppedValues > 0) {
			droppedValuesTemp =  droppedValues;
			//droppedValuesPercentage = (float) (Math.floor(10000* droppedValues / listOfMeasures.get(0).size()) / 100);
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
		
		logger.log(Level.INFO, "warmup filter transform end");

	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		return "WarmupFilter";
	}

	/*
	 * (non-Javadoc)
	 * @see de.uka.ipd.sdq.edp2.visualization.IDataTransformation#getProperties()
	 */
	@Override
	public HashMap<String,Object> getProperties(){		
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("droppedValues", getDroppedValues());
		map.put("droppedValuesPercentage", getDroppedValuesPercentage());
		return map;
	}
	/*
	 * (non-Javadoc)
	 * @see de.uka.ipd.sdq.edp2.visualization.IDataTransformation#getProperties()
	 */
	
	public void setProperties(HashMap<String, Object> map) {
		for(Object key : map.keySet()){
			if((key.toString()).equals("droppedValues")){
				setDroppedValues(Integer.parseInt(map.get(key).toString()));
				setDroppedValuesPercentage(0.0f);
			}
			if((key.toString()).equals("droppedValuesPercentage")){
				setDroppedValues(0);
				setDroppedValuesPercentage(Float.parseFloat(map.get(key).toString()));
				
			}
		}
		transformData();
		setChanged();
		notifyObservers();
		
	}
	@Override
	public Object getAdapter(Class adapter) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * update, if the observable object changed and notify observers
	 */
	@Override
	public void update(Observable o, Object arg) {
		transformData();
		setChanged();
		notifyObservers();
	}

	@Override
	public void setInitializationData(IConfigurationElement config,
			String propertyName, Object data) throws CoreException {
		// TODO Auto-generated method stub
		
	}
}
