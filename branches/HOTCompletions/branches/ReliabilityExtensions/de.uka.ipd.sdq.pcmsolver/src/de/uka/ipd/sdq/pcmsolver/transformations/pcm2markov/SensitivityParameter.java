package de.uka.ipd.sdq.pcmsolver.transformations.pcm2markov;

import java.util.ArrayList;

/**
 * This class represents a single Sensitivity Parameter for reliability
 * analysis.
 * 
 * The parameter references an EMF model element via its URI. A series of values
 * indicates the change of the parameter throughout sensitivity analysis.
 * 
 * @author brosch
 * 
 */
public class SensitivityParameter {

	/**
	 * The ID of the EMF model element.
	 */
	private String elemntId;

	/**
	 * Gets the ID of the EMF model element.
	 * 
	 * @return the ID.
	 */
	public String getElementId() {
		return elemntId;
	}

	/**
	 * Sets the ID of the EMF model element.
	 * 
	 * @param elementId
	 *            the ID to set.
	 */
	public void setElementId(final String elementId) {
		this.elemntId = elementId;
	}
	
	/**
	 * The list of values for sensitivity analysis.
	 */
	private final ArrayList<Double> values = new ArrayList<Double>();

	/**
	 * Gets the list of values.
	 * 
	 * @return the list of values
	 */
	public ArrayList<Double> getValues() {
		return values;
	}
}
