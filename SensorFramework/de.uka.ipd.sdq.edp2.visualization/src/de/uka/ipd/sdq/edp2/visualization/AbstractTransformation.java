package de.uka.ipd.sdq.edp2.visualization;

import java.util.HashMap;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;

import de.uka.ipd.sdq.edp2.models.ExperimentData.MeasurementsRange;

/**
 * Provides a default implementation of a transformation.
 * 
 * @author Dominik Ernst, Roland Richter
 */
public abstract class AbstractTransformation extends AbstractDataSource
		implements IDataSink {

	/**
	 * The previous element in a chain of {@link IDataFlow} elements.
	 */
	protected AbstractDataSource source;
	/**
	 * Key under which this class' name is stored in the properties.
	 */
	protected static final String ELEMENT_KEY = "elementName";

	/**
	 * Default, empty constructor.
	 */
	public AbstractTransformation() {
		super();
	}

	/**
	 * A constructor implementation, which keeps the reference on the original
	 * {@link MeasurementsRange} reference alive.
	 * 
	 * @param source
	 *            The source attached to this {@link AbstractTransformation}.
	 */

	public AbstractTransformation(AbstractDataSource source) {
		if (source != null) {
			setSource(source);
		}
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
		setOriginalMeasurementsRange(source.getOriginalMeasurementsRange());
		transformData();
	}

	/**
	 * Method which should contain the transformation logic of Filters or
	 * Adapters.
	 */
	public abstract void transformData();

	/**
	 * @param originalMeasurementsRange
	 *            the originalMeasurementsRange to set
	 */
	private void setOriginalMeasurementsRange(
			MeasurementsRange originalMeasurementsRange) {
		this.originalMeasurementsRange = originalMeasurementsRange;
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
		// as long as it has no relevance, the empty method is added here to
		// avoid unnecessary implementation
		// or misunderstandings
	}

	/**
	 * Method which checks the existence of the given key in two {@link HashMap}
	 * s: the <code>newProperties</code> specified as a parameter and the
	 * <code>properties</code>, which are currently set for this
	 * {@link AbstractTransformation}.
	 * 
	 * @param newProperties
	 *            the set of properties to set
	 * @param key
	 *            the key of a property, for which to check non-null
	 * @return <code>true</code>, if both the new and the old set of properties
	 *         contain a non-null entry with the given key
	 */
	public boolean validProperties(HashMap<String, Object> newProperties,
			String key) {
		return (properties.get(key) != null && newProperties.get(key) != null);
	}

}
