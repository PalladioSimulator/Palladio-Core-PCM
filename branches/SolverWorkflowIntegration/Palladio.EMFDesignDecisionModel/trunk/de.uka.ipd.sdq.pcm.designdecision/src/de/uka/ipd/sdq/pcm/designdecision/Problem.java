/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Problem</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.Problem#getDesigndecision <em>Designdecision</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getProblem()
 * @model
 * @generated
 */
public interface Problem extends EObject {
	/**
	 * Returns the value of the '<em><b>Designdecision</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.designdecision.DesignDecision}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Designdecision</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Designdecision</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getProblem_Designdecision()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<DesignDecision> getDesigndecision();

} // Problem
