/**
 * 
 */
package de.uka.ipd.sdq.edp2.visualization.editors;

import java.awt.Color;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.jface.viewers.ISelection;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.Dataset;

import de.uka.ipd.sdq.edp2.visualization.IVisualizationInput;

/**
 * Basic implementation of an {@link IVisualizationInput} for the
 * {@link JFreeChartEditor}. Responsible for common properties of any subclass
 * of {@link JFreeChartEditorInput}.
 * 
 * @author Dominik Ernst
 * 
 */
public abstract class JFreeChartEditorInput<T extends Dataset> extends
		IVisualizationInput implements ISelection {

	/**
	 * Keys used for persistence of properties.
	 */
	public static final String COLOR_KEY = "color";
	public final static String ALPHA_KEY = "alpha";

	/**
	 * Constant, describing that no color is used for this input (actually, it
	 * is white).
	 */
	public final static String NO_COLOR = "#ffffff";
	/**
	 * Color for this {@link JFreeChartEditorInput}'s data in the graph.
	 */
	private String hexColor;
	/**
	 * The alpha value for this {@link JFreeChartEditorInput}'s color.
	 */
	private float alpha;

	private JFreeChartEditorInputHandle handle;

	protected T dataset;

	public JFreeChartEditorInput() {
		// set default values
		setColor(NO_COLOR);
		setAlpha(1.0f);
		// add to properties
		properties.put(COLOR_KEY, NO_COLOR);
		properties.put(ALPHA_KEY, getAlpha());
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
	 * 
	 * @param handle
	 *            reference to the handle for all inputs
	 * @return a typed Dataset
	 */
	public T getDataset() {
		return dataset;
	}

	public String getColor() {
		return hexColor;
	}

	public void setColor(String color) {
		Color col = Color.decode(color);
		setColor(col);
	}

	public void setColor(Color color) {
		this.hexColor = "#" + Integer.toHexString(color.getRGB()).substring(2);
	}

	/**
	 * Method to return a default-title for the specific chart as provided by
	 * sub-classes. Typically used during chart creation in {@link #getChart()}.
	 * 
	 * @return a {@link String} used as the default chart title.
	 */
	public abstract String getDefaultTitle();

	public float getAlpha() {
		return alpha;
	}

	public void setAlpha(float alpha) {
		if (alpha < 0) {
			this.alpha = 0.0f;
		} else if (alpha > 1) {
			this.alpha = 1.0f;
		} else {
			this.alpha = alpha;
		}
	}

	public void setHandle(JFreeChartEditorInputHandle toHandle) {
		this.handle = toHandle;
	}

	public boolean hasHandle() {
		return handle != null;
	}

	public JFreeChartEditorInputHandle getHandle() {
		if (handle == null)
			throw new RuntimeException(
					"No Handle set for this JFreeChartEditorInput!");
		return handle;
	}

}
