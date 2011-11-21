package de.uka.ipd.sdq.edp2.visualization;

import java.util.HashMap;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.ui.IPersistableElement;
import org.jfree.data.general.AbstractSeriesDataset;

import de.uka.ipd.sdq.edp2.models.ExperimentData.MeasurementsRange;

/**
 * Provides a default implementation of a transformation. Should be subclassed
 * by all transformations.
 * 
 * @author Dominik Ernst, Roland Richter
 */
public abstract class AbstractTransformation extends AbstractDataSource implements
		IDataSink {

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
		// TODO Auto-generated method stub
		// as long as it has no relevance, the empty method is added here to
		// avoid unnecessary implementation
		// or misunderstandings
	}
	
	/**
	 * Method which checks the existence of the given key in both {@link HashMap}s: <newProperties> and
	 * the <properties> which are currently set for this {@link AbstractTransformation}.
	 * @param newProperties the set of properties to set
	 * @param key the key for which property to check non-null 
	 * @return <true> if both the new and the old set of properties contain an entry with the given key
	 */
	public boolean validProperties(HashMap<String, Object> newProperties, String key){
		return (properties.get(key) != null
				&& newProperties.get(key) != null);
	}
	
	/*
	 * (non-Javadoc)
	 * @see de.uka.ipd.sdq.edp2.visualization.IDataSink#getDataTypeInstance()
	 */
	@Override
	public Object getDataTypeInstance() {
		//transformations are no editor inputs, thus they cannot be displayed.
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * @see de.uka.ipd.sdq.edp2.visualization.IDataSink#getData()
	 */
	@Override
	public Object getData() {
		//transformations are no editor inputs, thus they cannot be displayed.
		return null;
	}

}
