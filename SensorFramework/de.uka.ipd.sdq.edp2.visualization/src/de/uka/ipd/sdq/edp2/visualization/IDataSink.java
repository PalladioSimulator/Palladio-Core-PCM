package de.uka.ipd.sdq.edp2.visualization;

import java.util.ArrayList;
import java.util.Observer;

import org.eclipse.ui.IEditorInput;

import de.uka.ipd.sdq.edp2.models.ExperimentData.MetricDescription;
import de.uka.ipd.sdq.edp2.visualization.editors.AbstractEditor;

/**
 * A {@link IDataSink} represents an Object which receives input by an {@link IDataSource}.
 * Objects, which implement only {@link IDataSink} instead of subclassing {@link AbstractTransformation},
 * are inputs for different {@link AbstractEditor}s.
 * @author Dominik Ernst
 * 
 */
public interface IDataSink extends IDataFlow, Observer, IEditorInput {
	/**
	 * @return The current IDataSource. 
	 */
	IDataSource getSource();

	/**
	 * @param source The IDataSource which represents the input for this sink.
	 */
	void setSource(IDataSource source);

	/**
	 * Roles are MetricDescriptions, which this IDataSink can use (i.e. its editor can display)
	 * for the given source.
	 * 
	 * @return A list of metric descriptions, applicable to any source.
	 */
	ArrayList<MetricDescription> getMetricRoles();
	/**
	 * 
	 * @return TRUE if there exists a MetricDescription that accepts the source.
	 */
	boolean canAccept(IDataSource source);
}
