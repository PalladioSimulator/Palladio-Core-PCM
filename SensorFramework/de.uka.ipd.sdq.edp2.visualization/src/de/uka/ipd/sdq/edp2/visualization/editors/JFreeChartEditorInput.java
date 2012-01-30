/**
 * 
 */
package de.uka.ipd.sdq.edp2.visualization.editors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Observable;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.general.AbstractSeriesDataset;
import org.jfree.data.xy.XYDataset;

import de.uka.ipd.sdq.edp2.visualization.AbstractTransformation;
import de.uka.ipd.sdq.edp2.visualization.IDataFlow;
import de.uka.ipd.sdq.edp2.visualization.IDataSink;
import de.uka.ipd.sdq.edp2.visualization.AbstractDataSource;
import de.uka.ipd.sdq.edp2.visualization.IVisualizationInput;
import de.uka.ipd.sdq.edp2.visualization.properties.CommonJFreeChartProperties;
import de.uka.ipd.sdq.edp2.visualization.properties.SpecificChartProperties;

/**
 * @author Dominik Ernst
 * 
 */
public abstract class JFreeChartEditorInput extends IVisualizationInput
		implements ISelection {

	/**
	 * The title for the chart.
	 */
	private String title;

	public JFreeChartEditorInput(AbstractDataSource source) {
		properties = new HashMap<String, Object>();
		setSource(source);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IEditorInput#getName()
	 */
	@Override
	public String getName() {
		return title;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
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
		// not used so far
	}

	/**
	 * This method delivers the particular bean-class, which is used to describe
	 * the chart's properties.
	 * 
	 * @return the properties class, which forwards changes in its attributes to
	 *         the {@link JFreeChart}
	 */
	public abstract SpecificChartProperties getChartProperties();
	
	/**
	 * Returns the JFreeChart, using the specific dataset, which is required by the implementing class.
	 * @return a newly created {@link JFreeChart}
	 */
	public abstract JFreeChart getChart();
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.ISelection#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return this.source != null;
	}
	
	/**
	 * Generic method which returns a typed instance of the wrapper for datasets used by JFreeCharts. 
	 * @return
	 */
	public abstract <T extends AbstractSeriesDataset> BasicDataset<T> getBasicDataset();
	


}
