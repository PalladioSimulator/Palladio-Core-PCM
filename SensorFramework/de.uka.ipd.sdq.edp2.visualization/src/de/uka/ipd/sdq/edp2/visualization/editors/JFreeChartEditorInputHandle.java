/**
 * 
 */
package de.uka.ipd.sdq.edp2.visualization.editors;

import java.util.ArrayList;
import java.util.Observable;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPersistableElement;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.general.AbstractSeriesDataset;
import org.jfree.data.statistics.HistogramDataset;

import de.uka.ipd.sdq.edp2.visualization.IDataSink;
import de.uka.ipd.sdq.edp2.visualization.IEditorInputHandle;

/**
 * Implementation of an {@link IEditorInputHandle} for {@link JFreeChartEditorInput}s.
 * @author Dominik Ernst
 * 
 */
public class JFreeChartEditorInputHandle implements IEditorInputHandle {

	private ArrayList<IDataSink> inputs;
	private Object dataset;
	private XYPlot plot;
	private XYItemRenderer renderer;

	/**
	 * Empty constructor.
	 */
	public JFreeChartEditorInputHandle() {
		inputs = new ArrayList<IDataSink>();
	}

	/**
	 * Constructor with a first input.
	 */
	public JFreeChartEditorInputHandle(IDataSink firstInput) {
		inputs = new ArrayList<IDataSink>();
		addInput(firstInput);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.uka.ipd.sdq.edp2.visualization.IEditorInputHandler#addInput(de.uka
	 * .ipd.sdq.edp2.visualization.IDataSink)
	 */
	@Override
	public boolean addInput(IDataSink newInput) {
		// if it is the first input, the <newInput> is added in any case.
		inputs.add((JFreeChartEditorInput) newInput);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.uka.ipd.sdq.edp2.visualization.IEditorInputHandler#getInputDataset()
	 */
	@Override
	public Object getInputDataset() {
		
		dataset = inputs.get(0).getDataTypeInstance();
		if (dataset instanceof HistogramDataset) {
			HistogramDataset histogramDataset = (HistogramDataset) dataset;
			for (IDataSink input : inputs) {
				histogramDataset.addSeries(input.getName(), (double[])input.getData(), Integer
						.parseInt(input.getProperties().get("numberOfBins")
								.toString()));
			}
			plot = ((JFreeChartEditorInput) inputs.get(0)).createPlot();
			plot.setDataset(histogramDataset);
		}
		renderer = ((JFreeChartEditorInput) inputs.get(0)).createRenderer();

		return dataset;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.edp2.visualization.IEditorInputHandler#getInputs()
	 */
	@Override
	public ArrayList<IDataSink> getInputs() {
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
	public boolean removeInput(IDataSink removedInput) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IEditorInput#exists()
	 */
	@Override
	public boolean exists() {
		// TODO Auto-generated method stub
		return true;
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
	@Override
	public String getName() {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
		getInputDataset();
		NumberAxis domainAxis = new NumberAxis("x-Axis label");
		NumberAxis rangeAxis = new NumberAxis("y-Axis label");
		plot.setRenderer(renderer);
		plot.setRangeAxis(rangeAxis);
		plot.setDomainAxis(domainAxis);
		JFreeChart chart = new JFreeChart(inputs.get(0).getName(),
				JFreeChart.DEFAULT_TITLE_FONT, plot, true);
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

}
