/**
 * 
 */
package de.uka.ipd.sdq.edp2.visualization.editors;

import java.awt.Color;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.jface.viewers.ISelection;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.AbstractSeriesDataset;

import de.uka.ipd.sdq.edp2.visualization.IVisualizationInput;

/**
 * Basic implementation of an {@link IVisualizationInput} for the {@link JFreeChartEditor}.
 * Responsible for common properties of any subclass of {@link JFreeChartEditorInput}.
 * @author Dominik Ernst
 * 
 */
public abstract class JFreeChartEditorInput extends IVisualizationInput
		implements ISelection {

	/**
	 * Keys used for persistence of properties.
	 */
	public static final String COLOR_KEY = "color";
	
	/**
	 * Constant, describing that no color is used for this input (actually, it is white).
	 */
	public final static String NO_COLOR = "#ffffff";
	
	/**
	 * Color for this {@link JFreeChartEditorInput}'s data in the graph.
	 */
	private String hexColor;
	
	public JFreeChartEditorInput(){
		properties.put(COLOR_KEY, NO_COLOR);
		setColor(NO_COLOR);
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
		// not used/needed so far
	}

	/**
	 * Returns the JFreeChart, using the specific dataset, which is required by
	 * the implementing class.
	 * 
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
	 * Generic method which returns a typed instance of the wrapper for datasets
	 * used by JFreeCharts.
	 * @param handle reference to the handle for all inputs
	 * @return a typed Dataset
	 */
	public abstract <T extends AbstractSeriesDataset> BasicDataset<T> getBasicDataset();

	public String getColor() {
		return hexColor;
	}

	public void setColor(String color){
		Color col = Color.decode(color);
		setColor(col);
	}
	public void setColor(Color color) {
		this.hexColor = "#"+Integer.toHexString(color.getRGB()).substring(2);
	}
	
	/**
	 * Method to return a default-title for the specific chart as provided by sub-classes.
	 * Typically used during chart creation in {@link #getChart()}.
	 * @return a {@link String} used as the default chart title.
	 */
	public abstract String getDefaultTitle();
	
	/**
	 * Return a default label for the domain axis / horizontal axis.
	 * @return a {@link String} used as the default label for the domain axis.
	 */
	public abstract String getDefaultDomainAxisLabel();
	
	/**
	 * Return a default label for the range axis / vertical axis.
	 * @return a {@link String} used as the default label for the range axis.
	 */
	public abstract String getDefaultRangeAxisLabel();

}
