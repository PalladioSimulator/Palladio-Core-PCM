package de.uka.ipd.sdq.edp2.visualization.wizards;

import java.util.ArrayList;
import java.util.HashMap;

import de.uka.ipd.sdq.edp2.visualization.AbstractTransformation;
import de.uka.ipd.sdq.edp2.visualization.IDataFlow;
import de.uka.ipd.sdq.edp2.visualization.IVisualizationInput;

/**
 * Instances of {@link DefaultSequence} represent predefined sequences of {@link IDataFlow}-elements.
 * @author Dominik Ernst
 * 
 */
public class DefaultSequence {
	private ArrayList<AbstractTransformation> sequenceElements;
	private String sequenceID;
	private String sequenceName;
	private String inputMetricUUID;
	private String inputDescription;
	private ArrayList<HashMap<String, Object>> sequenceProperties;
	private IVisualizationInput visualization;
	private HashMap<String, Object> visualizationProperties;

	public DefaultSequence() {
		sequenceElements = new ArrayList<AbstractTransformation>();
		sequenceProperties = new ArrayList<HashMap<String, Object>>();
	}

	/**
	 * @return the sequenceID
	 */
	public String getSequenceID() {
		return sequenceID;
	}

	/**
	 * @param sequenceID
	 *            the sequenceID to set
	 */
	public void setSequenceID(String sequenceID) {
		this.sequenceID = sequenceID;
	}

	/**
	 * 
	 * @param element the element to add
	 */
	public void addSequenceElement(AbstractTransformation element) {
		sequenceElements.add(element);
	}

	/**
	 * 
	 * @param key the property's key
	 * @param value the property's value
	 */
	public void addSequenceProperty(HashMap<String, Object> map) {
		sequenceProperties.add(map);
	}

	/**
	 * @return the sequenceElements
	 */
	public ArrayList<AbstractTransformation> getSequenceElements() {
		return sequenceElements;
	}
	
	/**
	 * Convenience method.
	 * @return the first element in <sequenceElements>
	 */
	public AbstractTransformation getFirstSequenceElement(){
		return sequenceElements.get(0);
	}

	/**
	 * @return the sequenceProperties
	 */
	public ArrayList<HashMap<String, Object>> getSequenceProperties() {
		return sequenceProperties;
	}
	/**
	 * Convenience method.
	 * @return the number of elements in <sequenceElements>
	 */
	public int getSize() {
		return sequenceElements.size();
	}

	/**
	 * @param visualization the visualization to set
	 */
	public void setVisualization(IVisualizationInput visualization) {
		this.visualization = visualization;
	}

	/**
	 * @return the visualization
	 */
	public IVisualizationInput getVisualization() {
		return visualization;
	}

	/**
	 * @return the sequenceName
	 */
	public String getSequenceName() {
		return sequenceName;
	}

	/**
	 * @param sequenceName the sequenceName to set
	 */
	public void setSequenceName(String sequenceName) {
		this.sequenceName = sequenceName;
	}

	/**
	 * @return the inputMetricUUID
	 */
	public String getInputMetricUUID() {
		return inputMetricUUID;
	}

	/**
	 * @param inputMetricUUID the inputMetricUUID to set
	 */
	public void setInputMetricUUID(String inputMetricUUID) {
		this.inputMetricUUID = inputMetricUUID;
	}

	/**
	 * @return the inputDescription
	 */
	public String getInputDescription() {
		return inputDescription;
	}

	/**
	 * @param inputDescription the inputDescription to set
	 */
	public void setInputDescription(String inputDescription) {
		this.inputDescription = inputDescription;
	}

	/**
	 * @param visualizationProperties the visualizationProperties to set
	 */
	public void setVisualizationProperties(HashMap<String, Object> visualizationProperties) {
		this.visualizationProperties = visualizationProperties;
	}

	/**
	 * @return the visualizationProperties
	 */
	public HashMap<String, Object> getVisualizationProperties() {
		//if no properties are set, return dummy properties to make the visualization use default values
		if (visualizationProperties == null) {
			return new HashMap<String,Object>();
		}
		return visualizationProperties;
	}
	
	/**
	 * Convenience method.
	 * @return the last element in <sequenceElements>
	 */
	public AbstractTransformation getLastSequenceElement(){
		return sequenceElements.get(getSize()-1);
	}
}
