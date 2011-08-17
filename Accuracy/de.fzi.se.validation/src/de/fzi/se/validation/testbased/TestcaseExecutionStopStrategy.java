/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.testbased;

import de.uka.ipd.sdq.identifier.Identifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Testcase Execution Stop Strategy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.se.validation.testbased.TestcaseExecutionStopStrategy#getValidationQuality <em>Validation Quality</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.validation.testbased.TestbasedPackage#getTestcaseExecutionStopStrategy()
 * @model abstract="true"
 * @generated
 */
public interface TestcaseExecutionStopStrategy extends Identifier {
	/**
	 * Returns the value of the '<em><b>Validation Quality</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.validation.testbased.TBValidationQuality#getStopStrategy <em>Stop Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Validation Quality</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Validation Quality</em>' container reference.
	 * @see #setValidationQuality(TBValidationQuality)
	 * @see de.fzi.se.validation.testbased.TestbasedPackage#getTestcaseExecutionStopStrategy_ValidationQuality()
	 * @see de.fzi.se.validation.testbased.TBValidationQuality#getStopStrategy
	 * @model opposite="stopStrategy" required="true" transient="false" ordered="false"
	 * @generated
	 */
	TBValidationQuality getValidationQuality();

	/**
	 * Sets the value of the '{@link de.fzi.se.validation.testbased.TestcaseExecutionStopStrategy#getValidationQuality <em>Validation Quality</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Validation Quality</em>' container reference.
	 * @see #getValidationQuality()
	 * @generated
	 */
	void setValidationQuality(TBValidationQuality value);

} // TestcaseExecutionStopStrategy
