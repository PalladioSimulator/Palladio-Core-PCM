/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.controlflowdescription;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Control Flow Descriptions</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.se.controlflowdescription.ControlFlowDescriptions#getControlFlowDescription <em>Control Flow Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.controlflowdescription.ControlFlowDescriptionPackage#getControlFlowDescriptions()
 * @model
 * @generated
 */
public interface ControlFlowDescriptions extends EObject {
	/**
	 * Returns the value of the '<em><b>Control Flow Description</b></em>' containment reference list.
	 * The list contents are of type {@link de.fzi.se.controlflowdescription.ControlFlowDescription}.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.controlflowdescription.ControlFlowDescription#getControlflowdescriptions <em>Controlflowdescriptions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Control Flow Description</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Control Flow Description</em>' containment reference list.
	 * @see de.fzi.se.controlflowdescription.ControlFlowDescriptionPackage#getControlFlowDescriptions_ControlFlowDescription()
	 * @see de.fzi.se.controlflowdescription.ControlFlowDescription#getControlflowdescriptions
	 * @model opposite="controlflowdescriptions" containment="true" ordered="false"
	 * @generated
	 */
	EList<ControlFlowDescription> getControlFlowDescription();

} // ControlFlowDescriptions
