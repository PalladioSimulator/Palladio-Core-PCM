/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters;

import de.uka.ipd.sdq.identifier.Identifier;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.se.quality.parameters.ComponentInstance#getComponentReference <em>Component Reference</em>}</li>
 *   <li>{@link de.fzi.se.quality.parameters.ComponentInstance#getParameterInstances <em>Parameter Instances</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.quality.parameters.ParametersPackage#getComponentInstance()
 * @model
 * @generated
 */
public interface ComponentInstance extends Identifier {
	/**
	 * Returns the value of the '<em><b>Component Reference</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.quality.parameters.ComponentReference#getComponentInstance <em>Component Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Reference</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component Reference</em>' containment reference.
	 * @see #setComponentReference(ComponentReference)
	 * @see de.fzi.se.quality.parameters.ParametersPackage#getComponentInstance_ComponentReference()
	 * @see de.fzi.se.quality.parameters.ComponentReference#getComponentInstance
	 * @model opposite="componentInstance" containment="true" required="true" ordered="false"
	 * @generated
	 */
	ComponentReference getComponentReference();

	/**
	 * Sets the value of the '{@link de.fzi.se.quality.parameters.ComponentInstance#getComponentReference <em>Component Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component Reference</em>' containment reference.
	 * @see #getComponentReference()
	 * @generated
	 */
	void setComponentReference(ComponentReference value);

	/**
	 * Returns the value of the '<em><b>Parameter Instances</b></em>' containment reference list.
	 * The list contents are of type {@link de.fzi.se.quality.parameters.ParameterInstance}.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.quality.parameters.ParameterInstance#getComponentInstance <em>Component Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Instances</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Instances</em>' containment reference list.
	 * @see de.fzi.se.quality.parameters.ParametersPackage#getComponentInstance_ParameterInstances()
	 * @see de.fzi.se.quality.parameters.ParameterInstance#getComponentInstance
	 * @model opposite="componentInstance" containment="true" ordered="false"
	 * @generated
	 */
	EList<ParameterInstance> getParameterInstances();

} // ComponentInstance
