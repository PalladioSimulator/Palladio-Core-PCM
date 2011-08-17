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
 * A representation of the model object '<em><b>Decision Space</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Problem represents the optimisation problem definition. It contains the DegreeOfFreedoms that make up this optimisation problem. 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.DecisionSpace#getDegreesOfFreedom <em>Degrees Of Freedom</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getDecisionSpace()
 * @model
 * @generated
 */
public interface DecisionSpace extends EObject {
	/**
	 * Returns the value of the '<em><b>Degrees Of Freedom</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedomInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Degrees Of Freedom</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Degrees Of Freedom</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getDecisionSpace_DegreesOfFreedom()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<DegreeOfFreedomInstance> getDegreesOfFreedom();

} // DecisionSpace
