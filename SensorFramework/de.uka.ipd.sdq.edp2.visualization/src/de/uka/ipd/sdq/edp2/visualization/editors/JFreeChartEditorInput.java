/**
 * 
 */
package de.uka.ipd.sdq.edp2.visualization.editors;

import java.util.HashMap;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.jface.viewers.ISelection;
import java.awt.Color;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.AbstractSeriesDataset;

import de.uka.ipd.sdq.edp2.visualization.AbstractDataSource;
import de.uka.ipd.sdq.edp2.visualization.IVisualizationInput;
import de.uka.ipd.sdq.edp2.visualization.properties.IProperty;

/**
 * @author Dominik Ernst
 * 
 */
public abstract class JFreeChartEditorInput extends IVisualizationInput
		implements ISelection {

	
	public static final String COLOR_KEY = "color";
	
	

	/**
	 * Constant, describing that no color is used for this input (actually, it is white).
	 */
	public final static String NO_COLOR = "#ffffff";
	
	/**
	 * Color for this {@link JFreeChartEditorInput}'s data in the graph.
	 */
	private String hexColor;
	
	public JFreeChartEditorInput() {
		properties = new HashMap<String, Object>();
	}

	public JFreeChartEditorInput(AbstractDataSource source) {
		properties = new HashMap<String, Object>();
		setSource(source);
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
	
	public abstract String getDefaultTitle();
	
	public abstract String getDefaultDomainAxisLabel();
	
	public abstract String getDefaultRangeAxisLabel();

}
