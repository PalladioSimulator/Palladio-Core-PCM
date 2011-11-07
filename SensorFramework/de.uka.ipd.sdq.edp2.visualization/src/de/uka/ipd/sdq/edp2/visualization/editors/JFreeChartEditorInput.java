/**
 * 
 */
package de.uka.ipd.sdq.edp2.visualization.editors;

import java.util.HashMap;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;
import org.jfree.chart.JFreeChart;

import de.uka.ipd.sdq.edp2.visualization.IDataSink;
import de.uka.ipd.sdq.edp2.visualization.IDataSource;
import de.uka.ipd.sdq.edp2.visualization.properties.SpecificChartProperties;
import de.uka.ipd.sdq.edp2.visualization.properties.sections.CommonChartProperties;

/**
 * @author Dominik Ernst
 * 
 */
public abstract class JFreeChartEditorInput implements IDataSink, ISelection {

	/**
	 * Key under which this class' name is stored in the properties.
	 */
	protected static final String ELEMENT_KEY = "elementName";

	/**
	 * Key under which this editor's title is stored in the properties.
	 */
	protected static final String TITLE_KEY = "editorTitle";
	/**
	 * The properties of this {@link JFreeChartEditorInput}, which are persisted
	 * and displayed in the 'Display'-Tab of the Properties-View.
	 */
	protected HashMap<String, Object> properties;
	/**
	 * The {@link IEditorInput}'s or rather {@link IDataSink}'s predecessor.
	 */
	private IDataSource source;
	/**
	 * Reference on the current chart.
	 */
	private JFreeChart chart;
	/**
	 * The title for the chart.
	 */
	private String title;

	public JFreeChartEditorInput() {
		properties = new HashMap<String, Object>();
	}

	public JFreeChartEditorInput(IDataSource source) {
		properties = new HashMap<String, Object>();
		setSource(source);
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.uka.ipd.sdq.edp2.visualization.IDataSink#setSource(de.uka.ipd.sdq.
	 * edp2.visualization.IDataSource)
	 */
	@Override
	public void setSource(IDataSource source) {
		if (this.source != null)
			getSource().deleteObserver(this);
		this.source = source;
		source.addObserver(this);
		updateDataset();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IEditorInput#exists()
	 */
	@Override
	public boolean exists() {
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
	@Override
	public String getName() {
		return title;
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

	/**
	 * Returns the current Chart of the editor. Creates a new one if none
	 * exists.
	 * 
	 * @return the currently displayed chart.
	 */
	public JFreeChart getChart() {
		if (chart == null)
			createChart();
		return chart;
	}

	/**
	 * Set the current JFreeChart.
	 * 
	 * @param chart
	 */
	public void setChart(JFreeChart chart) {
		this.chart = chart;
	}

	/**
	 * Creates a new {@link JFreeChart}. Charts are specific for each
	 * EditorInput. Typically an update of the current DataSet is recommended,
	 * before the chart itself is updated.
	 */
	public abstract JFreeChart createChart();

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
	 * Retrieves actual measurements from repository and wraps them to into a
	 * dataset. The dataset is used to be displayed in an JFreeChart editor.
	 */
	public abstract void updateDataset();
	
	/**
	 * This method delivers the particular bean-class, which is used to describe the chart's properties.
	 * @param <T> the particular type of properties for this editor input.
	 * @return the properties class, which forwards changes in its attributes to the {@link JFreeChart}
	 */
	public abstract SpecificChartProperties getChartProperties();

}
