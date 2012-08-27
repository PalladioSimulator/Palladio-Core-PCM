package de.uka.ipd.sdq.edp2.visualization;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Observable;

import de.uka.ipd.sdq.edp2.visualization.editors.AbstractEditor;

/**
 * Interface used to describe elements that are managed by an
 * {@link IVisualizationInputHandle}. It is important to note that the actual
 * input to an {@link IVisualization} is the {@link IVisualizationInputHandle}
 * and not implementations of this interface.
 * 
 * @author Dominik Ernst
 * 
 */
public abstract class IVisualizationInput extends Observable implements
		IDataSink {

	/**
	 * Keys used for persistence of properties.
	 */
	public static final String INPUT_NAME_KEY = "inputName";

	/**
	 * The properties of this {@link IVisualizationInput}, which are persisted
	 * and displayed in the 'Display'-Tab of the Properties-View.
	 */
	protected HashMap<String, Object> properties;
	/**
	 * The {@link IVisualizationInput}'s or rather {@link IDataSink}'s
	 * predecessor.
	 */
	protected AbstractDataSource source;
	
	/**
	 * A display name for this {@link IVisualizationInput}.
	 */
	private String inputName;

	public IVisualizationInput(){
		properties = new HashMap<String, Object>();
	}
	

	public IVisualizationInput(AbstractDataSource source) {
		properties = new HashMap<String, Object>();
		if (source != null) {
			setSource(source);
		}
	}

	/**
	 * Returns the Data in a Form that they can be wrapped by the type provided
	 * in {@link #getDataTypeInstance()}.
	 * 
	 * @return the Data in a Form that they can be wrapped by the type provided
	 *         in {@link #getDataTypeInstance()}.
	 */
	public abstract Object getData();

	/**
	 * Returns a list of all applied {@link AbstractTransformation}s before this
	 * {@link IVisualizationInput}.
	 * 
	 * @return the list of applied {@link AbstractTransformation} elements.
	 */
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


	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.edp2.visualization.IDataSink#getSource()
	 */
	@Override
	public AbstractDataSource getSource() {
		return source;
	}

	/**
	 * Method which handles the retrieval of the experiment data and wraps them
	 * or transforms them in a way they can be displayed by the corresponding
	 * {@link AbstractEditor} for this {@link IVisualizationInput}.
	 */
	public abstract void updateInputData();

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
		properties.put(INPUT_NAME_KEY, getInputName());
		source.addObserver(this);
		updateInputData();
	}

	/**
	 * Returns a default String-representation, which describes this
	 * {@link IVisualizationInput}. Further processing of this label is done by
	 * {@link IVisualizationInputHandle}s, which support multiple inputs.
	 * 
	 * @return
	 */
	public String getDefaultName() {
		if (getSource() != null)
		return source.getMeasurementsRange().getMeasurements().getMeasure()
				.getMeasuredObject();
		else return "noSourceSet";
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		updateInputData();
	}
	

	@Override
	public Object getAdapter(Class adapter) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getInputName() {
		if (inputName == null) return getDefaultName();
		return inputName;
	}
	
	public void setInputName(String inputName) {
		this.inputName = inputName;
	}
	
	/**
	 * Method, which returns <true> if the {@link IVisualizationInput} and its corresponding {@link AbstractEditor}
	 * are able to display multiple {@link IDataSink} objects.
	 * @return <code>true</code> if multiple inputs are supported.
	 */
	public abstract boolean supportsMultipleInputs();

}
