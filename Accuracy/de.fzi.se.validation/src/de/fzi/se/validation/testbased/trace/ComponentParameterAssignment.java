/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.testbased.trace;

import de.fzi.se.quality.parameters.ComponentInstance;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component Parameter Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.se.validation.testbased.trace.ComponentParameterAssignment#getComponentInstance <em>Component Instance</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.validation.testbased.trace.TracePackage#getComponentParameterAssignment()
 * @model
 * @generated
 */
public interface ComponentParameterAssignment extends TraceAction {
	/**
	 * Returns the value of the '<em><b>Component Instance</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Instance</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component Instance</em>' containment reference.
	 * @see #setComponentInstance(ComponentInstance)
	 * @see de.fzi.se.validation.testbased.trace.TracePackage#getComponentParameterAssignment_ComponentInstance()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	ComponentInstance getComponentInstance();

	/**
	 * Sets the value of the '{@link de.fzi.se.validation.testbased.trace.ComponentParameterAssignment#getComponentInstance <em>Component Instance</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component Instance</em>' containment reference.
	 * @see #getComponentInstance()
	 * @generated
	 */
	void setComponentInstance(ComponentInstance value);

} // ComponentParameterAssignment
