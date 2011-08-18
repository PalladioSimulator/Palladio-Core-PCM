/**
 * 
 */
package de.uka.ipd.sdq.edp2.visualization.editors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.measure.Measure;
import javax.xml.transform.Source;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPersistableElement;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.jfree.data.xy.DefaultTableXYDataset;
import org.jfree.data.xy.XYSeries;

import de.uka.ipd.sdq.edp2.OrdinalMeasurementsDao;
import de.uka.ipd.sdq.edp2.impl.DataNotAccessibleException;
import de.uka.ipd.sdq.edp2.impl.MeasurementsUtility;
import de.uka.ipd.sdq.edp2.impl.RepositoryManager;
import de.uka.ipd.sdq.edp2.models.ExperimentData.DataSeries;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MetricDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MetricSetDescription;
import de.uka.ipd.sdq.edp2.models.Repository.Repository;
import de.uka.ipd.sdq.edp2.visualization.IDataSink;
import de.uka.ipd.sdq.edp2.visualization.IDataSource;
import de.uka.ipd.sdq.edp2.visualization.datasource.EDP2SourceFactory;

/**
 * Input for {@link ScatterPlotEditor} .
 * 
 * @author Dominik Ernst, Roland Richter
 */
public class ScatterPlotInput implements IDataSink, ISelection {

	/**
	 * Logger for this class.
	 */
	private final static Logger logger = Logger
			.getLogger(ScatterPlotInput.class.getCanonicalName());

	private IDataSource source;
	private DefaultTableXYDataset dataset;
	private String name;
	private String toolTipText;
	private String labelXScale;
	private String labelYScale;

	public ScatterPlotInput(IDataSource source) {
		setSource(source);
		source.addObserver(this);
		updateDataset();
	}

	/**
	 * Retrieves actual measurements from repository and assigns them to the
	 * dataset. this dataset is used by the editor to display in the
	 * scatterplot.
	 */
	@SuppressWarnings("unchecked")
	public void updateDataset() {

		logger.log(Level.INFO, "Editor input updateDataSet begin");
		
		DefaultTableXYDataset dataset = new DefaultTableXYDataset();
		this.setDataset(dataset);
		ArrayList<OrdinalMeasurementsDao<Measure>> list = new ArrayList<OrdinalMeasurementsDao<Measure>>();
		for (DataSeries data : getSource().getOutput()) {
			list.add(MeasurementsUtility.getOrdinalMeasurementsDao(data));
		}
		OrdinalMeasurementsDao<Measure> omdSeries1 = MeasurementsUtility
				.getOrdinalMeasurementsDao(source.getOutput().get(0));
		OrdinalMeasurementsDao<Measure> omdSeries2 = MeasurementsUtility
				.getOrdinalMeasurementsDao(source.getOutput().get(1));
		List<Measure> list1 = omdSeries1.getMeasurements();

		List<Measure> list2 = omdSeries2.getMeasurements();

		XYSeries testSeries = new XYSeries(list1.get(0), false, false);
		for (int i = 0; i < list1.size(); i++) {
			Measure x = list1.get(i);
			Measure y = list2.get(i);
			testSeries.add(x.doubleValue(x.getUnit()), y.doubleValue(y
					.getUnit()));
		}

		dataset.addSeries(testSeries);

		// set the name and the description
		setName(source.getOriginalMeasurementsRange().getMeasurements()
				.getExperimentRun().getExperimentSetting().getDescription());
		setToolTipText(source.getMeasurementsRange().getMeasurements()
				.getMeasure().getMetric().getTextualDescription());

		// label data series according to metric definitions
		MetricSetDescription md = (MetricSetDescription) getSource()
				.getOutput().get(0).getRawMeasurements().getMeasurementsRange()
				.getMeasurements().getMeasure().getMetric();

		setLabelXScale(md.getSubsumedMetrics().get(0).getName() + " ( "
				+ ((Measure) list1.get(0)).getUnit() + ")");
		setLabelYScale(md.getSubsumedMetrics().get(1).getName() + " ( "
				+ ((Measure) list2.get(0)).getUnit() + ")");
		
		logger.log(Level.INFO, "Editor input updateDataSet end");
		
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
	 * @see
	 * de.uka.ipd.sdq.edp2.visualization.IDataSink#setSource(de.uka.ipd.sdq.
	 * edp2.visualization.IDataSource)
	 */
	@Override
	public void setSource(IDataSource source) {
		this.source = source;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IPersistableElement#getFactoryId()
	 */
	@Override
	public String getFactoryId() {
		// TODO Auto-generated method stub
		return ScatterPlotInputFactory.getFactoryId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IPersistable#saveState(org.eclipse.ui.IMemento)
	 */
	@Override
	public void saveState(IMemento memento) {
		ScatterPlotInputFactory.saveState(memento, this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 */
	@Override
	public Object getAdapter(Class adapter) {
		if (adapter == IPropertySource.class) {
			return this;
		}
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

		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IEditorInput#exists()
	 */
	@Override
	public boolean exists() {
		// TODO Auto-generated method stub
		return source != null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IEditorInput#getImageDescriptor()
	 */
	@Override
	public ImageDescriptor getImageDescriptor() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IEditorInput#getName()
	 */
	/**
	 * @return the attribute {@link ScatterPlotInput#name}
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            set the attribute {@link ScatterPlotInput#name}.
	 */
	private void setName(String name) {
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IEditorInput#getPersistable()
	 */
	@Override
	public IPersistableElement getPersistable() {
		return this;
	}

	/**
	 * Has to be implemented, @see org.eclipse.ui.IEditorInput#getToolTipText()
	 * 
	 * @return gets the attribute {@link ScatterPlotInput#toolTipText}
	 */
	@Override
	public String getToolTipText() {
		return toolTipText;
	}

	/**
	 * @param toolTipText
	 */
	private void setToolTipText(String toolTipText) {
		this.toolTipText = toolTipText;
	}

	/**
	 * @return the attribute {@link ScatterPlotInput#labelXScale}
	 */
	public String getLabelXScale() {
		return labelXScale;
	}

	/**
	 * @param labelXScale
	 */
	private void setLabelXScale(String labelXScale) {
		this.labelXScale = labelXScale;
	}

	/**
	 * @return the attribute {@link ScatterPlotInput#labelYScale}
	 */
	public String getLabelYScale() {
		return labelYScale;
	}

	/**
	 * @param labelYScale
	 *            set the attribute {@link #labelYScale} new
	 */
	private void setLabelYScale(String labelYScale) {
		this.labelYScale = labelYScale;
	}

	/**
	 * @param dataset
	 *            set the attribute {@link #dataset} new
	 */
	public void setDataset(DefaultTableXYDataset dataset) {
		this.dataset = dataset;

	}

	/**
	 * @return the attribute {@link ScatterPlotInput#dataset}
	 */
	public DefaultTableXYDataset getDataset() {
		return dataset;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.ISelection#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.edp2.visualization.IDataSink#getSource()
	 */
	@Override
	public IDataSource getSource() {
		return source;
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

}
