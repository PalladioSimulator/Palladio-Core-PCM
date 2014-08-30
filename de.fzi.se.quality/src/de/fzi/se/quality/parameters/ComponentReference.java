/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters;

import de.uka.ipd.sdq.identifier.Identifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.se.quality.parameters.ComponentReference#getComponentInstance <em>Component Instance</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.quality.parameters.ParametersPackage#getComponentReference()
 * @model abstract="true"
 * @generated
 */
public interface ComponentReference extends Identifier {
	/**
     * Returns the value of the '<em><b>Component Instance</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fzi.se.quality.parameters.ComponentInstance#getComponentReference <em>Component Reference</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Instance</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Component Instance</em>' container reference.
     * @see #setComponentInstance(ComponentInstance)
     * @see de.fzi.se.quality.parameters.ParametersPackage#getComponentReference_ComponentInstance()
     * @see de.fzi.se.quality.parameters.ComponentInstance#getComponentReference
     * @model opposite="componentReference" transient="false" ordered="false"
     * @generated
     */
	ComponentInstance getComponentInstance();

	/**
     * Sets the value of the '{@link de.fzi.se.quality.parameters.ComponentReference#getComponentInstance <em>Component Instance</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Component Instance</em>' container reference.
     * @see #getComponentInstance()
     * @generated
     */
	void setComponentInstance(ComponentInstance value);

} // ComponentReference
