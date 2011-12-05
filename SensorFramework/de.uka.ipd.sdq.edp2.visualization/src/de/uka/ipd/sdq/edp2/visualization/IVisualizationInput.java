package de.uka.ipd.sdq.edp2.visualization;

import java.util.ArrayList;

/**
 * Interface used to describe elements that are managed by an
 * {@link IVisualizationInputHandle}. It is important to note that the actual
 * input to an {@link IVisualization} is the {@link IVisualizationInputHandle}
 * and not implementations of this interface.
 * 
 * @author Dominik Ernst
 * 
 */
public interface IVisualizationInput extends IDataSink {
	/**
	 * Returns a new Instance of the data type, which is required to display the
	 * data of this {@link IVisualizationInput}.
	 * 
	 * @return a new Instance of the data type, which is required to display the
	 *         data of this {@link IVisualizationInput}.
	 */
	Object getDataTypeInstance();

	/**
	 * Returns the Data in a Form that they can be wrapped by the type provided
	 * in {@link #getDataTypeInstance()}.
	 * 
	 * @return the Data in a Form that they can be wrapped by the type provided
	 *         in {@link #getDataTypeInstance()}.
	 */
	Object getData();

	/**
	 * Creates a copy of the transformations of this {@link IVisualizationInput}
	 * for the given {@link AbstractDataSource}. This method is used if the user
	 * adds another input to an existing {@link IVisualization}. It ensures
	 * compatibility by using the same transformations and settings for these.
	 * Returns the last element of the copied chain, which is an
	 * {@link IVisualizationInput}.
	 * 
	 * @param source
	 *            the {@link AbstractDataSource} for which the copy is created
	 * @return the last element of the copied chain.
	 */
	IVisualizationInput createTransformationsChainCopy(AbstractDataSource source);
}
