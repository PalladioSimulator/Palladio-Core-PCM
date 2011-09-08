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

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPersistableElement;
import org.eclipse.ui.part.EditorPart;
import org.jfree.data.general.Dataset;
import org.jfree.data.statistics.HistogramDataset;

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
	 * Name constant, which is used to identify this class in properties.
	 */
	private static final String ELEMENT_NAME = "HistogramEditorInput";
	/**
	 * The specific type of {@link Dataset}.
	 */
	private HistogramDataset dataset;
	/**
	 * Logger for this class
	 */
	private final static Logger logger = Logger.getLogger(HistogramEditorInput.class.getCanonicalName());

	/**
	 * 
	 * @return the dataset
	 */
	public HistogramDataset getDataset() {
		return dataset;
	}

	/**
	 * Changes the dataset to the specified one.
	 * @param dataset the new {@link HistogramDataset}
	 */
	public void setDataset(HistogramDataset dataset) {
		this.dataset = dataset;
	}
	/**
	 * 
	 */
	public HistogramEditorInput(){
		super();
	}
	/**
	 * Constructor, with reference on the source. Automatically initiates an update of
	 * the {@link #dataset}.
	 * @param source
	 */
	public HistogramEditorInput(IDataSource source) {
		super(source);
		updateDataset();
	}

	/**
	 * Parses the data within the current source and updates the {@link #dataset} in accordance.
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
		//TODO sorting seems to have no effect
		Collections.sort(listOfMeasures.get(0));
		double[] values = new double[listOfMeasures.get(0).size()];
		for (int i = 0; i < listOfMeasures.get(0).size(); i++) {
			values[i] = listOfMeasures.get(0).get(i).doubleValue(
					listOfMeasures.get(0).get(i).getUnit());
		}

		//source must be a HistogramAdapter
		//TODO change so that the adapter doesn't have to be the direct predecessor
		//FIXME shouldn't use PersistenceTag, but must get the number of bins
		dataset.addSeries(0,
				values, Integer.parseInt((String) (getSource().getProperties().get(PersistenceTag.NUMBER_OF_BINS.getID()))));
		//set the title
		setTitle("Histogram");

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
		// TODO Auto-generated method stub
		return false;
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
		// TODO Auto-generated method stub
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ISelection#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see de.uka.ipd.sdq.edp2.visualization.IDataFlow#getProperties()
	 */
	public HashMap<String, Object> getProperties() {
		properties.put(ELEMENT_KEY, ELEMENT_NAME);
		return properties;
	}

	/*
	 * (non-Javadoc)
	 * @see de.uka.ipd.sdq.edp2.visualization.IDataFlow#setProperties(java.util.HashMap)
	 */
	@Override
	public void setProperties(HashMap<String, Object> newProperties) {
		// TODO Auto-generated method stub
	}

}
