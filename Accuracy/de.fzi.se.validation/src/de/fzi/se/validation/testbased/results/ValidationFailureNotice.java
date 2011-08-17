/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.testbased.results;

import de.fzi.se.validation.testbased.trace.TraceAction;

import de.uka.ipd.sdq.identifier.Identifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Validation Failure Notice</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.se.validation.testbased.results.ValidationFailureNotice#getDescription <em>Description</em>}</li>
 *   <li>{@link de.fzi.se.validation.testbased.results.ValidationFailureNotice#getRunProtocol <em>Run Protocol</em>}</li>
 *   <li>{@link de.fzi.se.validation.testbased.results.ValidationFailureNotice#getExpected <em>Expected</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.validation.testbased.results.ResultsPackage#getValidationFailureNotice()
 * @model abstract="true"
 * @generated
 */
public interface ValidationFailureNotice extends Identifier {
	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see de.fzi.se.validation.testbased.results.ResultsPackage#getValidationFailureNotice_Description()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link de.fzi.se.validation.testbased.results.ValidationFailureNotice#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Run Protocol</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.validation.testbased.results.RunProtocol#getValidationFailureNotices <em>Validation Failure Notices</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Run Protocol</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Run Protocol</em>' container reference.
	 * @see #setRunProtocol(RunProtocol)
	 * @see de.fzi.se.validation.testbased.results.ResultsPackage#getValidationFailureNotice_RunProtocol()
	 * @see de.fzi.se.validation.testbased.results.RunProtocol#getValidationFailureNotices
	 * @model opposite="validationFailureNotices" transient="false" ordered="false"
	 * @generated
	 */
	RunProtocol getRunProtocol();

	/**
	 * Sets the value of the '{@link de.fzi.se.validation.testbased.results.ValidationFailureNotice#getRunProtocol <em>Run Protocol</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Run Protocol</em>' container reference.
	 * @see #getRunProtocol()
	 * @generated
	 */
	void setRunProtocol(RunProtocol value);

	/**
	 * Returns the value of the '<em><b>Expected</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expected</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expected</em>' reference.
	 * @see #setExpected(TraceAction)
	 * @see de.fzi.se.validation.testbased.results.ResultsPackage#getValidationFailureNotice_Expected()
	 * @model ordered="false"
	 * @generated
	 */
	TraceAction getExpected();

	/**
	 * Sets the value of the '{@link de.fzi.se.validation.testbased.results.ValidationFailureNotice#getExpected <em>Expected</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expected</em>' reference.
	 * @see #getExpected()
	 * @generated
	 */
	void setExpected(TraceAction value);

} // ValidationFailureNotice
