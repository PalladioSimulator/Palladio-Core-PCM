package de.uka.ipd.sdq.edp2.visualization;

import java.util.ArrayList;
import java.util.Observer;

import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorInput;
import org.jfree.data.general.AbstractSeriesDataset;

import de.uka.ipd.sdq.edp2.models.ExperimentData.MetricDescription;
import de.uka.ipd.sdq.edp2.visualization.editors.AbstractEditor;

/**
 * A {@link IDataSink} represents an Object which receives input by an
 * {@link AbstractDataSource}. Objects, which implement only {@link IDataSink}
 * instead of subclassing {@link AbstractTransformation}, are inputs for
 * different {@link AbstractEditor}s or rather their specific
 * {@link IEditorInputHandle}. Because Editor inputs and transformations both
 * may be (and typically are) located in separate plugins, all {@link IDataSink}
 * s extend {@link IExecutableExtension}.
 * 
 * 
 * @author Dominik Ernst
 * 
 */
public interface IDataSink extends IDataFlow, Observer, IExecutableExtension {
	/**
	 * @return The current IDataSource.
	 */
	AbstractDataSource getSource();

	/**
	 * @param source
	 *            The IDataSource which represents the input for this sink.
	 */
	void setSource(AbstractDataSource source);

	/**
	 * Roles are MetricDescriptions, which this IDataSink can use (i.e. its
	 * editor can display) for the given source.
	 * 
	 * @return A list of metric descriptions, applicable to any source.
	 */
	ArrayList<MetricDescription> getMetricRoles();

	/**
	 * 
	 * @return <true> if there exists a MetricDescription that accepts the
	 *         source.
	 */
	boolean canAccept(AbstractDataSource source);

	/**
	 * 
	 * @return a new Instance of the data type, which is required to display the
	 *         data of this {@link IDataSink}.
	 */
	Object getDataTypeInstance();

	/**
	 * Adds this {@link IDataSink}'s data to the specified {@link IDataSink}'s data type instance.
	 * This method is used by {@link IEditorInputHandle}s if multiple editor inputs are displayed in the
	 * same visualization.
	 * @param toSink
	 *            the {@link IDataSink} to which this Sink adds its Data
	 * @return the combined data in a format which is used by the data type of
	 *         the <toSink>
	 */
	Object getCombinedData(IDataSink addedSink);
}
