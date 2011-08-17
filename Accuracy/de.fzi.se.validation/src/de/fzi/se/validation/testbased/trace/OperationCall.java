/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.testbased.trace;

import de.fzi.se.quality.parameters.CallInstance;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>
 *     Validation works for all CallInstances and is not restricted to business or infrastructure components.
 * </p><br />
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.se.validation.testbased.trace.OperationCall#getCallInstance <em>Call Instance</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.validation.testbased.trace.TracePackage#getOperationCall()
 * @model
 * @generated
 */
public interface OperationCall extends TraceAction {
	/**
	 * Returns the value of the '<em><b>Call Instance</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Call Instance</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Call Instance</em>' containment reference.
	 * @see #setCallInstance(CallInstance)
	 * @see de.fzi.se.validation.testbased.trace.TracePackage#getOperationCall_CallInstance()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	CallInstance getCallInstance();

	/**
	 * Sets the value of the '{@link de.fzi.se.validation.testbased.trace.OperationCall#getCallInstance <em>Call Instance</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Call Instance</em>' containment reference.
	 * @see #getCallInstance()
	 * @generated
	 */
	void setCallInstance(CallInstance value);

} // OperationCall
