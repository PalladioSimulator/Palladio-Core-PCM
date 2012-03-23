/**
 * 
 */
package de.uka.ipd.sdq.edp2.visualization.editors;

import java.util.HashMap;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.graphics.Color;
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

	public static final String TITLEY_KEY = "title";
	public static final String DOMAIN_AXIS_LABEL_KEY = "domainAxisLabel";
	public static final String RANGE_AXIS_LABEL_KEY = "rangeAxisLabel";
	public static final String COLOR_KEY = "color";

	/**
	 * The title for the chart. Only used if the input is the main input, i.e.
	 * the first input in case multiple inputs are supported by the editor.
	 */
	private String title;

	/**
	 * Label for the number axis (= horizontal axis)
	 */
	private String domainAxisLabel;

	/**
	 * Label for the range axis (= vertical axis)
	 */
	private String rangeAxisLabel;
	
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
		properties.put(TITLEY_KEY, title);
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
	 * @return
	 */
	public abstract <T extends AbstractSeriesDataset> BasicDataset<T> getBasicDataset();

	public String getDomainAxisLabel() {
		return domainAxisLabel;
	}

	public void setDomainAxisLabel(String domainAxisLabel) {
		properties.put(DOMAIN_AXIS_LABEL_KEY, domainAxisLabel);
		this.domainAxisLabel = domainAxisLabel;
	}

	public String getRangeAxisLabel() {
		return rangeAxisLabel;
	}

	public void setRangeAxisLabel(String rangeAxisLabel) {
		properties.put(RANGE_AXIS_LABEL_KEY, rangeAxisLabel);
		this.rangeAxisLabel = rangeAxisLabel;
	}

	public String getColor() {
		return hexColor;
	}

	public void setColor(Color color) {
		int r=color.getRed();
		int b = color.getBlue();
		int g = color.getGreen();
		this.hexColor = Integer.toHexString(r)+Integer.toHexString(b)+Integer.toHexString(g);
		properties.put(COLOR_KEY, hexColor);
	}

}
