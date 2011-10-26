/**
 * 
 */
package de.uka.ipd.sdq.edp2.visualization.wizards;

import java.util.ArrayList;
import java.util.HashMap;

import de.uka.ipd.sdq.edp2.visualization.IDataSink;

/**
 * @author Dominik Ernst
 * 
 */
public class DefaultSequence {
	private ArrayList<IDataSink> sequenceElements;
	private String sequenceID;
	private String sequenceName;
	private String matchingMetric;
	private ArrayList<HashMap<String, Object>> sequenceProperties;

	public DefaultSequence() {
		sequenceElements = new ArrayList<IDataSink>();
		sequenceProperties = new ArrayList<HashMap<String, Object>>();
	}

	/**
	 * @return the sequenceID
	 */
	public String getsequenceID() {
		return sequenceID;
	}

	/**
	 * @param sequenceID
	 *            the sequenceID to set
	 */
	public void setsequenceID(String sequenceID) {
		this.sequenceID = sequenceID;
	}

	/**
	 * @return the sequenceName
	 */
	public String getsequenceName() {
		return sequenceName;
	}

	/**
	 * @param sequenceName
	 *            the sequenceName to set
	 */
	public void setsequenceName(String sequenceName) {
		this.sequenceName = sequenceName;
	}

	/**
	 * @return the matchingMetric
	 */
	public String getMatchingMetric() {
		return matchingMetric;
	}

	/**
	 * @param matchingMetric
	 *            the matchingMetric to set
	 */
	public void setMatchingMetric(String matchingMetric) {
		this.matchingMetric = matchingMetric;
	}

	/**
	 * 
	 * @param element the element to add
	 */
	public void addSequenceElement(IDataSink element) {
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
	public ArrayList<IDataSink> getSequenceElements() {
		return sequenceElements;
	}
	
	/**
	 * Convenience method.
	 * @return the first element in <sequenceElements>
	 */
	public IDataSink getFirstSequenceElement(){
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
}
