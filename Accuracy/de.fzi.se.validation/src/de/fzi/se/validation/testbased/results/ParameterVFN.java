/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.testbased.results;

import de.fzi.se.quality.parameters.ParameterValue;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter VFN</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.se.validation.testbased.results.ParameterVFN#getObservedValue <em>Observed Value</em>}</li>
 *   <li>{@link de.fzi.se.validation.testbased.results.ParameterVFN#getExpectedValue <em>Expected Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.validation.testbased.results.ResultsPackage#getParameterVFN()
 * @model
 * @generated
 */
public interface ParameterVFN extends ValidationFailureNotice {
	/**
	 * Returns the value of the '<em><b>Observed Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Observed Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Observed Value</em>' containment reference.
	 * @see #setObservedValue(ParameterValue)
	 * @see de.fzi.se.validation.testbased.results.ResultsPackage#getParameterVFN_ObservedValue()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	ParameterValue getObservedValue();

	/**
	 * Sets the value of the '{@link de.fzi.se.validation.testbased.results.ParameterVFN#getObservedValue <em>Observed Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Observed Value</em>' containment reference.
	 * @see #getObservedValue()
	 * @generated
	 */
	void setObservedValue(ParameterValue value);

	/**
	 * Returns the value of the '<em><b>Expected Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expected Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expected Value</em>' containment reference.
	 * @see #setExpectedValue(ParameterValue)
	 * @see de.fzi.se.validation.testbased.results.ResultsPackage#getParameterVFN_ExpectedValue()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	ParameterValue getExpectedValue();

	/**
	 * Sets the value of the '{@link de.fzi.se.validation.testbased.results.ParameterVFN#getExpectedValue <em>Expected Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expected Value</em>' containment reference.
	 * @see #getExpectedValue()
	 * @generated
	 */
	void setExpectedValue(ParameterValue value);

} // ParameterVFN
