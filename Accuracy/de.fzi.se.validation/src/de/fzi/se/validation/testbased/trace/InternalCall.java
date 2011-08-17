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
 * A representation of the model object '<em><b>Internal Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.se.validation.testbased.trace.InternalCall#getCallInstance <em>Call Instance</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.validation.testbased.trace.TracePackage#getInternalCall()
 * @model
 * @generated
 */
public interface InternalCall extends TraceAction {
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
	 * @see de.fzi.se.validation.testbased.trace.TracePackage#getInternalCall_CallInstance()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	CallInstance getCallInstance();

	/**
	 * Sets the value of the '{@link de.fzi.se.validation.testbased.trace.InternalCall#getCallInstance <em>Call Instance</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Call Instance</em>' containment reference.
	 * @see #getCallInstance()
	 * @generated
	 */
	void setCallInstance(CallInstance value);

} // InternalCall
