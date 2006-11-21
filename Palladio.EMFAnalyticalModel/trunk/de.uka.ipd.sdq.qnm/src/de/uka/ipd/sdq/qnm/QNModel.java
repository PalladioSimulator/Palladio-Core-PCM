/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.qnm;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>QN Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.qnm.QNModel#getTasks <em>Tasks</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.QNModel#getResources <em>Resources</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.qnm.QnmPackage#getQNModel()
 * @model
 * @generated
 */
public interface QNModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Tasks</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.qnm.Task}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tasks</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tasks</em>' containment reference list.
	 * @see de.uka.ipd.sdq.qnm.QnmPackage#getQNModel_Tasks()
	 * @model type="de.uka.ipd.sdq.qnm.Task" containment="true"
	 * @generated
	 */
	EList getTasks();

	/**
	 * Returns the value of the '<em><b>Resources</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.spa.resourcemodel.Resource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resources</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resources</em>' containment reference list.
	 * @see de.uka.ipd.sdq.qnm.QnmPackage#getQNModel_Resources()
	 * @model type="de.uka.ipd.sdq.spa.resourcemodel.Resource" containment="true"
	 * @generated
	 */
	EList getResources();

} // QNModel