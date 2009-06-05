
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.usagemodel;

import de.uka.ipd.sdq.identifier.Identifier;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scenario Behaviour</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour#getActions_ScenarioBehaviour <em>Actions Scenario Behaviour</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage#getScenarioBehaviour()
 * @model
 * @generated
 */
public interface ScenarioBehaviour extends Identifier {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * Returns the value of the '<em><b>Actions Scenario Behaviour</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actions Scenario Behaviour</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actions Scenario Behaviour</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage#getScenarioBehaviour_Actions_ScenarioBehaviour()
	 * @model type="de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction" containment="true" ordered="false"
	 * @generated
	 */
	EList getActions_ScenarioBehaviour();

} // ScenarioBehaviour