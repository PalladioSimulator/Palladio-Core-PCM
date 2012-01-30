/**
 * 
 */
package de.uka.ipd.sdq.edp2.visualization.editors;

import java.util.ArrayList;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.databinding.observable.set.SetChangeEvent;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPersistableElement;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.general.AbstractSeriesDataset;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;

import de.uka.ipd.sdq.edp2.visualization.IDataSink;
import de.uka.ipd.sdq.edp2.visualization.IVisualizationInput;
import de.uka.ipd.sdq.edp2.visualization.IVisualizationInputHandle;
import de.uka.ipd.sdq.edp2.visualization.properties.CommonJFreeChartProperties;
import de.uka.ipd.sdq.edp2.visualization.properties.sections.CommonJFreeChartPropertiesComposite;

/**
 * Implementation of an {@link IVisualizationInputHandle} for
 * {@link JFreeChartEditorInput}s.
 * 
 * @author Dominik Ernst
 * 
 */
public class JFreeChartEditorInputHandle extends IVisualizationInputHandle<JFreeChartEditorInput> {

	Logger logger = Logger.getLogger(JFreeChartEditorInputHandle.class
			.getCanonicalName());

	private ArrayList<JFreeChartEditorInput> inputs;
	private BasicDataset<?> dataset;
	private XYPlot plot;
	private XYItemRenderer renderer;
	private JFreeChart chart;

	/**
	 * Empty constructor.
	 */
	public JFreeChartEditorInputHandle() {
		inputs = new ArrayList<JFreeChartEditorInput>();
	}

	/**
	 * Constructor with a first input.
	 */
	public JFreeChartEditorInputHandle(JFreeChartEditorInput firstInput) {
		inputs = new ArrayList<JFreeChartEditorInput>();
		addInput(firstInput);
		dataset = firstInput.getBasicDataset();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.uka.ipd.sdq.edp2.visualization.IEditorInputHandler#addInput(de.uka
	 * .ipd.sdq.edp2.visualization.IDataSink)
	 */
	@Override
	public boolean addInput(JFreeChartEditorInput newInput) {
		// if it is the first input, the <newInput> is added in any case.
		if (inputs.size() == 0) {
			inputs.add((JFreeChartEditorInput) newInput);
			dataset.addDataSeries(newInput);
			newInput.addObserver(this);
			setChanged();
			notifyObservers();
			return true;
		} else {
			inputs.add((JFreeChartEditorInput) newInput);
			dataset.addDataSeries(newInput);
			newInput.addObserver(this);
			setChanged();
			notifyObservers();
			return true;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.uka.ipd.sdq.edp2.visualization.IEditorInputHandler#getInputDataset()
	 */
	@Override
	public Object getInputData() {
		
		return dataset;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.edp2.visualization.IEditorInputHandler#getInputs()
	 */
	@Override
	public ArrayList<JFreeChartEditorInput> getInputs() {
		return inputs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.uka.ipd.sdq.edp2.visualization.IEditorInputHandler#removeInput(de.
	 * uka.ipd.sdq.edp2.visualization.IDataSink)
	 */
	@Override
	public boolean removeInput(JFreeChartEditorInput removedInput) {
		throw new RuntimeException("Not implemented.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IEditorInput#exists()
	 */
	@Override
	public boolean exists() {
		return !inputs.isEmpty();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IEditorInput#getImageDescriptor()
	 */
	@Override
	public ImageDescriptor getImageDescriptor() {
		throw new RuntimeException("Not implemented.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IEditorInput#getName()
	 */
	@Override
	public String getName() {
		return "someName";
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IEditorInput#getToolTipText()
	 */
	@Override
	public String getToolTipText() {
		// TODO Auto-generated method stub
		return "someTT";
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
	public void update(Observable o, Object arg) {
		logger.log(Level.INFO, "update invoked");
		createChart();
		setChanged();
		notifyObservers();
	}

	@Override
	public int getInputsSize() {
		return inputs.size();
	}

	/**
	 * Creates a new {@link JFreeChart}. Charts are specific for each
	 * EditorInput. Typically an update of the current DataSet is recommended,
	 * before the chart itself is updated.
	 */
	public JFreeChart createChart() {
		chart = getInputs().get(0).getChart();
		getInputData();
		return chart;
	}

	@Override
	public boolean isEmpty() {
		return getInputsSize() == 0;
	}

	@Override
	public String getFactoryId() {
		return JFreeChartEditorInputHandleFactory.getFactoryId();
	}

	@Override
	public void saveState(IMemento memento) {
		JFreeChartEditorInputHandleFactory.saveState(memento, this);
	}

	@Override
	public boolean supportsMultipleInputs() {
		return true;
	}

	@Override
	public Composite getCommonPropertiesComposite(Composite parent) {
		return new CommonJFreeChartPropertiesComposite(parent, SWT.EMBEDDED,
				new CommonJFreeChartProperties(chart));
	}

}
