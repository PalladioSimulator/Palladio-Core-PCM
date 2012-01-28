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
	 * Key under which this class' name is stored in the properties.
	 */
	protected static final String ELEMENT_KEY = "elementName";

	/**
	 * The properties of this {@link JFreeChartEditorInput}, which are persisted
	 * and displayed in the 'Display'-Tab of the Properties-View.
	 */
	protected HashMap<String, Object> properties;
	/**
	 * The {@link IEditorInput}'s or rather {@link IDataSink}'s predecessor.
	 */
	private AbstractDataSource source;
	/**
	 * The title for the chart.
	 */
	private String title;

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
	 * @see de.uka.ipd.sdq.edp2.visualization.IDataSink#getSource()
	 */
	@Override
	public AbstractDataSource getSource() {
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
	public void setSource(AbstractDataSource source) {
		if (this.source != null)
			getSource().deleteObserver(this);
		this.source = source;
		source.addObserver(this);
		updateDataset();
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
	 * Retrieves actual measurements from repository and wraps them to into a
	 * dataset. The dataset is used to be displayed in an JFreeChart editor.
	 */
	public abstract void updateDataset();

	/**
	 * This method delivers the particular bean-class, which is used to describe
	 * the chart's properties.
	 * 
	 * @param <T>
	 *            the particular type of properties for this editor input.
	 * @return the properties class, which forwards changes in its attributes to
	 *         the {@link JFreeChart}
	 */
	public abstract SpecificChartProperties getChartProperties();

	public abstract JFreeChart getChart();

	public ArrayList<AbstractTransformation> getListOfTransformations() {
		// a list which holds all transformations (not the current datasource
		// and not the current visualization)
		ArrayList<AbstractTransformation> listOfTransformations = new ArrayList<AbstractTransformation>();
		// while it is not clear, if there are any transformations at all,
		// use the new source
		// as the direct predecessor
		AbstractDataSource previousElement = getSource();
		// if the previousElement is also an implementation of IDataSink, it
		// consequently is a transformation
		while (previousElement instanceof IDataSink) {
			AbstractTransformation previousTransformation = (AbstractTransformation) previousElement;
			listOfTransformations.add(previousTransformation);
			previousElement = previousTransformation.getSource();
		}
		return listOfTransformations;
	}

	public IVisualizationInput createTransformationsChainCopy(
			AbstractDataSource source) {
		ArrayList<AbstractTransformation> listOfTransformations = (ArrayList<AbstractTransformation>) getListOfTransformations()
				.clone();
		// invert the list of transformations' order
		Collections.reverse(listOfTransformations);
		AbstractDataSource inputSource = source;
		// create copies of the elements, using the previously created copy as
		// each element's source
		if (!listOfTransformations.isEmpty()) {
			AbstractTransformation firstTransformation = (AbstractTransformation) listOfTransformations
					.remove(0).createCopyForSource(source);
			AbstractTransformation lastTransformation = firstTransformation;
			for (AbstractTransformation transformation : listOfTransformations) {
				lastTransformation = (AbstractTransformation) transformation
						.createCopyForSource(lastTransformation);
			}
			inputSource = lastTransformation;
		}
		return (IVisualizationInput) createCopyForSource(inputSource);

	}

}
