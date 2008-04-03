/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.core;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Probabilistic Prefix</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.core.ProbabilisticPrefix#getAction <em>Action</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.core.ProbabilisticPrefix#getTargetOptions <em>Target Options</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.capra.core.CorePackage#getProbabilisticPrefix()
 * @model
 * @generated
 */
public interface ProbabilisticPrefix extends Operator {
	/**
	 * Returns the value of the '<em><b>Action</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action</em>' containment reference.
	 * @see #setAction(Action)
	 * @see de.uka.ipd.sdq.capra.core.CorePackage#getProbabilisticPrefix_Action()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Action getAction();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.core.ProbabilisticPrefix#getAction <em>Action</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action</em>' containment reference.
	 * @see #getAction()
	 * @generated
	 */
	void setAction(Action value);

	/**
	 * Returns the value of the '<em><b>Target Options</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.capra.core.InternalSelector}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Options</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Options</em>' containment reference list.
	 * @see de.uka.ipd.sdq.capra.core.CorePackage#getProbabilisticPrefix_TargetOptions()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<InternalSelector> getTargetOptions();

} // ProbabilisticPrefix
