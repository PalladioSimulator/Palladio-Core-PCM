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
 *   <li>{@link de.uka.ipd.sdq.qnm.QNModel#getCustomers <em>Customers</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.QNModel#getServers <em>Servers</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.QNModel#getINFINITE <em>INFINITE</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.qnm.QnmPackage#getQNModel()
 * @model
 * @generated
 */
public interface QNModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Customers</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.qnm.Customer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Customers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Customers</em>' containment reference list.
	 * @see de.uka.ipd.sdq.qnm.QnmPackage#getQNModel_Customers()
	 * @model type="de.uka.ipd.sdq.qnm.Customer" containment="true"
	 * @generated
	 */
	EList getCustomers();

	/**
	 * Returns the value of the '<em><b>Servers</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.qnm.Server}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Servers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Servers</em>' containment reference list.
	 * @see de.uka.ipd.sdq.qnm.QnmPackage#getQNModel_Servers()
	 * @model type="de.uka.ipd.sdq.qnm.Server" containment="true"
	 * @generated
	 */
	EList getServers();

	/**
	 * Returns the value of the '<em><b>INFINITE</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>INFINITE</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>INFINITE</em>' attribute.
	 * @see de.uka.ipd.sdq.qnm.QnmPackage#getQNModel_INFINITE()
	 * @model default="-1" required="true" changeable="false"
	 * @generated
	 */
	int getINFINITE();

} // QNModel