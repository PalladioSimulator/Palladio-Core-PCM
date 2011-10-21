/**
 * 
 */
package de.uka.ipd.sdq.edp2.visualization.editors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;

import javax.measure.Measure;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPersistableElement;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import de.uka.ipd.sdq.edp2.OrdinalMeasurementsDao;
import de.uka.ipd.sdq.edp2.impl.DataNotAccessibleException;
import de.uka.ipd.sdq.edp2.impl.MeasurementsUtility;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MetricDescription;
import de.uka.ipd.sdq.edp2.visualization.IDataSink;
import de.uka.ipd.sdq.edp2.visualization.IDataSource;

/**
 * FIXME not up-to-date
 * @author Dominik Ernst
 *
 */
public class PieChartEditorInput implements IDataSink {
	
	private IDataSource source;
	private DefaultPieDataset dataset;
	
	public DefaultPieDataset getDataset() {
		return dataset;
	}
	public void setDataset(DefaultPieDataset dataset) {
		this.dataset = dataset;
	}
	public PieChartEditorInput(IDataSource source) {
		this.source = source;
		updateDataset();
	}
	@SuppressWarnings("unchecked")
	public void updateDataset() {
		dataset = new DefaultPieDataset();
		/*ArrayList<OrdinalMeasurementsDao<Measure>> list = new ArrayList<OrdinalMeasurementsDao<Measure>>();
		for (DataSeries data : source.getOutput()) {
			list.add(MeasurementsUtility.getOrdinalMeasurementsDao(data));
		}*/
		OrdinalMeasurementsDao<Measure> omdSeries1 = MeasurementsUtility
				.getOrdinalMeasurementsDao(source.getOutput().get(0));
		OrdinalMeasurementsDao<Measure> omdSeries2 = MeasurementsUtility
				.getOrdinalMeasurementsDao(source.getOutput().get(1));
		List<Measure> list1 = omdSeries1.getMeasurements();
		List<Measure> list2 = omdSeries2.getMeasurements();
		
		double value = 0;
		for (Measure x : list1) {
			value++;
		}
		dataset.setValue("series1", value);
		value = 0;
		for (Measure y : list2) {
			value++;
		}
		dataset.setValue("series2", value);
		
	}
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.presentation.IDataSink#canAccept(de.uka.ipd.sdq.edp2.models.ExperimentData.presentation.IDataSource)
	 */
	@Override
	public boolean canAccept(IDataSource source) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.presentation.IDataSink#getMetricRoles()
	 */
	@Override
	public ArrayList<MetricDescription> getMetricRoles() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.presentation.IDataSink#getSource()
	 */
	@Override
	public IDataSource getSource() {
		// TODO Auto-generated method stub
		return source;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.presentation.IDataSink#setSource(de.uka.ipd.sdq.edp2.models.ExperimentData.presentation.IDataSource)
	 */
	@Override
	public void setSource(IDataSource source) {
		this.source = source;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IPersistableElement#getFactoryId()
	 */
	@Override
	public String getFactoryId() {
		return PieChartEditorInputFactory.getFactoryId();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IPersistable#saveState(org.eclipse.ui.IMemento)
	 */
	@Override
	public void saveState(IMemento memento) {
		PieChartEditorInputFactory.saveState(memento, this);

	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 */
	@Override
	public Object getAdapter(Class adapter) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IEditorInput#exists()
	 */
	@Override
	public boolean exists() {
		// TODO Auto-generated method stub
		return source != null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IEditorInput#getImageDescriptor()
	 */
	@Override
	public ImageDescriptor getImageDescriptor() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IEditorInput#getName()
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "someName";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IEditorInput#getPersistable()
	 */
	@Override
	public IPersistableElement getPersistable() {
		// TODO Auto-generated method stub
		return this;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IEditorInput#getToolTipText()
	 */
	@Override
	public String getToolTipText() {
		// TODO Auto-generated method stub
		return "someTT";
	}
	@Override
	public HashMap<String, Object> getProperties() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setProperties(HashMap<String, Object> newProperties) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setInitializationData(IConfigurationElement config,
			String propertyName, Object data) throws CoreException {
		// TODO Auto-generated method stub
		
	}

}
